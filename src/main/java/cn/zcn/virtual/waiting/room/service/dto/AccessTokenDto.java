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

package cn.zcn.virtual.waiting.room.service.dto;

import cn.zcn.virtual.waiting.room.repository.entity.AccessToken;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.Duration;
import java.time.Instant;

/**
 * @author zicung
 */
public class AccessTokenDto {

    @JsonProperty("access_token")
    private String tokenValue;

    @JsonProperty("token_type")
    private String tokenType;

    @JsonProperty("expires_in")
    private Long expiresIn;

    public String getTokenValue() {
        return tokenValue;
    }

    public void setTokenValue(String tokenValue) {
        this.tokenValue = tokenValue;
    }

    public String getTokenType() {
        return tokenType;
    }

    public void setTokenType(String tokenType) {
        this.tokenType = tokenType;
    }

    public Long getExpiresIn() {
        return expiresIn;
    }

    public void setExpiresIn(Long expiresIn) {
        this.expiresIn = expiresIn;
    }

    public static AccessTokenDto from(AccessToken token) {
        if (token == null) {
            return null;
        }

        AccessTokenDto dto = new AccessTokenDto();
        dto.setTokenValue(token.getTokenValue());
        dto.setTokenType(token.getTokenType());
        if (token.getExpiredTime() != null) {
            dto.setExpiresIn(
                    Duration.between(Instant.now(), token.getExpiredTime().toInstant())
                            .getSeconds());
        }
        return dto;
    }
}
