package com.NATE.dao;

import com.NATE.pojo.User;
import com.NATE.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.sql.SQLOutput;
import java.util.HashMap;
import java.util.List;


public class UserDaoTest {

/*    static Logger logger = Logger.getLogger(UserDaoTest.class);
    @Test
    public void testlog4j(){
        logger.info("info:进入了testlog4");
        logger.debug("debug:进入了testlog4");
        logger.error("error:进入了testlog4");
    }*/

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

    @Test
    public void getUserBylimit(){
        //获取SqlSession对象
        SqlSession sqlSession = MybatisUtils.getSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        HashMap<String, Integer> map = new HashMap<String, Integer>();
        map.put("startIndex",1);
        map.put("pageSize",2);

        List<User> userList = mapper.getUserByLimit(map);

        for (User user : userList) {
            System.out.println(user);
        }

        // 关闭SqlSession
        sqlSession.close();

    }


}
