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
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.data.redis.core.script.RedisScript;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Date;
import java.util.Set;

import static cn.zcn.virtual.waiting.room.domain.utils.RedisKeyUtils.*;

/**
 * @author zicung
 */
@Component
public class CacheGatewayImpl implements CacheGateway {

    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    @Override
    public void setMaxExpiredPosition(String queueId, long position) {
        String script = "local exist = tonumber(redis.call('get', KEYS[1]));"
                + "if exist == nil or tonumber(ARGV[1]) > exist then "
                + "   redis.call('set', KEYS[1], ARGV[1]);"
                + "end; ";
        redisTemplate.execute(RedisScript.of(script), joinKeys(getQueueMaxExpiredPositionKey(queueId)), position);
    }

    @Override
    public Long getMaxExpiredPosition(String queueId) {
        return cast2Long(redisTemplate.opsForValue().get(getQueueMaxExpiredPositionKey(queueId)));
    }

    @Override
    public long assignQueuePosition(String queueId) {
        String script = "redis.call('INCR', KEYS[1]); " + // 增加等候室等待人数
                "return redis.call('INCR', KEYS[2]);"; // 递增并返回等候室排队位置

        RedisScript<Long> typedScript = RedisScript.of(script, Long.class);
        Long ans = redisTemplate.execute(
                typedScript, joinKeys(getQueueWaitingNumKey(queueId), getQueueLatestPosition(queueId)));
        assertNotNull(ans, typedScript.getResultType());
        return ans;
    }

    @Override
    public void increaseServingRequestNum(String queueId, String requestId, Date accessTokenExpiredTime) {
        String script = "local waitingNum = tonumber(redis.call('get', KEYS[2])); "
                + "if waitingNum ~= nil and waitingNum >=1 then "
                + "    redis.call('DECR', KEYS[2]); " // 减少等候室等待人数
                + "end; "
                + "redis.call('ZADD', KEYS[1], ARGV[2], ARGV[1]); "; // 记录可服务的Request

        redisTemplate.execute(
                RedisScript.of(script),
                joinKeys(getQueueServingRequests(queueId), getQueueWaitingNumKey(queueId)),
                requestId,
                accessTokenExpiredTime.getTime());
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
    public Long getIssuedTimeByClosestServingPosition(String queueId, long queuePosition) {
        Set<Object> set = redisTemplate
                .opsForZSet()
                .rangeByScore(
                        RedisKeyUtils.getQueueIssuedServingPosition(queueId), queuePosition, Long.MAX_VALUE, 0, 1);
        if (set == null || set.isEmpty()) {
            return null;
        }

        return (Long) set.iterator().next();
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
    public long getServingRequestNum(String queueId, Date before) {
        String script = "redis.call('ZREMRANGEBYSCORE', KEYS[1], 0, ARGV[1]); " + // 移除令牌已过期的Request
                "return redis.call('ZCARD', KEYS[1]);"; // 返回令牌未过期的Request的数量

        RedisScript<Long> typedScript = RedisScript.of(script, Long.class);
        Long ans = redisTemplate.execute(typedScript, joinKeys(getQueueServingRequests(queueId)), before.getTime());
        assertNotNull(ans, typedScript.getResultType());
        return ans;
    }

    @Override
    public int getWaitingNum(String queueId) {
        Integer waitingNum = (Integer) redisTemplate.opsForValue().get(RedisKeyUtils.getQueueWaitingNumKey(queueId));
        return waitingNum == null ? 0 : waitingNum;
    }

    private void assertNotNull(Object obj, Class<?> expected) {
        if (obj == null) {
            throw new IllegalArgumentException("Expected " + expected.getName() + " but was null");
        }
    }

    private Long cast2Long(Object obj) {
        if (obj == null) {
            return null;
        } else if (obj instanceof Long) {
            return (Long) obj;
        } else if (obj instanceof Number) {
            return ((Number) obj).longValue();
        }
        throw new IllegalArgumentException("Expected Long but was " + obj.getClass().getName());
    }
}
