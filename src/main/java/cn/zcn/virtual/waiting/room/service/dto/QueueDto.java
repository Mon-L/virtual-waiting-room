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

import cn.zcn.virtual.waiting.room.repository.entity.Queue;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author zicung
 */
public class QueueDto {

    private Integer id;

    @JsonProperty("queue_id")
    private String queueId;

    @JsonProperty("token_validity_second")
    private Integer tokenValiditySecond;

    @JsonProperty("enable_queue_position_expiry")
    private Boolean enableQueuePositionExpiry = false;

    @JsonProperty("position_expiry_second")
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

    public Integer getTokenValiditySecond() {
        return tokenValiditySecond;
    }

    public void setTokenValiditySecond(Integer tokenValiditySecond) {
        this.tokenValiditySecond = tokenValiditySecond;
    }

    public Boolean getEnableQueuePositionExpiry() {
        return enableQueuePositionExpiry;
    }

    public void setEnableQueuePositionExpiry(Boolean enableQueuePositionExpiry) {
        this.enableQueuePositionExpiry = enableQueuePositionExpiry;
    }

    public Integer getPositionExpirySecond() {
        return positionExpirySecond;
    }

    public void setPositionExpirySecond(Integer positionExpirySecond) {
        this.positionExpirySecond = positionExpirySecond;
    }

    public static QueueDto from(Queue queue) {
        QueueDto dto = new QueueDto();
        dto.setId(queue.getId());
        dto.setQueueId(queue.getQueueId());
        dto.setEnableQueuePositionExpiry(queue.isEnableQueuePositionExpiry());
        dto.setTokenValiditySecond(queue.getTokenValiditySecond());
        dto.setPositionExpirySecond(queue.getPositionExpirySecond());
        return dto;
    }
}
