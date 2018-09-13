package com.blog.common.query;

import com.blog.common.constant.SystemConst;

/**
 * @author wangfujie
 * @date 2018-08-10 9:38
 * @description 分页查询参数封装
 */
public class BaseQuery {
    /**
     * 当前页:默认值1
     */
    private int currentPage = 1;
    /**
     * 每页条数:默认值10
     */
    private int pageSize = SystemConst.DEFAULT_PAGE_SIZE;

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        if(pageSize > SystemConst.MAX_PAGE_SIZE){
            pageSize = SystemConst.MAX_PAGE_SIZE;
        }
        this.pageSize = pageSize;
    }
}
