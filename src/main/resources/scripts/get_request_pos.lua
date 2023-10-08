--[[
KEYS:
    request.${queueId}.${requestId}
    queue.${queueId}
    expired.request.${queueId}
    waiting-queue.${queueId}
    ${queueId}

ARGV:
    ${now}
    ${requestId}

RETURN:
    -3: request expired
    -2: request not processed
    -1: no request
    other: request position
--]]

-- 检查request是否已超时
if redis.call('SISMEMBER', KEYS[3], ARGV[2]) == 1 then
    return -3;
end ;

-- 判断request是否有效
if redis.call('exists', KEYS[1]) == 0 then
    return -1;
end ;

if redis.call('HEXISTS', KEYS[1], 'queuePosition') == 0 then
    return -2;
end

local queuePosition = tonumber(redis.call('HGET', KEYS[1], 'queuePosition'));

local enableExpiry = tonumber(redis.call('HGET', KEYS[2], 'enableQueuePositionExpiry'));
if enableExpiry == 0 then
    -- 等候室没有开启超时开关
    return queuePosition;
else
    -- 等候室开启了超时开关，判断request是否已经超时
    local entryTime = tonumber(redis.call('HGET', KEYS[1], 'entryTime'));
    local servingPosIssuedTime = tonumber(redis.call('HGET', KEYS[2], 'servingPositionIssuedTime'));
    local posExpiryPeriod = tonumber(redis.call('HGET', KEYS[2], 'queuePositionExpiryPeriod')) * 1000;
    local now = tonumber(ARGV[1]);

    local tiq = -1;
    if entryTime >= servingPosIssuedTime then
        tiq = entryTime - servingPosIssuedTime;
    else
        tiq = now - entryTime;
    end ;

    if tiq >= posExpiryPeriod then
        -- 等待超时
        local idx = tonumber(redis.call('LPOS', KEYS[4], ARGV[2]));
        local expiredReqs = redis.call('LPOP', KEYS[4], idx + 1);
        for i = 1, #expiredReqs do
            local requestKey = 'request.' .. KEYS[5] .. '.' .. string.gsub(expiredReqs[i], '\"', '');
            redis.call('DEL', requestKey);
            redis.call('SADD', KEYS[3], expiredReqs[i]);
        end;
        return -3;
    else
        -- 等待未超时
        return queuePosition;
    end ;
end ;
