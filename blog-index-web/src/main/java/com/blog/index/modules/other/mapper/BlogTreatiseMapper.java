package com.blog.index.modules.other.mapper;

import com.blog.index.modules.other.vo.BlogTreatiseVo;
import com.blog.pojo.entity.BlogTreatise;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author wangfj
 * @date 2018-08-16
 * @description 文章详情表 Mapper 接口
 */
@Mapper
public interface BlogTreatiseMapper extends BaseMapper<BlogTreatise> {

    /**
     * 通过id查询详情
     * @param uuid
     * @return
     */
    BlogTreatiseVo getBlogTreatiseVoById(String uuid);
}