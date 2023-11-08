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

import cn.zcn.virtual.waiting.room.domain.gateway.repository.AccessTokenGateway;
import cn.zcn.virtual.waiting.room.domain.model.entity.AccessToken;
import cn.zcn.virtual.waiting.room.domain.model.entity.AccessTokenStatus;
import cn.zcn.virtual.waiting.room.infrastructure.repository.AccessTokenMapper;
import cn.zcn.virtual.waiting.room.infrastructure.repository.converter.AccessTokenConverter;
import cn.zcn.virtual.waiting.room.infrastructure.repository.po.AccessTokenPO;
import javax.annotation.Resource;
import org.springframework.stereotype.Component;

/**
 * @author zicung
 */
@Component
public class AccessTokenGatewayImpl implements AccessTokenGateway {

    @Resource
    private AccessTokenMapper accessTokenMapper;

    @Override
    public AccessToken add(AccessToken token) {
        AccessTokenPO po = AccessTokenConverter.INSTANCE.entityToPO(token);
        accessTokenMapper.add(po);
        return AccessTokenConverter.INSTANCE.poToEntity(po);
    }

    @Override
    public AccessToken getByQueueIdAndRequestId(String queueId, String requestId) {
        AccessTokenPO po = accessTokenMapper.getByQueueIdAndRequestId(queueId, requestId);
        return AccessTokenConverter.INSTANCE.poToEntity(po);
    }

    @Override
    public boolean changeStatus(
            String queueId, String requestId, AccessTokenStatus oldStatus, AccessTokenStatus newStatus) {
        int count = accessTokenMapper.changeStatus(queueId, requestId, oldStatus, newStatus);
        return count > 0;
    }
}
