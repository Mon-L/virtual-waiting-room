--[[
KEYS:
    queue.${queueId}
    waiting-queue.${queueId}

ARGV:
    ${incrementBy}
    ${issuedTime}
--]]

local incrementBy = tonumber(ARGV[1]);
local issuedTime = tonumber(ARGV[2]);
local lastServingPos = tonumber(redis.call('HGET', KEYS[1], 'servingPosition'));
local lastIssuedTime = tonumber(redis.call('HGET', KEYS[1], 'servingPositionIssuedTime'));

-- 当前时间小于上一次的设置时间
if issuedTime <= lastIssuedTime then
    return nil;
end;

local servingPos = lastServingPos + incrementBy;
redis.call('HSET', KEYS[1], 'servingPosition', servingPos);
redis.call('HSET', KEYS[1], 'servingPositionIssuedTime', issuedTime);
return servingPos;