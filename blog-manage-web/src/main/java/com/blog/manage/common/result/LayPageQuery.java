package com.blog.manage.common.result;

import com.blog.common.constant.SystemConst;

/**
 * @author wangfujie
 * @date 2018-09-21 14:48
 * @description 适配layui分页查询参数封装
 */
public class LayPageQuery {
    /**
     * 当前页:默认值1
     */
    private int page = 1;
    /**
     * 每页条数:默认值10
     */
    private int limit = SystemConst.DEFAULT_PAGE_SIZE;

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
