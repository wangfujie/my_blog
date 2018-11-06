package com.blog.manage.modules.others.controller;

import com.blog.manage.common.result.LayPageQuery;
import com.blog.manage.common.result.ResultLay;
import com.blog.manage.modules.others.service.IBlogWebTechnologyService;
import com.blog.pojo.entity.BlogWebTechnology;
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
 * @description 关于网站使用的技术 前端控制器
 */
@RestController
@RequestMapping("/blogWebTechnology" )
@Api(value = "关于网站使用的技术接口",description = "用作关于网站使用的技术演示")
public class BlogWebTechnologyController {

    @Autowired
    private IBlogWebTechnologyService technologyService;

    /**
     * 列表
     */
    @GetMapping("/list" )
    @ApiOperation(value = "关于网站使用的技术", notes = "获取关于网站使用的技术分页列表" )
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "当前页码", paramType = "query" ),
            @ApiImplicitParam(name = "limit", value = "每页条数", paramType = "query" )
    })
    public ResultLay list(@ApiIgnore LayPageQuery baseQuery){
        //查询列表数据
        Page pageList = technologyService.selectPage(new Page(baseQuery.getPage(),baseQuery.getLimit()),
                new EntityWrapper<BlogWebTechnology>().orderBy("show_sort", true));
        return ResultLay.fillPageData(pageList);
    }


    /**
     * 信息
     */
    @GetMapping("/info/{id}" )
    @ApiOperation(value = "关于网站使用的技术", notes = "获取关于网站使用的技术详情信息" )
    public R info(@PathVariable("id" ) Integer id){
        BlogWebTechnology blogWebTechnology = technologyService.selectById(id);
        if (blogWebTechnology == null) {
            return R.notFound();
        }
        return R.fillSingleData(blogWebTechnology);
    }

    /**
     * 修改或新增
     */
    @PostMapping("/insertOrUpdate" )
    @ApiOperation(value = "关于网站使用的技术，修改或新增", notes = "修改或新增关于网站使用的技术信息" )
    public R save(BlogWebTechnology blogWebTechnology){
        boolean retFlag = technologyService.insertOrUpdate(blogWebTechnology);
        if (!retFlag) {
            return R.error(MessageSourceUtil.getMessage("500"));
        }
        return R.ok();
    }

    /**
     * 删除
     */
    @PostMapping("/delete/{id}" )
    @ApiOperation(value = "关于网站使用的技术", notes = "删除关于网站使用的技术信息" )
    public R delete(@PathVariable("id" ) Integer id){
        boolean retFlag = technologyService.deleteById(id);
        if (!retFlag) {
            return R.error(MessageSourceUtil.getMessage("500"));
        }
        return R.ok();
    }
}
