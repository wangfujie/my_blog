package com.blog.manage.modules.others.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.blog.manage.common.result.LayPageQuery;
import com.blog.manage.common.result.ResultLay;
import com.blog.manage.modules.others.service.IBlogLeaveMessageService;
import com.blog.pojo.entity.BlogLeaveMessage;
import com.baomidou.mybatisplus.plugins.Page;
import com.blog.common.utils.MessageSourceUtil;
import com.blog.common.result.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;

/**
 * @author wangfj
 * @date 2018-09-10
 * @description 留言表 前端控制器
 */
@RestController
@RequestMapping("/blogLeaveMessage" )
@Api(value = "留言表接口",tags = "用作留言表演示")
public class BlogLeaveMessageController {

    @Autowired
    private IBlogLeaveMessageService iBlogLeaveMessageService;

    /**
     * 列表
     */
    @GetMapping("/list" )
    @ApiOperation(value = "留言表", notes = "获取留言表分页列表" )
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "当前页码", paramType = "query" ),
            @ApiImplicitParam(name = "limit", value = "每页条数", paramType = "query" )
    })
    public ResultLay list(@ApiIgnore LayPageQuery baseQuery){
            //查询列表数据
            Page pageList = iBlogLeaveMessageService.selectPage(new Page(baseQuery.getPage(),baseQuery.getLimit()),
                    new EntityWrapper<BlogLeaveMessage>()
                            .eq("status", 1)
                            .orderBy("create_time", false));
            return ResultLay.fillPageData(pageList);
    }

    /**
     * 信息
     */
    @GetMapping("/info/{uuid}" )
    @ApiOperation(value = "留言表", notes = "获取留言表详情信息" )
    public R info(@PathVariable("uuid" ) String uuid){
        BlogLeaveMessage blogLeaveMessage = iBlogLeaveMessageService.selectById(uuid);
        if (blogLeaveMessage == null) {
            return R.notFound();
        }
        return R.fillSingleData(blogLeaveMessage);
    }

    /**
     * 保存
     */
    @PostMapping("/save" )
    @ApiOperation(value = "留言表", notes = "保存留言表信息" )
    public R save(@RequestBody BlogLeaveMessage blogLeaveMessage){
        boolean retFlag = iBlogLeaveMessageService.insert(blogLeaveMessage);
        if (!retFlag) {
            return R.error(MessageSourceUtil.getMessage("500"));
        }
        return R.ok();
    }

    /**
     * 修改
     */
    @PostMapping("/reply" )
    @ApiOperation(value = "留言表", notes = "回复留言" )
    public R reply(BlogLeaveMessage blogLeaveMessage){
        boolean retFlag = iBlogLeaveMessageService.updateById(blogLeaveMessage);
        if (!retFlag) {
            return R.error(MessageSourceUtil.getMessage("500"));
        }
        return R.ok();
    }

    /**
     * 删除
     */
    @PostMapping("/delete/{uuid}" )
    @ApiOperation(value = "留言表", notes = "删除留言表信息" )
    public R delete(@PathVariable("uuid" ) String uuid){
        BlogLeaveMessage blogLeaveMessage = iBlogLeaveMessageService.selectById(uuid);
        if (blogLeaveMessage != null){
            //设置成删除状态
            blogLeaveMessage.setStatus(2);
        }
        boolean retFlag = iBlogLeaveMessageService.updateById(blogLeaveMessage);
        if (!retFlag) {
            return R.error(MessageSourceUtil.getMessage("500"));
        }
        return R.ok();
    }

    /**
     * 批量删除
     */
    @PutMapping("/deleteBatch" )
    @ApiOperation(value = "留言表", notes = "批量删除留言表信息" )
    public R deleteBatch(String uuidString){
        String[] uuidArray = uuidString.split("\\,");
        List<BlogLeaveMessage> leaveMessageList = iBlogLeaveMessageService.selectList(new EntityWrapper<BlogLeaveMessage>().in("uuid",uuidArray));
        if (leaveMessageList != null && leaveMessageList.size() > 0){
            //设置成删除状态
            leaveMessageList.forEach(message -> message.setStatus(2));
        }
        boolean retFlag = iBlogLeaveMessageService.updateBatchById(leaveMessageList);
        if (!retFlag) {
            return R.error(MessageSourceUtil.getMessage("500"));
        }
        return R.ok();
    }
}
