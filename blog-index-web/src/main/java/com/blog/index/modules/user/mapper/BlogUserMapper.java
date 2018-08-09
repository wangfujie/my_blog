package com.blog.index.modules.user.mapper;

import com.blog.pojo.entity.BlogUser;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

/**
 * @author wangfj
 * @date 2018-08-09
 * @description  Mapper 接口
 */
@Mapper
public interface BlogUserMapper extends BaseMapper<BlogUser> {

    /**
     * 获取用户列表
     * @return
     */
    List<BlogUser> getBlogUserList();
}