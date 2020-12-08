import com.NATE.dao.TeacherMapper;
import com.NATE.pojo.Teacher;
import com.NATE.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class Mytest {
    @Test
    public void getTeacher(){
        SqlSession sqlsession = MybatisUtils.getSession();
        TeacherMapper mapper = sqlsession.getMapper(TeacherMapper.class);
        Teacher teacher = mapper.getTeacher(1);
        System.out.println(teacher);

        sqlsession.close();
    }

    @Test
    public void getTeacher2(){
        SqlSession sqlsession = MybatisUtils.getSession();
        TeacherMapper mapper = sqlsession.getMapper(TeacherMapper.class);
        Teacher teacher = mapper.getTeacher2(1);
        System.out.println(teacher);

        sqlsession.close();
    }
}
