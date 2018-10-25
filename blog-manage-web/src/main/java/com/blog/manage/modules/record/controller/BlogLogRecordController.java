package com.blog.manage.modules.record.controller;

import com.blog.manage.modules.record.service.IBlogLogRecordService;
import com.blog.pojo.entity.BlogLogRecord;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.blog.common.query.BaseQuery;
import com.blog.common.utils.MessageSourceUtil;
import com.blog.common.result.R;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.shiro.authz.annotation.RequiresPermissions;
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
@Api(value = "日志记录接口",description = "用作日志记录演示")
public class BlogLogRecordController {

    @Autowired
    private IBlogLogRecordService iBlogLogRecordService;

    /**
     * 列表
     */
    @GetMapping("/list" )
    @RequiresPermissions("blogLogRecord:list" )
    @ApiOperation(value = "日志记录", notes = "获取日志记录分页列表" )
    @ApiImplicitParams({
            @ApiImplicitParam(name = "currentPage", value = "当前页码", paramType = "query" ),
            @ApiImplicitParam(name = "pageSize", value = "每页条数", paramType = "query" )
    })
    public R list(@ApiIgnore BaseQuery baseQuery){
            //查询列表数据
            Page page=new Page(baseQuery.getCurrentPage(),baseQuery.getPageSize());
            Page pageList=iBlogLogRecordService.selectPage(page,new EntityWrapper<BlogLogRecord>());
            if (CollectionUtils.isEmpty(pageList.getRecords())) {
                return R.notFound();
            }
            return R.fillPageData(pageList);
    }


    /**
     * 信息
     */
    @GetMapping("/info/{id}" )
    @RequiresPermissions("blogLogRecord:info" )
    @ApiOperation(value = "日志记录", notes = "获取日志记录详情信息" )
    public R info(@PathVariable("id" ) Integer id){
        BlogLogRecord blogLogRecord = iBlogLogRecordService.selectById(id);
        if (blogLogRecord == null) {
            return R.notFound();
        }
        return R.fillSingleData(blogLogRecord);
    }

    /**
     * 保存
     */
    @PostMapping("/save" )
    @RequiresPermissions("blogLogRecord:save" )
    @ApiOperation(value = "日志记录", notes = "保存日志记录信息" )
    public R save(@RequestBody BlogLogRecord blogLogRecord){
        boolean retFlag = iBlogLogRecordService.insert(blogLogRecord);
        if (!retFlag) {
            return R.error(MessageSourceUtil.getMessage("500"));
        }
        return R.ok();
    }

    /**
     * 修改
     */
    @PostMapping("/update" )
    @RequiresPermissions("blogLogRecord:update" )
    @ApiOperation(value = "日志记录", notes = "更新日志记录信息" )
    public R update(@RequestBody BlogLogRecord blogLogRecord){
        boolean retFlag = iBlogLogRecordService.updateById(blogLogRecord);
        if (!retFlag) {
            return R.error(MessageSourceUtil.getMessage("500"));
        }
        return R.ok();
    }

    /**
     * 删除
     */
    @PostMapping("/delete/{id}" )
    @RequiresPermissions("blogLogRecord:delete" )
    @ApiOperation(value = "日志记录", notes = "删除日志记录信息" )
    public R delete(@PathVariable("id" ) Integer id){
        boolean retFlag = iBlogLogRecordService.deleteById(id);
        if (!retFlag) {
            return R.error(MessageSourceUtil.getMessage("500"));
        }
        return R.ok();
    }
}
