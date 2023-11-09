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

package cn.zcn.virtual.waiting.room.app;

import cn.zcn.virtual.waiting.room.app.assembler.AccessTokenAssembler;
import cn.zcn.virtual.waiting.room.app.utils.DistributedLock;
import cn.zcn.virtual.waiting.room.client.api.QueueService;
import cn.zcn.virtual.waiting.room.client.dto.data.AccessTokenDTO;
import cn.zcn.virtual.waiting.room.domain.ability.QueueAbility;
import cn.zcn.virtual.waiting.room.domain.ability.RequestAbility;
import cn.zcn.virtual.waiting.room.domain.exception.*;
import cn.zcn.virtual.waiting.room.domain.gateway.cache.CacheGateway;
import cn.zcn.virtual.waiting.room.domain.gateway.repository.AccessTokenGateway;
import cn.zcn.virtual.waiting.room.domain.gateway.repository.QueueServingPositionGateway;
import cn.zcn.virtual.waiting.room.domain.gateway.repository.RequestPositionGateway;
import cn.zcn.virtual.waiting.room.domain.model.entity.*;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.support.TransactionTemplate;

/**
 * @author zicung
 */
@Service
public class QueueServiceImpl implements QueueService {

    private static final String QUEUE_LOCK_PREFIX = "queue-lock-";

    @Resource
    private QueueAbility queueAbility;

    @Resource
    private RequestAbility requestAbility;

    @Resource
    private DistributedLock distributedLock;

    @Resource
    private CacheGateway cacheGateway;

    @Resource
    private RequestPositionGateway requestPositionGateway;

    @Resource
    private AccessTokenGateway accessTokenGateway;

    @Resource
    private QueueServingPositionGateway queueServingPositionGateway;

    @Resource
    private TransactionTemplate transactionTemplate;

    @Override
    public long increaseServingPosition(String queueId, int incrementBy) {
        queueAbility.checkAndGet(queueId);

        String lockKey = QUEUE_LOCK_PREFIX + queueId;
        boolean locked = distributedLock.lock(lockKey, 5, TimeUnit.SECONDS);
        if (!locked) {
            throw new WaitingRoomException("Cant increase serving position because of no lock.");
        }

        try {
            QueueServingPosition latestQueueServingPos =
                    queueServingPositionGateway.getLatestPositionByQueueId(queueId);
            long newServingPos = incrementBy;
            if (latestQueueServingPos != null) {
                newServingPos += latestQueueServingPos.getServingPosition();
            }

            Date issuedTime = new Date();
            QueueServingPosition newQueueServingPos = new QueueServingPosition();
            newQueueServingPos.setQueueId(queueId);
            newQueueServingPos.setIssuedTime(issuedTime);
            newQueueServingPos.setServingPosition(newServingPos);
            queueServingPositionGateway.add(newQueueServingPos);

            // 更新缓存
            cacheGateway.increaseServingPosition(newQueueServingPos);

            return newServingPos;
        } finally {
            distributedLock.unlock(lockKey);
        }
    }

    @Override
    public void updateTokenStatus(String queueId, String requestId, int status) {
        AccessTokenStatus newStatus = AccessTokenStatus.getByValue(status);
        if (newStatus != AccessTokenStatus.ABANDONED && newStatus != AccessTokenStatus.COMPLETED) {
            throw new WaitingRoomException(
                    "The access token status must be {} or {}",
                    AccessTokenStatus.COMPLETED,
                    AccessTokenStatus.ABANDONED);
        }

        AccessToken accessToken = accessTokenGateway.getByQueueIdAndRequestId(queueId, requestId);
        if (accessToken.getStatus() == newStatus) {
            throw new WaitingRoomException("The status has already been set {}", newStatus.name());
        }

        cacheGateway.removeServingRequest(queueId, requestId);
        accessTokenGateway.changeStatus(queueId, requestId, accessToken.getStatus(), newStatus);
    }

    @Override
    public long getActiveTokenNum(String queueId, Date after) {
        queueAbility.checkAndGet(queueId);
        return cacheGateway.getServingRequestNum(queueId, after);
    }

    @Override
    public long getLatestServingPosition(String queueId) {
        queueAbility.checkAndGet(queueId);
        return cacheGateway.getLatestServingPosition(queueId);
    }

    @Override
    public int getWaitingNum(String queueId) {
        queueAbility.checkAndGet(queueId);
        return cacheGateway.getWaitingNum(queueId);
    }

    @Override
    public AccessTokenDTO generateToken(String queueId, String requestId) {
        Queue queue = queueAbility.checkAndGet(queueId);
        RequestPosition requestPosition = requestPositionGateway.getByQueueIdAndRequestId(queueId, requestId);
        if (requestPosition == null) {
            throw new InvalidRequestIdException("Request cant be found.");
        }

        if (!requestPosition.isProcessed()) {
            throw new RequestNotProcessedException("Request has not been processed.");
        }

        // 检查Request状态，防止重复获取令牌
        if (!requestPosition.canIssueAccessToken()) {
            throw new WaitingRoomException(
                    "Excepted request status {}, but got {}.",
                    RequestStatus.INCOMPLETE.name(),
                    requestPosition.getStatus().name());
        }

        Long closestServingPositionIssuedTime =
                cacheGateway.getIssuedTimeByClosestServingPosition(queueId, requestPosition.getQueuePosition());
        if (!requestPosition.canBeServed(closestServingPositionIssuedTime)) {
            throw new RequestNotServedException("Request not being served.");
        }

        // 计算是否过期
        if (requestAbility.checkIfExpired(requestPosition, queue)) {
            throw new RequestExpiredException("Request is expired.");
        }

        // 生成访问令牌
        AccessToken accessToken = AccessToken.create(
                queueId, requestId, requestPosition.getQueuePosition(), queue.getTokenValiditySecond());

        // 更新可服务的Request的数量
        cacheGateway.increaseServingRequestNum(queueId, requestId, accessToken.getExpiredTime());

        transactionTemplate.executeWithoutResult(transactionStatus -> {
            // 更新Request状态
            boolean success = requestPositionGateway.changeRequestStatus(
                    requestPosition.getRequestId(), RequestStatus.INCOMPLETE, RequestStatus.COMPLETED);
            if (!success) {
                throw new WaitingRoomException("Failed to change request status.");
            }

            // 保存访问令牌
            accessTokenGateway.add(accessToken);
        });

        return AccessTokenAssembler.INSTANCE.toAccessTokenDTO(accessToken);
    }
}
