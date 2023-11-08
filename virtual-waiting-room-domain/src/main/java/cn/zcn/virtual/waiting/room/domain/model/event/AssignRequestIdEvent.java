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

package cn.zcn.virtual.waiting.room.domain.model.event;

import java.util.Date;

/**
 * @author zicung
 */
public class AssignRequestIdEvent {
    private String queueId;
    private String requestId;
    private Date sendTime;

    public AssignRequestIdEvent() {}

    public AssignRequestIdEvent(String queueId, String requestId, Date sendTime) {
        this.queueId = queueId;
        this.requestId = requestId;
        this.sendTime = sendTime;
    }

    public String getQueueId() {
        return queueId;
    }

    public String getRequestId() {
        return requestId;
    }

    public Date getSendTime() {
        return sendTime;
    }
}
