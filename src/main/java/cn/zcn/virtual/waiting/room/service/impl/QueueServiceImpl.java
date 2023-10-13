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

import cn.zcn.virtual.waiting.room.exception.*;
import cn.zcn.virtual.waiting.room.repository.AccessTokenMapper;
import cn.zcn.virtual.waiting.room.repository.QueueServingPositionMapper;
import cn.zcn.virtual.waiting.room.repository.RequestPositionMapper;
import cn.zcn.virtual.waiting.room.repository.entity.AccessToken;
import cn.zcn.virtual.waiting.room.repository.entity.QueueServingPosition;
import cn.zcn.virtual.waiting.room.repository.entity.RequestPosition;
import cn.zcn.virtual.waiting.room.repository.entity.RequestStatus;
import cn.zcn.virtual.waiting.room.script.DequeueScript;
import cn.zcn.virtual.waiting.room.script.EnqueueScript;
import cn.zcn.virtual.waiting.room.script.LuaScriptLoader;
import cn.zcn.virtual.waiting.room.service.QueueManageService;
import cn.zcn.virtual.waiting.room.service.QueueService;
import cn.zcn.virtual.waiting.room.service.dto.AccessTokenDto;
import cn.zcn.virtual.waiting.room.service.dto.QueueDto;
import cn.zcn.virtual.waiting.room.utils.RedisKeyUtils;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.UUID;
import javax.annotation.Resource;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author zicung
 */
@Service
public class QueueServiceImpl implements QueueService {

    @Resource
    private QueueService that;

    @Resource
    private LuaScriptLoader redisScriptLoader;

    @Resource
    private QueueManageService queueManageService;

    @Resource
    private RequestPositionMapper requestPositionMapper;

    @Resource
    private AccessTokenMapper queuePositionTokenMapper;

    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    @Resource
    private QueueServingPositionMapper queueServingPositionMapper;

    @Override
    @Cacheable(cacheNames = "request", key = "#requestId")
    public RequestPosition getRequestPosition(String queueId, String requestId) throws InvalidRequestIdException {
        RequestPosition requestPosition = requestPositionMapper.getByQueueIdAndRequestId(queueId, requestId);
        if (requestPosition != null) {
            return requestPosition;
        }
        throw new InvalidRequestIdException("No request be found. QueueId:{}, RequestId:{}.", queueId, requestId);
    }

    @Override
    public int getWaitingNum(String queueId) throws InvalidQueueIdException {
        checkQueue(queueId);
        Integer waitingNum = (Integer) redisTemplate.opsForValue().get(RedisKeyUtils.getQueueWaitingNumKey(queueId));
        return waitingNum == null ? 0 : waitingNum;
    }

    @Override
    @Cacheable(cacheNames = "queue:latestServingPosition", key = "#queueId")
    public QueueServingPosition getLatestServingPosition(String queueId) {
        checkQueue(queueId);
        return queueServingPositionMapper.getLatestPositionByQueueId(queueId, false);
    }

    @Override
    @CacheEvict(cacheNames = "request", key = "#requestId")
    public void enqueue(String queueId, String requestId)
            throws InvalidQueueIdException, InvalidRequestIdException, RequestExpiredException {
        checkQueue(queueId);

        // 获取request
        RequestPosition requestPosition = that.getRequestPosition(queueId, requestId);

        // 进入等候室
        EnqueueScript enqueueScript = redisScriptLoader.get(EnqueueScript.class);
        long pos = enqueueScript.execute(redisTemplate, queueId);

        QueueServingPosition latestServingPosition = getLatestServingPosition(queueId);

        // 设置入队信息
        requestPosition.setQueuePosition(pos);
        requestPosition.setEntryTime(new Date());
        requestPosition.setCanServedWhenEntry(latestServingPosition.getServingPosition() >= pos);
        requestPositionMapper.updateRequestPosition(requestPosition);
    }

    @Override
    @Transactional
    @CacheEvict(cacheNames = "queue:latestServingPosition", key = "#queueId")
    public long incrementServingPosition(String queueId, int incrementBy) throws InvalidQueueIdException {
        checkQueue(queueId);

        QueueServingPosition latestQueueServingPos =
                queueServingPositionMapper.getLatestPositionByQueueId(queueId, true);
        long newServingPos = incrementBy;
        if (latestQueueServingPos != null) {
            newServingPos += latestQueueServingPos.getServingPosition();
        }

        Date now = new Date();
        QueueServingPosition newQueueServingPos = new QueueServingPosition();
        newQueueServingPos.setQueueId(queueId);
        newQueueServingPos.setIssuedTime(now);
        newQueueServingPos.setServingPosition(newServingPos);
        queueServingPositionMapper.add(newQueueServingPos);
        return newServingPos;
    }

    @Override
    @CacheEvict(cacheNames = "request", key = "#requestId")
    public AccessTokenDto generateToken(String queueId, String requestId) throws WaitingRoomException {
        QueueDto queue = checkQueue(queueId);
        QueueServingPosition latestServingPosition = getLatestServingPosition(queueId);

        // check request
        RequestPosition requestPosition = that.getRequestPosition(queueId, requestId);
        checkIfProcessed(requestPosition);
        checkIfServed(latestServingPosition, requestPosition);
        checkIfExpired(queue, latestServingPosition, requestPosition);

        // change request status
        int successNum = requestPositionMapper.changeRequestStatus(
                requestPosition.getId(), RequestStatus.INCOMPLETE, RequestStatus.COMPLETED);
        if (successNum <= 0) {
            throw new WaitingRoomException("Request is completed. RequestId:{}", requestId);
        }

        // dequeue
        DequeueScript dequeueScript = redisScriptLoader.get(DequeueScript.class);
        dequeueScript.execute(redisTemplate, queueId);

        // generate token
        Instant now = Instant.now();
        AccessToken queuePositionToken = new AccessToken();
        queuePositionToken.setQueueId(queueId);
        queuePositionToken.setRequestId(requestId);
        queuePositionToken.setPosition(requestPosition.getQueuePosition());
        queuePositionToken.setCreateTime(Date.from(now));
        queuePositionToken.setTokenType(AccessToken.BEARER_TOKEN_TYPE);
        queuePositionToken.setTokenValue(generateTokenValue());

        if (queue.getTokenValiditySecond() != null) {
            Instant expiredTime = now.plus(queue.getTokenValiditySecond(), ChronoUnit.SECONDS);
            queuePositionToken.setExpiredTime(Date.from(expiredTime));
        }
        queuePositionTokenMapper.add(queuePositionToken);
        return AccessTokenDto.from(queuePositionToken);
    }

    private QueueDto checkQueue(String queueId) {
        QueueDto queue = queueManageService.getQueueByQueueId(queueId);
        if (queue == null) {
            throw new InvalidQueueIdException("No queue be found. QueueId:{}", queueId);
        }
        return queue;
    }

    private void checkIfProcessed(RequestPosition requestPosition) throws RequestNotProcessedException {
        if (requestPosition.getQueuePosition() == null) {
            throw new RequestNotProcessedException(
                    "Request has not been processed. RequestId:{}", requestPosition.getRequestId());
        }
    }

    private void checkIfExpired(
            QueueDto queue, QueueServingPosition queueServingPosition, RequestPosition requestPosition)
            throws RequestExpiredException {
        if (!queue.getEnableQueuePositionExpiry()) {
            return;
        }

        long tiq;
        if (requestPosition.getCanServedWhenEntry()) {
            tiq = dateDiff(requestPosition.getEntryTime(), new Date());
        } else {
            tiq = dateDiff(queueServingPosition.getIssuedTime(), new Date());
        }

        if (tiq >= queue.getPositionExpirySecond() * 1000) {
            throw new RequestExpiredException("RequestId is expired. RequestId:{}.", requestPosition.getRequestId());
        }
    }

    private void checkIfServed(QueueServingPosition queueServingPosition, RequestPosition requestPosition)
            throws RequestNotServedException {
        if (queueServingPosition.getServingPosition() < requestPosition.getQueuePosition()) {
            throw new RequestNotServedException(
                    "RequestId not being served. QueueId:{}, RequestId:{}.",
                    queueServingPosition.getQueueId(),
                    requestPosition.getQueuePosition());
        }
    }

    private String generateTokenValue() {
        return UUID.randomUUID().toString().replace("-", "");
    }

    private long dateDiff(Date date1, Date date2) {
        return date2.getTime() - date1.getTime();
    }
}
