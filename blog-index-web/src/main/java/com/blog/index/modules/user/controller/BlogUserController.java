package com.blog.index.modules.user.controller;

import com.blog.common.query.BaseQuery;
import com.blog.common.utils.MessageSourceUtil;
import com.blog.pojo.entity.BlogUser;
import com.blog.index.modules.user.service.IBlogUserService;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.blog.common.result.R;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
//import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.*;
import springfox.documentation.annotations.ApiIgnore;

/**
 * @author wangfj
 * @date 2018-08-09
 * @description  前端控制器
 */
@RestController
@RequestMapping("/blogUser" )
@Api(value = "用户表接口",description = "用作用户表演示")
public class BlogUserController {

                
    @Autowired
    private IBlogUserService iBlogUserService;

    /**
     * 列表
     */
    @GetMapping("/list" )
    @ApiOperation(value = "", notes = "获取分页列表" )
    @ApiImplicitParams({
            @ApiImplicitParam(name = "currentPage", value = "当前页码", paramType = "query" ),
            @ApiImplicitParam(name = "pageSize", value = "每页条数", paramType = "query" )
    })
    public R list(@ApiIgnore BaseQuery baseQuery){
            //查询列表数据
            Page page=new Page(baseQuery.getCurrentPage(),baseQuery.getPageSize());
            Page pageList=iBlogUserService.selectPage(page,new EntityWrapper<BlogUser>());
            if (CollectionUtils.isEmpty(pageList.getRecords())) {
                return R.notFound();
            }
            return R.fillPageData(pageList);
    }


    /**
     * 信息
     */
    @GetMapping("/info/{uuid}" )
    @ApiOperation(value = "", notes = "获取详情信息" )
    public R info(@PathVariable("uuid" ) String uuid){
        BlogUser blogUser = iBlogUserService.selectById(uuid);
        if (blogUser == null) {
            return R.notFound();
        }
        return R.fillSingleData(blogUser);
    }

    /**
     * 保存
     */
    @PostMapping("/save" )
    @ApiOperation(value = "", notes = "保存信息" )
    public R save(BlogUser blogUser){
        boolean retFlag = iBlogUserService.insert(blogUser);
        if (!retFlag) {
            return R.error(MessageSourceUtil.getMessage("500"));
        }
        return R.ok();
    }

    /**
     * 修改
     */
    @PostMapping("/update" )
    @ApiOperation(value = "", notes = "更新信息" )
    public R update(BlogUser blogUser){
        boolean retFlag = iBlogUserService.updateById(blogUser);
        if (!retFlag) {
            return R.error(MessageSourceUtil.getMessage("500"));
        }
        return R.ok();
    }

    /**
     * 删除
     */
    @PostMapping("/delete/{uuid}" )
    @ApiOperation(value = "", notes = "删除信息" )
    public R delete(@PathVariable("uuid" ) String uuid){
        boolean retFlag = iBlogUserService.deleteById(uuid);
        if (!retFlag) {
            return R.error(MessageSourceUtil.getMessage("500"));
        }
        return R.ok();
    }
}