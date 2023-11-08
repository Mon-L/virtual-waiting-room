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

import cn.zcn.virtual.waiting.room.domain.gateway.repository.RequestPositionGateway;
import cn.zcn.virtual.waiting.room.domain.model.entity.RequestPosition;
import cn.zcn.virtual.waiting.room.domain.model.entity.RequestStatus;
import cn.zcn.virtual.waiting.room.domain.utils.RedisKeyUtils;
import cn.zcn.virtual.waiting.room.infrastructure.repository.RequestPositionMapper;
import cn.zcn.virtual.waiting.room.infrastructure.repository.converter.RequestPositionConverter;
import cn.zcn.virtual.waiting.room.infrastructure.repository.po.RequestPositionPO;
import javax.annotation.Resource;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

/**
 * @author zicung
 */
@Component
public class RequestPositionGatewayImpl implements RequestPositionGateway {

    @Resource
    private RequestPositionMapper requestPositionMapper;

    @Override
    public RequestPosition add(RequestPosition requestPosition) {
        RequestPositionPO po = RequestPositionConverter.INSTANCE.entityToPO(requestPosition);
        requestPositionMapper.add(po);
        return RequestPositionConverter.INSTANCE.poToEntity(po);
    }

    @Override
    @CacheEvict(
            cacheNames = RedisKeyUtils.REQUEST_NAME,
            condition = "#result == true ",
            key = "#requestPosition.requestId")
    public boolean update(RequestPosition requestPosition) {
        int count = requestPositionMapper.updatePosition(
                requestPosition.getId(),
                requestPosition.getQueuePosition(),
                requestPosition.getEntryTime(),
                requestPosition.getCanServedWhenEntry());
        return count > 0;
    }

    @Override
    @Cacheable(cacheNames = RedisKeyUtils.REQUEST_NAME, unless = "#result == null", key = "#requestId")
    public RequestPosition getByQueueIdAndRequestId(String queueId, String requestId) {
        RequestPositionPO po = requestPositionMapper.getByQueueIdAndRequestId(queueId, requestId);
        return po != null ? RequestPositionConverter.INSTANCE.poToEntity(po) : null;
    }

    @Override
    public boolean changeRequestStatus(int id, RequestStatus oldStatus, RequestStatus newStatus) {
        int count = requestPositionMapper.changeRequestStatus(id, oldStatus, newStatus);
        return count > 0;
    }
}
