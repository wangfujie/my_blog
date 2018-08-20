package com.blog.index.modules.other.service.impl;

import com.blog.pojo.entity.BlogWebInfo;
import com.blog.index.modules.other.mapper.BlogWebInfoMapper;
import com.blog.index.modules.other.service.IBlogWebInfoService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author wangfj
 * @date 2018-08-16
 * @description 网站的一些统计数据 服务接口实现类
 */
@Service
@Transactional
public class BlogWebInfoServiceImpl extends ServiceImpl<BlogWebInfoMapper, BlogWebInfo> implements IBlogWebInfoService {

}