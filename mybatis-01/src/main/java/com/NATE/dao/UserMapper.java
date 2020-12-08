package com.NATE.dao;

import com.NATE.pojo.User;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    // 查询所有用户
    List<User> getUserList();

    // 根据id查询用户
    User getUserById(int id);

    // 插入一个用户
    int addUser(User user);

    // 修改一个用户
    int updateUser(User user);

    // 删除一个用户
    int deleteUser(int id);

    // 用Map的方式增加一个用户
    int addUser2(Map<String,Object> map);

    // 用Map的方式根据Id查询用户
    User getUserById2(Map<String,Object> map);

    // 模糊查询
    List<User> getUserLike(String value);
}
