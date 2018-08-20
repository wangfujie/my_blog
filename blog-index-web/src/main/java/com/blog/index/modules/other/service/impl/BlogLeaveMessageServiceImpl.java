package com.blog.index.modules.other.service.impl;

import com.blog.pojo.entity.BlogLeaveMessage;
import com.blog.index.modules.other.mapper.BlogLeaveMessageMapper;
import com.blog.index.modules.other.service.IBlogLeaveMessageService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author wangfj
 * @date 2018-08-16
 * @description 留言表 服务接口实现类
 */
@Service
@Transactional
public class BlogLeaveMessageServiceImpl extends ServiceImpl<BlogLeaveMessageMapper, BlogLeaveMessage> implements IBlogLeaveMessageService {

}