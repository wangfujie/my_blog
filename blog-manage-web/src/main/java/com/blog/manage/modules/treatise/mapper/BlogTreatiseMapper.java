package com.blog.manage.modules.treatise.mapper;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.blog.manage.modules.treatise.query.BlogTreatiseQuery;
import com.blog.manage.modules.treatise.vo.BlogTreatiseVo;
import com.blog.pojo.entity.BlogTreatise;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

/**
 * @author wangfj
 * @date 2018-09-10
 * @description 文章详情表 Mapper 接口
 */
@Mapper
public interface BlogTreatiseMapper extends BaseMapper<BlogTreatise> {

    /**
     * 查询文章分页列表
     * @param page
     * @param treatiseQuery
     * @return
     */
    List<BlogTreatiseVo> getTreatiseList(Pagination page, BlogTreatiseQuery treatiseQuery);

    /**
     * 查询文章详情
     * @param uuid
     * @return
     */
    BlogTreatiseVo getTreatiseVoById(String uuid);
}