package cn.edu.ccut.bo;

import org.apache.ibatis.type.Alias;

//@Alias("blog")
public class Blog {

	private Integer id;
	private String name;
	private String desc;
	public Blog() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Blog(Integer id, String name, String desc) {
		super();
		this.id = id;
		this.name = name;
		this.desc = desc;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	@Override
	public String toString() {
		return "Blog [id=" + id + ", name=" + name + ", desc=" + desc + "]";
	}
}
