package com.NATE.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

public class MybatisUtils {

    private static SqlSessionFactory sqlSessionFactory;

    static {
        try{
            //使用Mybatis第一步：获取sqlSessionFactory对象
            String resource = "mybatis-config.xml";
            InputStream inputStream = Resources.getResourceAsStream(resource);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    // 获取SqlSession连接
    //SqlSession 完全包含了面向数据库执行SQL命令所需的所有方法
    public static SqlSession getSession(){
        return sqlSessionFactory.openSession();
    }
}
