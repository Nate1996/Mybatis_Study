import com.NATE.dao.UserMapper;
import com.NATE.pojo.User;
import com.NATE.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class Mytest {
    @Test
    public void queryUsersById(){
        //创建两个Session
        SqlSession sqlSession = MybatisUtils.getSession();
        SqlSession sqlSession2 = MybatisUtils.getSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.queryUsersById(2);
        System.out.println(user);
        sqlSession.close();

        UserMapper mapper2 = sqlSession2.getMapper(UserMapper.class);
        User user2 = mapper2.queryUsersById(2);
        System.out.println(user2);

        System.out.println(user==user2);


        sqlSession2.close();
    }
}
