package com.blog.index.modules.user.service.impl;

import com.blog.pojo.entity.BlogUser;
import com.blog.index.modules.user.mapper.BlogUserMapper;
import com.blog.index.modules.user.service.IBlogUserService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

/**
 * @author wangfj
 * @date 2018-08-09
 * @description  服务接口实现类
 */
@Service
@Transactional
public class BlogUserServiceImpl extends ServiceImpl<BlogUserMapper, BlogUser> implements IBlogUserService {

    @Autowired
    private BlogUserMapper blogUserMapper;

    /**
     * 获取用户列表
     *
     * @return
     */
    @Override
    public List<BlogUser> getBlogUserList() {
        return blogUserMapper.getBlogUserList();
    }
}