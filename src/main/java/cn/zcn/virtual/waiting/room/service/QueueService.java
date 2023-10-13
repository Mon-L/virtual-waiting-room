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

package cn.zcn.virtual.waiting.room.service;

import cn.zcn.virtual.waiting.room.exception.InvalidQueueIdException;
import cn.zcn.virtual.waiting.room.exception.InvalidRequestIdException;
import cn.zcn.virtual.waiting.room.exception.RequestExpiredException;
import cn.zcn.virtual.waiting.room.exception.WaitingRoomException;
import cn.zcn.virtual.waiting.room.repository.entity.QueueServingPosition;
import cn.zcn.virtual.waiting.room.repository.entity.RequestPosition;
import cn.zcn.virtual.waiting.room.service.dto.AccessTokenDto;

/**
 * @author zicung
 */
public interface QueueService {

    RequestPosition getRequestPosition(String queueId, String requestId) throws InvalidRequestIdException;

    QueueServingPosition getLatestServingPosition(String queueId);

    void enqueue(String queueId, String requestId) throws InvalidQueueIdException, RequestExpiredException;

    int getWaitingNum(String queueId) throws InvalidQueueIdException;

    long incrementServingPosition(String queueId, int incrementBy) throws InvalidQueueIdException;

    AccessTokenDto generateToken(String queueId, String requestId) throws WaitingRoomException;
}
