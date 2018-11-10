package com.blog.manage.modules.record.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.blog.manage.modules.record.mapper.BlogLogRecordMapper;
import com.blog.manage.modules.record.service.IBlogLogRecordService;
import com.blog.manage.modules.record.vo.LogRecordVo;
import com.blog.pojo.entity.BlogLogRecord;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author wangfj
 * @date 2018-10-25
 * @description 日志记录 服务接口实现类
 */
@Service
@Transactional
public class BlogLogRecordServiceImpl extends ServiceImpl<BlogLogRecordMapper, BlogLogRecord> implements IBlogLogRecordService {

    @Autowired
    private BlogLogRecordMapper logRecordMapper;

    @Override
    public Page<LogRecordVo> getLogRecordVoPage(Page<LogRecordVo> page) {
        page.setRecords(logRecordMapper.getLogRecordList(page));
        return page;
    }
}