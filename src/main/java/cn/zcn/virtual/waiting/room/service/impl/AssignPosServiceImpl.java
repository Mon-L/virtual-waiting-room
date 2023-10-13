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

import cn.zcn.virtual.waiting.room.exception.InvalidQueueIdException;
import cn.zcn.virtual.waiting.room.exception.WaitingRoomException;
import cn.zcn.virtual.waiting.room.repository.RequestPositionMapper;
import cn.zcn.virtual.waiting.room.repository.entity.RequestPosition;
import cn.zcn.virtual.waiting.room.repository.entity.RequestStatus;
import cn.zcn.virtual.waiting.room.service.AssignPosService;
import cn.zcn.virtual.waiting.room.service.QueueManageService;
import cn.zcn.virtual.waiting.room.service.QueueService;
import cn.zcn.virtual.waiting.room.service.dto.QueueDto;
import java.util.Date;
import java.util.UUID;
import javax.annotation.Resource;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.client.producer.SendStatus;
import org.apache.rocketmq.spring.annotation.MessageModel;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.stereotype.Service;

/**
 * @author zicung
 */
@Service
@RocketMQMessageListener(
        consumerGroup = "virtual-waiting-room-consumer",
        topic = AssignPosServiceImpl.TOPIC_ASSIGN_POS,
        messageModel = MessageModel.CLUSTERING,
        maxReconsumeTimes = 2)
public class AssignPosServiceImpl implements AssignPosService, RocketMQListener<RequestPosition> {

    protected static final String TOPIC_ASSIGN_POS = "assign-pos";

    @Resource
    private QueueService queueService;

    @Resource
    private RocketMQTemplate rocketMQTemplate;

    @Resource
    private QueueManageService queueManageService;

    @Resource
    private RequestPositionMapper queuePositionMapper;

    @Override
    public String assignPos(String queueId) throws InvalidQueueIdException {
        QueueDto queue = queueManageService.getQueueByQueueId(queueId);
        if (queue == null) {
            throw new InvalidQueueIdException("No queue be found. QueueId:{}", queueId);
        }

        RequestPosition reqPos = new RequestPosition();
        reqPos.setQueueId(queueId);
        reqPos.setRequestId(generateRequestId());
        reqPos.setCreateTime(new Date());
        reqPos.setStatus(RequestStatus.INCOMPLETE);
        queuePositionMapper.add(reqPos);

        SendResult sendResult = rocketMQTemplate.syncSend(TOPIC_ASSIGN_POS, reqPos);
        if (sendResult.getSendStatus() != SendStatus.SEND_OK) {
            throw new WaitingRoomException("Failed to send RequestPosition to MQ. SendStatus:"
                    + sendResult.getSendStatus().name());
        }
        return reqPos.getRequestId();
    }

    @Override
    public void onMessage(RequestPosition requestPosition) {
        queueService.enqueue(requestPosition.getQueueId(), requestPosition.getRequestId());
    }

    private String generateRequestId() {
        return UUID.randomUUID().toString().replace("-", "");
    }
}
