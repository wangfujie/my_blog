package com.blog.manage.modules.resource.service.impl;

import com.blog.pojo.entity.BlogResourceInfo;
import com.blog.manage.modules.resource.mapper.BlogResourceInfoMapper;
import com.blog.manage.modules.resource.service.IBlogResourceInfoService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author wangfj
 * @date 2018-12-11
 * @description 资源分享信息表 服务接口实现类
 */
@Service
@Transactional
public class BlogResourceInfoServiceImpl extends ServiceImpl<BlogResourceInfoMapper, BlogResourceInfo> implements IBlogResourceInfoService {

}