package com.blog.index.modules.other.controller;

import com.blog.pojo.entity.BlogWebTechnology;
import com.blog.index.modules.other.service.IBlogWebTechnologyService;
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
 * @description 关于网站使用的技术 前端控制器
 */
@RestController
@RequestMapping("/blogWebTechnology" )
@Api(value = "关于网站使用的技术接口",description = "用作关于网站使用的技术演示")
public class BlogWebTechnologyController {

    @Autowired
    private IBlogWebTechnologyService iBlogWebTechnologyService;

    /**
     * 列表
     */
    @GetMapping("/list" )
    @RequiresPermissions("blogWebTechnology:list" )
    @ApiOperation(value = "关于网站使用的技术", notes = "获取关于网站使用的技术分页列表" )
    @ApiImplicitParams({
            @ApiImplicitParam(name = "currentPage", value = "当前页码", paramType = "query" ),
            @ApiImplicitParam(name = "pageSize", value = "每页条数", paramType = "query" )
    })
    public R list(@ApiIgnore BaseQuery baseQuery){
            //查询列表数据
            Page page=new Page(baseQuery.getCurrentPage(),baseQuery.getPageSize());
            Page pageList=iBlogWebTechnologyService.selectPage(page,new EntityWrapper<BlogWebTechnology>());
            if (CollectionUtils.isEmpty(pageList.getRecords())) {
                return R.notFound();
            }
            return R.fillPageData(pageList);
    }

    /**
     * 信息
     */
    @GetMapping("/info/{id}" )
    @RequiresPermissions("blogWebTechnology:info" )
    @ApiOperation(value = "关于网站使用的技术", notes = "获取关于网站使用的技术详情信息" )
    public R info(@PathVariable("id" ) Integer id){
        BlogWebTechnology blogWebTechnology = iBlogWebTechnologyService.selectById(id);
        if (blogWebTechnology == null) {
            return R.notFound();
        }
        return R.fillSingleData(blogWebTechnology);
    }

    /**
     * 保存
     */
    @PostMapping("/save" )
    @RequiresPermissions("blogWebTechnology:save" )
    @ApiOperation(value = "关于网站使用的技术", notes = "保存关于网站使用的技术信息" )
    public R save(@RequestBody BlogWebTechnology blogWebTechnology){
        boolean retFlag = iBlogWebTechnologyService.insert(blogWebTechnology);
        if (!retFlag) {
            return R.error(MessageSourceUtil.getMessage("500"));
        }
        return R.ok();
    }

    /**
     * 修改
     */
    @PostMapping("/update" )
    @RequiresPermissions("blogWebTechnology:update" )
    @ApiOperation(value = "关于网站使用的技术", notes = "更新关于网站使用的技术信息" )
    public R update(@RequestBody BlogWebTechnology blogWebTechnology){
        boolean retFlag = iBlogWebTechnologyService.updateById(blogWebTechnology);
        if (!retFlag) {
            return R.error(MessageSourceUtil.getMessage("500"));
        }
        return R.ok();
    }

    /**
     * 删除
     */
    @PostMapping("/delete/{id}" )
    @RequiresPermissions("blogWebTechnology:delete" )
    @ApiOperation(value = "关于网站使用的技术", notes = "删除关于网站使用的技术信息" )
    public R delete(@PathVariable("id" ) Integer id){
        boolean retFlag = iBlogWebTechnologyService.deleteById(id);
        if (!retFlag) {
            return R.error(MessageSourceUtil.getMessage("500"));
        }
        return R.ok();
    }
}
