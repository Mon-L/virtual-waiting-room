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

package cn.zcn.virtual.waiting.room.infrastructure.configuration;

import cn.zcn.virtual.waiting.room.domain.utils.RedisKeyUtils;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zicung
 */
@Configuration
@EnableCaching
public class CacheConfiguration {

    @Bean
    public CacheManager cacheManager(
            RedisConnectionFactory redisConnectionFactory,
            Jackson2JsonRedisSerializer<Object> jackson2JsonRedisSerializer) {
        Map<String, RedisCacheConfiguration> configurations = new HashMap<>();

        configurations.put(
                RedisKeyUtils.REQUEST_NAME,
                createBaseCacheConfiguration(jackson2JsonRedisSerializer, Duration.ofMinutes(10)));
        configurations.put(
                RedisKeyUtils.QUEUE_NAME,
                createBaseCacheConfiguration(jackson2JsonRedisSerializer, Duration.ofMinutes(10)));

        return RedisCacheManager.builder(redisConnectionFactory)
                .initialCacheNames(configurations.keySet())
                .withInitialCacheConfigurations(configurations)
                .build();
    }

    private RedisCacheConfiguration createBaseCacheConfiguration(
            Jackson2JsonRedisSerializer<Object> jackson2JsonRedisSerializer, Duration timeout) {
        return RedisCacheConfiguration.defaultCacheConfig()
                .serializeKeysWith(
                        RedisSerializationContext.SerializationPair.fromSerializer(new StringRedisSerializer()))
                .serializeValuesWith(
                        RedisSerializationContext.SerializationPair.fromSerializer(jackson2JsonRedisSerializer))
                .disableCachingNullValues()
                .entryTtl(timeout)
                .computePrefixWith(name -> name + ":");
    }
}
