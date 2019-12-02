package cn.edu.ccut.test;

import java.io.InputStream;
import java.util.ArrayList;
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
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	}

	@Test
	public void testMybatisIf(){
		try (SqlSession session = sqlSessionFactory.openSession()) {
			session.selectOne("cn.edu.ccut.mapper.BlogMapper.selectBlog1", null);
		}
	}
	
	@Test
	public void testMybatisWhere(){
		try (SqlSession session = sqlSessionFactory.openSession()) {
			session.selectOne("cn.edu.ccut.mapper.BlogMapper.selectBlog2", 101);
		}
	}
	
	@Test
	public void testMybatisIfElse(){
		try (SqlSession session = sqlSessionFactory.openSession()) {
			session.selectOne("cn.edu.ccut.mapper.BlogMapper.selectBlog3", null);
		}
	}
	
	@Test
	public void testMybatisSet(){
		try (SqlSession session = sqlSessionFactory.openSession()) {
			Blog blog = new Blog(101, "Java1", "Java1");
			session.update("cn.edu.ccut.mapper.BlogMapper.updateBlog1", blog);
			session.commit();
		}
	}
	
	@Test
	public void testMybatisTrim(){
		try (SqlSession session = sqlSessionFactory.openSession()) {
			Blog blog = new Blog(101, "Java2", "Java2");
			session.update("cn.edu.ccut.mapper.BlogMapper.updateBlog2", blog);
			session.commit();
		}
	}
	
	@Test
	public void testMybatisBind(){
		try (SqlSession session = sqlSessionFactory.openSession()) {
			List<Blog> list = session.selectList("cn.edu.ccut.mapper.BlogMapper.selectAllBlogByName", "P");
			System.out.println(list);
		}
	}
	
	@Test
	public void testMybatisForeach(){
		try (SqlSession session = sqlSessionFactory.openSession()) {
			List<Integer> ids = new ArrayList<Integer>();
			ids.add(101);
			ids.add(102);
			session.delete("cn.edu.ccut.mapper.BlogMapper.delBlog",ids);
		}
	}
	
	@Test
	public void testMybatisInclude(){
		try (SqlSession session = sqlSessionFactory.openSession()) {
			List<Blog> list = session.selectList("cn.edu.ccut.mapper.BlogMapper.findTest");
			System.out.println(list);
		}
	}
}
