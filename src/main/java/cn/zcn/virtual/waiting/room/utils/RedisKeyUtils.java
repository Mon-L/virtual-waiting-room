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

package cn.zcn.virtual.waiting.room.utils;

import org.slf4j.helpers.MessageFormatter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author zicung
 */
public class RedisKeyUtils {

    /**
     * 存储等候室基本信息
     */
    private static final String QUEUE = "queue.{}";

    /**
     * 存储在等候室排队的 Request IDs
     */
    private static final String WAITING_QUEUE = "waiting-queue.{}";

    /**
     * 存储Request ID 的信息
     */
    private static final String REQUEST = "request.{}.{}";

    /**
     * 存储等待过期的Request IDs
     */
    private static final String EXPIRED_REQUESTS = "expired.requests.{}";

    public static String getQueueKey(String queueId) {
        return formatKey(QUEUE, queueId);
    }

    public static String getWaitingQueueKey(String queueId) {
        return formatKey(WAITING_QUEUE, queueId);
    }

    public static String getRequestKey(String queueId, String requestId) {
        return formatKey(REQUEST, queueId, requestId);
    }

    public static String getExpiredRequests(String queueId) {
        return formatKey(EXPIRED_REQUESTS, queueId);
    }

    public static List<String> joinKeys(String... keys) {
        List<String> list = new ArrayList<>();
        Collections.addAll(list, keys);
        return list;
    }

    private static String formatKey(String pattern, String... args) {
        return MessageFormatter.arrayFormat(pattern, args).getMessage();
    }
}
