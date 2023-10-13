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

import cn.zcn.virtual.waiting.room.exception.WaitingRoomException;
import cn.zcn.virtual.waiting.room.repository.QueueMapper;
import cn.zcn.virtual.waiting.room.repository.QueueServingPositionMapper;
import cn.zcn.virtual.waiting.room.repository.entity.Queue;
import cn.zcn.virtual.waiting.room.repository.entity.QueueServingPosition;
import cn.zcn.virtual.waiting.room.service.QueueManageService;
import cn.zcn.virtual.waiting.room.service.dto.CreateQueueCmd;
import cn.zcn.virtual.waiting.room.service.dto.QueueDto;
import cn.zcn.virtual.waiting.room.service.dto.UpdateQueueCmd;
import java.util.Date;
import javax.annotation.Resource;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author zicung
 */
@Service
public class QueueManageServiceImpl implements QueueManageService {

    @Resource
    private QueueMapper queueMapper;

    @Resource
    private QueueServingPositionMapper queueServingPositionMapper;

    @Override
    @Transactional
    public QueueDto addQueue(CreateQueueCmd createQueueCmd) throws WaitingRoomException {
        if (createQueueCmd.getQueueId() == null) {
            throw new WaitingRoomException("QueueId must not be null.");
        }

        Queue exist = queueMapper.getByQueueId(createQueueCmd.getQueueId());
        if (exist != null) {
            throw new WaitingRoomException("Duplicate QueueId. QueueId:{}.", createQueueCmd.getQueueId());
        }

        Queue queue = new Queue();
        queue.setQueueId(createQueueCmd.getQueueId());
        queue.setTokenValiditySecond(createQueueCmd.getTokenValiditySecond());
        queue.setEnableQueuePositionExpiry(createQueueCmd.getEnableQueuePositionExpiry());
        queue.setPositionExpirySecond(createQueueCmd.getPositionExpirySecond());
        queueMapper.add(queue);

        // 设置初始 ServingPosition
        QueueServingPosition queueServingPosition = new QueueServingPosition();
        queueServingPosition.setQueueId(queue.getQueueId());
        queueServingPosition.setServingPosition(0L);
        queueServingPosition.setIssuedTime(new Date());
        queueServingPositionMapper.add(queueServingPosition);

        return QueueDto.from(queue);
    }

    @Override
    public QueueDto getQueueById(Integer id) throws WaitingRoomException {
        if (id == null) {
            throw new WaitingRoomException("Missing id.");
        }

        Queue queue = queueMapper.getById(id);
        return QueueDto.from(queue);
    }

    @Override
    @Cacheable(cacheNames = "queue", key = "#queueId")
    public QueueDto getQueueByQueueId(String queueId) throws WaitingRoomException {
        if (queueId == null) {
            throw new WaitingRoomException("Missing queueId.");
        }

        Queue queue = queueMapper.getByQueueId(queueId);
        return QueueDto.from(queue);
    }

    @Override
    @CacheEvict(cacheNames = "queue", key = "#result.queueId")
    public QueueDto deleteById(Integer id) throws WaitingRoomException {
        if (id == null) {
            throw new WaitingRoomException("Missing queue id.");
        }

        Queue exist = queueMapper.getById(id);
        if (exist == null) {
            return null;
        }

        int deleted = queueMapper.deleteById(exist.getId());
        return deleted >= 0 ? QueueDto.from(exist) : null;
    }

    @Override
    @CacheEvict(cacheNames = "queue", key = "#result.queueId")
    public QueueDto updateQueue(UpdateQueueCmd updateQueueCmd) throws WaitingRoomException {
        if (updateQueueCmd.getId() == null) {
            throw new WaitingRoomException("Id must not be null.");
        }

        Queue queue = queueMapper.getById(updateQueueCmd.getId());
        if (queue == null) {
            throw new WaitingRoomException("Queue cant be found. Id:{}", updateQueueCmd.getId());
        }
        queue.setTokenValiditySecond(updateQueueCmd.getTokenValiditySecond());
        queue.setEnableQueuePositionExpiry(updateQueueCmd.getEnableQueuePositionExpiry());
        queue.setPositionExpirySecond(updateQueueCmd.getPositionExpirySecond());
        queueMapper.update(queue);
        return QueueDto.from(queue);
    }
}
