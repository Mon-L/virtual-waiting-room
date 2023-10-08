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

import cn.zcn.virtual.waiting.room.exception.WaitingRoomException;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.script.RedisScript;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

import static cn.zcn.virtual.waiting.room.utils.RedisKeyUtils.*;

/**
 * 加载 {@code classpath:scripts/increment_serving_position.lua} 脚本。
 *
 * @author zicung
 */
@Component
public class IncrementServingPosScript extends BaseScript {

    @Override
    protected String getResourcePath() {
        return "scripts/increment_serving_position.lua";
    }

    public void execute(RedisTemplate<String, Object> redisTemplate, String queueId, int incrementBy, Date now)
            throws WaitingRoomException {
        RedisScript<Long> redisScript = getRedisScript(Long.class);
        List<String> keys = joinKeys(getQueueKey(queueId), getWaitingQueueKey(queueId));
        Long ret = redisTemplate.execute(redisScript, keys, incrementBy, now.getTime());

        if (ret != null && ret == -1) {
            //在并发情况下可能出现设置失败
            throw new WaitingRoomException("Increment serving pos occur error, cause by concurrency.");
        }
    }
}
