package com.blog.manage.modules.treatise.controller;

import com.blog.manage.modules.treatise.service.IBlogTreatiseService;
import com.blog.pojo.entity.BlogTreatise;
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
 * @description 文章详情表 前端控制器
 */
@RestController
@RequestMapping("/blogTreatise" )
@Api(value = "文章详情表接口",description = "用作文章详情表演示")
public class BlogTreatiseController {

    @Autowired
    private IBlogTreatiseService iBlogTreatiseService;

    /**
     * 列表
     */
    @GetMapping("/list" )
    @RequiresPermissions("blogTreatise:list" )
    @ApiOperation(value = "文章详情表", notes = "获取文章详情表分页列表" )
    @ApiImplicitParams({
            @ApiImplicitParam(name = "currentPage", value = "当前页码", paramType = "query" ),
            @ApiImplicitParam(name = "pageSize", value = "每页条数", paramType = "query" )
    })
    public R list(@ApiIgnore BaseQuery baseQuery){
            //查询列表数据
            Page page=new Page(baseQuery.getCurrentPage(),baseQuery.getPageSize());
            Page pageList=iBlogTreatiseService.selectPage(page,new EntityWrapper<BlogTreatise>());
            if (CollectionUtils.isEmpty(pageList.getRecords())) {
                return R.notFound();
            }
            return R.fillPageData(pageList);
    }


    /**
     * 信息
     */
    @GetMapping("/info/{uuid}" )
    @RequiresPermissions("blogTreatise:info" )
    @ApiOperation(value = "文章详情表", notes = "获取文章详情表详情信息" )
    public R info(@PathVariable("uuid" ) String uuid){
        BlogTreatise blogTreatise = iBlogTreatiseService.selectById(uuid);
        if (blogTreatise == null) {
            return R.notFound();
        }
        return R.fillSingleData(blogTreatise);
    }

    /**
     * 保存
     */
    @PostMapping("/save" )
    @RequiresPermissions("blogTreatise:save" )
    @ApiOperation(value = "文章详情表", notes = "保存文章详情表信息" )
    public R save(@RequestBody BlogTreatise blogTreatise){
        boolean retFlag = iBlogTreatiseService.insert(blogTreatise);
        if (!retFlag) {
            return R.error(MessageSourceUtil.getMessage("500"));
        }
        return R.ok();
    }

    /**
     * 修改
     */
    @PostMapping("/update" )
    @RequiresPermissions("blogTreatise:update" )
    @ApiOperation(value = "文章详情表", notes = "更新文章详情表信息" )
    public R update(@RequestBody BlogTreatise blogTreatise){
        boolean retFlag = iBlogTreatiseService.updateById(blogTreatise);
        if (!retFlag) {
            return R.error(MessageSourceUtil.getMessage("500"));
        }
        return R.ok();
    }

    /**
     * 删除
     */
    @PostMapping("/delete/{uuid}" )
    @RequiresPermissions("blogTreatise:delete" )
    @ApiOperation(value = "文章详情表", notes = "删除文章详情表信息" )
    public R delete(@PathVariable("uuid" ) String uuid){
        boolean retFlag = iBlogTreatiseService.deleteById(uuid);
        if (!retFlag) {
            return R.error(MessageSourceUtil.getMessage("500"));
        }
        return R.ok();
    }
}