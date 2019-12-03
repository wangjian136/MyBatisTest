package cn.edu.ccut.test;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import cn.edu.ccut.bo.Author;
import cn.edu.ccut.bo.Blog;
import cn.edu.ccut.mapper.AuthorMapper;
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
	public void testMybatisManyToOne(){
		try (SqlSession session = sqlSessionFactory.openSession()) {
			BlogMapper blogMapper = session.getMapper(BlogMapper.class);
			List<Blog> blogs = blogMapper.selectAllBlog();
			System.out.println(blogs);
		}
	}
	
	@Test
	public void testMybatisOneToMany(){
		try (SqlSession session = sqlSessionFactory.openSession()) {
			AuthorMapper authorMapper = session.getMapper(AuthorMapper.class);
			List<Author> authors = authorMapper.selAllAuthor();
			System.out.println(authors);
		}
	}

}
