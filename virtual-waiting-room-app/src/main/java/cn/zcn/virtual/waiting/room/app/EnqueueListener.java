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

import cn.zcn.virtual.waiting.room.domain.ability.QueueAbility;
import cn.zcn.virtual.waiting.room.domain.gateway.cache.CacheGateway;
import cn.zcn.virtual.waiting.room.domain.gateway.mq.MqGateway;
import cn.zcn.virtual.waiting.room.domain.gateway.repository.RequestPositionGateway;
import cn.zcn.virtual.waiting.room.domain.model.entity.RequestPosition;
import cn.zcn.virtual.waiting.room.domain.model.event.AssignRequestIdEvent;
import javax.annotation.Resource;
import org.apache.rocketmq.spring.annotation.MessageModel;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Service;

/**
 * @author zicung
 */
@Service
@RocketMQMessageListener(
        consumerGroup = "virtual-waiting-room-consumer",
        topic = MqGateway.TOPIC_ASSIGN_POS,
        messageModel = MessageModel.CLUSTERING,
        maxReconsumeTimes = 2)
public class EnqueueListener implements RocketMQListener<AssignRequestIdEvent> {

    @Resource
    private QueueAbility queueAbility;

    @Resource
    private CacheGateway cacheGateway;

    @Resource
    private RequestPositionGateway requestPositionGateway;

    @Override
    public void onMessage(AssignRequestIdEvent event) {
        String queueId = event.getQueueId();
        String requestId = event.getRequestId();

        queueAbility.checkAndGet(queueId);

        RequestPosition requestPosition = cacheGateway.getTransientRequestPosition(requestId);
        if (requestPosition == null) {
            return;
        }

        // 进入等候室排队，并获取排队位置
        long position = cacheGateway.nextQueuePosition(queueId);

        // 获取等候室最新的servingPosition
        long latestQueueServingPosition = cacheGateway.getLatestServingPosition(event.getQueueId());
        requestPosition.assignQueuePosition(position, latestQueueServingPosition);

        cacheGateway.deleteTransientRequestPosition(requestId);
        requestPositionGateway.add(requestPosition);
    }
}
