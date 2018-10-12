package com.blog.manage.modules.others.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.blog.manage.modules.others.vo.BlogTagsVo;
import com.blog.pojo.entity.BlogTags;
import com.blog.manage.modules.others.mapper.BlogTagsMapper;
import com.blog.manage.modules.others.service.IBlogTagsService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author wangfj
 * @date 2018-09-10
 * @description 标签表 服务接口实现类
 */
@Service
@Transactional
public class BlogTagsServiceImpl extends ServiceImpl<BlogTagsMapper, BlogTags> implements IBlogTagsService {

    @Autowired
    private BlogTagsMapper blogTagsMapper;

    /**
     * 获取标签表分页列表
     *
     * @param page
     * @return
     */
    @Override
    public Page<BlogTagsVo> getBlogTagsPage(Page<BlogTagsVo> page) {
        page.setRecords(blogTagsMapper.getBlogTagsList(page));
        return page;
    }
}