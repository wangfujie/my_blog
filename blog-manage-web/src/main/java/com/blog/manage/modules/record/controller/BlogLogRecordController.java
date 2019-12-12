package com.blog.manage.modules.record.controller;

import com.blog.manage.common.result.LayPageQuery;
import com.blog.manage.common.result.ResultLay;
import com.blog.manage.modules.record.service.IBlogLogRecordService;
import com.blog.pojo.entity.BlogLogRecord;
import com.baomidou.mybatisplus.plugins.Page;
import com.blog.common.utils.MessageSourceUtil;
import com.blog.common.result.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.*;
import springfox.documentation.annotations.ApiIgnore;

/**
 * @author wangfj
 * @date 2018-10-25
 * @description 日志记录 前端控制器
 */
@RestController
@RequestMapping("/blogLogRecord" )
@Api(value = "日志记录接口",tags = "用作日志记录演示")
public class BlogLogRecordController {

    @Autowired
    private IBlogLogRecordService logRecordService;

    /**
     * 列表
     */
    @GetMapping("/list" )
    @ApiOperation(value = "日志记录", notes = "获取日志记录分页列表" )
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "当前页码", paramType = "query" ),
            @ApiImplicitParam(name = "limit", value = "每页条数", paramType = "query" )
    })
    public ResultLay list(@ApiIgnore LayPageQuery baseQuery){
        //查询列表数据
        return ResultLay.fillPageData(logRecordService.getLogRecordVoPage(new Page(baseQuery.getPage(),baseQuery.getLimit())));
    }

    /**
     * 信息
     */
    @GetMapping("/info/{id}" )
    @ApiOperation(value = "日志记录", notes = "获取日志记录详情信息" )
    public R info(@PathVariable("id" ) Integer id){
        BlogLogRecord blogLogRecord = logRecordService.selectById(id);
        if (blogLogRecord == null) {
            return R.notFound();
        }
        return R.fillSingleData(blogLogRecord);
    }

    /**
     * 保存
     */
    @PostMapping("/save" )
    @ApiOperation(value = "日志记录", notes = "保存日志记录信息" )
    public R save(@RequestBody BlogLogRecord blogLogRecord){
        boolean retFlag = logRecordService.insert(blogLogRecord);
        if (!retFlag) {
            return R.error(MessageSourceUtil.getMessage("500"));
        }
        return R.ok();
    }

    /**
     * 修改
     */
    @PostMapping("/update" )
    @ApiOperation(value = "日志记录", notes = "更新日志记录信息" )
    public R update(@RequestBody BlogLogRecord blogLogRecord){
        boolean retFlag = logRecordService.updateById(blogLogRecord);
        if (!retFlag) {
            return R.error(MessageSourceUtil.getMessage("500"));
        }
        return R.ok();
    }

    /**
     * 删除
     */
    @PostMapping("/delete/{id}" )
    @ApiOperation(value = "日志记录", notes = "删除日志记录信息" )
    public R delete(@PathVariable("id" ) Integer id){
        boolean retFlag = logRecordService.deleteById(id);
        if (!retFlag) {
            return R.error(MessageSourceUtil.getMessage("500"));
        }
        return R.ok();
    }
}
