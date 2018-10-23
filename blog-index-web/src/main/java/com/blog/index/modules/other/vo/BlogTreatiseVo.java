package com.blog.index.modules.other.vo;

import com.baomidou.mybatisplus.annotations.TableField;
import com.blog.pojo.entity.BlogTreatise;

/**
 * @author wangfujie
 * @date 2018-08-21 16:01
 * @description 文章封装类
 */
public class BlogTreatiseVo extends BlogTreatise {
    /**
     * 分类父id
     */
    @TableField("f_id")
    private String fId;
    /**
     * 分类名称
     */
    @TableField("category_name")
    private String categoryName;
    /**
     * 由来
     */
    private String sourceName;
    /**
     * 是否推荐
     */
    private String recommendName;

    /**
     * 上一篇
     */
    private BlogTreatise upBlogTreatise;
    /**
     * 下一篇
     */
    private BlogTreatise downBlogTreatise;

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getSourceName() {
        return sourceName;
    }

    public void setSourceName(String sourceName) {
        this.sourceName = sourceName;
    }

    public String getRecommendName() {
        return recommendName;
    }

    public void setRecommendName(String recommendName) {
        this.recommendName = recommendName;
    }

    public BlogTreatise getUpBlogTreatise() {
        return upBlogTreatise;
    }

    public void setUpBlogTreatise(BlogTreatise upBlogTreatise) {
        this.upBlogTreatise = upBlogTreatise;
    }

    public BlogTreatise getDownBlogTreatise() {
        return downBlogTreatise;
    }

    public void setDownBlogTreatise(BlogTreatise downBlogTreatise) {
        this.downBlogTreatise = downBlogTreatise;
    }

    public String getfId() {
        return fId;
    }

    public void setfId(String fId) {
        this.fId = fId;
    }
}
