package com.blog.pojo.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import java.io.Serializable;
import java.util.Date;

/**
 * @author wangfj
 * @date 2018-08-16
 * @description 文章详情表
 */
@TableName("blog_treatise")
public class BlogTreatise extends Model<BlogTreatise> {

    private static final long serialVersionUID = 1L;

	@TableId(type = IdType.UUID)
	private String uuid;
    /**
     * 种类id
     */
	@TableField("category_id")
	private Integer categoryId;
    /**
     * 标题
     */
	@TableField("treatise_title")
	private String treatiseTitle;
    /**
     * 预览
     */
	@TableField("treatise_preview")
	private String treatisePreview;
    /**
     * 由来（1原创，2转载）
     */
	private Integer source;
    /**
     * 来源地
     */
	@TableField("reprint_from")
	private String reprintFrom;
    /**
     * 来源url
     */
	@TableField("reprint_url")
	private String reprintUrl;
    /**
     * 正文（html格式）
     */
	@TableField("treatise_body")
	private String treatiseBody;
	/**
     * 正文（markdown格式内容）
     */
	@TableField("markdown_content")
	private String markdownContent;
    /**
     * 创建时间
     */
	@TableField("create_time")
	private Date createTime;
    /**
     * 阅读量
     */
	@TableField("read_num")
	private Integer readNum;
    /**
     * 点赞数
     */
	@TableField("praise_num")
	private Integer praiseNum;
    /**
     * 标签
     */
	private String tags;
    /**
     * 是否推荐（1是，0否）
     */
	private Integer recommend;

	/**
	 * 删除状态（1删除，0正常）
	 */
	@TableField("del_flag")
	private Integer delFlag;


	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	public String getTreatiseTitle() {
		return treatiseTitle;
	}

	public void setTreatiseTitle(String treatiseTitle) {
		this.treatiseTitle = treatiseTitle;
	}

	public String getTreatisePreview() {
		return treatisePreview;
	}

	public void setTreatisePreview(String treatisePreview) {
		this.treatisePreview = treatisePreview;
	}

	public Integer getSource() {
		return source;
	}

	public void setSource(Integer source) {
		this.source = source;
	}

	public String getReprintFrom() {
		return reprintFrom;
	}

	public void setReprintFrom(String reprintFrom) {
		this.reprintFrom = reprintFrom;
	}

	public String getReprintUrl() {
		return reprintUrl;
	}

	public void setReprintUrl(String reprintUrl) {
		this.reprintUrl = reprintUrl;
	}

	public String getTreatiseBody() {
		return treatiseBody;
	}

	public void setTreatiseBody(String treatiseBody) {
		this.treatiseBody = treatiseBody;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Integer getReadNum() {
		return readNum;
	}

	public void setReadNum(Integer readNum) {
		this.readNum = readNum;
	}

	public Integer getPraiseNum() {
		return praiseNum;
	}

	public void setPraiseNum(Integer praiseNum) {
		this.praiseNum = praiseNum;
	}

	public String getTags() {
		return tags;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}

	public Integer getRecommend() {
		return recommend;
	}

	public void setRecommend(Integer recommend) {
		this.recommend = recommend;
	}

	@Override
	protected Serializable pkVal() {
		return this.uuid;
	}

	public Integer getDelFlag() {
		return delFlag;
	}

	public void setDelFlag(Integer delFlag) {
		this.delFlag = delFlag;
	}

	public String getMarkdownContent() {
		return markdownContent;
	}

	public void setMarkdownContent(String markdownContent) {
		this.markdownContent = markdownContent;
	}
}
