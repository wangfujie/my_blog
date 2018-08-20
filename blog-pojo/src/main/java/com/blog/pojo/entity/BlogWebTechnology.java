package com.blog.pojo.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import java.io.Serializable;

/**
 * @author wangfj
 * @date 2018-08-16
 * @description 关于网站使用的技术
 */
@TableName("blog_web_technology")
public class BlogWebTechnology extends Model<BlogWebTechnology> {

    private static final long serialVersionUID = 1L;

	@TableId(type = IdType.AUTO)
	private Integer id;
    /**
     * 技术标题名称
     */
	@TableField("technology_title")
	private String technologyTitle;
    /**
     * 技术内容介绍
     */
	@TableField("technology_content")
	private String technologyContent;
    /**
     * 显示顺序
     */
	@TableField("show_sort")
	private Integer showSort;


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTechnologyTitle() {
		return technologyTitle;
	}

	public void setTechnologyTitle(String technologyTitle) {
		this.technologyTitle = technologyTitle;
	}

	public String getTechnologyContent() {
		return technologyContent;
	}

	public void setTechnologyContent(String technologyContent) {
		this.technologyContent = technologyContent;
	}

	public Integer getShowSort() {
		return showSort;
	}

	public void setShowSort(Integer showSort) {
		this.showSort = showSort;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

}
