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

package cn.zcn.virtual.waiting.room.repository.entity;

/**
 * @author zicung
 */
public class Queue {
    private Integer id;
    private String queueId;
    private Integer tokenValiditySecond;
    private Boolean enableQueuePositionExpiry = false;
    private Integer positionExpirySecond = 0;

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

    public int getTokenValiditySecond() {
        return tokenValiditySecond;
    }

    public void setTokenValiditySecond(int tokenValiditySecond) {
        this.tokenValiditySecond = tokenValiditySecond;
    }

    public boolean isEnableQueuePositionExpiry() {
        return enableQueuePositionExpiry;
    }

    public void setEnableQueuePositionExpiry(boolean enableQueuePositionExpiry) {
        this.enableQueuePositionExpiry = enableQueuePositionExpiry;
    }

    public int getPositionExpirySecond() {
        return positionExpirySecond;
    }

    public void setPositionExpirySecond(int positionExpirySecond) {
        this.positionExpirySecond = positionExpirySecond;
    }
}
