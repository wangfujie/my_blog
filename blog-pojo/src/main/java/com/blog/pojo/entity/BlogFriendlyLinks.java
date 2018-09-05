package com.blog.pojo.entity;

import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * @author wangfj
 * @date 2018-08-20
 * @description 友情链接
 */
@TableName("blog_friendly_links")
public class BlogFriendlyLinks extends Model<BlogFriendlyLinks> {

    private static final long serialVersionUID = 1L;

    @TableId(type = IdType.AUTO)
	private Integer id;
    /**
     * 链接地址
     */
	@TableField("link_url")
	private String linkUrl;
    /**
     * 链接名称
     */
	@TableField("link_name")
	private String linkName;
    /**
     * 链接标题
     */
	@TableField("link_title")
	private String linkTitle;
    /**
     * 创建时间
     */
	@TableField("create_time")
	private Date createTime;
    /**
     * 逻辑删除标识
     */
	@TableField("del_falg")
	private Integer delFalg;
    /**
     * 删除时间
     */
	@TableField("delete_time")
	private Date deleteTime;


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLinkUrl() {
		return linkUrl;
	}

	public void setLinkUrl(String linkUrl) {
		this.linkUrl = linkUrl;
	}

	public String getLinkName() {
		return linkName;
	}

	public void setLinkName(String linkName) {
		this.linkName = linkName;
	}

	public String getLinkTitle() {
		return linkTitle;
	}

	public void setLinkTitle(String linkTitle) {
		this.linkTitle = linkTitle;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Integer getDelFalg() {
		return delFalg;
	}

	public void setDelFalg(Integer delFalg) {
		this.delFalg = delFalg;
	}

	public Date getDeleteTime() {
		return deleteTime;
	}

	public void setDeleteTime(Date deleteTime) {
		this.deleteTime = deleteTime;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

}
