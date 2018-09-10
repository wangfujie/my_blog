package com.blog.manage.modules.others.controller;

import com.blog.manage.modules.others.service.IBlogFriendlyLinksService;
import com.blog.pojo.entity.BlogFriendlyLinks;
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
 * @date 2018-09-10
 * @description 友情链接 前端控制器
 */
@RestController
@RequestMapping("/blogFriendlyLinks" )
@Api(value = "友情链接接口",description = "用作友情链接演示")
public class BlogFriendlyLinksController {

    @Autowired
    private IBlogFriendlyLinksService iBlogFriendlyLinksService;

    /**
     * 列表
     */
    @GetMapping("/list" )
    @RequiresPermissions("blogFriendlyLinks:list" )
    @ApiOperation(value = "友情链接", notes = "获取友情链接分页列表" )
    @ApiImplicitParams({
            @ApiImplicitParam(name = "currentPage", value = "当前页码", paramType = "query" ),
            @ApiImplicitParam(name = "pageSize", value = "每页条数", paramType = "query" )
    })
    public R list(@ApiIgnore BaseQuery baseQuery){
            //查询列表数据
            Page page=new Page(baseQuery.getCurrentPage(),baseQuery.getPageSize());
            Page pageList=iBlogFriendlyLinksService.selectPage(page,new EntityWrapper<BlogFriendlyLinks>());
            if (CollectionUtils.isEmpty(pageList.getRecords())) {
                return R.notFound();
            }
            return R.fillPageData(pageList);
    }


    /**
     * 信息
     */
    @GetMapping("/info/{id}" )
    @RequiresPermissions("blogFriendlyLinks:info" )
    @ApiOperation(value = "友情链接", notes = "获取友情链接详情信息" )
    public R info(@PathVariable("id" ) Integer id){
        BlogFriendlyLinks blogFriendlyLinks = iBlogFriendlyLinksService.selectById(id);
        if (blogFriendlyLinks == null) {
            return R.notFound();
        }
        return R.fillSingleData(blogFriendlyLinks);
    }

    /**
     * 保存
     */
    @PostMapping("/save" )
    @RequiresPermissions("blogFriendlyLinks:save" )
    @ApiOperation(value = "友情链接", notes = "保存友情链接信息" )
    public R save(@RequestBody BlogFriendlyLinks blogFriendlyLinks){
        boolean retFlag = iBlogFriendlyLinksService.insert(blogFriendlyLinks);
        if (!retFlag) {
            return R.error(MessageSourceUtil.getMessage("500"));
        }
        return R.ok();
    }

    /**
     * 修改
     */
    @PostMapping("/update" )
    @RequiresPermissions("blogFriendlyLinks:update" )
    @ApiOperation(value = "友情链接", notes = "更新友情链接信息" )
    public R update(@RequestBody BlogFriendlyLinks blogFriendlyLinks){
        boolean retFlag = iBlogFriendlyLinksService.updateById(blogFriendlyLinks);
        if (!retFlag) {
            return R.error(MessageSourceUtil.getMessage("500"));
        }
        return R.ok();
    }

    /**
     * 删除
     */
    @PostMapping("/delete/{id}" )
    @RequiresPermissions("blogFriendlyLinks:delete" )
    @ApiOperation(value = "友情链接", notes = "删除友情链接信息" )
    public R delete(@PathVariable("id" ) Integer id){
        boolean retFlag = iBlogFriendlyLinksService.deleteById(id);
        if (!retFlag) {
            return R.error(MessageSourceUtil.getMessage("500"));
        }
        return R.ok();
    }
}
