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

import cn.zcn.virtual.waiting.room.exception.InvalidQueueIdException;
import cn.zcn.virtual.waiting.room.exception.InvalidRequestIdException;
import cn.zcn.virtual.waiting.room.exception.UnexpectedReturnException;
import cn.zcn.virtual.waiting.room.exception.WaitingRoomException;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.script.RedisScript;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

import static cn.zcn.virtual.waiting.room.utils.RedisKeyUtils.*;

/**
 * 加载 {@code classpath:scripts/enqueue.lua} 脚本。该脚本逻辑是执行 Request ID 进入等候室，并返回 request_pos。
 *
 * @author zicung
 */
@Component
public class EnqueueScript extends BaseScript {

    @Override
    protected String getResourcePath() {
        return "scripts/enqueue.lua";
    }

    public Long execute(RedisTemplate<String, Object> redisTemplate, String queueId, String requestId)
            throws WaitingRoomException {
        RedisScript<Long> redisScript = getRedisScript(Long.class);
        Date now = new Date();
        List<String> keys =
                joinKeys(getWaitingQueueKey(queueId), getRequestKey(queueId, requestId), getQueueKey(queueId));
        Long pos = redisTemplate.execute(redisScript, keys, queueId, requestId, now.getTime());
        if (pos == null) {
            throw new UnexpectedReturnException("Expected Long but got null.");
        } else if (pos == -1) {
            throw new InvalidQueueIdException("No queue be found. QueueId:{}.", queueId);
        } else if (pos == -2) {
            throw new InvalidRequestIdException("No request be found. QueueId:{}, RequestId:{}.", queueId, requestId);
        } else {
            return pos;
        }
    }
}
