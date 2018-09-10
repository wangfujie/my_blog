package com.blog.manage.modules.others.service.impl;

import com.blog.manage.modules.others.mapper.BlogAboutMeMapper;
import com.blog.manage.modules.others.service.IBlogAboutMeService;
import com.blog.pojo.entity.BlogAboutMe;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author wangfj
 * @date 2018-09-10
 * @description 关于我 服务接口实现类
 */
@Service
@Transactional
public class BlogAboutMeServiceImpl extends ServiceImpl<BlogAboutMeMapper, BlogAboutMe> implements IBlogAboutMeService {

}