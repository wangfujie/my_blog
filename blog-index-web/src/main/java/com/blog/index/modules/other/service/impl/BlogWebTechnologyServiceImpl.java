package com.blog.index.modules.other.service.impl;

import com.blog.pojo.entity.BlogWebTechnology;
import com.blog.index.modules.other.mapper.BlogWebTechnologyMapper;
import com.blog.index.modules.other.service.IBlogWebTechnologyService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author wangfj
 * @date 2018-08-16
 * @description 关于网站使用的技术 服务接口实现类
 */
@Service
@Transactional
public class BlogWebTechnologyServiceImpl extends ServiceImpl<BlogWebTechnologyMapper, BlogWebTechnology> implements IBlogWebTechnologyService {

}