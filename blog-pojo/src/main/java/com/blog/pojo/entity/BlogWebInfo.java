package com.blog.pojo.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import java.io.Serializable;
import java.util.Date;

/**
 * @author wangfj
 * @date 2018-08-16
 * @description 网站的一些统计数据
 */
@TableName("blog_web_info")
public class BlogWebInfo extends Model<BlogWebInfo> {

    private static final long serialVersionUID = 1L;

	@TableId(type = IdType.AUTO)
	private Integer id;
    /**
     * 网站简介
     */
	@TableField("web_summary")
	private String webSummary;
    /**
     * 网站浏览量
     */
	@TableField("web_browse_num")
	private Integer webBrowseNum;
    /**
     * 网站关注量
     */
	@TableField("web_follow_num")
	private Integer webFollowNum;
    /**
     * 网站注册量
     */
	@TableField("web_user_num")
	private Integer webUserNum;
    /**
     * 数据更新时间（按天统计）
     */
	@TableField("update_time")
	private Date updateTime;


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getWebSummary() {
		return webSummary;
	}

	public void setWebSummary(String webSummary) {
		this.webSummary = webSummary;
	}

	public Integer getWebBrowseNum() {
		return webBrowseNum;
	}

	public void setWebBrowseNum(Integer webBrowseNum) {
		this.webBrowseNum = webBrowseNum;
	}

	public Integer getWebFollowNum() {
		return webFollowNum;
	}

	public void setWebFollowNum(Integer webFollowNum) {
		this.webFollowNum = webFollowNum;
	}

	public Integer getWebUserNum() {
		return webUserNum;
	}

	public void setWebUserNum(Integer webUserNum) {
		this.webUserNum = webUserNum;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

}
