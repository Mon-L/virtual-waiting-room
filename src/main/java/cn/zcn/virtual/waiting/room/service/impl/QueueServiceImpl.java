/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package cn.zcn.virtual.waiting.room.service.impl;

import static cn.zcn.virtual.waiting.room.utils.RedisKeyUtils.getQueueKey;

import cn.zcn.virtual.waiting.room.exception.*;
import cn.zcn.virtual.waiting.room.repository.QueuePositionMapper;
import cn.zcn.virtual.waiting.room.repository.QueuePositionTokenMapper;
import cn.zcn.virtual.waiting.room.repository.QueueServingPositionMapper;
import cn.zcn.virtual.waiting.room.repository.entity.QueuePosition;
import cn.zcn.virtual.waiting.room.repository.entity.QueuePositionToken;
import cn.zcn.virtual.waiting.room.repository.entity.QueueServingPosition;
import cn.zcn.virtual.waiting.room.script.*;
import cn.zcn.virtual.waiting.room.service.QueueService;
import cn.zcn.virtual.waiting.room.service.dto.AccessTokenDto;
import cn.zcn.virtual.waiting.room.service.dto.QueueServingPositionDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.Map;
import java.util.UUID;
import javax.annotation.Resource;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author zicung
 */
@Service
public class QueueServiceImpl implements QueueService {

    @Resource
    private ObjectMapper objectMapper;

    @Resource
    private LuaScriptLoader redisScriptLoader;

    @Resource
    private QueuePositionMapper queuePositionMapper;

    @Resource
    private QueuePositionTokenMapper queuePositionTokenMapper;

    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    @Resource
    private QueueServingPositionMapper queueServingPositionMapper;

    @Override
    public long getRequestPosition(String queueId, String requestId)
            throws InvalidRequestIdException, RequestNotProcessedException, RequestExpiredException {
        GetRequestPosScript getRequestPos = redisScriptLoader.get(GetRequestPosScript.class);
        return getRequestPos.execute(redisTemplate, queueId, requestId);
    }

    @Override
    public QueueServingPositionDto getServingPosition(String queueId) throws InvalidQueueIdException {
        return getQueueServingPosition(queueId);
    }

    @Override
    public long getWaitingNum(String queueId) throws InvalidQueueIdException {
        GetQueueWaitingNumScript getWaitingNum = redisScriptLoader.get(GetQueueWaitingNumScript.class);
        return getWaitingNum.execute(redisTemplate, queueId);
    }

    @Override
    public QueuePosition enqueue(String queueId, String requestId) throws InvalidQueueIdException {
        EnqueueScript enqueue = redisScriptLoader.get(EnqueueScript.class);
        Long requestPosition = enqueue.execute(redisTemplate, queueId, requestId);

        QueuePosition queuePosition = new QueuePosition();
        queuePosition.setQueueId(queueId);
        queuePosition.setRequestId(requestId);
        queuePosition.setQueuePosition(requestPosition);
        queuePosition.setEntryTime(new Date());
        queuePositionMapper.add(queuePosition);
        return queuePosition;
    }

    @Override
    @Transactional
    public long incrementServingPosition(String queueId, int incrementBy) {
        if (redisTemplate.hasKey(getQueueKey(queueId)) != Boolean.TRUE) {
            throw new InvalidQueueIdException("No queue be found. QueueId:{}.", queueId);
        }

        QueueServingPosition lastQueueServingPos = queueServingPositionMapper.getLastPositionByQueueId(queueId, true);
        long newServingPos = incrementBy;
        if (lastQueueServingPos != null) {
            newServingPos += lastQueueServingPos.getServingPosition();
        }

        Date now = new Date();
        QueueServingPosition newQueueServingPos = new QueueServingPosition();
        newQueueServingPos.setQueueId(queueId);
        newQueueServingPos.setIssuedTime(now);
        newQueueServingPos.setServingPosition(newServingPos);
        queueServingPositionMapper.add(newQueueServingPos);

        IncrementServingPosScript incrementServingPos = redisScriptLoader.get(IncrementServingPosScript.class);
        incrementServingPos.execute(redisTemplate, queueId, incrementBy, now);
        return newServingPos;
    }

    @Override
    public long dequeue(String queueId, String requestId)
            throws InvalidQueueIdException, InvalidRequestIdException, RequestNotServedException,
                    RequestExpiredException {
        DequeueScript dequeue = redisScriptLoader.get(DequeueScript.class);
        return dequeue.execute(redisTemplate, queueId, requestId);
    }

    @Override
    public AccessTokenDto generateToken(String queueId, String requestId) throws WaitingRoomException {
        long requestPos = dequeue(queueId, requestId);
        QueueServingPositionDto queueServingPositionDto = getQueueServingPosition(queueId);

        Instant now = Instant.now();
        QueuePositionToken queuePositionToken = new QueuePositionToken();
        queuePositionToken.setQueueId(queueId);
        queuePositionToken.setRequestId(requestId);
        queuePositionToken.setPosition(requestPos);
        queuePositionToken.setCreateTime(Date.from(now));
        queuePositionToken.setTokenType(QueuePositionToken.BEARER_TOKEN_TYPE);
        queuePositionToken.setTokenValue(generateTokenValue());

        if (queueServingPositionDto.getTokenValiditySecond() != null) {
            Instant expiredTime = now.plus(queueServingPositionDto.getTokenValiditySecond(), ChronoUnit.SECONDS);
            queuePositionToken.setExpiredTime(Date.from(expiredTime));
        }
        queuePositionTokenMapper.add(queuePositionToken);
        return AccessTokenDto.from(queuePositionToken);
    }

    private QueueServingPositionDto getQueueServingPosition(String queueId) {
        Map<Object, Object> fields = redisTemplate.opsForHash().entries(getQueueKey(queueId));
        if (fields.isEmpty()) {
            throw new InvalidQueueIdException("No queue serving position be found. QueueId:{}.", queueId);
        }

        return objectMapper.convertValue(fields, QueueServingPositionDto.class);
    }

    private String generateTokenValue() {
        return UUID.randomUUID().toString().replace("-", "");
    }
}
