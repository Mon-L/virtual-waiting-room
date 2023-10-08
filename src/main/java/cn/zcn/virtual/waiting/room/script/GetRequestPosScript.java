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
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.script.RedisScript;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

import static cn.zcn.virtual.waiting.room.utils.RedisKeyUtils.*;

/**
 * 加载 {@code classpath:scripts/get_request_pos.lua} 脚本。该脚本用于获取 Request ID 在等候室的位置。
 *
 * @author zicung
 */
@Component
public class GetRequestPosScript extends BaseScript {

    @Override
    protected String getResourcePath() {
        return "scripts/get_request_pos.lua";
    }

    public Long execute(RedisTemplate<String, Object> redisTemplate, String queueId, String requestId)
            throws WaitingRoomException {
        RedisScript<Long> redisScript = getRedisScript(Long.class);
        List<String> keys = joinKeys(
                getRequestKey(queueId, requestId),
                getQueueKey(queueId),
                getExpiredRequests(queueId),
                getWaitingQueueKey(queueId),
                queueId);
        Long pos = redisTemplate.execute(redisScript, keys, new Date().getTime(), requestId);
        if (pos == null) {
            throw new UnexpectedReturnException("Expected Long but got null.");
        } else if (pos == -1) {
            throw new InvalidRequestIdException("No request be found. RequestId:{}.", requestId);
        } else if (pos == -2) {
            throw new RequestNotProcessedException("Request has not been processed. RequestId:{}", requestId);
        } else if (pos == -3) {
            throw new RequestExpiredException("RequestId is expired. RequestId:{}.", requestId);
        } else {
            return pos;
        }
    }
}
