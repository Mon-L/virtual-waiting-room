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
import cn.zcn.virtual.waiting.room.repository.entity.*;
import cn.zcn.virtual.waiting.room.script.DequeueScript;
import cn.zcn.virtual.waiting.room.script.EnqueueScript;
import cn.zcn.virtual.waiting.room.script.GetServingRequestsNumScript;
import cn.zcn.virtual.waiting.room.script.LuaScriptLoader;
import cn.zcn.virtual.waiting.room.service.QueueManageService;
import cn.zcn.virtual.waiting.room.service.QueueService;
import cn.zcn.virtual.waiting.room.service.RequestService;
import cn.zcn.virtual.waiting.room.service.dto.AccessTokenDto;
import cn.zcn.virtual.waiting.room.service.dto.QueueDto;
import cn.zcn.virtual.waiting.room.utils.RedisKeyUtils;
import org.apache.rocketmq.spring.annotation.MessageModel;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.cache.CacheManager;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.Set;
import java.util.UUID;

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
    private CacheManager cacheManager;

    @Resource
    private QueueManageService queueManageService;

    @Resource
    private AccessTokenMapper accessTokenMapper;

    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    @Resource
    private RequestPositionMapper requestPositionMapper;

    @Resource
    private QueueServingPositionMapper queueServingPositionMapper;

    @Override
    public void enqueue(String queueId, String requestId)
            throws InvalidQueueIdException, InvalidRequestIdException, RequestExpiredException {
        checkQueue(queueId);

        // 获取RequestPosition，实际上是从缓存中获取。在生成RequestId时，RequestPosition写进了缓存，但还没有写入数据库。
        RequestPosition requestPosition = requestService.getRequestPosition(queueId, requestId);

        // 进入等候室
        EnqueueScript enqueueScript = redisScriptLoader.get(EnqueueScript.class);
        long pos = enqueueScript.execute(redisTemplate, queueId);

        // 写入数据库
        long latestServingPosition = getLatestServingPosition(queueId);
        requestPosition.setQueuePosition(pos);
        requestPosition.setEntryTime(new Date());
        requestPosition.setCanServedWhenEntry(latestServingPosition >= pos);
        requestPositionMapper.add(requestPosition);

        // 更新Request缓存
        cacheManager.getCache(RedisKeyUtils.REQUEST_NAME).put(requestId, requestPosition);
    }

    @Override
    public int getWaitingNum(String queueId) throws InvalidQueueIdException {
        checkQueue(queueId);
        Integer waitingNum = (Integer) redisTemplate.opsForValue().get(RedisKeyUtils.getQueueWaitingNumKey(queueId));
        return waitingNum == null ? 0 : waitingNum;
    }

    @Override
    public long getLatestServingPosition(String queueId) {
        checkQueue(queueId);

        Set<ZSetOperations.TypedTuple<Object>> set = redisTemplate
                .opsForZSet()
                .reverseRangeWithScores(RedisKeyUtils.getQueueIssuedServingPosition(queueId), 0, 0);
        if (set == null || set.isEmpty()) {
            return 0;
        }
        return set.iterator().next().getScore().longValue();
    }

    @Override
    @Transactional
    public long incrementServingPosition(String queueId, int incrementBy) throws InvalidQueueIdException {
        checkQueue(queueId);
        QueueServingPosition latestQueueServingPos =
                queueServingPositionMapper.getLatestPositionByQueueId(queueId, true);

        long newServingPos = incrementBy;
        if (latestQueueServingPos != null) {
            newServingPos += latestQueueServingPos.getServingPosition();
        }

        Date issuedTime = new Date();
        QueueServingPosition newQueueServingPos = new QueueServingPosition();
        newQueueServingPos.setQueueId(queueId);
        newQueueServingPos.setIssuedTime(issuedTime);
        newQueueServingPos.setServingPosition(newServingPos);
        queueServingPositionMapper.add(newQueueServingPos);

        redisTemplate
                .opsForZSet()
                .add(RedisKeyUtils.getQueueIssuedServingPosition(queueId), issuedTime.getTime(), newServingPos);

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
        RequestPosition requestPosition = requestService.getRequestPosition(queueId, requestId);

        // 检查Request状态，防止重复获取令牌
        if (requestPosition.getStatus() != RequestStatus.INCOMPLETE) {
            throw new WaitingRoomException(
                    "Excepted request status{}, but got {}.",
                    RequestStatus.INCOMPLETE.name(),
                    requestPosition.getStatus().name());
        }

        QueueServingPosition servingPosition =
                queueServingPositionMapper.getFirstServingPositionGe(queueId, requestPosition.getQueuePosition());

        if (!requestIsProcessed(requestPosition)) {
            throw new RequestNotProcessedException(
                    "Request has not been processed. RequestId:{}", requestPosition.getRequestId());
        }

        if (!requestIsServed(servingPosition, requestPosition)) {
            throw new RequestNotServedException(
                    "Request not being served. QueueId:{}, RequestId:{}.", queueId, requestPosition.getQueuePosition());
        }

        if (queue.getEnableQueuePositionExpiry() && requestIsExpired(queue, requestPosition, servingPosition)) {
            throw new RequestExpiredException("Request is expired. RequestId:{}.", requestPosition.getRequestId());
        }

        // 更新Request状态
        boolean success = requestService.changeRequestStatus(
                requestPosition.getId(), RequestStatus.INCOMPLETE, RequestStatus.COMPLETED);
        if (!success) {
            throw new WaitingRoomException("Failed to change request status. RequestId:{}", requestId);
        }

        // 生成访问令牌
        Instant now = Instant.now();
        AccessToken queuePositionToken = new AccessToken();
        queuePositionToken.setQueueId(queueId);
        queuePositionToken.setRequestId(requestId);
        queuePositionToken.setPosition(requestPosition.getQueuePosition());
        queuePositionToken.setCreateTime(Date.from(now));
        queuePositionToken.setTokenType(AccessToken.BEARER_TOKEN_TYPE);
        queuePositionToken.setStatus(AccessTokenStatus.ACTIVE);
        queuePositionToken.setTokenValue(generateTokenValue());

        if (queue.getTokenValiditySecond() != null) {
            Instant expiredTime = now.plus(queue.getTokenValiditySecond(), ChronoUnit.SECONDS);
            queuePositionToken.setExpiredTime(Date.from(expiredTime));
        }
        accessTokenMapper.add(queuePositionToken);

        // Request离开排队队列
        DequeueScript dequeueScript = redisScriptLoader.get(DequeueScript.class);
        dequeueScript.execute(
                redisTemplate,
                queueId,
                requestId,
                queuePositionToken.getExpiredTime().getTime());

        return AccessTokenDto.from(queuePositionToken);
    }

    @Override
    public void updateTokenStatus(String queueId, String requestId, AccessTokenStatus newStatus)
            throws WaitingRoomException {
        if (newStatus != AccessTokenStatus.ABANDONED && newStatus != AccessTokenStatus.COMPLETED) {
            throw new WaitingRoomException(
                    "The access token status must be {} or {}",
                    AccessTokenStatus.COMPLETED,
                    AccessTokenStatus.ABANDONED);
        }

        AccessToken accessToken = accessTokenMapper.getByQueueIdAndRequestId(queueId, requestId);
        if (accessToken.getStatus() == newStatus) {
            throw new WaitingRoomException("The status has already been set {}", newStatus.name());
        }

        int num = accessTokenMapper.changeStatus(queueId, requestId, accessToken.getStatus(), newStatus);
        if (num > 0) {
            // 把Request从可进入网站的列表中移除
            redisTemplate.opsForZSet().remove(RedisKeyUtils.getQueueServingRequests(queueId), requestId);
        }
    }

    @Override
    public long getActiveTokenNum(String queueId, Date after) {
        GetServingRequestsNumScript getServingRequestsNumScript =
                redisScriptLoader.get(GetServingRequestsNumScript.class);
        return getServingRequestsNumScript.execute(redisTemplate, queueId, after.getTime());
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

    private boolean requestIsExpired(
            QueueDto queue, RequestPosition requestPosition, QueueServingPosition servingPosition)
            throws RequestExpiredException {
        long tiq;
        if (requestPosition.getCanServedWhenEntry()) {
            tiq = dateDiff(requestPosition.getEntryTime(), new Date());
        } else {
            tiq = dateDiff(servingPosition.getIssuedTime(), new Date());
        }

        return tiq >= queue.getPositionExpirySecond() * 1000;
    }

    private boolean requestIsServed(QueueServingPosition queueServingPosition, RequestPosition requestPosition)
            throws RequestNotServedException {
        return queueServingPosition != null && queueServingPosition.getServingPosition() >= requestPosition.getQueuePosition();
    }

    private String generateTokenValue() {
        return UUID.randomUUID().toString().replace("-", "");
    }

    private long dateDiff(Date date1, Date date2) {
        return date2.getTime() - date1.getTime();
    }
}
