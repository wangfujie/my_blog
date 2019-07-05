package com.blog.pojo.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author wangfj
 * @date 2018-08-16
 * @description 关于网站使用的技术
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
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

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

}
