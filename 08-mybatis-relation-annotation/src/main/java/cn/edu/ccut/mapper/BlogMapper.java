package cn.edu.ccut.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import cn.edu.ccut.bo.Blog;

public interface BlogMapper {
	
	@Select("select * from Blog")
	@Results(value = {
            @Result(id=true,property = "id",column = "id"),
            @Result(property = "name",column = "name"),
            @Result(property = "descs",column = "descs"),
            @Result(property = "author", one = @One(select = "cn.edu.ccut.mapper.AuthorMapper.selById"),column = "author_id")
    })
	public List<Blog> selectAllBlog();
	
	
	@Select("select * from Blog where author_id=#{author_id}")
    public List<Blog> selBlogByAuthorId(@Param("author_id") Integer author_id);
}
