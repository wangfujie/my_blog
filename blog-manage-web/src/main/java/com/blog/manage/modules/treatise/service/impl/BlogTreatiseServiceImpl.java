package com.blog.manage.modules.treatise.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.blog.manage.modules.treatise.mapper.BlogTreatiseMapper;
import com.blog.manage.modules.treatise.query.BlogTreatiseQuery;
import com.blog.manage.modules.treatise.service.IBlogTreatiseService;
import com.blog.manage.modules.treatise.vo.BlogTreatiseVo;
import com.blog.pojo.entity.BlogTreatise;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private BlogTreatiseMapper treatiseMapper;

    /**
     * 查询文章分页列表
     */
    @Override
    public Page<BlogTreatiseVo> getTreatisePage(Page<BlogTreatiseVo> page, BlogTreatiseQuery treatiseQuery) {
        page.setRecords(treatiseMapper.getTreatiseList(page, treatiseQuery));
        return page;
    }

    /**
     * 查询文章详情
     *
     * @param uuid
     * @return
     */
    @Override
    public BlogTreatiseVo getTreatiseVoById(String uuid) {
        return treatiseMapper.getTreatiseVoById(uuid);
    }
}