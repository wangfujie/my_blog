package com.blog.index.modules.other.service;

import com.blog.index.modules.other.vo.BlogMenuNode;
import com.blog.pojo.entity.BlogCategory;
import com.baomidou.mybatisplus.service.IService;

import java.util.List;

/**
 * @author wangfj
 * @date 2018-08-16
 * @description 博客类型表 服务接口
 */
public interface IBlogCategoryService extends IService<BlogCategory> {

    /**
     * 获取菜单分类列表
     * @return
     */
    List<BlogMenuNode> getBlogMenuNode();
}