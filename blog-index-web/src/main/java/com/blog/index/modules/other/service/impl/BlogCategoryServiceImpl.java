package com.blog.index.modules.other.service.impl;

import com.blog.index.modules.other.vo.BlogMenuNode;
import com.blog.pojo.entity.BlogCategory;
import com.blog.index.modules.other.mapper.BlogCategoryMapper;
import com.blog.index.modules.other.service.IBlogCategoryService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

/**
 * @author wangfj
 * @date 2018-08-16
 * @description 博客类型表 服务接口实现类
 */
@Service
@Transactional
public class BlogCategoryServiceImpl extends ServiceImpl<BlogCategoryMapper, BlogCategory> implements IBlogCategoryService {

    @Autowired
    private BlogCategoryMapper categoryMapper;

    /**
     * 获取菜单分类列表
     *
     * @return
     */
    @Override
    public List<BlogMenuNode> getBlogMenuNode() {
        return categoryMapper.getBlogMenuNode();
    }
}