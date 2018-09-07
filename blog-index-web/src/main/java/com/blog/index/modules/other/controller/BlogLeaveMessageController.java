package com.blog.index.modules.other.controller;

import com.blog.common.utils.RandomUtils;
import com.blog.pojo.entity.BlogLeaveMessage;
import com.blog.index.modules.other.service.IBlogLeaveMessageService;
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

import java.util.Date;

/**
 * @author wangfj
 * @date 2018-08-16
 * @description 留言表 前端控制器
 */
@RestController
@RequestMapping("/blogLeaveMessage" )
@Api(value = "留言表接口",description = "用作留言表演示")
public class BlogLeaveMessageController {

    @Autowired
    private IBlogLeaveMessageService iBlogLeaveMessageService;

    /**
     * 列表
     */
    @GetMapping("/list" )
    @RequiresPermissions("blogLeaveMessage:list" )
    @ApiOperation(value = "留言表", notes = "获取留言表分页列表" )
    @ApiImplicitParams({
            @ApiImplicitParam(name = "currentPage", value = "当前页码", paramType = "query" ),
            @ApiImplicitParam(name = "pageSize", value = "每页条数", paramType = "query" )
    })
    public R list(@ApiIgnore BaseQuery baseQuery){
            //查询列表数据
            Page page=new Page(baseQuery.getCurrentPage(),baseQuery.getPageSize());
            Page pageList=iBlogLeaveMessageService.selectPage(page,
                    new EntityWrapper<BlogLeaveMessage>()
                            .eq("status",1)
                            .orderBy("create_time",false));
            if (CollectionUtils.isEmpty(pageList.getRecords())) {
                return R.notFound();
            }
            return R.fillPageData(pageList);
    }

    /**
     * 信息
     */
    @GetMapping("/info/{uuid}" )
    @RequiresPermissions("blogLeaveMessage:info" )
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
    @RequiresPermissions("blogLeaveMessage:save" )
    @ApiOperation(value = "留言表", notes = "保存留言表信息" )
    public R save(BlogLeaveMessage blogLeaveMessage){
        //设置随机头像数字
        blogLeaveMessage.setHeadImgNum(RandomUtils.getRandomNum(1,17));
        blogLeaveMessage.setCreateTime(new Date());
        boolean retFlag = iBlogLeaveMessageService.insert(blogLeaveMessage);
        if (!retFlag) {
            return R.error(MessageSourceUtil.getMessage("500"));
        }
        return R.ok();
    }

    /**
     * 修改
     */
    @PostMapping("/update" )
    @RequiresPermissions("blogLeaveMessage:update" )
    @ApiOperation(value = "留言表", notes = "更新留言表信息" )
    public R update(@RequestBody BlogLeaveMessage blogLeaveMessage){
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
    @RequiresPermissions("blogLeaveMessage:delete" )
    @ApiOperation(value = "留言表", notes = "删除留言表信息" )
    public R delete(@PathVariable("uuid" ) String uuid){
        boolean retFlag = iBlogLeaveMessageService.deleteById(uuid);
        if (!retFlag) {
            return R.error(MessageSourceUtil.getMessage("500"));
        }
        return R.ok();
    }
}
