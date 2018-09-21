package com.blog.manage.modules.others.mapper;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.blog.manage.modules.others.vo.BlogCategoryVo;
import com.blog.pojo.entity.BlogCategory;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

/**
 * @author wangfj
 * @date 2018-09-10
 * @description 博客类型表 Mapper 接口
 */
@Mapper
public interface BlogCategoryMapper extends BaseMapper<BlogCategory> {

    /**
     * 查询
     * @param page
     * @return
     */
    List<BlogCategoryVo> getBlogCategoryList(Pagination page);
}