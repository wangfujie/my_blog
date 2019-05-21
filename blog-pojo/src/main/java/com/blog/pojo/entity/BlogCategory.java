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
 * @date 2018-08-16
 * @description 博客类型表
 */
@TableName("blog_category")
@NoArgsConstructor
@Data
@Accessors(chain = true)
public class BlogCategory extends Model<BlogCategory> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
	@TableId(type = IdType.AUTO)
	private Integer id;
    /**
     * 类型名称
     */
	@TableField("category_name")
	private String categoryName;
	/**
     * 跳转url
     */
	@TableField("link_url")
	private String linkUrl;
    /**
     * 上级id
     */
	@TableField("f_id")
	private Integer fId;
    /**
     * 级别
     */
	@TableField("dict_level")
	private Integer dictLevel;
    /**
     * 创建时间
     */
	@TableField("create_time")
	private Date createTime;
    /**
     * 状态（0停用，1启用）
     */
	private Integer status;

	@Override
	protected Serializable pkVal() {
		return this.id;
	}
}
