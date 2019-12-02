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

public class MyBatisTest {
	
	private SqlSessionFactory sqlSessionFactory;
	
	@Before
	public void init() throws Exception {
		String resource = "org/mybatis/example/mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	}

	@Test
	public void testMybatisInit(){
		try (SqlSession session = sqlSessionFactory.openSession()) {
			Blog blog = (Blog) session.selectOne("org.mybatis.example.BlogMapper.selectBlog", 101);
			System.out.println(blog);
			List<Blog> blogs = session.selectList("selectAllBlog");
			System.out.println(blogs);
		}
	}
	
	
	@Test
	public void testMybatisInit2() throws Exception {
		try (SqlSession session = sqlSessionFactory.openSession()) {
			Blog blog = new Blog(106,"PHP", "PHP从入门到放弃");
			session.insert("createBlog", blog);
			//session.commit();
		}
	}
}
