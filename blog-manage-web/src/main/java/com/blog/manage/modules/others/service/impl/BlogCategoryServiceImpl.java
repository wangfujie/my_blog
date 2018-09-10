package com.blog.manage.modules.others.service.impl;

import com.blog.pojo.entity.BlogCategory;
import com.blog.manage.modules.others.mapper.BlogCategoryMapper;
import com.blog.manage.modules.others.service.IBlogCategoryService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
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

}