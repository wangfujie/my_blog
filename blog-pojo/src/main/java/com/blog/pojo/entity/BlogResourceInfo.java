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
 * @date 2018-12-11
 * @description 资源分享信息表
 */
@TableName("blog_resource_info")
public class BlogResourceInfo extends Model<BlogResourceInfo> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
	@TableId(type = IdType.AUTO)
	private Integer id;
    /**
     * 资源名称
     */
	@TableField("resource_name")
	private String resourceName;
    /**
     * 资源描述
     */
	@TableField("resource_desc")
	private String resourceDesc;
    /**
     * 资源等级
     */
	@TableField("resource_level")
	private String resourceLevel;
    /**
     * 对应分类id
     */
	@TableField("category_id")
	private Integer categoryId;
    /**
     * 资源标签
     */
	private String tags;
    /**
     * 对应的文件id
     */
	@TableField("file_id")
	private Integer fileId;
    /**
     * 最近修改时间
     */
	@TableField("last_update_time")
	private Date lastUpdateTime;
    /**
     * 创建时间
     */
	@TableField("create_time")
	private Date createTime;
    /**
     * 是否开启分享（0不开启，1开启）
     */
	private Integer status;


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getResourceName() {
		return resourceName;
	}

	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}

	public String getResourceDesc() {
		return resourceDesc;
	}

	public void setResourceDesc(String resourceDesc) {
		this.resourceDesc = resourceDesc;
	}

	public String getResourceLevel() {
		return resourceLevel;
	}

	public void setResourceLevel(String resourceLevel) {
		this.resourceLevel = resourceLevel;
	}

	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	public String getTags() {
		return tags;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}

	public Integer getFileId() {
		return fileId;
	}

	public void setFileId(Integer fileId) {
		this.fileId = fileId;
	}

	public Date getLastUpdateTime() {
		return lastUpdateTime;
	}

	public void setLastUpdateTime(Date lastUpdateTime) {
		this.lastUpdateTime = lastUpdateTime;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

}
