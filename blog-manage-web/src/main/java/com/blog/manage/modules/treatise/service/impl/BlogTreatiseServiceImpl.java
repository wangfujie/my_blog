package com.blog.manage.modules.treatise.service.impl;

import com.blog.manage.modules.treatise.mapper.BlogTreatiseMapper;
import com.blog.manage.modules.treatise.service.IBlogTreatiseService;
import com.blog.pojo.entity.BlogTreatise;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author wangfj
 * @date 2018-09-10
 * @description 文章详情表 服务接口实现类
 */
@Service
@Transactional
public class BlogTreatiseServiceImpl extends ServiceImpl<BlogTreatiseMapper, BlogTreatise> implements IBlogTreatiseService {

}