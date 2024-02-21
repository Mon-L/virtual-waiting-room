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

package cn.zcn.virtual.waiting.room.app;

import cn.zcn.virtual.waiting.room.domain.gateway.cache.CacheGateway;
import cn.zcn.virtual.waiting.room.domain.model.event.AssignRequestIdEvent;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;

/**
 * @author zicung
 */
@Component
public class EnqueueListener {

    @Resource
    private CacheGateway cacheGateway;

    @KafkaListener(
            id = "AssignRequestIdListener",
            topics = AssignRequestIdEvent.TOPIC,
            containerFactory = "batchKafkaFactory",
            properties = {
                ConsumerConfig.MAX_POLL_INTERVAL_MS_CONFIG + "=100000",
                ConsumerConfig.MAX_POLL_RECORDS_CONFIG + "=10"
            })
    public void onMessage(List<ConsumerRecord<String, AssignRequestIdEvent>> records, Acknowledgment acknowledgment) {
        List<AssignRequestIdEvent> events = new ArrayList<>();
        for (ConsumerRecord<String, AssignRequestIdEvent> record : records) {
            events.add(record.value());
        }
        cacheGateway.assignQueuePositions(events);
        acknowledgment.acknowledge();
    }
}
