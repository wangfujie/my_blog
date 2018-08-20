package com.blog.index.modules.other.service.impl;

import com.blog.pojo.entity.BlogTags;
import com.blog.index.modules.other.mapper.BlogTagsMapper;
import com.blog.index.modules.other.service.IBlogTagsService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author wangfj
 * @date 2018-08-20
 * @description 标签表 服务接口实现类
 */
@Service
@Transactional
public class BlogTagsServiceImpl extends ServiceImpl<BlogTagsMapper, BlogTags> implements IBlogTagsService {

}