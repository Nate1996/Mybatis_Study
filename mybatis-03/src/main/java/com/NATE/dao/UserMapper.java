package com.NATE.dao;

import com.NATE.pojo.User;

import java.util.List;
import java.util.Map;

public interface UserMapper {

    // 查询所有用户
    List<User> getUserList();

    // 插入一个用户
    int addUser(User user);

    // 修改一个用户
    int updateUser(User user);

    // 删除一个用户
    int deleteUser(int id);


}
