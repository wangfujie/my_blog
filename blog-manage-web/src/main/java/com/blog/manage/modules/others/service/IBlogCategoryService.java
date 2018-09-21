package com.blog.manage.modules.others.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.blog.manage.modules.others.vo.BlogCategoryVo;
import com.blog.pojo.entity.BlogCategory;
import com.baomidou.mybatisplus.service.IService;

/**
 * @author wangfj
 * @date 2018-09-10
 * @description 博客类型表 服务接口
 */
public interface IBlogCategoryService extends IService<BlogCategory> {

    /**
     * 分页查询分类
     * @param page
     * @return
     */
    Page<BlogCategoryVo> getBlogCategoryPage(Page<BlogCategoryVo> page);
}