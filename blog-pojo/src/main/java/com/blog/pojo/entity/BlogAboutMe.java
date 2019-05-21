package com.blog.pojo.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import java.io.Serializable;
import java.util.Date;

/**
 * @author wangfj
 * @date 2018-08-16
 * @description 关于我
 */
@TableName("blog_about_me")
@NoArgsConstructor
@Data
@Accessors(chain = true)
public class BlogAboutMe extends Model<BlogAboutMe> {

    private static final long serialVersionUID = 1L;

    @TableId(type = IdType.AUTO)
	private Integer id;
    /**
     * 我的名字
     */
	@TableField("my_name")
	private String myName;
    /**
     * 关于我简介
     */
	@TableField("about_me")
	private String aboutMe;
    /**
     * 博客域名
     */
	@TableField("blog_domain_name")
	private String blogDomainName;
    /**
     * 服务器
     */
	@TableField("server_name")
	private String serverName;
    /**
     * 域名创建时间
     */
	@JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
	@TableField("domain_time")
	private Date domainTime;
    /**
     * 服务器链接
     */
	@TableField("server_link")
	private String serverLink;
    /**
     * 备案号
     */
	@TableField("record_number")
	private String recordNumber;
    /**
     * 程序
     */
	@TableField("program_type")
	private String programType;
    /**
     * 信息更新时间
     */
	@TableField("update_time")
	private Date updateTime;

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

}
