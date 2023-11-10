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

import cn.zcn.virtual.waiting.room.client.api.RequestService;
import cn.zcn.virtual.waiting.room.domain.ability.QueueAbility;
import cn.zcn.virtual.waiting.room.domain.ability.RequestAbility;
import cn.zcn.virtual.waiting.room.domain.exception.InvalidRequestIdException;
import cn.zcn.virtual.waiting.room.domain.exception.RequestExpiredException;
import cn.zcn.virtual.waiting.room.domain.exception.RequestNotProcessedException;
import cn.zcn.virtual.waiting.room.domain.gateway.cache.CacheGateway;
import cn.zcn.virtual.waiting.room.domain.gateway.mq.MqGateway;
import cn.zcn.virtual.waiting.room.domain.gateway.repository.RequestPositionGateway;
import cn.zcn.virtual.waiting.room.domain.model.entity.Queue;
import cn.zcn.virtual.waiting.room.domain.model.entity.RequestPosition;
import cn.zcn.virtual.waiting.room.domain.model.event.AssignRequestIdEvent;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * @author zicung
 */
@Service
public class RequestServiceImpl implements RequestService {

    @Resource
    private MqGateway mqGateway;

    @Resource
    private CacheGateway cacheGateway;

    @Resource
    private QueueAbility queueAbility;

    @Resource
    private RequestAbility requestAbility;

    @Resource
    private RequestPositionGateway requestPositionGateway;

    @Override
    public String assignPosition(String queueId) {
        queueAbility.checkAndGet(queueId);

        // 生成RequestId
        RequestPosition requestPosition = RequestPosition.create(queueId);

        // 保存RequestPosition到缓存
        cacheGateway.addTransientRequestPosition(requestPosition);

        // 发送到MQ
        mqGateway.sendAssignRequest(
                new AssignRequestIdEvent(queueId, requestPosition.getRequestId(), requestPosition.getCreateTime()));
        return requestPosition.getRequestId();
    }

    @Override
    public Long getRequestPosition(String queueId, String requestId)
            throws InvalidRequestIdException, RequestNotProcessedException {
        RequestPosition requestPosition = requestPositionGateway.getByQueueIdAndRequestId(queueId, requestId);
        if (requestPosition == null) {
            throw new InvalidRequestIdException("Request cant be found.");
        }

        if (!requestPosition.isProcessed()) {
            throw new RequestNotProcessedException("Request has not been processed.");
        }

        if (requestPosition.isCompleted()) {
            return requestPosition.getQueuePosition();
        }

        Queue queue = queueAbility.checkAndGet(queueId);
        if (requestAbility.checkIfExpired(requestPosition, queue)) {
            throw new RequestExpiredException("Request is expired.");
        }

        return requestPosition.getQueuePosition();
    }
}
