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
import cn.zcn.virtual.waiting.room.exception.InvalidRequestIdException;
import cn.zcn.virtual.waiting.room.exception.WaitingRoomException;
import cn.zcn.virtual.waiting.room.repository.RequestPositionMapper;
import cn.zcn.virtual.waiting.room.repository.entity.RequestPosition;
import cn.zcn.virtual.waiting.room.repository.entity.RequestStatus;
import cn.zcn.virtual.waiting.room.service.QueueManageService;
import cn.zcn.virtual.waiting.room.service.RequestService;
import cn.zcn.virtual.waiting.room.service.dto.QueueDto;
import cn.zcn.virtual.waiting.room.utils.RedisKeyUtils;
import java.util.Date;
import java.util.UUID;
import javax.annotation.Resource;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.client.producer.SendStatus;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * @author zicung
 */
@Service
public class RequestServiceImpl implements RequestService {

    protected static final String TOPIC_ASSIGN_POS = "assign-pos";

    @Resource
    private RocketMQTemplate rocketMQTemplate;

    @Resource
    private QueueManageService queueManageService;

    @Resource
    private CacheManager cacheManager;

    @Resource
    private RequestPositionMapper requestPositionMapper;

    @Override
    public String assignPosition(String queueId) throws InvalidQueueIdException {
        QueueDto queue = queueManageService.getQueueByQueueId(queueId);
        if (queue == null) {
            throw new InvalidQueueIdException("No queue be found. QueueId:{}", queueId);
        }

        // 生成RequestId并写入缓存
        RequestPosition reqPos = new RequestPosition();
        reqPos.setQueueId(queueId);
        reqPos.setRequestId(generateRequestId());
        reqPos.setCreateTime(new Date());
        reqPos.setStatus(RequestStatus.INCOMPLETE);
        cacheManager.getCache(RedisKeyUtils.REQUEST_NAME).put(reqPos.getRequestId(), reqPos);

        // 发送到MQ
        SendResult sendResult = rocketMQTemplate.syncSend(TOPIC_ASSIGN_POS, reqPos);
        if (sendResult.getSendStatus() != SendStatus.SEND_OK) {
            throw new WaitingRoomException("Failed to send RequestPosition to MQ. SendStatus:"
                    + sendResult.getSendStatus().name());
        }
        return reqPos.getRequestId();
    }

    @Override
    @Cacheable(cacheNames = RedisKeyUtils.REQUEST_NAME, unless = "#result == null", key = "#requestId")
    public RequestPosition getRequestPosition(String queueId, String requestId) throws InvalidRequestIdException {
        RequestPosition requestPosition = requestPositionMapper.getByQueueIdAndRequestId(queueId, requestId);
        if (requestPosition != null) {
            return requestPosition;
        }
        throw new InvalidRequestIdException("No request be found. QueueId:{}, RequestId:{}.", queueId, requestId);
    }

    @Override
    @CacheEvict(cacheNames = RedisKeyUtils.REQUEST_NAME, key = "#id", condition = "#result")
    public boolean changeRequestStatus(int id, RequestStatus oldStatus, RequestStatus newStatus) {
        int count = requestPositionMapper.changeRequestStatus(id, oldStatus, newStatus);
        return count >= 1;
    }

    private String generateRequestId() {
        return UUID.randomUUID().toString().replace("-", "");
    }
}
