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

package cn.zcn.virtual.waiting.room.adapter.web;

import cn.zcn.virtual.waiting.room.client.api.QueueManageService;
import cn.zcn.virtual.waiting.room.client.api.QueueService;
import cn.zcn.virtual.waiting.room.client.dto.QueueCreateCmd;
import cn.zcn.virtual.waiting.room.client.dto.QueueUpdateCmd;
import cn.zcn.virtual.waiting.room.client.dto.data.QueueDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Date;
import javax.annotation.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @author zicung
 */
@Controller
@RequestMapping(path = "api/queue")
public class PrivateAPI {

    @Resource
    private ObjectMapper objectMapper;

    @Resource
    private QueueService queueService;

    @Resource
    private QueueManageService queueManageService;

    @ResponseBody
    @RequestMapping(method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    public QueueDTO addQueue(@RequestBody QueueCreateCmd queueCreateCmd) {
        return queueManageService.addQueue(queueCreateCmd);
    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.PUT, consumes = "application/json", produces = "application/json")
    public QueueDTO updateQueue(@RequestBody QueueUpdateCmd queueUpdateCmd) {
        return queueManageService.updateQueue(queueUpdateCmd);
    }

    @ResponseBody
    @RequestMapping(path = "{id}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<QueueDTO> getQueue(@PathVariable int id) {
        QueueDTO queue = queueManageService.getQueueById(id);
        if (queue == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(queue);
    }

    @RequestMapping(path = "{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteQueue(@PathVariable int id) {
        if (queueManageService.deleteById(id) != null) {
            return ResponseEntity.ok(null);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @ResponseBody
    @RequestMapping(
            path = "increment_serving_position",
            method = RequestMethod.POST,
            consumes = "application/x-www-form-urlencoded",
            produces = "application/json")
    public Object incrementServingPosition(
            @RequestParam("queue_id") String queueId, @RequestParam("increment_by") int incrementBy) {
        long servingPos = queueService.increaseServingPosition(queueId, incrementBy);
        return objectMapper.createObjectNode().put("serving_pos", servingPos);
    }

    @ResponseBody
    @RequestMapping(
            path = "update_token_status",
            method = RequestMethod.POST,
            consumes = "application/x-www-form-urlencoded")
    public void updateTokenStatus(
            @RequestParam("queue_id") String queueId,
            @RequestParam("request_id") String requestId,
            @RequestParam("status") int status) {
        queueService.updateTokenStatus(queueId, requestId, status);
    }

    @ResponseBody
    @RequestMapping(path = "/{queue_id}/active_token_num", method = RequestMethod.GET)
    public Object getActiveTokenNum(@PathVariable("queue_id") String queueId) {
        long num = queueService.getActiveTokenNum(queueId, new Date());
        return objectMapper.createObjectNode().put("active_num", num);
    }
}
