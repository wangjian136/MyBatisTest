package cn.edu.ccut.mapper;

import java.util.List;

import cn.edu.ccut.bo.Blog;

public interface BlogMapper {
	
	public Blog selectBlog(Integer id);
	
	public List<Blog> selectAllBlog();
	
	public void createBlog(Blog blog);
}
