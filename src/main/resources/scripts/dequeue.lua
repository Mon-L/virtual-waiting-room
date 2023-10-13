--[[
KEYS:
    1. queue.${queueId}.waitingNum

ARGV:

RETURN:

--]]

redis.call('DECR', KEYS[1]);