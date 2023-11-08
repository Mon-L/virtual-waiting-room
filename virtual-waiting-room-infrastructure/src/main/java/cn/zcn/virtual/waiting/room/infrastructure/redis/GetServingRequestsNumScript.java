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

import static cn.zcn.virtual.waiting.room.domain.utils.RedisKeyUtils.getQueueServingRequests;
import static cn.zcn.virtual.waiting.room.domain.utils.RedisKeyUtils.joinKeys;

import cn.zcn.virtual.waiting.room.domain.exception.WaitingRoomException;
import java.util.List;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.script.RedisScript;
import org.springframework.stereotype.Component;

/**
 * @author zicung
 */
@Component
public class GetServingRequestsNumScript extends BaseScript {

    @Override
    protected String getResourcePath() {
        return "scripts/get_serving_requests_num.lua";
    }

    public long execute(RedisTemplate<String, Object> redisTemplate, String queueId, long now)
            throws WaitingRoomException {
        RedisScript<Long> redisScript = getRedisScript(Long.class);
        List<String> keys = joinKeys(getQueueServingRequests(queueId));
        Long num = redisTemplate.execute(redisScript, keys, now);
        return num == null ? 0 : num;
    }
}
