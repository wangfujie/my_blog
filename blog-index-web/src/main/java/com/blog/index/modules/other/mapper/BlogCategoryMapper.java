package com.blog.index.modules.other.mapper;

import com.blog.index.modules.other.vo.BlogMenuNode;
import com.blog.pojo.entity.BlogCategory;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author wangfj
 * @date 2018-08-16
 * @description 博客类型表 Mapper 接口
 */
@Mapper
public interface BlogCategoryMapper extends BaseMapper<BlogCategory> {

    /**
     * 获取菜单分类列表
     * @return
     */
    List<BlogMenuNode> getBlogMenuNode();

    /**
     * 通过fid获取菜单列表
     * @return
     */
    List<BlogCategory> getBlogCategoryByFid(Integer fId);
}