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

import static cn.zcn.virtual.waiting.room.domain.utils.RedisKeyUtils.*;

import cn.zcn.virtual.waiting.room.domain.gateway.cache.CacheGateway;
import cn.zcn.virtual.waiting.room.domain.model.entity.QueueServingPosition;
import cn.zcn.virtual.waiting.room.domain.utils.RedisKeyUtils;
import java.util.Date;
import java.util.Set;
import javax.annotation.Resource;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.data.redis.core.script.RedisScript;
import org.springframework.stereotype.Component;

/**
 * @author zicung
 */
@Component
public class CacheGatewayImpl implements CacheGateway {

    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    @Override
    public long assignQueuePosition(String queueId) {
        String script = "redis.call('INCR', KEYS[1]); " + // 更新等待人数
                "return redis.call('INCR', KEYS[2]);"; // 递增并返回等候室排队位置

        RedisScript<Long> typedScript = RedisScript.of(script, Long.class);
        Long ans = redisTemplate.execute(
                typedScript, joinKeys(getQueueWaitingNumKey(queueId), getQueueLatestPosition(queueId)));
        assertNotNull(ans, typedScript.getResultType());
        return ans;
    }

    @Override
    public void dequeue(String queueId, String requestId, Date accessTokenExpiredTime) {
        String script = "local waitingNum = tonumber(redis.call('get', KEYS[2])); "
                + "if waitingNum ~= nil and waitingNum >=1 then "
                + "    redis.call('DECR', KEYS[2]); " // 更新等待人数
                + "end; "
                + "redis.call('ZADD', KEYS[1], ARGV[2], ARGV[1]); "; // 记录可服务的Request

        redisTemplate.execute(
                RedisScript.of(script),
                joinKeys(getQueueServingRequests(queueId), getQueueWaitingNumKey(queueId)),
                requestId,
                accessTokenExpiredTime.getTime());
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
    public long getServingRequestNum(String queueId, Date after) {
        String script = "redis.call('ZREMRANGEBYSCORE', KEYS[1], 0, ARGV[1]); " + // 移除令牌已过期的Request
                "return redis.call('ZCARD', KEYS[1]);"; // 返回令牌未过期的Request的数量

        RedisScript<Long> typedScript = RedisScript.of(script, Long.class);
        Long ans = redisTemplate.execute(typedScript, joinKeys(getQueueServingRequests(queueId)), after.getTime());
        assertNotNull(ans, typedScript.getResultType());
        return ans;
    }

    @Override
    public long getLatestServingPosition(String queueId) {
        Set<ZSetOperations.TypedTuple<Object>> set = redisTemplate
                .opsForZSet()
                .reverseRangeWithScores(RedisKeyUtils.getQueueIssuedServingPosition(queueId), 0, 0);
        if (set == null || set.isEmpty()) {
            return 0;
        }
        Double latestServingPosition = set.iterator().next().getScore();
        assertNotNull(latestServingPosition, Double.class);
        return latestServingPosition.longValue();
    }

    @Override
    public int getWaitingNum(String queueId) {
        Integer waitingNum = (Integer) redisTemplate.opsForValue().get(RedisKeyUtils.getQueueWaitingNumKey(queueId));
        return waitingNum == null ? 0 : waitingNum;
    }

    private void assertNotNull(Object obj, Class<?> expected) {
        if (obj == null) {
            throw new IllegalArgumentException("Expected redis return type " + expected.getName() + " but was null");
        }
    }
}
