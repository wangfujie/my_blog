package com.blog.index.modules.other.vo;

import com.baomidou.mybatisplus.annotations.TableField;
import com.blog.pojo.entity.BlogTreatise;

/**
 * @author wangfujie
 * @date 2018-08-21 16:01
 * @description 文章封装类
 */
public class BlogTreatiseVo extends BlogTreatise {

    /**
     * 分类名称
     */
    @TableField("category_name")
    private String categoryName;

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}
