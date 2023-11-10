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

package cn.zcn.virtual.waiting.room.domain.ability;

import cn.zcn.virtual.waiting.room.domain.gateway.cache.CacheGateway;
import cn.zcn.virtual.waiting.room.domain.model.entity.Queue;
import cn.zcn.virtual.waiting.room.domain.model.entity.RequestPosition;
import java.util.Date;
import javax.annotation.Resource;
import org.springframework.stereotype.Component;

/**
 * @author zicung
 */
@Component
public class RequestAbility {

    @Resource
    private CacheGateway cacheGateway;

    public boolean checkIfExpired(RequestPosition requestPosition, Queue queue) {
        if (!queue.getEnableQueuePositionExpiry()) {
            return false;
        }

        Long maxExpiredPosition = cacheGateway.getMaxExpiredPosition(queue.getQueueId());
        if (maxExpiredPosition != null) {
            return maxExpiredPosition >= requestPosition.getQueuePosition();
        }

        Long closestServingPositionIssuedTime = cacheGateway.getIssuedTimeByClosestServingPosition(
                requestPosition.getQueueId(), requestPosition.getQueuePosition());

        if (closestServingPositionIssuedTime != null) {
            long expiredTime = requestPosition.getExpiredTime(
                    queue.getPositionExpirySecond(), new Date(closestServingPositionIssuedTime));
            if (System.currentTimeMillis() >= expiredTime) {
                cacheGateway.setMaxExpiredPosition(requestPosition.getQueueId(), requestPosition.getQueuePosition());
                return true;
            }
        }
        return false;
    }
}
