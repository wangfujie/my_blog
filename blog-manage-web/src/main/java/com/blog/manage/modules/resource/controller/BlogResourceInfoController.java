package com.blog.manage.modules.resource.controller;

import com.blog.pojo.entity.BlogResourceInfo;
import com.blog.manage.modules.resource.service.IBlogResourceInfoService;
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
 * @date 2018-12-11
 * @description 资源分享信息表 前端控制器
 */
@RestController
@RequestMapping("/blogResourceInfo" )
@Api(value = "资源分享信息表接口",description = "用作资源分享信息表演示")
public class BlogResourceInfoController {

                                                                                                                                    
        @Autowired
    private IBlogResourceInfoService iBlogResourceInfoService;

    /**
     * 列表
     */
    @GetMapping("/list" )
    @RequiresPermissions("blogResourceInfo:list" )
    @ApiOperation(value = "资源分享信息表", notes = "获取资源分享信息表分页列表" )
    @ApiImplicitParams({
            @ApiImplicitParam(name = "currentPage", value = "当前页码", paramType = "query" ),
            @ApiImplicitParam(name = "pageSize", value = "每页条数", paramType = "query" )
    })
    public R list(@ApiIgnore BaseQuery baseQuery){
            //查询列表数据
            Page page=new Page(baseQuery.getCurrentPage(),baseQuery.getPageSize());
            Page pageList=iBlogResourceInfoService.selectPage(page,new EntityWrapper<BlogResourceInfo>());
            if (CollectionUtils.isEmpty(pageList.getRecords())) {
                return R.notFound();
            }
            return R.fillPageData(pageList);
    }


    /**
     * 信息
     */
    @GetMapping("/info/{id}" )
    @RequiresPermissions("blogResourceInfo:info" )
    @ApiOperation(value = "资源分享信息表", notes = "获取资源分享信息表详情信息" )
    public R info(@PathVariable("id" ) Integer id){
        BlogResourceInfo blogResourceInfo = iBlogResourceInfoService.selectById(id);
        if (blogResourceInfo == null) {
            return R.notFound();
        }
        return R.fillSingleData(blogResourceInfo);
    }

    /**
     * 保存
     */
    @PostMapping("/save" )
    @RequiresPermissions("blogResourceInfo:save" )
    @ApiOperation(value = "资源分享信息表", notes = "保存资源分享信息表信息" )
    public R save(@RequestBody BlogResourceInfo blogResourceInfo){
        boolean retFlag = iBlogResourceInfoService.insert(blogResourceInfo);
        if (!retFlag) {
            return R.error(MessageSourceUtil.getMessage("500"));
        }
        return R.ok();
    }

    /**
     * 修改
     */
    @PostMapping("/update" )
    @RequiresPermissions("blogResourceInfo:update" )
    @ApiOperation(value = "资源分享信息表", notes = "更新资源分享信息表信息" )
    public R update(@RequestBody BlogResourceInfo blogResourceInfo){
        boolean retFlag = iBlogResourceInfoService.updateById(blogResourceInfo);
        if (!retFlag) {
            return R.error(MessageSourceUtil.getMessage("500"));
        }
        return R.ok();
    }

    /**
     * 删除
     */
    @PostMapping("/delete/{id}" )
    @RequiresPermissions("blogResourceInfo:delete" )
    @ApiOperation(value = "资源分享信息表", notes = "删除资源分享信息表信息" )
    public R delete(@PathVariable("id" ) Integer id){
        boolean retFlag = iBlogResourceInfoService.deleteById(id);
        if (!retFlag) {
            return R.error(MessageSourceUtil.getMessage("500"));
        }
        return R.ok();
    }
}
