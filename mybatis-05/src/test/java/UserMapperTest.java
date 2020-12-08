
import com.NATE.dao.UserMapper;
import com.NATE.pojo.User;
import com.NATE.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class UserMapperTest {
    @Test
    public void getUsers(){
        SqlSession sqlSession = MybatisUtils.getSession();

        //本质上利用了jvm的动态代理机制
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> users = mapper.getUsers();

        for (User user : users) {
            System.out.println(user);
        }

        sqlSession.close();
    }

    @Test
    public void getUsersByid(){
        SqlSession sqlSession = MybatisUtils.getSession();

        //本质上利用了jvm的动态代理机制
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        User user = mapper.selectUserByid(2);
        System.out.println(user);

        sqlSession.close();
    }

    //新增注解
    @Test
    public void addUser(){
        SqlSession sqlSession = MybatisUtils.getSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        mapper.addUser(new User(6, "小川", "123456"));

        sqlSession.close();
    }

    // 修改注解
    @Test
    public void upadteUser(){
        SqlSession sqlSession = MybatisUtils.getSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        mapper.updateUser(new User(6, "小川1", "1234567"));

        sqlSession.close();
    }

    // 删除注解
    @Test
    public void deleteUser(){
        SqlSession sqlSession = MybatisUtils.getSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        mapper.deleteUser(6);

        sqlSession.close();
    }

}
