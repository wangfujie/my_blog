package com.blog.manage.modules.treatise.query;

import com.blog.manage.common.result.LayPageQuery;

/**
 * @author wangfujie
 * @date 2018-09-13 16:48
 * @description 文章查询参数封装
 */
public class BlogTreatiseQuery extends LayPageQuery {
    /**
     * 关键词
     */
    private String keyWord;

    /**
     * 分类ID
     */
    private String categoryId;

    public String getKeyWord() {
        return keyWord;
    }

    public void setKeyWord(String keyWord) {
        this.keyWord = keyWord;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }
}
