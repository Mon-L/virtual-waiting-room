--[[
KEYS:
    1. queue:serving.requests:${queueId}
    2. queue.${queueId}.waitingNum
ARGV:
    1. requestId
    2. expiredTime
RETURN:

--]]

-- 更新等待人数
local waitingNum = tonumber(redis.call('get', KEYS[2]));
if waitingNum ~= nil and waitingNum >=1 then
    redis.call('DECR', KEYS[2]);
end;

-- 记录可进入网站的Request
redis.call('ZADD', KEYS[1], ARGV[2], ARGV[1]);