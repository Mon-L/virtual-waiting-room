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

import static cn.zcn.virtual.waiting.room.utils.RedisKeyUtils.*;

import cn.zcn.virtual.waiting.room.exception.*;
import cn.zcn.virtual.waiting.room.repository.QueuePositionMapper;
import cn.zcn.virtual.waiting.room.repository.QueuePositionTokenMapper;
import cn.zcn.virtual.waiting.room.repository.QueueServingPositionMapper;
import cn.zcn.virtual.waiting.room.repository.entity.QueuePosition;
import cn.zcn.virtual.waiting.room.repository.entity.QueuePositionToken;
import cn.zcn.virtual.waiting.room.repository.entity.QueueServingPosition;
import cn.zcn.virtual.waiting.room.script.LuaScriptLoader;
import cn.zcn.virtual.waiting.room.service.QueueService;
import cn.zcn.virtual.waiting.room.service.dto.AccessTokenDto;
import cn.zcn.virtual.waiting.room.service.dto.QueueServingPositionDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.*;
import javax.annotation.Resource;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.script.RedisScript;
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
        RedisScript<Long> redisScript = redisScriptLoader.get(LuaScriptLoader.GET_QUEUE_POS, Long.class);
        List<String> keys = join2List(
                getRequestKey(queueId, requestId),
                getQueueKey(queueId),
                getExpiredRequests(queueId),
                getWaitingQueueKey(queueId),
                queueId);

        Long pos = redisTemplate.execute(redisScript, keys, new Date().getTime(), requestId);

        if (pos == null) {
            throw new UnexpectedReturnException("Expected Long but got null.");
        } else if (pos == -1) {
            throw new InvalidRequestIdException("No request be found. RequestId:{}.", requestId);
        } else if (pos == -2) {
            throw new RequestNotProcessedException("Request has not been processed. RequestId:{}", requestId);
        } else if (pos == -3) {
            throw new RequestExpiredException("RequestId is expired. RequestId:{}.", requestId);
        } else {
            return pos;
        }
    }

    @Override
    public QueueServingPositionDto getServingPosition(String queueId) throws InvalidQueueIdException {
        return getQueueServingPosition(queueId);
    }

    @Override
    public long getWaitingNum(String queueId) throws InvalidQueueIdException {
        RedisScript<Long> redisScript = redisScriptLoader.get(LuaScriptLoader.GET_WAITING_NUM, Long.class);
        List<String> keys = join2List(getWaitingQueueKey(queueId), getQueueKey(queueId));
        Long waitingNum = redisTemplate.execute(redisScript, keys);

        if (waitingNum == null) {
            throw new UnexpectedReturnException("Expected Long but got null.");
        } else if (waitingNum == -1) {
            throw new InvalidQueueIdException("No queue be found. QueueId:{}.", queueId);
        }
        return waitingNum;
    }

    @Override
    public QueuePosition enqueue(String queueId, String requestId) throws InvalidQueueIdException {
        Date now = new Date();
        RedisScript<Long> redisScript = redisScriptLoader.get(LuaScriptLoader.ENQUEUE, Long.class);
        List<String> keys =
                join2List(getWaitingQueueKey(queueId), getRequestKey(queueId, requestId), getQueueKey(queueId));
        Long pos = redisTemplate.execute(redisScript, keys, queueId, requestId, now.getTime());
        if (pos == null) {
            throw new UnexpectedReturnException("Expected Long but got null.");
        } else if (pos == -1) {
            throw new InvalidQueueIdException("No queue be found. QueueId:{}.", queueId);
        } else if (pos == -2) {
            throw new InvalidRequestIdException("No request be found. QueueId:{}, RequestId:{}.", queueId, requestId);
        } else {
            QueuePosition queuePosition = new QueuePosition();
            queuePosition.setQueueId(queueId);
            queuePosition.setRequestId(requestId);
            queuePosition.setQueuePosition(pos);
            queuePosition.setEntryTime(now);
            queuePositionMapper.add(queuePosition);
            return queuePosition;
        }
    }

    @Override
    @Transactional
    public long incrementServingPosition(String queueId, int incrementBy) {
        if (redisTemplate.hasKey(getQueueKey(queueId)) != Boolean.TRUE) {
            throw new InvalidQueueIdException("No queue be found. QueueId:{}.", queueId);
        }

        QueueServingPosition lastQueueServingPos = queueServingPositionMapper.getLastPositionByQueueId(queueId, true);
        long newPos = incrementBy;
        if (lastQueueServingPos != null) {
            newPos += lastQueueServingPos.getServingPosition();
        }

        Date issuedTime = new Date();
        QueueServingPosition newQueueServingPos = new QueueServingPosition();
        newQueueServingPos.setQueueId(queueId);
        newQueueServingPos.setIssuedTime(issuedTime);
        newQueueServingPos.setServingPosition(newPos);
        queueServingPositionMapper.add(newQueueServingPos);

        RedisScript<Long> redisScript = redisScriptLoader.get(LuaScriptLoader.INCREMENT_SERVING_POSITION, Long.class);
        List<String> keys = join2List(getQueueKey(queueId), getWaitingQueueKey(queueId));

        redisTemplate.execute(redisScript, keys, incrementBy, issuedTime.getTime());
        return newPos;
    }

    @Override
    public long dequeue(String queueId, String requestId)
            throws InvalidQueueIdException, InvalidRequestIdException, RequestNotServedException,
                    RequestExpiredException {
        RedisScript<Long> redisScript = redisScriptLoader.get(LuaScriptLoader.DEQUEUE, Long.class);

        List<String> keys = join2List(
                getWaitingQueueKey(queueId),
                getRequestKey(queueId, requestId),
                getQueueKey(queueId),
                getExpiredRequests(queueId));
        Long ret = redisTemplate.execute(redisScript, keys, requestId, new Date().getTime());

        if (ret == null) {
            throw new UnexpectedReturnException("Expected Long but got null.");
        } else if (ret == -4) {
            throw new RequestExpiredException("RequestId is expired. QueueId:{}, RequestId:{}.", queueId, requestId);
        } else if (ret == -3) {
            throw new InvalidRequestIdException("No request be found. QueueId:{}, RequestId:{}.", queueId, requestId);
        } else if (ret == -2) {
            throw new InvalidQueueIdException("No queue be found. QueueId:{}.", queueId);
        } else if (ret == -1) {
            throw new RequestNotServedException(
                    "RequestId not being served. QueueId:{}, RequestId:{}.", queueId, requestId);
        }
        return ret;
    }

    @Override
    public AccessTokenDto generateToken(String queueId, String requestId) throws WaitingRoomException {
        long requestPos = dequeue(queueId, requestId);
        QueueServingPositionDto queueServingPositionDto = getQueueServingPosition(queueId);

        Instant now = Instant.now();
        QueuePositionToken queuePositionToken = new QueuePositionToken();
        queuePositionToken.setQueueId(queueId);
        queuePositionToken.setRequestId(requestId);
        queuePositionToken.setCreateTime(Date.from(now));

        if (queueServingPositionDto.getTokenValiditySecond() != null) {
            Instant expiredTime = now.plus(queueServingPositionDto.getTokenValiditySecond(), ChronoUnit.SECONDS);
            queuePositionToken.setExpiredTime(Date.from(expiredTime));
        }

        queuePositionToken.setPosition(requestPos);
        queuePositionToken.setTokenValue(UUID.randomUUID().toString().replace("-", ""));
        queuePositionToken.setTokenValue(QueuePositionToken.BEARER_TOKEN_TYPE);
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

    private List<String> join2List(String... keys) {
        List<String> list = new ArrayList<>();
        Collections.addAll(list, keys);
        return list;
    }
}
