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
 * @description 网站的一些统计数据
 */
@TableName("blog_web_info")
@NoArgsConstructor
@Data
@Accessors(chain = true)
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

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

}
