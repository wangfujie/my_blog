package com.blog.index.modules.other.controller;

import com.blog.pojo.entity.BlogWebInfo;
import com.blog.index.modules.other.service.IBlogWebInfoService;
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
 * @date 2018-08-16
 * @description 网站的一些统计数据 前端控制器
 */
@RestController
@RequestMapping("/blogWebInfo" )
@Api(value = "网站的一些统计数据接口",description = "用作网站的一些统计数据演示")
public class BlogWebInfoController {

    @Autowired
    private IBlogWebInfoService iBlogWebInfoService;

    /**
     * 列表
     */
    @GetMapping("/list" )
    @RequiresPermissions("blogWebInfo:list" )
    @ApiOperation(value = "网站的一些统计数据", notes = "获取网站的一些统计数据分页列表" )
    @ApiImplicitParams({
            @ApiImplicitParam(name = "currentPage", value = "当前页码", paramType = "query" ),
            @ApiImplicitParam(name = "pageSize", value = "每页条数", paramType = "query" )
    })
    public R list(@ApiIgnore BaseQuery baseQuery){
            //查询列表数据
            Page page=new Page(baseQuery.getCurrentPage(),baseQuery.getPageSize());
            Page pageList=iBlogWebInfoService.selectPage(page,new EntityWrapper<BlogWebInfo>());
            if (CollectionUtils.isEmpty(pageList.getRecords())) {
                return R.notFound();
            }
            return R.fillPageData(pageList);
    }


    /**
     * 信息
     */
    @GetMapping("/info/{id}" )
    @RequiresPermissions("blogWebInfo:info" )
    @ApiOperation(value = "网站的一些统计数据", notes = "获取网站的一些统计数据详情信息" )
    public R info(@PathVariable("id" ) Integer id){
        BlogWebInfo blogWebInfo = iBlogWebInfoService.selectById(id);
        if (blogWebInfo == null) {
            return R.notFound();
        }
        return R.fillSingleData(blogWebInfo);
    }

    /**
     * 保存
     */
    @PostMapping("/save" )
    @RequiresPermissions("blogWebInfo:save" )
    @ApiOperation(value = "网站的一些统计数据", notes = "保存网站的一些统计数据信息" )
    public R save(@RequestBody BlogWebInfo blogWebInfo){
        boolean retFlag = iBlogWebInfoService.insert(blogWebInfo);
        if (!retFlag) {
            return R.error(MessageSourceUtil.getMessage("500"));
        }
        return R.ok();
    }

    /**
     * 修改
     */
    @PostMapping("/update" )
    @RequiresPermissions("blogWebInfo:update" )
    @ApiOperation(value = "网站的一些统计数据", notes = "更新网站的一些统计数据信息" )
    public R update(@RequestBody BlogWebInfo blogWebInfo){
        boolean retFlag = iBlogWebInfoService.updateById(blogWebInfo);
        if (!retFlag) {
            return R.error(MessageSourceUtil.getMessage("500"));
        }
        return R.ok();
    }

    /**
     * 删除
     */
    @PostMapping("/delete/{id}" )
    @RequiresPermissions("blogWebInfo:delete" )
    @ApiOperation(value = "网站的一些统计数据", notes = "删除网站的一些统计数据信息" )
    public R delete(@PathVariable("id" ) Integer id){
        boolean retFlag = iBlogWebInfoService.deleteById(id);
        if (!retFlag) {
            return R.error(MessageSourceUtil.getMessage("500"));
        }
        return R.ok();
    }
}
