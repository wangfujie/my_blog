package com.blog.manage.modules.treatise.query;

import com.blog.common.constant.SystemConst;

/**
 * @author wangfujie
 * @date 2018-09-13 16:48
 * @description 文章查询参数封装
 */
public class BlogTreatiseQuery {
    /**
     * 当前页:默认值1
     */
    private int page = 1;
    /**
     * 每页条数:默认值10
     */
    private int limit = SystemConst.DEFAULT_PAGE_SIZE;

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

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        if(limit > SystemConst.MAX_PAGE_SIZE){
            limit = SystemConst.MAX_PAGE_SIZE;
        }
        this.limit = limit;
    }
}
