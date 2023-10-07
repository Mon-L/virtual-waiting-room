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

package cn.zcn.virtual.waiting.room.exception;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.http.HttpStatus;

/**
 * @author zicung
 */
public class ExceptionResponse {

    private String error;

    @JsonProperty("error_msg")
    private String errorMsg;

    public String getErrorMsg() {
        return errorMsg;
    }

    public String getError() {
        return error;
    }

    public static class Builder {

        private final HttpStatus httpStatus;
        private String errorMsg;

        public Builder(HttpStatus httpStatus) {
            this.httpStatus = httpStatus;
        }

        public Builder errorMsg(String errorMsg) {
            this.errorMsg = errorMsg;
            return this;
        }

        public ExceptionResponse build() {
            ExceptionResponse response = new ExceptionResponse();
            response.error = httpStatus.getReasonPhrase();
            response.errorMsg = errorMsg;
            return response;
        }
    }
}
