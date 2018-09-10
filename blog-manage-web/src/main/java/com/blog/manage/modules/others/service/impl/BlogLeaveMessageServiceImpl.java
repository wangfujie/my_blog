package com.blog.manage.modules.others.service.impl;

import com.blog.pojo.entity.BlogLeaveMessage;
import com.blog.manage.modules.others.mapper.BlogLeaveMessageMapper;
import com.blog.manage.modules.others.service.IBlogLeaveMessageService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author wangfj
 * @date 2018-09-10
 * @description 留言表 服务接口实现类
 */
@Service
@Transactional
public class BlogLeaveMessageServiceImpl extends ServiceImpl<BlogLeaveMessageMapper, BlogLeaveMessage> implements IBlogLeaveMessageService {

}