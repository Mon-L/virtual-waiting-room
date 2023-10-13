package cn.zcn.virtual.waiting.room.repository.entity;

import cn.zcn.virtual.waiting.room.repository.typeHandler.EnumValue;

/**
 * @author zicung
 */
public enum RequestStatus implements EnumValue<Integer> {
    INCOMPLETE(0),
    COMPLETED(1);

    private final int value;

    RequestStatus(int value) {
        this.value = value;
    }

    @Override
    public Integer getValue() {
        return value;
    }
}
