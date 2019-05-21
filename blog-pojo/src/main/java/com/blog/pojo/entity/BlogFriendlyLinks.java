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
 * @date 2018-08-20
 * @description 友情链接
 */
@TableName("blog_friendly_links")
@NoArgsConstructor
@Data
@Accessors(chain = true)
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
	@TableField("del_flag")
	private Integer delFlag;
    /**
     * 删除时间
     */
	@TableField("delete_time")
	private Date deleteTime;


	@Override
	protected Serializable pkVal() {
		return this.id;
	}

}
