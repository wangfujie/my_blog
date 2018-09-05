package com.blog.index.modules.other.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.blog.index.modules.other.query.BlogTreatiseQuery;
import com.blog.index.modules.other.vo.BlogTreatiseVo;
import com.blog.pojo.entity.BlogTreatise;
import com.blog.index.modules.other.mapper.BlogTreatiseMapper;
import com.blog.index.modules.other.service.IBlogTreatiseService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private BlogTreatiseMapper treatiseMapper;

    /**
     * 通过id查询详情
     *
     * @param uuid
     * @return
     */
    @Override
    public BlogTreatiseVo getBlogTreatiseVoById(String uuid) {
        return treatiseMapper.getBlogTreatiseVoById(uuid);
    }

    /**
     * 查询文章分页列表
     *
     * @param page
     * @param treatiseQuery
     * @return
     */
    @Override
    public Page<BlogTreatiseVo> getTreatisePage(Page<BlogTreatiseVo> page, BlogTreatiseQuery treatiseQuery) {
        page.setRecords(treatiseMapper.getTreatiseList(page, treatiseQuery));
        return page;
    }
}