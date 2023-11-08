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

import cn.zcn.virtual.waiting.room.domain.gateway.repository.QueueGateway;
import cn.zcn.virtual.waiting.room.domain.model.entity.Queue;
import cn.zcn.virtual.waiting.room.domain.utils.RedisKeyUtils;
import cn.zcn.virtual.waiting.room.infrastructure.repository.QueueMapper;
import cn.zcn.virtual.waiting.room.infrastructure.repository.converter.QueueConverter;
import cn.zcn.virtual.waiting.room.infrastructure.repository.po.QueuePO;
import javax.annotation.Resource;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

/**
 * @author zicung
 */
@Component
public class QueueGatewayImpl implements QueueGateway {

    @Resource
    private QueueMapper queueMapper;

    @Override
    public Queue getQueueById(int id) {
        QueuePO queuePO = queueMapper.getById(id);
        return queuePO != null ? QueueConverter.INSTANCE.poToEntity(queuePO) : null;
    }

    @Override
    @Cacheable(cacheNames = RedisKeyUtils.QUEUE_NAME, unless = "#result == null", key = "#queueId")
    public Queue getQueueByQueueId(String queueId) {
        QueuePO queuePO = queueMapper.getByQueueId(queueId);
        return queuePO != null ? QueueConverter.INSTANCE.poToEntity(queuePO) : null;
    }

    @Override
    @CacheEvict(cacheNames = RedisKeyUtils.QUEUE_NAME, key = "#result.queueId")
    public Queue deleteQueueById(int id) {
        QueuePO exist = queueMapper.getById(id);
        if (exist == null) {
            return null;
        }

        int deleted = queueMapper.deleteById(exist.getId());
        return deleted > 0 ? QueueConverter.INSTANCE.poToEntity(exist) : null;
    }

    @Override
    public Queue addQueue(Queue queue) {
        QueuePO queuePO = QueueConverter.INSTANCE.entityToPO(queue);
        queueMapper.add(queuePO);
        return QueueConverter.INSTANCE.poToEntity(queuePO);
    }

    @Override
    @CacheEvict(cacheNames = RedisKeyUtils.QUEUE_NAME, key = "#queue.queueId")
    public boolean updateQueue(Queue queue) {
        QueuePO queuePO = QueueConverter.INSTANCE.entityToPO(queue);
        int count = queueMapper.update(queuePO);
        return count > 0;
    }
}
