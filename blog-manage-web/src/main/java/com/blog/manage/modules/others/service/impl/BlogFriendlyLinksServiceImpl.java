package com.blog.manage.modules.others.service.impl;

import com.blog.pojo.entity.BlogFriendlyLinks;
import com.blog.manage.modules.others.mapper.BlogFriendlyLinksMapper;
import com.blog.manage.modules.others.service.IBlogFriendlyLinksService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author wangfj
 * @date 2018-09-10
 * @description 友情链接 服务接口实现类
 */
@Service
@Transactional
public class BlogFriendlyLinksServiceImpl extends ServiceImpl<BlogFriendlyLinksMapper, BlogFriendlyLinks> implements IBlogFriendlyLinksService {

}