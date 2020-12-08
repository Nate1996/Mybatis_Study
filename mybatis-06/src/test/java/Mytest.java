import com.NATE.dao.StudentMapper;
import com.NATE.dao.TeacherMapper;
import com.NATE.pojo.Student;
import com.NATE.pojo.Teacher;
import com.NATE.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class Mytest {
    public static void main(String[] args) {
        SqlSession sqlsession = MybatisUtils.getSession();

        TeacherMapper mapper = sqlsession.getMapper(TeacherMapper.class);
        Teacher teacher = mapper.getTeacher(1);
        System.out.println(teacher);

        sqlsession.close();

    }
    @Test
    public void testStudent(){
        SqlSession sqlSession = MybatisUtils.getSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        List<Student> studentList = mapper.getStudent();
        for (Student student : studentList) {
            System.out.println(student);
        }
    }

    @Test
    public void testStudent2(){
        SqlSession sqlSession = MybatisUtils.getSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        List<Student> studentList = mapper.getStudent2();
        for (Student student : studentList) {
            System.out.println(student);
        }
    }
}
