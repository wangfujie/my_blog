package com.blog.manage.modules.admin.service.impl;

import com.blog.manage.modules.admin.mapper.BlogAdminMapper;
import com.blog.manage.modules.admin.service.IBlogAdminService;
import com.blog.pojo.entity.BlogAdmin;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author wangfj
 * @date 2018-09-10
 * @description  服务接口实现类
 */
@Service
@Transactional
public class BlogAdminServiceImpl extends ServiceImpl<BlogAdminMapper, BlogAdmin> implements IBlogAdminService {

}