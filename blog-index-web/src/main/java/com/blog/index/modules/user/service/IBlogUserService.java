package com.blog.index.modules.user.service;

import com.blog.pojo.entity.BlogUser;
import com.baomidou.mybatisplus.service.IService;
import java.util.List;

/**
 * @author wangfj
 * @date 2018-08-09
 * @description  服务接口
 */
public interface IBlogUserService extends IService<BlogUser> {

    /**
     * 获取用户列表
     * @return
     */
    List<BlogUser> getBlogUserList();
}