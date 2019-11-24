package com.my.mybatis.dao;

import com.my.mybatis.entity.Student;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

public interface StudentDao {

    @Delete(value="delete from student where id=#{id}")
    void delete(long id);

    @Select(value = "select * from student where id=#{id}")
    @Results({
            @Result(property = "createTime", column = "create_time"),
            @Result(property = "modifyTime", column = "modify_time")
    })
    Student select(long id);

}
