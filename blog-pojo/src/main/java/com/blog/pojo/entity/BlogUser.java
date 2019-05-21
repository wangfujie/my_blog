package com.blog.pojo.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * @author wangfj
 * @date 2018-08-09
 * @description
 */
@TableName("blog_user")
@NoArgsConstructor
@Data
@Accessors(chain = true)
public class BlogUser extends Model<BlogUser> {

    private static final long serialVersionUID = 1L;

	/**
	 * 主键
	 */
	@TableId(type = IdType.UUID)
	private String uuid;

	/**
	 * 地区
	 */
	@TableField("region_id")
	private String regionId;

	/**
	 * 用户名
	 */
	@TableField("user_name")
	private String userName;

	/**
	 * 真实姓名
	 */
	@TableField("real_name")
	private String realName;

	/**
	 * 生日
	 */
	private Date birthday;

	/**
	 * 账号
	 */
	private String account;

	/**
	 * 密码
	 */
	private String password;

	/**
	 * 邮箱
	 */
	private String email;

	/**
	 * 性别
	 */
	private String sex;

	/**
	 * 简单描述
	 */
	private String describe;

	/**
	 * 注册时间
	 */
	@TableField("create_time")
	private Date createTime;

	/**
	 * 最后登录时间
	 */
	@TableField("login_time")
	private Date loginTime;

	/**
	 * 最后登录ip
	 */
	@TableField("login_ip")
	private String loginIp;

	@Override
	protected Serializable pkVal() {
		return this.uuid;
	}

}