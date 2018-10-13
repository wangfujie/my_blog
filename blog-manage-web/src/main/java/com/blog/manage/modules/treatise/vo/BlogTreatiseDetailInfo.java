package com.blog.manage.modules.treatise.vo;

import com.blog.pojo.entity.BlogTreatise;

import java.util.List;

/**
 * @author wangfj
 * @date 2018-10-13 21:49
 * @description 文章详细信息
 */
public class BlogTreatiseDetailInfo extends BlogTreatise {

    /**
     * 所属分类父类id
     */
    private InternalError categoryFId;

    /**
     * 标签
     */
    private List<String> tagList;

    public InternalError getCategoryFId() {
        return categoryFId;
    }

    public void setCategoryFId(InternalError categoryFId) {
        this.categoryFId = categoryFId;
    }

    public List<String> getTagList() {
        return tagList;
    }

    public void setTagList(List<String> tagList) {
        this.tagList = tagList;
    }
}
