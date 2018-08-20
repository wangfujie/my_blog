package com.blog.index.modules.other.service.impl;

import com.blog.pojo.entity.BlogTreatise;
import com.blog.index.modules.other.mapper.BlogTreatiseMapper;
import com.blog.index.modules.other.service.IBlogTreatiseService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author wangfj
 * @date 2018-08-16
 * @description 文章详情表 服务接口实现类
 */
@Service
@Transactional
public class BlogTreatiseServiceImpl extends ServiceImpl<BlogTreatiseMapper, BlogTreatise> implements IBlogTreatiseService {

}