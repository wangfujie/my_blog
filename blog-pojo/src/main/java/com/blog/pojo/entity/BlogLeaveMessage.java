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
 * @description 留言表
 */
@TableName("blog_leave_message")
@NoArgsConstructor
@Data
@Accessors(chain = true)
public class BlogLeaveMessage extends Model<BlogLeaveMessage> {

    private static final long serialVersionUID = 1L;

	@TableId(type = IdType.UUID)
	private String uuid;
    /**
     * 留言ip地址
     */
	@TableField("ip_address")
	private String ipAddress;
    /**
     * 留言人名称
     */
	@TableField("fan_name")
	private String fanName;
    /**
     * 性别
     */
	@TableField("fan_sex")
	private Integer fanSex;
	/**
     * 随机头像码
     */
	@TableField("head_img_num")
	private Integer headImgNum;
	/**
     * 留言内容
     */
	@TableField("message_content")
	private String messageContent;
	/**
     * 回复
     */
	private String reply;
    /**
     * 联系邮箱
     */
	@TableField("contact_mail")
	private String contactMail;
    /**
     * 留言时间
     */
	@TableField("create_time")
	private Date createTime;
    /**
     * 状态（1正常，2删除）
     */
	private Integer status;


	@Override
	protected Serializable pkVal() {
		return this.uuid;
	}

}
