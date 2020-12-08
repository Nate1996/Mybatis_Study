package com.NATE.dao;

import com.NATE.pojo.User;
import com.NATE.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;

public class UserDaoTest {

    @Test
    public void test(){

        //获取SqlSession对象
        SqlSession sqlSession = MybatisUtils.getSession();
        //方式一：getMapper
        UserMapper userDao = sqlSession.getMapper(UserMapper.class);
        List<User> userList = userDao.getUserList();

        for (User user : userList) {
            System.out.println(user);
        }
        // 关闭SqlSession
        sqlSession.close();

    }


}
