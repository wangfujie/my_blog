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
 * @date 2018-10-25
 * @description 日志记录
 */
@TableName("blog_log_record")
@NoArgsConstructor
@Data
@Accessors(chain = true)
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


	@Override
	protected Serializable pkVal() {
		return this.id;
	}

}
