--[[
KEYS:
    1. queue.${queueId}.latestPosition
    2. queue.${queueId}.waitingNum
ARGV:

RETURN:
    -1 (no queue latestPosition)
    other (requestPos)
--]]

redis.call('INCR', KEYS[2]);
return redis.call('INCR', KEYS[1]);