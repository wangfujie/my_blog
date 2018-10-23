package com.blog.index.modules.other.mapper;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.blog.index.modules.other.query.BlogTreatiseQuery;
import com.blog.index.modules.other.vo.BlogTreatiseVo;
import com.blog.pojo.entity.BlogTreatise;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author wangfj
 * @date 2018-08-16
 * @description 文章详情表 Mapper 接口
 */
@Mapper
public interface BlogTreatiseMapper extends BaseMapper<BlogTreatise> {

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
    List<BlogTreatiseVo> getTreatiseList(Pagination page, BlogTreatiseQuery treatiseQuery);

    /**
     * 获取上篇文章
     * @param uuid
     * @return
     */
    BlogTreatise getUpBlogTreatise(String uuid);

    /**
     * 获取下篇文章
     * @param uuid
     * @return
     */
    BlogTreatise getDownBlogTreatise(String uuid);
}