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

/**
 * 从文件流中读取lua代码
 * @author zicung
 */
public class LuaReader {

    private final InputStream inputStream;

    public LuaReader(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    /**
     * 返回紧凑的lua代码。返回的代码中会去除以下不必要的内容，如单行注释、多行注释、换行符、不必要的空格符等
     */
    public String getCompactContent() throws IOException {
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
}
