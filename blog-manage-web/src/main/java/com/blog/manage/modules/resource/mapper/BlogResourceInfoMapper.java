package com.blog.manage.modules.resource.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.blog.manage.modules.resource.vo.ResourceInfoVo;
import com.blog.pojo.entity.BlogResourceInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author wangfj
 * @date 2018-12-11
 * @description 资源分享信息表 Mapper 接口
 */
@Mapper
public interface BlogResourceInfoMapper extends BaseMapper<BlogResourceInfo> {

    /**
     * 查询资源列表
     * @param page
     * @return
     */
    List<ResourceInfoVo> selectListInfo(Pagination page);

    /**
     * 查询资源详情
     * @param id
     * @return
     */
    ResourceInfoVo getResourceInfoVoById(@Param("id") Integer id);
}