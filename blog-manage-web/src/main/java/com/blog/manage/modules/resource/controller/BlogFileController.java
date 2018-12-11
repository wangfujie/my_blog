package com.blog.manage.modules.resource.controller;

import com.blog.pojo.entity.BlogFile;
import com.blog.manage.modules.resource.service.IBlogFileService;
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
 * @description 文件信息表 前端控制器
 */
@RestController
@RequestMapping("/blogFile" )
@Api(value = "文件信息表接口",description = "用作文件信息表演示")
public class BlogFileController {

                                                                                                            
        @Autowired
    private IBlogFileService iBlogFileService;

    /**
     * 列表
     */
    @GetMapping("/list" )
    @RequiresPermissions("blogFile:list" )
    @ApiOperation(value = "文件信息表", notes = "获取文件信息表分页列表" )
    @ApiImplicitParams({
            @ApiImplicitParam(name = "currentPage", value = "当前页码", paramType = "query" ),
            @ApiImplicitParam(name = "pageSize", value = "每页条数", paramType = "query" )
    })
    public R list(@ApiIgnore BaseQuery baseQuery){
            //查询列表数据
            Page page=new Page(baseQuery.getCurrentPage(),baseQuery.getPageSize());
            Page pageList=iBlogFileService.selectPage(page,new EntityWrapper<BlogFile>());
            if (CollectionUtils.isEmpty(pageList.getRecords())) {
                return R.notFound();
            }
            return R.fillPageData(pageList);
    }


    /**
     * 信息
     */
    @GetMapping("/info/{id}" )
    @RequiresPermissions("blogFile:info" )
    @ApiOperation(value = "文件信息表", notes = "获取文件信息表详情信息" )
    public R info(@PathVariable("id" ) Integer id){
        BlogFile blogFile = iBlogFileService.selectById(id);
        if (blogFile == null) {
            return R.notFound();
        }
        return R.fillSingleData(blogFile);
    }

    /**
     * 保存
     */
    @PostMapping("/save" )
    @RequiresPermissions("blogFile:save" )
    @ApiOperation(value = "文件信息表", notes = "保存文件信息表信息" )
    public R save(@RequestBody BlogFile blogFile){
        boolean retFlag = iBlogFileService.insert(blogFile);
        if (!retFlag) {
            return R.error(MessageSourceUtil.getMessage("500"));
        }
        return R.ok();
    }

    /**
     * 修改
     */
    @PostMapping("/update" )
    @RequiresPermissions("blogFile:update" )
    @ApiOperation(value = "文件信息表", notes = "更新文件信息表信息" )
    public R update(@RequestBody BlogFile blogFile){
        boolean retFlag = iBlogFileService.updateById(blogFile);
        if (!retFlag) {
            return R.error(MessageSourceUtil.getMessage("500"));
        }
        return R.ok();
    }

    /**
     * 删除
     */
    @PostMapping("/delete/{id}" )
    @RequiresPermissions("blogFile:delete" )
    @ApiOperation(value = "文件信息表", notes = "删除文件信息表信息" )
    public R delete(@PathVariable("id" ) Integer id){
        boolean retFlag = iBlogFileService.deleteById(id);
        if (!retFlag) {
            return R.error(MessageSourceUtil.getMessage("500"));
        }
        return R.ok();
    }
}
