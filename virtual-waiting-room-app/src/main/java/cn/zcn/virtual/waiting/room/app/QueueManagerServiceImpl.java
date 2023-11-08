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

import cn.zcn.virtual.waiting.room.app.assembler.QueueAssembler;
import cn.zcn.virtual.waiting.room.client.api.QueueManageService;
import cn.zcn.virtual.waiting.room.client.dto.QueueCreateCmd;
import cn.zcn.virtual.waiting.room.client.dto.QueueUpdateCmd;
import cn.zcn.virtual.waiting.room.client.dto.data.QueueDTO;
import cn.zcn.virtual.waiting.room.domain.exception.WaitingRoomException;
import cn.zcn.virtual.waiting.room.domain.gateway.repository.QueueGateway;
import cn.zcn.virtual.waiting.room.domain.gateway.repository.QueueServingPositionGateway;
import cn.zcn.virtual.waiting.room.domain.model.entity.Queue;
import cn.zcn.virtual.waiting.room.domain.model.entity.QueueServingPosition;
import java.util.Date;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author zicung
 */
@Service
public class QueueManagerServiceImpl implements QueueManageService {

    @Resource
    private QueueGateway queueGateway;

    @Resource
    private QueueServingPositionGateway queueServingPositionGateway;

    @Override
    @Transactional
    public QueueDTO addQueue(QueueCreateCmd queueCreateCmd) {
        Queue queue = QueueAssembler.INSTANCE.toQueue(queueCreateCmd);
        if (queue.getQueueId() == null) {
            throw new WaitingRoomException("QueueId must not be null.");
        }

        Queue exist = queueGateway.getQueueByQueueId(queue.getQueueId());
        if (exist != null) {
            throw new WaitingRoomException("Duplicate QueueId. QueueId:{}.", queue.getQueueId());
        }

        queue = queueGateway.addQueue(queue);

        // 设置初始的 ServingPosition
        QueueServingPosition queueServingPosition = new QueueServingPosition();
        queueServingPosition.setQueueId(queue.getQueueId());
        queueServingPosition.setServingPosition(0L);
        queueServingPosition.setIssuedTime(new Date());
        queueServingPositionGateway.add(queueServingPosition);

        return QueueAssembler.INSTANCE.toQueueDTO(queue);
    }

    @Override
    public QueueDTO getQueueById(int id) {
        Queue queue = queueGateway.getQueueById(id);
        return queue == null ? null : QueueAssembler.INSTANCE.toQueueDTO(queue);
    }

    @Override
    public QueueDTO deleteById(int id) {
        Queue deleted = queueGateway.deleteQueueById(id);
        return deleted != null ? QueueAssembler.INSTANCE.toQueueDTO(deleted) : null;
    }

    @Override
    public QueueDTO updateQueue(QueueUpdateCmd queueUpdateCmd) {
        Queue queue = queueGateway.getQueueById(queueUpdateCmd.getId());
        if (queue == null) {
            throw new WaitingRoomException("Queue cant be found.");
        }

        queue.setTokenValiditySecond(queueUpdateCmd.getTokenValiditySecond());
        queue.setEnableQueuePositionExpiry(queueUpdateCmd.getEnableQueuePositionExpiry());
        queue.setPositionExpirySecond(queueUpdateCmd.getPositionExpirySecond());
        queueGateway.updateQueue(queue);
        return QueueAssembler.INSTANCE.toQueueDTO(queue);
    }
}
