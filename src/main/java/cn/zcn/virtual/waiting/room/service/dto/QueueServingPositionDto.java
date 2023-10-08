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
import java.util.Date;

/**
 * @author zicung
 */
public class QueueServingPositionDto {
    private Integer tokenValiditySecond = -1;
    private Long lastQueuePosition = 0L;
    private Date servingPositionIssuedTime;
    private Integer enableQueuePositionExpiry = 0;
    private Integer queuePositionExpiryPeriod;
    private Long servingPosition = 0L;

    public Integer getTokenValiditySecond() {
        return tokenValiditySecond;
    }

    public void setTokenValiditySecond(Integer tokenValiditySecond) {
        this.tokenValiditySecond = tokenValiditySecond;
    }

    public Long getLastQueuePosition() {
        return lastQueuePosition;
    }

    public void setLastQueuePosition(Long lastQueuePosition) {
        this.lastQueuePosition = lastQueuePosition;
    }

    public Date getServingPositionIssuedTime() {
        return servingPositionIssuedTime;
    }

    public void setServingPositionIssuedTime(Date servingPositionIssuedTime) {
        this.servingPositionIssuedTime = servingPositionIssuedTime;
    }

    public Integer isEnableQueuePositionExpiry() {
        return enableQueuePositionExpiry;
    }

    public void setEnableQueuePositionExpiry(Integer enableQueuePositionExpiry) {
        this.enableQueuePositionExpiry = enableQueuePositionExpiry;
    }

    public Integer getQueuePositionExpiryPeriod() {
        return queuePositionExpiryPeriod;
    }

    public void setQueuePositionExpiryPeriod(Integer queuePositionExpiryPeriod) {
        this.queuePositionExpiryPeriod = queuePositionExpiryPeriod;
    }

    public Long getServingPosition() {
        return servingPosition;
    }

    public void setServingPosition(Long servingPosition) {
        this.servingPosition = servingPosition;
    }

    public static QueueServingPositionDto from(Queue queue) {
        if (queue == null) {
            return null;
        }

        QueueServingPositionDto dto = new QueueServingPositionDto();
        dto.setLastQueuePosition(0L);
        dto.setServingPosition(0L);
        dto.setTokenValiditySecond(queue.getTokenValiditySecond());
        dto.setEnableQueuePositionExpiry(queue.isEnableQueuePositionExpiry() ? 1 : 0);
        dto.setQueuePositionExpiryPeriod(queue.getPositionExpirySecond());
        dto.setServingPositionIssuedTime(new Date());
        return dto;
    }
}
