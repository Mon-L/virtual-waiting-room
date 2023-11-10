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

package cn.zcn.virtual.waiting.room.domain.gateway.cache;

import cn.zcn.virtual.waiting.room.domain.model.entity.QueueServingPosition;
import cn.zcn.virtual.waiting.room.domain.model.entity.RequestPosition;
import java.util.Date;

/**
 * @author zicung
 */
public interface CacheGateway {

    void addTransientRequestPosition(RequestPosition requestPosition);

    RequestPosition getTransientRequestPosition(String requestId);

    void deleteTransientRequestPosition(String requestId);

    long getLatestServingPosition(String queueId);

    void increaseServingPosition(QueueServingPosition queueServingPosition);

    Long getIssuedTimeByClosestServingPosition(String queueId, long queuePosition);

    void removeServingRequest(String queueId, String requestId);

    void setMaxExpiredPosition(String queueId, long position);

    Long getMaxExpiredPosition(String queueId);

    void increaseServingRequestNum(String queueId, String requestId, Date accessTokenExpiredTime);

    long getServingRequestNum(String queueId, Date before);

    int getWaitingNum(String queueId);

    long nextQueuePosition(String queueId);
}
