package com.blog.index.modules.record.service;

import com.baomidou.mybatisplus.service.IService;
import com.blog.common.result.R;
import com.blog.pojo.entity.BlogLogRecord;
import javax.servlet.http.HttpServletRequest;

/**
 * @author wangfj
 * @date 2018-10-25
 * @description 日志记录 服务接口
 */
public interface IBlogLogRecordService extends IService<BlogLogRecord> {

    /**
     * 增加日志记录信息
     * @param blogLogRecord
     * @param request
     * @return
     */
    R addBlogLogRecord(BlogLogRecord blogLogRecord, HttpServletRequest request);
}