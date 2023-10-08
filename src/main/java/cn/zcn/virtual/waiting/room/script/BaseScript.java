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

import cn.zcn.virtual.waiting.room.script.ast.LuaLexer;
import java.io.IOException;
import java.io.InputStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Token;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.data.redis.core.script.RedisScript;

/**
 * @author zicung
 */
public abstract class BaseScript {

    private String content;

    /**
     * 初始化lua脚本信息
     */
    public final void init() throws LuaScriptException {
        String path = getResourcePath();
        if (path == null || path.trim().length() == 0) {
            throw new LuaScriptException(
                    "Script resource path must be specified. Class: {}",
                    this.getClass().getSimpleName());
        }

        try {
            Resource resource = new PathMatchingResourcePatternResolver().getResource(path);
            this.content = getCompactContent(resource.getInputStream());
        } catch (IOException e) {
            throw new LuaScriptException("Failed to load lua script. Path:{}", path, e);
        }
    }

    /**
     * 返回紧凑的lua代码。返回的代码中会去除以下不必要的内容，如单行注释、多行注释、换行符、不必要的空格符等
     */
    private String getCompactContent(InputStream inputStream) throws IOException {
        StringBuilder compactContent = new StringBuilder();
        CharStream input = CharStreams.fromStream(inputStream);
        LuaLexer lexer = new LuaLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        tokens.fill();

        int i = 0;
        int size = tokens.size();
        while (i < size) {
            Token token = tokens.get(i);
            boolean hasWS = false;
            while (token.getType() == LuaLexer.WS) {
                hasWS = true;
                token = tokens.get(++i);
            }
            if (hasWS) {
                compactContent.append(' ');
            }

            int type = token.getType();
            if (type != LuaLexer.EOF && type != LuaLexer.LONG_COMMENT && type != LuaLexer.SHORT_COMMENT) {
                compactContent.append(token.getText());
            }
            i++;
        }
        return compactContent.toString();
    }

    protected <T> RedisScript<T> getRedisScript(Class<T> returnType) {
        return RedisScript.of(content, returnType);
    }

    protected abstract String getResourcePath();
}
