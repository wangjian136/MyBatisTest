package cn.edu.ccut.test;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import cn.edu.ccut.bo.Blog;
import cn.edu.ccut.mapper.BlogMapper;

public class MyBatisTest {
	
	private SqlSessionFactory sqlSessionFactory;
	
	@Before
	public void init() throws Exception {
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	}

	@Test
	public void testMybatisInterface(){
		try (SqlSession session = sqlSessionFactory.openSession()) {
			 BlogMapper mapper = session.getMapper(BlogMapper.class);
			 Blog blog = mapper.selectBlog(101);
			 List<Blog> blogs = mapper.selectAllBlog();
			 System.out.println(blog);
			 System.out.println(blogs);
		}
	}
	
	
	@Test
	public void testMybatisInterface2() throws Exception {
		try (SqlSession session = sqlSessionFactory.openSession()) {
			Blog blog = new Blog(106,"PHP", "PHP从入门到放弃");
			BlogMapper mapper = session.getMapper(BlogMapper.class);
			mapper.createBlog(blog);
			//session.commit();
		}
	}
	
	
	@Test
	public void testMybatisPageAndSize01() throws Exception {
		try (SqlSession session = sqlSessionFactory.openSession()) {
			int page = 2;//当前页数
			int rows = 2;//每页显示条数
			BlogMapper mapper = session.getMapper(BlogMapper.class);
			//数组分页
			List<Blog> blogs = mapper.selectAllBlog();
			int firstIndex = (page - 1) * rows;
			int lastIndex = page * rows;
			List<Blog> newBlogs = blogs.subList(firstIndex, lastIndex);
			System.out.println(newBlogs);
		}
	}
	
	@Test
	public void testMybatisPageAndSize02() throws Exception {
		try (SqlSession session = sqlSessionFactory.openSession()) {
			int page = 2;//当前页数
			int rows = 2;//每页显示条数
			BlogMapper mapper = session.getMapper(BlogMapper.class);
			//SQL分页
			List<Blog> blogs = mapper.selectAllBlog2(page,rows);
			System.out.println(blogs);
		}
	}
	
	@Test
	public void testMybatisPageAndSize03() throws Exception {
		try (SqlSession session = sqlSessionFactory.openSession()) {
			int page = 1;//当前页数
			int rows = 2;//每页显示条数
			RowBounds rowBounds = new RowBounds(page, rows);
			BlogMapper mapper = session.getMapper(BlogMapper.class);
			//RowBounds分页
			List<Blog> blogs = mapper.selectAllBlog3(rowBounds);
			System.out.println(blogs);
		}
	}
}
