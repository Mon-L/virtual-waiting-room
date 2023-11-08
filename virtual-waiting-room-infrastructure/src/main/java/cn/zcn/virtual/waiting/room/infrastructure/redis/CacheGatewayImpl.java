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

package cn.zcn.virtual.waiting.room.infrastructure.redis;

import cn.zcn.virtual.waiting.room.domain.gateway.cache.CacheGateway;
import cn.zcn.virtual.waiting.room.domain.model.entity.QueueServingPosition;
import cn.zcn.virtual.waiting.room.domain.utils.RedisKeyUtils;
import java.util.Date;
import java.util.Set;
import javax.annotation.Resource;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.stereotype.Component;

/**
 * @author zicung
 */
@Component
public class CacheGatewayImpl implements CacheGateway {

    @Resource
    private LuaScriptLoader luaScriptLoader;

    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    @Override
    public long assignQueuePosition(String queueId) {
        EnqueueScript enqueueScript = luaScriptLoader.get(EnqueueScript.class);
        return enqueueScript.execute(redisTemplate, queueId);
    }

    @Override
    public void dequeue(String queueId, String requestId, Date accessTokenExpiredTime) {
        DequeueScript dequeueScript = luaScriptLoader.get(DequeueScript.class);
        dequeueScript.execute(redisTemplate, queueId, requestId, accessTokenExpiredTime.getTime());
    }

    @Override
    public void increaseServingPosition(QueueServingPosition queueServingPosition) {
        redisTemplate
                .opsForZSet()
                .add(
                        RedisKeyUtils.getQueueIssuedServingPosition(queueServingPosition.getQueueId()),
                        queueServingPosition.getIssuedTime().getTime(),
                        queueServingPosition.getServingPosition());
    }

    @Override
    public void removeServingRequest(String queueId, String requestId) {
        redisTemplate.opsForZSet().remove(RedisKeyUtils.getQueueServingRequests(queueId), requestId);
    }

    @Override
    public long getActiveTokenNum(String queueId, Date after) {
        GetServingRequestsNumScript getServingRequestsNumScript =
                luaScriptLoader.get(GetServingRequestsNumScript.class);
        return getServingRequestsNumScript.execute(redisTemplate, queueId, after.getTime());
    }

    @Override
    public long getLatestServingPosition(String queueId) {
        Set<ZSetOperations.TypedTuple<Object>> set = redisTemplate
                .opsForZSet()
                .reverseRangeWithScores(RedisKeyUtils.getQueueIssuedServingPosition(queueId), 0, 0);
        if (set == null || set.isEmpty()) {
            return 0;
        }
        return set.iterator().next().getScore().longValue();
    }

    @Override
    public int getWaitingNum(String queueId) {
        Integer waitingNum = (Integer) redisTemplate.opsForValue().get(RedisKeyUtils.getQueueWaitingNumKey(queueId));
        return waitingNum == null ? 0 : waitingNum;
    }
}
