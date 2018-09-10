package com.blog.manage.modules.others.service.impl;

import com.blog.pojo.entity.BlogWebInfo;
import com.blog.manage.modules.others.mapper.BlogWebInfoMapper;
import com.blog.manage.modules.others.service.IBlogWebInfoService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author wangfj
 * @date 2018-09-10
 * @description 网站的一些统计数据 服务接口实现类
 */
@Service
@Transactional
public class BlogWebInfoServiceImpl extends ServiceImpl<BlogWebInfoMapper, BlogWebInfo> implements IBlogWebInfoService {

}