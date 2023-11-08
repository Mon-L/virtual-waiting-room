--[[
KEYS:
    1. queue:serving.requests:${queueId}

ARGV:
    1. now

RETURN:

--]]

-- 移除令牌已过期的Request
redis.call('ZREMRANGEBYSCORE', KEYS[1], 0, ARGV[1]);

--返回未过期的Request的数量
return redis.call('ZCARD', KEYS[1]);