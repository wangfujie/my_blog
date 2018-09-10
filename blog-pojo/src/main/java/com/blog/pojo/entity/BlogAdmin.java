package com.blog.pojo.entity;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import java.io.Serializable;

/**
 * @author wangfj
 * @date 2018-09-10
 * @description 
 */
@TableName("blog_admin")
public class BlogAdmin extends Model<BlogAdmin> {

    private static final long serialVersionUID = 1L;

    @TableId(type = IdType.AUTO)
	private Integer id;
    /**
     * 显示名称
     */
	@TableField("show_name")
	private String showName;
    /**
     * 账号
     */
	private String account;
    /**
     * 密码
     */
	private String password;
    /**
     * 状态（1，启用，0，停用）
     */
	private Integer status;
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


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getShowName() {
		return showName;
	}

	public void setShowName(String showName) {
		this.showName = showName;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Date getLoginTime() {
		return loginTime;
	}

	public void setLoginTime(Date loginTime) {
		this.loginTime = loginTime;
	}

	public String getLoginIp() {
		return loginIp;
	}

	public void setLoginIp(String loginIp) {
		this.loginIp = loginIp;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

}
