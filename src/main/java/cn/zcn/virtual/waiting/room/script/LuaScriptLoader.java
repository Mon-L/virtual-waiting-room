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

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.data.redis.core.script.RedisScript;

/**
 * 加载 {classes}/scripts/ 下lua脚本
 *
 * @author zicung
 */
public class LuaScriptLoader {

    public static final String GET_QUEUE_POS = "get_queue_pos";
    public static final String GET_WAITING_NUM = "get_waiting_num";
    public static final String ENQUEUE = "enqueue";
    public static final String DEQUEUE = "dequeue";
    public static final String INCREMENT_SERVING_POSITION = "increment_serving_position";

    private final Map<String, String> scripts = new HashMap<>();

    public void init() throws LuaScriptException {
        try {
            Resource[] resources = new PathMatchingResourcePatternResolver().getResources("scripts/**.lua");
            for (Resource r : resources) {
                loadScript(r);
            }
        } catch (IOException e) {
            throw new LuaScriptException("Failed to load lua scripts.", e);
        }
    }

    private void loadScript(Resource resource) throws IOException {
        String filename = resource.getFilename();
        if (filename == null) {
            throw new LuaScriptException(
                    "Failed to get lua script filename. File:{}",
                    resource.getURI().getPath());
        }

        int idx = filename.lastIndexOf('.');
        if (idx != -1) {
            filename = filename.substring(0, idx);
        }

        LuaReader luaReader = new LuaReader(resource.getInputStream());
        String compactContent = luaReader.getCompactContent().trim();
        if (compactContent.isEmpty()) {
            throw new LuaScriptException(
                    "Lua script is empty exclude comments. File:{}",
                    resource.getURI().getPath());
        }
        scripts.put(filename, compactContent);
    }

    public <T> RedisScript<T> get(String name, Class<T> resultType) {
        String content = scripts.get(name);
        return content == null ? null : RedisScript.of(content, resultType);
    }
}
