package cn.zcn.virtual.waiting.room.repository.typeHandler;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author zicung
 */
public class EnumValueTypeHandler<F, T> extends BaseTypeHandler<EnumValue<F>> {

    private EnumValue<F>[] enums;

    public EnumValueTypeHandler(Class<T> clazz) {
        if (!EnumValue.class.isAssignableFrom(clazz)) {
            throw new IllegalArgumentException("No EnumValue class: " + clazz.getSimpleName());
        }

        enums = (EnumValue<F>[]) clazz.getEnumConstants();
    }

    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, EnumValue<F> ftEnumValue, JdbcType jdbcType) throws SQLException {
        if (jdbcType == null) {
            preparedStatement.setObject(i, ftEnumValue.getValue());
        } else {
            preparedStatement.setObject(i, ftEnumValue.getValue(), jdbcType.TYPE_CODE);
        }
    }

    @Override
    public EnumValue<F> getNullableResult(ResultSet resultSet, String s) throws SQLException {
        Object obj = resultSet.getObject(s);

        for (EnumValue<F> t : enums) {
            if (t.getValue() == obj) {
                return t;
            }
        }

        return null;
    }

    @Override
    public EnumValue<F> getNullableResult(ResultSet resultSet, int i) throws SQLException {
        Object obj = resultSet.getObject(i);

        for (EnumValue<F> t : enums) {
            if (t.getValue() == obj) {
                return t;
            }
        }

        return null;
    }

    @Override
    public EnumValue<F> getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        Object val = callableStatement.getObject(i);
        for (EnumValue<F> t : enums) {
            if (t.getValue() == val) {
                return t;
            }
        }

        return null;
    }
}
