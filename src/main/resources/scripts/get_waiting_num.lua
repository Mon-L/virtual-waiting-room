--[[
KEYS:
    waiting-queue.${queueId}
    queue.${queueId}

RETURN:
    -1:no queue
--]]

if redis.call('exists', KEYS[2]) == 0 then
    return -1;
else
    return redis.call('LLEN', KEYS[1]);
end;
