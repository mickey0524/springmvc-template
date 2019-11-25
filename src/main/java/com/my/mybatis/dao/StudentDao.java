package com.my.mybatis.dao;

import com.my.mybatis.entity.Student;
import com.my.mybatis.provider.StudentProvider;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface StudentDao {

    @Delete(value="delete from student where id=#{id}")
    void delete(long id);

    @Select(value = "select * from student where id=#{id}")
    @Results(id = "resultMap", value = {
            @Result(property = "createTime", column = "create_time"),
            @Result(property = "modifyTime", column = "modify_time")
    })
    Student select(long id);

    @SelectProvider(type = StudentProvider.class, method = "queryStudentByParam")
    @ResultMap("resultMap")
    List<Student> selectV1(@Param("id") Integer id);

}
