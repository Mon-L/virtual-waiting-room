/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package cn.zcn.virtual.waiting.room.infrastructure.repository.typeHandler;

import cn.zcn.virtual.waiting.room.domain.utils.EnumValue;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

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
    public void setNonNullParameter(
            PreparedStatement preparedStatement, int i, EnumValue<F> ftEnumValue, JdbcType jdbcType)
            throws SQLException {
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
