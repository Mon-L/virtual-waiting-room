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
import static cn.zcn.virtual.waiting.room.utils.RedisKeyUtils.getRequestKey;

import cn.zcn.virtual.waiting.room.exception.InvalidQueueIdException;
import cn.zcn.virtual.waiting.room.service.AssignPosService;
import cn.zcn.virtual.waiting.room.service.QueueService;
import cn.zcn.virtual.waiting.room.service.dto.AssignPosDto;
import cn.zcn.virtual.waiting.room.service.dto.QueuePositionDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Date;
import java.util.Map;
import java.util.UUID;
import javax.annotation.Resource;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.client.producer.SendStatus;
import org.apache.rocketmq.spring.annotation.MessageModel;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.data.redis.core.RedisTemplate;
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
public class AssignPosServiceImpl implements AssignPosService, RocketMQListener<AssignPosDto> {

    protected static final String TOPIC_ASSIGN_POS = "assign-pos";

    @Resource
    private QueueService queueService;

    @Resource
    private ObjectMapper objectMapper;

    @Resource
    private RocketMQTemplate rocketMQTemplate;

    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    @Override
    public String assignPos(String queueId) throws InvalidQueueIdException {
        if (redisTemplate.hasKey(getQueueKey(queueId)) != Boolean.TRUE) {
            throw new InvalidQueueIdException("No queue found. QueueId:{}", queueId);
        }

        String requestId = generateRequestId();
        QueuePositionDto queuePositionDto = new QueuePositionDto();
        queuePositionDto.setQueueId(queueId);
        queuePositionDto.setRequestId(requestId);
        redisTemplate
                .opsForHash()
                .putAll(getRequestKey(queueId, requestId), objectMapper.convertValue(queuePositionDto, Map.class));

        AssignPosDto assignPosDto = new AssignPosDto();
        assignPosDto.setQueueId(queueId);
        assignPosDto.setRequestId(requestId);
        assignPosDto.setCreateTime(new Date());
        SendResult sendResult = rocketMQTemplate.syncSend(TOPIC_ASSIGN_POS, assignPosDto);
        if (sendResult.getSendStatus() != SendStatus.SEND_OK) {
            throw new InvalidQueueIdException("Failed to send AssignPos to MQ. SendStatus:"
                    + sendResult.getSendStatus().name());
        }
        return assignPosDto.getRequestId();
    }

    @Override
    public void onMessage(AssignPosDto assignPosDto) {
        queueService.enqueue(assignPosDto.getQueueId(), assignPosDto.getRequestId());
    }

    private String generateRequestId() {
        return UUID.randomUUID().toString().replace("-", "");
    }
}
