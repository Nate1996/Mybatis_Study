import com.NATE.dao.BlogMapper;
import com.NATE.pojo.Blog;
import com.NATE.utils.IDutils;
import com.NATE.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class Mytest {
    @Test
    public void addInitBlog(){
        SqlSession sqlSession = MybatisUtils.getSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);

        Blog blog = new Blog();
        blog.setId(IDutils.getId());
        blog.setTitle("凡人终有一死");
        blog.setAuthor("达摩流浪者");
        blog.setCreateTime(new Date());
        blog.setViews(10);
        mapper.addBlog(blog);

        blog.setId(IDutils.getId());
        blog.setTitle("go for it");
        mapper.addBlog(blog);

        sqlSession.close();

    }

    @Test
    public void queryBlogIF(){
        SqlSession sqlSession = MybatisUtils.getSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);

        HashMap map = new HashMap();
        map.put("title","凡人终有一死");
        map.put("author","达摩流浪者");
        List<Blog> blogs = mapper.queryBlogIF(map);
        for (Blog blog : blogs) {
            System.out.println(blog);
        }
        sqlSession.close();
    }

    @Test
    public void queryBlogChoose(){
        SqlSession sqlSession = MybatisUtils.getSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);

        HashMap map = new HashMap();
        //map.put("title","凡人终有一死");
        // map.put("author","达摩流浪者");
        map.put("views",10);

        List<Blog> blogs = mapper.queryBlogChoose(map);

        for (Blog blog : blogs) {
            System.out.println(blog);
        }

        sqlSession.close();
    }

    @Test
    public void updateBlog(){
        SqlSession sqlSession = MybatisUtils.getSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);

        HashMap map = new HashMap();
        //map.put("title","凡人终有一死1");
        map.put("author","达摩流浪者2");
        map.put("id","97213138eda644af9056fff279ac86ee");

       mapper.updateBlog(map);

        sqlSession.close();
    }

    @Test
    public void queryBlogForeach(){
        SqlSession sqlSession = MybatisUtils.getSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);

        HashMap map = new HashMap();
        ArrayList<Integer> ids = new ArrayList<Integer>();
        ids.add(1);
        ids.add(2);

        map.put("ids",ids);
        List<Blog> blogs = mapper.queryBlogForeach(map);

        for (Blog blog : blogs) {
            System.out.println(blog);
        }


        sqlSession.close();
    }
}
