--[[
KEYS:
    1. queue.${queueId}.latestPosition
    2. queue.${queueId}.waitingNum
ARGV:

RETURN:
    -1 (no queue latestPosition)
    other (requestPos)
--]]

-- 更新等待人数
redis.call('INCR', KEYS[2]);

-- 递增等候室已排队位置并返回
return redis.call('INCR', KEYS[1]);