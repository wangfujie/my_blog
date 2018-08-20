package com.blog.index.modules.other.service.impl;

import com.blog.pojo.entity.BlogAboutMe;
import com.blog.index.modules.other.mapper.BlogAboutMeMapper;
import com.blog.index.modules.other.service.IBlogAboutMeService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author wangfj
 * @date 2018-08-16
 * @description 关于我 服务接口实现类
 */
@Service
@Transactional
public class BlogAboutMeServiceImpl extends ServiceImpl<BlogAboutMeMapper, BlogAboutMe> implements IBlogAboutMeService {

}