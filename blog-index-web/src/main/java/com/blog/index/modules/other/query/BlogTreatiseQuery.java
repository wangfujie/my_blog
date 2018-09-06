package com.blog.index.modules.other.query;

import com.blog.common.query.BaseQuery;

/**
 * @author wangfujie
 * @date 2018-09-05 14:47
 * @description 文章列表查询类
 */
public class BlogTreatiseQuery extends BaseQuery {
    /**
     * 关键词
     */
    private String keyWord;

    /**
     * 标签名
     */
    private String tagInfo;

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

    public String getTagInfo() {
        return tagInfo;
    }

    public void setTagInfo(String tagInfo) {
        this.tagInfo = tagInfo;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }
}
