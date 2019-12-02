package cn.edu.ccut.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.session.RowBounds;

import cn.edu.ccut.bo.Blog;

public interface BlogMapper {
	@Select("select * from Blog where id = #{id}")
	public Blog selectBlog(Integer id);
	@Select("select * from Blog")
	public List<Blog> selectAllBlog();
	@Select("select * from Blog limit #{page},#{rows}")
	public List<Blog> selectAllBlog2(@Param("page")int page,@Param("rows")int rows);
	@Select("select * from Blog")
	public List<Blog> selectAllBlog3(RowBounds rowBounds);
	@Insert("insert into Blog(id,name,descs) values (#{id},#{name},#{descs})")
	public void createBlog(Blog blog);
}
