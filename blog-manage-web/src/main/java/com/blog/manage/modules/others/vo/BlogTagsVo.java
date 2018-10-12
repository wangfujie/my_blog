package com.blog.manage.modules.others.vo;

import com.blog.pojo.entity.BlogTags;

/**
 * @author wangfujie
 * @date 2018-10-12 10:26
 * @description 标签
 */
public class BlogTagsVo extends BlogTags {

    /**
     * 类型名称
     */
    private String categoryName;

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}
