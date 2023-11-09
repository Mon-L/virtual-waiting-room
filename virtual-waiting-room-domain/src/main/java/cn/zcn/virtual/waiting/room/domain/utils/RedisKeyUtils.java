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

package cn.zcn.virtual.waiting.room.domain.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.slf4j.helpers.MessageFormatter;

/**
 * @author zicung
 */
public class RedisKeyUtils {

    /**
     * String。QueuePO。
     */
    public static final String QUEUE_NAME = "queue";

    /**
     * String。Request。
     */
    public static final String REQUEST_NAME = "request";

    /**
     * String。 最大已过期位置。
     */
    public static final String QUEUE_MAX_EXPIRED_POSITION = "queue:max.expired.pos:{}";

    /**
     * String。等候室发布的可服务的位置的列表。
     */
    public static final String QUEUE_ISSUED_SERVING_POSITIONS = "queue:issued.serving.positions:{}";

    /**
     * String。等候室最大已分配的位置。
     */
    private static final String QUEUE_LATEST_POSITION = "queue:latest.position:{}";

    /**
     * String。等候室等待人数。
     */
    private static final String QUEUE_WAITING_NUM = "queue:waiting.num:{}";

    /**
     * ZSet。记录已可服务的requests。
     */
    private static final String QUEUE_SERVING_REQUESTS = "queue:serving.requests:{}";

    public static String getQueueLatestPosition(String queueId) {
        return formatKey(QUEUE_LATEST_POSITION, queueId);
    }

    public static String getQueueWaitingNumKey(String queueId) {
        return formatKey(QUEUE_WAITING_NUM, queueId);
    }

    public static String getQueueServingRequests(String queueId) {
        return formatKey(QUEUE_SERVING_REQUESTS, queueId);
    }

    public static String getQueueIssuedServingPosition(String queueId) {
        return formatKey(QUEUE_ISSUED_SERVING_POSITIONS, queueId);
    }

    public static String getQueueMaxExpiredPositionKey(String queueId) {
        return formatKey(QUEUE_MAX_EXPIRED_POSITION, queueId);
    }

    private static String formatKey(String pattern, String... args) {
        return MessageFormatter.arrayFormat(pattern, args).getMessage();
    }

    public static List<String> joinKeys(String... keys) {
        List<String> list = new ArrayList<>();
        Collections.addAll(list, keys);
        return list;
    }
}
