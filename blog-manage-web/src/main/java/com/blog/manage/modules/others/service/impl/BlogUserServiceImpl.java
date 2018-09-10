package com.blog.manage.modules.others.service.impl;

import com.blog.pojo.entity.BlogUser;
import com.blog.manage.modules.others.mapper.BlogUserMapper;
import com.blog.manage.modules.others.service.IBlogUserService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author wangfj
 * @date 2018-09-10
 * @description 用户表 服务接口实现类
 */
@Service
@Transactional
public class BlogUserServiceImpl extends ServiceImpl<BlogUserMapper, BlogUser> implements IBlogUserService {

}