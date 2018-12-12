package com.blog.manage.modules.resource.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.blog.manage.modules.resource.vo.ResourceInfoVo;
import com.blog.pojo.entity.BlogResourceInfo;
import com.baomidou.mybatisplus.service.IService;

/**
 * @author wangfj
 * @date 2018-12-11
 * @description 资源分享信息表 服务接口
 */
public interface IBlogResourceInfoService extends IService<BlogResourceInfo> {

    /**
     * 分页查询资源列表
     * @param page
     * @return
     */
    Page selectPageInfo(Page<ResourceInfoVo> page);

    /**
     * 查询资源详情
     */
    ResourceInfoVo getResourceInfoVoById(Integer id);
}