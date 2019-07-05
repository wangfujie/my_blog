package com.blog.pojo.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * @author wangfj
 * @date 2018-09-10
 * @description 
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
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

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

}
