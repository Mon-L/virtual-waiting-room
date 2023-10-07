--[[
KEYS:
    waiting-queue.${queueId},
    request.${queueId}.${requestId},
    queue.${queueId}
ARGV:
    ${queueId},
    ${requestId},
    ${entryTime}

RETURN:
    -1:no queue
    -2:no request
--]]

-- 判断queueId是否有效
if redis.call('exists', KEYS[3]) == 0 then
    return -1;
end;

-- 判断request是否有效
if redis.call('exists', KEYS[2]) == 0 then
    return -2;
end;

local lastQueuePosition = tonumber(redis.call('HGET', KEYS[3], 'lastQueuePosition'));
local currQueuePos = lastQueuePosition + 1;

-- 进入队列
redis.call('RPUSH', KEYS[1], ARGV[2]);

redis.call('HSET', KEYS[3], 'lastQueuePosition', currQueuePos);
redis.call('HSET', KEYS[2],'entryTime', ARGV[3], 'queuePosition', currQueuePos);

return currQueuePos;