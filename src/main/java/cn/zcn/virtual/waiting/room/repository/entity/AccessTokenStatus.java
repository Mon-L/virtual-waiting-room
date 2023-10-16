package cn.zcn.virtual.waiting.room.repository.entity;

import cn.zcn.virtual.waiting.room.repository.typeHandler.EnumValue;

/**
 * @author zicung
 */
public enum AccessTokenStatus implements EnumValue<Integer> {
    COMPLETED(1),
    ABANDONED(2),
    ACTIVE(3);

    private final int value;

    AccessTokenStatus(int value) {
        this.value = value;
    }

    @Override
    public Integer getValue() {
        return value;
    }

    public static AccessTokenStatus getByValue(int value) {
        for (AccessTokenStatus t : AccessTokenStatus.class.getEnumConstants()) {
            if (t.getValue() == value) {
                return t;
            }
        }
        throw new IllegalArgumentException("AccessTokenStatus can not be found by value: " + value);
    }
}
