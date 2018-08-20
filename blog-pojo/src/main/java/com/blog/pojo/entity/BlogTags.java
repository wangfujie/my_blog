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
 * @description 标签表
 */
@TableName("blog_tags")
public class BlogTags extends Model<BlogTags> {

    private static final long serialVersionUID = 1L;

    @TableId(type = IdType.AUTO)
	private Integer id;
    /**
     * 标签名称
     */
	@TableField("tag_name")
	private String tagName;
    /**
     * 所属分类
     */
	@TableField("category_id")
	private Integer categoryId;
    /**
     * 创建时间
     */
	@TableField("create_time")
	private Date createTime;
    /**
     * 点击次数
     */
	@TableField("click_num")
	private Integer clickNum;
    /**
     * 使用次数
     */
	@TableField("use_num")
	private Integer useNum;


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTagName() {
		return tagName;
	}

	public void setTagName(String tagName) {
		this.tagName = tagName;
	}

	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Integer getClickNum() {
		return clickNum;
	}

	public void setClickNum(Integer clickNum) {
		this.clickNum = clickNum;
	}

	public Integer getUseNum() {
		return useNum;
	}

	public void setUseNum(Integer useNum) {
		this.useNum = useNum;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

}
