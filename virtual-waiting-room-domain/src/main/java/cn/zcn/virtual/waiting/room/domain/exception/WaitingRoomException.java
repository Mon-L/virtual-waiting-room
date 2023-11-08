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

package cn.zcn.virtual.waiting.room.domain.exception;

import org.slf4j.helpers.MessageFormatter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author zicung
 */
@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
public class WaitingRoomException extends RuntimeException {

    public static Throwable getCause(Object[] argArray) {
        if (argArray == null || argArray.length == 0) {
            return null;
        }

        final Object lastEntry = argArray[argArray.length - 1];
        if (lastEntry instanceof Throwable) {
            return (Throwable) lastEntry;
        }

        return null;
    }

    public WaitingRoomException(String msg) {
        super(msg);
    }

    public WaitingRoomException(String msg, Throwable t) {
        super(msg, t);
    }

    public WaitingRoomException(String pattern, Object... args) {
        super(MessageFormatter.arrayFormat(pattern, args).getMessage(), getCause(args));
    }
}
