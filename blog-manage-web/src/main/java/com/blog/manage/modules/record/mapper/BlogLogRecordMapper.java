package com.blog.manage.modules.record.mapper;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.blog.manage.modules.record.vo.LogRecordVo;
import com.blog.pojo.entity.BlogLogRecord;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author wangfj
 * @date 2018-10-25
 * @description 日志记录 Mapper 接口
 */
@Mapper
public interface BlogLogRecordMapper extends BaseMapper<BlogLogRecord> {

    /**
     * 查询日志
     * @param page
     * @return
     */
    List<LogRecordVo> getLogRecordList(Pagination page);
}