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

package cn.zcn.virtual.waiting.room.repository;

import cn.zcn.virtual.waiting.room.repository.entity.AccessToken;
import cn.zcn.virtual.waiting.room.repository.entity.AccessTokenStatus;
import org.apache.ibatis.annotations.Param;

import java.util.Date;

/**
 * @author zicung
 */
public interface AccessTokenMapper {
    void add(AccessToken token);

    AccessToken getByTokenValue(String token);

    AccessToken getByQueueIdAndRequestId(@Param("queueId") String queueId, @Param("requestId") String requestId);

    void changeStatus(@Param("queueId") String queueId, @Param("requestId") String requestId, @Param("oldStatus") AccessTokenStatus oldStatus, @Param("newStatus") AccessTokenStatus newStatus);

    long getActiveTokenNum(@Param("queueId") String queueId, @Param("after") Date after);
}
