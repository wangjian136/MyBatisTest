package cn.edu.ccut.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Select;

import cn.edu.ccut.bo.Author;

public interface AuthorMapper {
	
	@Select("select * from author where id=#{id}")
    public Author selById(@Param("id") Integer id);
	
	@Select("select * from author")
    @Results(value = {
            @Result(id=true,property = "id",column = "id"),
            @Result(property = "name",column = "name"),
            @Result(property = "age",column = "age"),
            @Result(property = "blogs", many = @Many(select = "cn.edu.ccut.mapper.BlogMapper.selBlogByAuthorId"),column = "id")
    })
    public List<Author> selAllAuthor();
}
