package com.blog.index.modules.other.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.blog.index.modules.other.query.BlogTreatiseQuery;
import com.blog.index.modules.other.vo.BlogTreatiseVo;
import com.blog.pojo.entity.BlogTreatise;
import com.baomidou.mybatisplus.service.IService;

/**
 * @author wangfj
 * @date 2018-08-16
 * @description 文章详情表 服务接口
 */
public interface IBlogTreatiseService extends IService<BlogTreatise> {

    /**
     * 通过id查询详情
     * @param uuid
     * @return
     */
    BlogTreatiseVo getBlogTreatiseVoById(String uuid);

    /**
     * 查询文章分页列表
     * @param page
     * @param treatiseQuery
     * @return
     */
    Page<BlogTreatiseVo> getTreatisePage(Page<BlogTreatiseVo> page, BlogTreatiseQuery treatiseQuery);
}