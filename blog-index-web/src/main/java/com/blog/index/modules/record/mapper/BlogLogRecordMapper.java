package com.blog.index.modules.record.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.blog.pojo.entity.BlogLogRecord;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author wangfj
 * @date 2018-10-25
 * @description 日志记录 Mapper 接口
 */
@Mapper
public interface BlogLogRecordMapper extends BaseMapper<BlogLogRecord> {

}