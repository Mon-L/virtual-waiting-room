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

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

/**
 * @author zicung
 */
public class RequestPosition implements Serializable {
    private Integer id;
    private String queueId;
    private String requestId;
    private Long queuePosition;
    private Date entryTime;
    private Boolean canServedWhenEntry = false;
    private Date createTime;

    public static RequestPosition create(String queueId) {
        RequestPosition requestPosition = new RequestPosition();
        requestPosition.setQueueId(queueId);
        requestPosition.setRequestId(generateRequestId());
        requestPosition.setCreateTime(new Date());
        return requestPosition;
    }

    public boolean isProcessed() {
        return queuePosition != null;
    }

    public boolean canBeServed(Long latestServingPosition) {
        return isProcessed() && latestServingPosition != null && latestServingPosition >= queuePosition;
    }

    public long getExpiredTime(int positionExpirySecond, Date closestServingPositionIssuedTime) {
        Date start;
        if (canServedWhenEntry) {
            start = entryTime;
        } else {
            start = closestServingPositionIssuedTime;
        }

        return start.getTime() + positionExpirySecond * 1000L;
    }

    private static String generateRequestId() {
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

    public Long getQueuePosition() {
        return queuePosition;
    }

    public void setQueuePosition(Long queuePosition) {
        this.queuePosition = queuePosition;
    }

    public Date getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(Date entryTime) {
        this.entryTime = entryTime;
    }

    public Boolean getCanServedWhenEntry() {
        return canServedWhenEntry;
    }

    public void setCanServedWhenEntry(Boolean canServedWhenEntry) {
        this.canServedWhenEntry = canServedWhenEntry;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
