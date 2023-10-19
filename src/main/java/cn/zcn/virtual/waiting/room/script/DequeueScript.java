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

package cn.zcn.virtual.waiting.room.script;

import static cn.zcn.virtual.waiting.room.utils.RedisKeyUtils.getQueueServingRequests;
import static cn.zcn.virtual.waiting.room.utils.RedisKeyUtils.getQueueWaitingNumKey;

import cn.zcn.virtual.waiting.room.exception.WaitingRoomException;
import cn.zcn.virtual.waiting.room.utils.RedisKeyUtils;
import java.util.List;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.script.RedisScript;
import org.springframework.stereotype.Component;

/**
 * @author zicung
 */
@Component
public class DequeueScript extends BaseScript {

    @Override
    protected String getResourcePath() {
        return "scripts/dequeue.lua";
    }

    public void execute(
            RedisTemplate<String, Object> redisTemplate, String queueId, String requestId, long tokenExpiredTime)
            throws WaitingRoomException {
        RedisScript<Void> redisScript = getRedisScript(Void.class);
        List<String> keys = RedisKeyUtils.joinKeys(getQueueServingRequests(queueId), getQueueWaitingNumKey(queueId));
        redisTemplate.execute(redisScript, keys, requestId, tokenExpiredTime);
    }
}
