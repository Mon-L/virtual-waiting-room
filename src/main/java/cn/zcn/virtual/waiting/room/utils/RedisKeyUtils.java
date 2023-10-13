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

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.slf4j.helpers.MessageFormatter;

/**
 * @author zicung
 */
public class RedisKeyUtils {

    /**
     * 等候室最新position
     */
    private static final String QUEUE_LATEST_POSITION = "queue:latestPosition:{}";

    /**
     * 等候室等待人数
     */
    private static final String QUEUE_WAITING_NUM = "queue:waitingNum:{}";

    public static String getQueueLatestPosition(String queueId) {
        return formatKey(QUEUE_LATEST_POSITION, queueId);
    }

    public static String getQueueWaitingNumKey(String queueId) {
        return formatKey(QUEUE_WAITING_NUM, queueId);
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
