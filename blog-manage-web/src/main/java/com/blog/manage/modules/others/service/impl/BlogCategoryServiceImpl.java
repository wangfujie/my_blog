package com.blog.manage.modules.others.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.blog.manage.modules.others.vo.BlogCategoryVo;
import com.blog.pojo.entity.BlogCategory;
import com.blog.manage.modules.others.mapper.BlogCategoryMapper;
import com.blog.manage.modules.others.service.IBlogCategoryService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author wangfj
 * @date 2018-09-10
 * @description 博客类型表 服务接口实现类
 */
@Service
@Transactional
public class BlogCategoryServiceImpl extends ServiceImpl<BlogCategoryMapper, BlogCategory> implements IBlogCategoryService {

    @Autowired
    private BlogCategoryMapper categoryMapper;

    /**
     * 分页查询分类
     *
     * @param page
     * @return
     */
    @Override
    public Page<BlogCategoryVo> getBlogCategoryPage(Page<BlogCategoryVo> page) {
        page.setRecords(categoryMapper.getBlogCategoryList(page));
        return page;
    }
}