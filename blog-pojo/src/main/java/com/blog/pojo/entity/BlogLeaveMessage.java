package com.blog.pojo.entity;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;

/**
 * @author wangfj
 * @date 2018-08-16
 * @description 留言表
 */
@TableName("blog_leave_message")
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
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
	@TableField("create_time")
	private Date createTime;
    /**
     * 状态（1正常，2删除）
     */
	private Integer status;


	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	public String getFanName() {
		return fanName;
	}

	public void setFanName(String fanName) {
		this.fanName = fanName;
	}

	public Integer getFanSex() {
		return fanSex;
	}

	public void setFanSex(Integer fanSex) {
		this.fanSex = fanSex;
	}

	public String getContactMail() {
		return contactMail;
	}

	public void setContactMail(String contactMail) {
		this.contactMail = contactMail;
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
		return this.uuid;
	}

	public String getMessageContent() {
		return messageContent;
	}

	public void setMessageContent(String messageContent) {
		this.messageContent = messageContent;
	}

	public String getReply() {
		return reply;
	}

	public void setReply(String reply) {
		this.reply = reply;
	}

	public Integer getHeadImgNum() {
		return headImgNum;
	}

	public void setHeadImgNum(Integer headImgNum) {
		this.headImgNum = headImgNum;
	}
}
