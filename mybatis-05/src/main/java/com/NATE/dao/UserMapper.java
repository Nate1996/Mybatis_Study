package com.NATE.dao;

import com.NATE.pojo.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface UserMapper {

    @Select("select * from user")
    List<User> getUsers();

    //查询注解
    // 方法存在多个参数，所有的参数前面必须加上@Param（“id”）
    @Select("select * from user where id = #{id}")
    User selectUserByid(@Param("id") int id);

    // 插入注解
    @Insert("insert into user(id,name,pwd) values(#{id},#{name},#{password})")
    int addUser(User user);

    // 修改注解
    @Update("update user set name=#{name},pwd=#{password} where id=#{id}")
    int updateUser(User user);

    //根据id删除用
    @Delete("delete from user where id = #{id}")
    int deleteUser(@Param("id")int id);

}
