--[[
KEYS:
    waiting-queue.${queueId}
    request.${queueId}.${requestId}
    queue.${queueId}
    expired.request.${queueId}

ARGV:
    ${requestId}
    ${now}

RETURN:
    -4:超时
    -3:no request
    -2:no queue
    -1:未能退出等候室
    pos:退出成功
--]]

-- 判断queueId是否有效
if redis.call('exists', KEYS[3]) == 0 then
    return -2;
end;

-- 判断request是否有效
if redis.call('exists', KEYS[2]) == 0 then
    return -3;
end;

-- 检查request是否已超时
if redis.call('SISMEMBER', KEYS[4], ARGV[1]) == 1 then
    return -4;
end;

local servingPos = tonumber(redis.call('HGET', KEYS[3], 'servingPosition'));
local requestPos = tonumber(redis.call('HGET', KEYS[2], 'queuePosition'));

if servingPos < requestPos then
    -- 还不能离开等待队列
    return -1;
end;

-- 离开等待队列
redis.call('LREM', KEYS[1], 1, ARGV[1]);

local enableExpiry = tonumber(redis.call('HGET', KEYS[3], 'enableQueuePositionExpiry'));
if enableExpiry == 0 then
    -- 等候室没有开启超时开关
    redis.call('DEL', KEYS[2]);
    return 1;
else
    -- 等候室开启了超时开关，判断是否已超时
    local entryTime = tonumber(redis.call('HGET', KEYS[2], 'entryTime'));
    local servingPosIssuedTime = tonumber(redis.call('HGET', KEYS[3], 'servingPositionIssuedTime'));
    local posExpiryPeriod = tonumber(redis.call('HGET', KEYS[3], 'queuePositionExpiryPeriod')) * 1000;
    local now = tonumber(ARGV[2]);

    local tiq = -1;
    if entryTime >= servingPosIssuedTime then
        tiq = entryTime - servingPosIssuedTime;
    else
        tiq = now - entryTime;
    end;

    if tiq >= posExpiryPeriod then
        -- 等待超时
        redis.call('SADD', KEYS[4], ARGV[1]);
        redis.call('DEL', KEYS[2]);
        return -4;
    else
        -- 等待未超时，并可以离开等候室
        redis.call('DEL', KEYS[2]);
        return 1;
    end;
end;