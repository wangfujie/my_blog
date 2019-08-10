package com.blog.manage.modules.treatise.vo;

import com.baomidou.mybatisplus.annotations.TableField;
import com.blog.pojo.entity.BlogTreatise;
import lombok.Data;

/**
 * @author wangfujie
 * @date 2018-09-13 16:48
 * @description 文章封装类
 */
@Data
public class BlogTreatiseVo extends BlogTreatise {
    /**
     * 分类名称
     */
    @TableField("category_name")
    private String categoryName;
    /**
     * 由来
     */
    private String sourceName;
    /**
     * 是否推荐
     */
    private String recommendName;

    /**
     * 是否收录
     */
    private String bdIncludedName;

}
