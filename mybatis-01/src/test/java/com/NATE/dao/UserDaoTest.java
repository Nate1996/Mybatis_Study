package com.NATE.dao;

import com.NATE.pojo.User;
import com.NATE.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.sql.SQLOutput;
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


    // 测试根据Id查询用户
    @Test
    public void getUserById(){
        SqlSession sqlSession = MybatisUtils.getSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.getUserById(1);
        System.out.println(user);

        sqlSession.close();

    }

    // 增删改需要提交事务
    // 增加一个用户
    @Test
    public void addUser(){
        SqlSession sqlSession = MybatisUtils.getSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        mapper.addUser(new User(4,"小冬","654123"));

        // 提交事务
        sqlSession.commit();

        sqlSession.close();
    }

    // 修改一个用户
    @Test
    public void updateUser(){
        SqlSession sqlSession = MybatisUtils.getSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        mapper.updateUser(new User(4,"小董","969632"));

        // 提交事务
        sqlSession.commit();

        sqlSession.close();
    }

    // 删除一个用户
    @Test
    public void deleteUser(){
        SqlSession sqlSession = MybatisUtils.getSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        mapper.deleteUser(4);

        // 提交事务
        sqlSession.commit();

        sqlSession.close();
    }


    // map方式 增加一个用户
    @Test
    public void addUser2(){

        //获取SqlSession对象
        SqlSession sqlSession = MybatisUtils.getSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        HashMap<String, Object> map = new HashMap<String, Object>();

        map.put("userid",5);
        map.put("username","小姚");
        map.put("password","512341");

        int i = mapper.addUser2(map);
        if(i>0){
            System.out.println("添加成功");
        }

        sqlSession.commit();
        // 关闭SqlSession
        sqlSession.close();
    }


    // 模糊查询
    @Test
    public void getUserLike(){
        //获取SqlSession对象
        SqlSession sqlSession = MybatisUtils.getSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        List<User> userlist = mapper.getUserLike("%卷");

        for (User user : userlist) {
            System.out.println(user.getName());
        }
        sqlSession.close();
    }

}
