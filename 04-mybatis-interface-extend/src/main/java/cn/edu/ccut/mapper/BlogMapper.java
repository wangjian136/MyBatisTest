package cn.edu.ccut.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import cn.edu.ccut.bo.Blog;

public interface BlogMapper {
	@Select("select * from Blog where id = #{id}")
	public Blog selectBlog(Integer id);
	@Select("select * from Blog")
	public List<Blog> selectAllBlog();
	@Insert("insert into Blog(id,name,descs) values (#{id},#{name},#{descs})")
	public void createBlog(Blog blog);
}
