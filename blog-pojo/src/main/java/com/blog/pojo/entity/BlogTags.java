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
 * @description 标签表
 */
@TableName("blog_tags")
@NoArgsConstructor
@Data
@Accessors(chain = true)
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


	@Override
	protected Serializable pkVal() {
		return this.id;
	}

}
