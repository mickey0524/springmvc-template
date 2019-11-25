package com.my.mybatis.provider;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.jdbc.SQL;

public class StudentProvider {

    private static final String TABLE = "student";

    public String queryStudentByParam(@Param("id") Integer id) {
        SQL sql = new SQL().SELECT("*").FROM(TABLE);

        if (id != null) {
            sql.WHERE("id = #{id}");
        }

        return sql.toString();
    }

}
