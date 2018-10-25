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
 * @date 2018-10-25
 * @description 日志记录
 */
@TableName("blog_log_record")
public class BlogLogRecord extends Model<BlogLogRecord> {

    private static final long serialVersionUID = 1L;

    @TableId(type = IdType.AUTO)
	private Integer id;
    /**
     * 记录类别（1、点赞文章，2、阅读文章，3、主页浏览）
     */
	@TableField("record_type")
	private Integer recordType;
    /**
     * 对应的文章
     */
	@TableField("treatise_uuid")
	private String treatiseUuid;
    /**
     * 记录ip地址
     */
	@TableField("ip_address")
	private String ipAddress;
    /**
     * 记录创建时间
     */
	@TableField("create_time")
	private Date createTime;


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getRecordType() {
		return recordType;
	}

	public void setRecordType(Integer recordType) {
		this.recordType = recordType;
	}

	public String getTreatiseUuid() {
		return treatiseUuid;
	}

	public void setTreatiseUuid(String treatiseUuid) {
		this.treatiseUuid = treatiseUuid;
	}

	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

}
