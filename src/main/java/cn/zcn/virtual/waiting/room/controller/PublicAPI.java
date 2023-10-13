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

package cn.zcn.virtual.waiting.room.controller;

import cn.zcn.virtual.waiting.room.repository.entity.QueueServingPosition;
import cn.zcn.virtual.waiting.room.service.AssignPosService;
import cn.zcn.virtual.waiting.room.service.QueueManageService;
import cn.zcn.virtual.waiting.room.service.QueueService;
import cn.zcn.virtual.waiting.room.service.dto.AccessTokenDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @author zicung
 */
@Controller
public class PublicAPI {

    @Resource
    private ObjectMapper objectMapper;

    @Resource
    private QueueService queueService;

    @Resource
    private QueueManageService queueManageService;

    @Resource
    private AssignPosService assignPosService;

    @ResponseBody
    @RequestMapping(
            path = "assign_queue_pos",
            method = RequestMethod.POST,
            consumes = "application/x-www-form-urlencoded",
            produces = "application/json")
    public Object assignPos(@RequestParam("queue_id") String queueId) {
        String requestId = assignPosService.assignPos(queueId);

        return objectMapper.createObjectNode().put("request_id", requestId);
    }

    @ResponseBody
    @RequestMapping(
            path = "queue_pos/{queue_id}/{request_id}",
            method = RequestMethod.GET,
            produces = "application/json")
    public Object queuePos(@PathVariable("queue_id") String queueId, @PathVariable("request_id") String requestId) {
        long pos = queueService.getPosition(queueId, requestId);

        return objectMapper.createObjectNode().put("position", pos);
    }

    @ResponseBody
    @RequestMapping(path = "serving_pos/{queue_id}", method = RequestMethod.GET, produces = "application/json")
    public Object servingPos(@PathVariable("queue_id") String queueId) {
        QueueServingPosition latestServingPosition = queueService.getLatestServingPosition(queueId);
        return objectMapper.createObjectNode().put("position", latestServingPosition.getServingPosition());
    }

    @ResponseBody
    @RequestMapping(path = "waiting_num/{queue_id}", method = RequestMethod.GET, produces = "application/json")
    public Object waitingNum(@PathVariable("queue_id") String queueId) {
        int waitingNum = queueService.getWaitingNum(queueId);

        return objectMapper.createObjectNode().put("waiting_num", waitingNum);
    }

    @ResponseBody
    @RequestMapping(
            path = "generate_token",
            method = RequestMethod.POST,
            consumes = "application/x-www-form-urlencoded",
            produces = "application/json")
    public AccessTokenDto generateToken(
            @RequestParam("queue_id") String queueId, @RequestParam("request_id") String requestId) {
        return queueService.generateToken(queueId, requestId);
    }
}
