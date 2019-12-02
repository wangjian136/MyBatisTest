package cn.edu.ccut.test;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
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
			session.commit();
		}
	}
}
