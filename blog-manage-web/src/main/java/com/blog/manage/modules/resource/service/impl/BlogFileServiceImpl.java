package com.blog.manage.modules.resource.service.impl;

import com.blog.pojo.entity.BlogFile;
import com.blog.manage.modules.resource.mapper.BlogFileMapper;
import com.blog.manage.modules.resource.service.IBlogFileService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author wangfj
 * @date 2018-12-11
 * @description 文件信息表 服务接口实现类
 */
@Service
@Transactional
public class BlogFileServiceImpl extends ServiceImpl<BlogFileMapper, BlogFile> implements IBlogFileService {

}