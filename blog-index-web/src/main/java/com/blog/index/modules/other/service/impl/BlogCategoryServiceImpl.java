package com.blog.index.modules.other.service.impl;

import com.blog.pojo.entity.BlogCategory;
import com.blog.index.modules.other.mapper.BlogCategoryMapper;
import com.blog.index.modules.other.service.IBlogCategoryService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author wangfj
 * @date 2018-08-16
 * @description 博客类型表 服务接口实现类
 */
@Service
@Transactional
public class BlogCategoryServiceImpl extends ServiceImpl<BlogCategoryMapper, BlogCategory> implements IBlogCategoryService {

}