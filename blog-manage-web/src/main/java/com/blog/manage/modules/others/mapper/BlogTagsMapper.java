package com.blog.manage.modules.others.mapper;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.blog.manage.modules.others.vo.BlogTagsVo;
import com.blog.pojo.entity.BlogTags;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

/**
 * @author wangfj
 * @date 2018-09-10
 * @description 标签表 Mapper 接口
 */
@Mapper
public interface BlogTagsMapper extends BaseMapper<BlogTags> {

    /**
     * 获取标签表分页列表
     * @param page
     * @return
     */
    List<BlogTagsVo> getBlogTagsList(Pagination page);

    /**
     * 通过id获取标签信息
     * @param id
     * @return
     */
    BlogTagsVo getBlogTagsVoById(Integer id);
}