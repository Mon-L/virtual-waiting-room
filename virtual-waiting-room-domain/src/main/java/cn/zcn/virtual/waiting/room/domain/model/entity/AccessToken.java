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

package cn.zcn.virtual.waiting.room.domain.model.entity;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.UUID;

/**
 * @author zicung
 */
public class AccessToken {

    public static final String BEARER_TOKEN_TYPE = "Bearer";

    private Integer id;
    private String queueId;
    private String requestId;
    private long position;
    private String tokenValue;
    private String tokenType;
    private Date createTime;
    private Date expiredTime;
    private AccessTokenStatus status;

    public static AccessToken create(
            String queueId, String requestId, long requestPosition, Integer tokenValiditySecond) {
        Instant now = Instant.now();
        AccessToken accessToken = new AccessToken();
        accessToken.setQueueId(queueId);
        accessToken.setRequestId(requestId);
        accessToken.setPosition(requestPosition);
        accessToken.setCreateTime(Date.from(now));
        accessToken.setTokenType(AccessToken.BEARER_TOKEN_TYPE);
        accessToken.setTokenValue(generateBearerTokenValue());
        accessToken.setStatus(AccessTokenStatus.ACTIVE);
        if (tokenValiditySecond != null) {
            Instant expiredTime = now.plus(tokenValiditySecond, ChronoUnit.SECONDS);
            accessToken.setExpiredTime(Date.from(expiredTime));
        }
        return accessToken;
    }

    private static String generateBearerTokenValue() {
        return UUID.randomUUID().toString().replace("-", "");
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getQueueId() {
        return queueId;
    }

    public void setQueueId(String queueId) {
        this.queueId = queueId;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public long getPosition() {
        return position;
    }

    public void setPosition(long position) {
        this.position = position;
    }

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

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getExpiredTime() {
        return expiredTime;
    }

    public void setExpiredTime(Date expiredTime) {
        this.expiredTime = expiredTime;
    }

    public AccessTokenStatus getStatus() {
        return status;
    }

    public void setStatus(AccessTokenStatus status) {
        this.status = status;
    }
}
