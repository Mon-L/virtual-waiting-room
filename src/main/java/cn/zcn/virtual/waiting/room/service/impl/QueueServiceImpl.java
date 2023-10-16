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
import cn.zcn.virtual.waiting.room.repository.entity.AccessToken;
import cn.zcn.virtual.waiting.room.repository.entity.QueueServingPosition;
import cn.zcn.virtual.waiting.room.repository.entity.RequestPosition;
import cn.zcn.virtual.waiting.room.repository.entity.RequestStatus;
import cn.zcn.virtual.waiting.room.script.DequeueScript;
import cn.zcn.virtual.waiting.room.script.EnqueueScript;
import cn.zcn.virtual.waiting.room.script.LuaScriptLoader;
import cn.zcn.virtual.waiting.room.service.QueueManageService;
import cn.zcn.virtual.waiting.room.service.QueueService;
import cn.zcn.virtual.waiting.room.service.RequestService;
import cn.zcn.virtual.waiting.room.service.dto.AccessTokenDto;
import cn.zcn.virtual.waiting.room.service.dto.QueueDto;
import cn.zcn.virtual.waiting.room.utils.RedisKeyUtils;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.UUID;
import javax.annotation.Resource;
import org.apache.rocketmq.spring.annotation.MessageModel;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author zicung
 */
@Service
@RocketMQMessageListener(
        consumerGroup = "virtual-waiting-room-consumer",
        topic = RequestServiceImpl.TOPIC_ASSIGN_POS,
        messageModel = MessageModel.CLUSTERING,
        maxReconsumeTimes = 2)
public class QueueServiceImpl implements QueueService, RocketMQListener<RequestPosition> {

    @Resource
    private LuaScriptLoader redisScriptLoader;

    @Resource
    private RequestService requestService;

    @Resource
    private QueueManageService queueManageService;

    @Resource
    private AccessTokenMapper accessTokenMapper;

    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    @Resource
    private QueueServingPositionMapper queueServingPositionMapper;

    @Override
    public int getWaitingNum(String queueId) throws InvalidQueueIdException {
        checkQueue(queueId);
        Integer waitingNum = (Integer) redisTemplate.opsForValue().get(RedisKeyUtils.getQueueWaitingNumKey(queueId));
        return waitingNum == null ? 0 : waitingNum;
    }

    @Override
    @Cacheable(cacheNames = "queue:latestServingPosition", unless = "#result == null", key = "#queueId")
    public QueueServingPosition getLatestServingPosition(String queueId) {
        checkQueue(queueId);
        return queueServingPositionMapper.getLatestPositionByQueueId(queueId, false);
    }

    @Override
    public void enqueue(String queueId, String requestId)
            throws InvalidQueueIdException, InvalidRequestIdException, RequestExpiredException {
        checkQueue(queueId);

        // 获取request
        RequestPosition requestPosition = requestService.getRequestPosition(queueId, requestId);

        // 进入等候室
        EnqueueScript enqueueScript = redisScriptLoader.get(EnqueueScript.class);
        long pos = enqueueScript.execute(redisTemplate, queueId);

        QueueServingPosition latestServingPosition = getLatestServingPosition(queueId);

        // 设置入队信息
        requestPosition.setQueuePosition(pos);
        requestPosition.setEntryTime(new Date());
        requestPosition.setCanServedWhenEntry(latestServingPosition.getServingPosition() >= pos);
        requestPosition.setServingPositionIdWhenEntry(latestServingPosition.getId());
        requestService.updateRequestPosition(requestPosition);
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
    public void onMessage(RequestPosition requestPosition) {
        enqueue(requestPosition.getQueueId(), requestPosition.getRequestId());
    }

    @Override
    @Transactional
    public AccessTokenDto generateToken(String queueId, String requestId) throws WaitingRoomException {
        QueueDto queue = checkQueue(queueId);
        QueueServingPosition latestServingPosition = getLatestServingPosition(queueId);

        // check request
        RequestPosition requestPosition = requestService.getRequestPosition(queueId, requestId);
        if (requestPosition.getStatus() != RequestStatus.INCOMPLETE) {
            throw new WaitingRoomException(
                    "Excepted request status{}, but got {}.",
                    RequestStatus.INCOMPLETE.name(),
                    requestPosition.getStatus().name());
        }

        if (!requestIsProcessed(requestPosition)) {
            throw new RequestNotProcessedException(
                    "Request has not been processed. RequestId:{}", requestPosition.getRequestId());
        }

        if (!requestIsServed(latestServingPosition, requestPosition)) {
            throw new RequestNotServedException(
                    "Request not being served. QueueId:{}, RequestId:{}.", queueId, requestPosition.getQueuePosition());
        }

        if (queue.getEnableQueuePositionExpiry() && requestIsExpired(queue, requestPosition)) {
            throw new RequestExpiredException("Request is expired. RequestId:{}.", requestPosition.getRequestId());
        }

        // change request status
        boolean success = requestService.changeRequestStatus(
                requestPosition.getId(), RequestStatus.INCOMPLETE, RequestStatus.COMPLETED);
        if (!success) {
            throw new WaitingRoomException("Failed to change request status. RequestId:{}", requestId);
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
        accessTokenMapper.add(queuePositionToken);
        return AccessTokenDto.from(queuePositionToken);
    }

    private QueueDto checkQueue(String queueId) {
        QueueDto queue = queueManageService.getQueueByQueueId(queueId);
        if (queue != null) {
            return queue;
        }
        throw new InvalidQueueIdException("No queue be found. QueueId:{}", queueId);
    }

    private boolean requestIsProcessed(RequestPosition requestPosition) throws RequestNotProcessedException {
        return requestPosition.getQueuePosition() != null;
    }

    private boolean requestIsExpired(QueueDto queue, RequestPosition requestPosition) throws RequestExpiredException {
        long tiq;
        if (requestPosition.getCanServedWhenEntry()) {
            tiq = dateDiff(requestPosition.getEntryTime(), new Date());
        } else {
            QueueServingPosition queueServingPosition =
                    queueServingPositionMapper.getById(requestPosition.getServingPositionIdWhenEntry() + 1);
            if (queueServingPosition == null) {
                return false;
            }
            tiq = dateDiff(queueServingPosition.getIssuedTime(), new Date());
        }

        return tiq >= queue.getPositionExpirySecond() * 1000;
    }

    private boolean requestIsServed(QueueServingPosition queueServingPosition, RequestPosition requestPosition)
            throws RequestNotServedException {
        return queueServingPosition.getServingPosition() >= requestPosition.getQueuePosition();
    }

    private String generateTokenValue() {
        return UUID.randomUUID().toString().replace("-", "");
    }

    private long dateDiff(Date date1, Date date2) {
        return date2.getTime() - date1.getTime();
    }
}
