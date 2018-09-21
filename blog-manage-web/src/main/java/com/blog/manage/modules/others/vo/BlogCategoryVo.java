package com.blog.manage.modules.others.vo;

import com.blog.pojo.entity.BlogCategory;

/**
 * @author wangfujie
 * @date 2018-09-21 15:06
 * @description 分类封装
 */
public class BlogCategoryVo extends BlogCategory {

    /**
     * 启用状态
     */
    private String statusName;

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }
}
