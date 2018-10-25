package com.blog.index.modules.record.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.blog.common.query.BaseQuery;
import com.blog.common.result.R;
import com.blog.common.utils.DateUtils;
import com.blog.common.utils.IpAddressUtil;
import com.blog.common.utils.MessageSourceUtil;
import com.blog.index.modules.record.service.IBlogLogRecordService;
import com.blog.pojo.entity.BlogLogRecord;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.collections.CollectionUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

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
    private IBlogLogRecordService logRecordService;

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
            Page pageList=logRecordService.selectPage(page,new EntityWrapper<BlogLogRecord>());
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
        BlogLogRecord blogLogRecord = logRecordService.selectById(id);
        if (blogLogRecord == null) {
            return R.notFound();
        }
        return R.fillSingleData(blogLogRecord);
    }

    /**
     * 增加记录(网站浏览，文章浏览，文章点赞记录)
     */
    @PostMapping("/addRecord" )
    @ApiOperation(value = "增加记录", notes = "增加日志记录信息" )
    public R addRecord(BlogLogRecord blogLogRecord, HttpServletRequest request){
        return logRecordService.addBlogLogRecord(blogLogRecord, request);
    }

    /**
     * 修改
     */
    @PostMapping("/update" )
    @RequiresPermissions("blogLogRecord:update" )
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
    @RequiresPermissions("blogLogRecord:delete" )
    @ApiOperation(value = "日志记录", notes = "删除日志记录信息" )
    public R delete(@PathVariable("id" ) Integer id){
        boolean retFlag = logRecordService.deleteById(id);
        if (!retFlag) {
            return R.error(MessageSourceUtil.getMessage("500"));
        }
        return R.ok();
    }
}
