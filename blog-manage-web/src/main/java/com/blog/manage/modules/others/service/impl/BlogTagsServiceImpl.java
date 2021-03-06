package com.blog.manage.modules.others.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.blog.manage.modules.others.vo.BlogTagsVo;
import com.blog.pojo.entity.BlogTags;
import com.blog.manage.modules.others.mapper.BlogTagsMapper;
import com.blog.manage.modules.others.service.IBlogTagsService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wangfj
 * @date 2018-09-10
 * @description 标签表 服务接口实现类
 */
@Service
@Transactional
public class BlogTagsServiceImpl extends ServiceImpl<BlogTagsMapper, BlogTags> implements IBlogTagsService {

    @Autowired
    private BlogTagsMapper blogTagsMapper;

    /**
     * 获取标签表分页列表
     *
     * @param page
     * @return
     */
    @Override
    public Page<BlogTagsVo> getBlogTagsPage(Page<BlogTagsVo> page) {
        page.setRecords(blogTagsMapper.getBlogTagsList(page));
        return page;
    }

    /**
     * 通过id获取标签信息
     *
     * @param id
     * @return
     */
    @Override
    public BlogTagsVo getBlogTagsVoById(Integer id) {
        return blogTagsMapper.getBlogTagsVoById(id);
    }

    @Override
    public void addTagsUseNum(String tags) {
        String[] tagArr = tags.split(",");
        List<BlogTags> updateTags = new ArrayList<>(tagArr.length);
        for (String tag : tagArr){
            BlogTags blogTag = selectOne(new EntityWrapper<BlogTags>().eq("tag_name" , tag));
            if (blogTag != null){
                blogTag.setUseNum(blogTag.getUseNum() + 1);
                updateTags.add(blogTag);
            }
        }
        updateBatchById(updateTags);
    }
}