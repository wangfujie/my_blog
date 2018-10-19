package com.blog.manage.modules.treatise.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.blog.manage.modules.treatise.query.BlogTreatiseQuery;
import com.blog.manage.modules.treatise.vo.BlogTreatiseVo;
import com.blog.pojo.entity.BlogTreatise;
import com.baomidou.mybatisplus.service.IService;

/**
 * @author wangfj
 * @date 2018-09-10
 * @description 文章详情表 服务接口
 */
public interface IBlogTreatiseService extends IService<BlogTreatise> {

    /**
     * 查询文章分页列表
     * @param page
     * @param treatiseQuery
     * @return
     */
    Page<BlogTreatiseVo> getTreatisePage(Page<BlogTreatiseVo> page, BlogTreatiseQuery treatiseQuery);

    /**
     * 查询文章详情
     * @param uuid
     * @return
     */
    BlogTreatiseVo getTreatiseVoById(String uuid);
}