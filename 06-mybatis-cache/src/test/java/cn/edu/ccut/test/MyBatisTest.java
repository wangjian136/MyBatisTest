package cn.edu.ccut.test;

import java.io.InputStream;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

public class MyBatisTest {
	
	private SqlSessionFactory sqlSessionFactory;
	
	@Before
	public void init() throws Exception {
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	}

	@Test
	public void testMybatisOneLevelCache1(){
		try (SqlSession session = sqlSessionFactory.openSession()) {
			session.selectList("cn.edu.ccut.mapper.BlogMapper.selectAllBlog");
			session.selectList("cn.edu.ccut.mapper.BlogMapper.selectAllBlog");
		}
	}
	
	@Test
	public void testMybatisOneLevelCache2(){
		try (SqlSession session = sqlSessionFactory.openSession()) {
			session.selectList("cn.edu.ccut.mapper.BlogMapper.selectAllBlog");
		}
		try (SqlSession session = sqlSessionFactory.openSession()) {
			session.selectList("cn.edu.ccut.mapper.BlogMapper.selectAllBlog");
		}
	}

}
