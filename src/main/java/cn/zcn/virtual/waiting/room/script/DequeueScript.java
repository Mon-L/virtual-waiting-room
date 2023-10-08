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

import cn.zcn.virtual.waiting.room.exception.*;
import cn.zcn.virtual.waiting.room.utils.RedisKeyUtils;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.script.RedisScript;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

import static cn.zcn.virtual.waiting.room.utils.RedisKeyUtils.*;

/**
 * 加载 {@code classpath:scripts/dequeue.lua} 脚本。该脚本的功能是使 Request ID 离开等候室，并返回 request_pos。
 *
 * @author zicung
 */
@Component
public class DequeueScript extends BaseScript {

    @Override
    protected String getResourcePath() {
        return "scripts/dequeue.lua";
    }

    public Long execute(RedisTemplate<String, Object> redisTemplate, String queueId, String requestId)
            throws WaitingRoomException {
        RedisScript<Long> redisScript = getRedisScript(Long.class);
        List<String> keys = RedisKeyUtils.joinKeys(
                getWaitingQueueKey(queueId),
                getRequestKey(queueId, requestId),
                getQueueKey(queueId),
                getExpiredRequests(queueId));
        Long ret = redisTemplate.execute(redisScript, keys, requestId, new Date().getTime());
        if (ret == null) {
            throw new UnexpectedReturnException("Expected Long but got null.");
        } else if (ret == -4) {
            throw new RequestExpiredException("RequestId is expired. QueueId:{}, RequestId:{}.", queueId, requestId);
        } else if (ret == -3) {
            throw new InvalidRequestIdException("No request be found. QueueId:{}, RequestId:{}.", queueId, requestId);
        } else if (ret == -2) {
            throw new InvalidQueueIdException("No queue be found. QueueId:{}.", queueId);
        } else if (ret == -1) {
            throw new RequestNotServedException(
                    "RequestId not being served. QueueId:{}, RequestId:{}.", queueId, requestId);
        }
        return ret;
    }
}
