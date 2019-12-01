package cn.edu.ccut.test;

import java.io.InputStream;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import cn.edu.ccut.bo.Blog;

public class MyBatisTest {

	@Test
	public void testMybatisInit() throws Exception {
		String resource = "org/mybatis/example/mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		
		try (SqlSession session = sqlSessionFactory.openSession()) {
			Blog blog = (Blog) session.selectOne("org.mybatis.example.BlogMapper.selectBlog", 101);
			System.out.println(blog);
		}
	}
}
