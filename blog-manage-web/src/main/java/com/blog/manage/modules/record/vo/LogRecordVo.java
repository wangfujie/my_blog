package com.blog.manage.modules.record.vo;

import com.blog.pojo.entity.BlogLogRecord;

/**
 * @author wangfj
 * @date 2018-11-10
 * @description 日志记录扩展类
 */
public class LogRecordVo extends BlogLogRecord {

    /**
     * 浏览类别
     */
    private String recordTypeStr;

    /**
     * 浏览文章
     */
    private String treatiseName;

    public String getRecordTypeStr() {
        return recordTypeStr;
    }

    public void setRecordTypeStr(String recordTypeStr) {
        this.recordTypeStr = recordTypeStr;
    }

    public String getTreatiseName() {
        return treatiseName;
    }

    public void setTreatiseName(String treatiseName) {
        this.treatiseName = treatiseName;
    }
}
