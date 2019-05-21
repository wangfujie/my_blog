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
 * @date 2018-12-11
 * @description 文件信息表
 */
@TableName("blog_file")
@NoArgsConstructor
@Data
@Accessors(chain = true)
public class BlogFile extends Model<BlogFile> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
	@TableId(type = IdType.AUTO)
	private Integer id;
    /**
     * 文件名
     */
	@TableField("file_name")
	private String fileName;
    /**
     * 文件路径
     */
	@TableField("file_path")
	private String filePath;
    /**
     * 文件类型(扩展名)
     */
	@TableField("file_type")
	private String fileType;
    /**
     * 文件大小
     */
	@TableField("file_size")
	private String fileSize;
    /**
     * 文件描述
     */
	private String description;
    /**
     * 短路径
     */
	@TableField("short_path")
	private String shortPath;
	/**
     * 文件uuid
     */
	@TableField("file_uuid")
	private String fileUuid;
    /**
     * 上传时间
     */
	@TableField("create_time")
	private Date createTime;

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

}
