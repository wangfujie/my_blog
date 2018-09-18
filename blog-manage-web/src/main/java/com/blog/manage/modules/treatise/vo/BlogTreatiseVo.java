package com.blog.manage.modules.treatise.vo;

import com.baomidou.mybatisplus.annotations.TableField;
import com.blog.pojo.entity.BlogTreatise;

/**
 * @author wangfujie
 * @date 2018-09-13 16:48
 * @description 文章封装类
 */
public class BlogTreatiseVo extends BlogTreatise {
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
}