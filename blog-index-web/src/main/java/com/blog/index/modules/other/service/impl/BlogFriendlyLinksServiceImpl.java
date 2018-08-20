package com.blog.index.modules.other.service.impl;

import com.blog.pojo.entity.BlogFriendlyLinks;
import com.blog.index.modules.other.mapper.BlogFriendlyLinksMapper;
import com.blog.index.modules.other.service.IBlogFriendlyLinksService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author wangfj
 * @date 2018-08-20
 * @description  服务接口实现类
 */
@Service
@Transactional
public class BlogFriendlyLinksServiceImpl extends ServiceImpl<BlogFriendlyLinksMapper, BlogFriendlyLinks> implements IBlogFriendlyLinksService {

}