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

package cn.zcn.virtual.waiting.room.infrastructure.repository.gateway;

import cn.zcn.virtual.waiting.room.domain.gateway.repository.QueueServingPositionGateway;
import cn.zcn.virtual.waiting.room.domain.model.entity.QueueServingPosition;
import cn.zcn.virtual.waiting.room.infrastructure.repository.QueueServingPositionMapper;
import cn.zcn.virtual.waiting.room.infrastructure.repository.converter.QueueServingPositionConverter;
import cn.zcn.virtual.waiting.room.infrastructure.repository.po.QueueServingPositionPO;
import javax.annotation.Resource;
import org.springframework.stereotype.Component;

/**
 * @author zicung
 */
@Component
public class QueueServingPositionGatewayImpl implements QueueServingPositionGateway {

    @Resource
    private QueueServingPositionMapper queueServingPositionMapper;

    @Override
    public QueueServingPosition add(QueueServingPosition queueServingPosition) {
        QueueServingPositionPO po = QueueServingPositionConverter.INSTANCE.entityToPO(queueServingPosition);
        queueServingPositionMapper.add(po);
        return QueueServingPositionConverter.INSTANCE.poToEntity(po);
    }

    @Override
    public QueueServingPosition getLatestPositionByQueueId(String queueId) {
        QueueServingPositionPO po = queueServingPositionMapper.getLatestPositionByQueueId(queueId);
        return po != null ? QueueServingPositionConverter.INSTANCE.poToEntity(po) : null;
    }

    @Override
    public QueueServingPosition getClosestServingPositionGe(String queueId, long queuePosition) {
        QueueServingPositionPO po = queueServingPositionMapper.getClosestServingPositionGe(queueId, queuePosition);
        return po != null ? QueueServingPositionConverter.INSTANCE.poToEntity(po) : null;
    }
}
