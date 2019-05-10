package com.blog.index.modules.record.controller;

import com.blog.common.result.R;
import com.blog.index.modules.record.service.IBlogLogRecordService;
import com.blog.pojo.entity.BlogLogRecord;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;

/**
 * @author wangfj
 * @date 2018-10-25
 * @description 日志记录 前端控制器
 */
@RestController
@RequestMapping("/blogLogRecord" )
@Api(value = "日志记录接口")
public class BlogLogRecordController {

    @Autowired
    private IBlogLogRecordService logRecordService;

    /**
     * 增加记录(网站浏览，文章浏览，文章点赞记录)
     */
    @PostMapping("/addRecord" )
    @ApiOperation(value = "增加记录", notes = "增加日志记录信息" )
    public R addRecord(@RequestBody BlogLogRecord blogLogRecord, HttpServletRequest request){
        return logRecordService.addBlogLogRecord(blogLogRecord, request);
    }
}
