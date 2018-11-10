package com.blog.manage.modules.record.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.blog.manage.modules.record.vo.LogRecordVo;
import com.blog.pojo.entity.BlogLogRecord;
import com.baomidou.mybatisplus.service.IService;

/**
 * @author wangfj
 * @date 2018-10-25
 * @description 日志记录 服务接口
 */
public interface IBlogLogRecordService extends IService<BlogLogRecord> {

    /**
     * 查询日志分页
     * @param page
     * @return
     */
    Page<LogRecordVo> getLogRecordVoPage(Page<LogRecordVo> page);
	
}