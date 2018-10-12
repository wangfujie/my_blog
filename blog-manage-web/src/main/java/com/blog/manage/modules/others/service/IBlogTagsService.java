package com.blog.manage.modules.others.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.blog.manage.modules.others.vo.BlogTagsVo;
import com.blog.pojo.entity.BlogTags;
import com.baomidou.mybatisplus.service.IService;

/**
 * @author wangfj
 * @date 2018-09-10
 * @description 标签表 服务接口
 */
public interface IBlogTagsService extends IService<BlogTags> {

    /**
     * 获取标签表分页列表
     * @param page
     * @return
     */
    Page<BlogTagsVo> getBlogTagsPage(Page<BlogTagsVo> page);
}