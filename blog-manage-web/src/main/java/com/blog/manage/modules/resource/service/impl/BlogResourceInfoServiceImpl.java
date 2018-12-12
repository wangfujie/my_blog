package com.blog.manage.modules.resource.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.blog.manage.modules.resource.vo.ResourceInfoVo;
import com.blog.pojo.entity.BlogResourceInfo;
import com.blog.manage.modules.resource.mapper.BlogResourceInfoMapper;
import com.blog.manage.modules.resource.service.IBlogResourceInfoService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author wangfj
 * @date 2018-12-11
 * @description 资源分享信息表 服务接口实现类
 */
@Service
@Transactional
public class BlogResourceInfoServiceImpl extends ServiceImpl<BlogResourceInfoMapper, BlogResourceInfo> implements IBlogResourceInfoService {

    @Autowired
    private BlogResourceInfoMapper resourceInfoMapper;

    /**
     * 分页查询资源列表
     *
     * @param page
     * @return
     */
    @Override
    public Page selectPageInfo(Page<ResourceInfoVo> page) {
        page.setRecords(resourceInfoMapper.selectListInfo(page));
        return page;
    }

    /**
     * 查询资源详情
     *
     * @param id
     */
    @Override
    public ResourceInfoVo getResourceInfoVoById(Integer id) {
        return resourceInfoMapper.getResourceInfoVoById(id);
    }
}