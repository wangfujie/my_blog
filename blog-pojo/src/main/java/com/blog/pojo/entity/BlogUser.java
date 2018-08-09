package com.blog.pojo.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * @author wangfj
 * @date 2018-08-09
 * @description
 */
@TableName("blog_user")
public class BlogUser extends Model<BlogUser> {

    private static final long serialVersionUID = 1L;

	private String uuid;
	private String name;
	private String email;


	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	protected Serializable pkVal() {
		return this.uuid;
	}

}
