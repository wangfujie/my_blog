package com.blog.manage.modules.admin.controller;

import com.blog.manage.modules.admin.service.IBlogAdminService;
import com.blog.pojo.entity.BlogAdmin;
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
 * @description  前端控制器
 */
@RestController
@RequestMapping("/blogAdmin" )
@Api(value = "接口",description = "用作演示")
public class BlogAdminController {
                                                                                                
    @Autowired
    private IBlogAdminService iBlogAdminService;

    /**
     * 列表
     */
    @GetMapping("/list" )
    @RequiresPermissions("blogAdmin:list" )
    @ApiOperation(value = "", notes = "获取分页列表" )
    @ApiImplicitParams({
            @ApiImplicitParam(name = "currentPage", value = "当前页码", paramType = "query" ),
            @ApiImplicitParam(name = "pageSize", value = "每页条数", paramType = "query" )
    })
    public R list(@ApiIgnore BaseQuery baseQuery){
            //查询列表数据
            Page page=new Page(baseQuery.getCurrentPage(),baseQuery.getPageSize());
            Page pageList=iBlogAdminService.selectPage(page,new EntityWrapper<BlogAdmin>());
            if (CollectionUtils.isEmpty(pageList.getRecords())) {
                return R.notFound();
            }
            return R.fillPageData(pageList);
    }


    /**
     * 信息
     */
    @GetMapping("/info/{id}" )
    @RequiresPermissions("blogAdmin:info" )
    @ApiOperation(value = "", notes = "获取详情信息" )
    public R info(@PathVariable("id" ) Integer id){
        BlogAdmin blogAdmin = iBlogAdminService.selectById(id);
        if (blogAdmin == null) {
            return R.notFound();
        }
        return R.fillSingleData(blogAdmin);
    }

    /**
     * 保存
     */
    @PostMapping("/save" )
    @RequiresPermissions("blogAdmin:save" )
    @ApiOperation(value = "", notes = "保存信息" )
    public R save(@RequestBody BlogAdmin blogAdmin){
        boolean retFlag = iBlogAdminService.insert(blogAdmin);
        if (!retFlag) {
            return R.error(MessageSourceUtil.getMessage("500"));
        }
        return R.ok();
    }

    /**
     * 修改
     */
    @PostMapping("/update" )
    @RequiresPermissions("blogAdmin:update" )
    @ApiOperation(value = "", notes = "更新信息" )
    public R update(@RequestBody BlogAdmin blogAdmin){
        boolean retFlag = iBlogAdminService.updateById(blogAdmin);
        if (!retFlag) {
            return R.error(MessageSourceUtil.getMessage("500"));
        }
        return R.ok();
    }

    /**
     * 删除
     */
    @PostMapping("/delete/{id}" )
    @RequiresPermissions("blogAdmin:delete" )
    @ApiOperation(value = "", notes = "删除信息" )
    public R delete(@PathVariable("id" ) Integer id){
        boolean retFlag = iBlogAdminService.deleteById(id);
        if (!retFlag) {
            return R.error(MessageSourceUtil.getMessage("500"));
        }
        return R.ok();
    }
}
