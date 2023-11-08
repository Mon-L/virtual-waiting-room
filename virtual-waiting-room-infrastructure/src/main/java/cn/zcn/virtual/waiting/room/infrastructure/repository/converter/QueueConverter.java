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

package cn.zcn.virtual.waiting.room.infrastructure.repository.converter;

import cn.zcn.virtual.waiting.room.domain.model.entity.Queue;
import cn.zcn.virtual.waiting.room.infrastructure.repository.po.QueuePO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @author zicung
 */
@Mapper
public interface QueueConverter {

    QueueConverter INSTANCE = Mappers.getMapper(QueueConverter.class);

    Queue poToEntity(QueuePO po);

    QueuePO entityToPO(Queue entity);
}
