package com.blog.index.modules.other.controller;

import cn.hutool.core.date.DateUtil;
import com.blog.index.modules.other.service.IBlogWebInfoService;
import com.blog.pojo.entity.BlogAboutMe;
import com.blog.index.modules.other.service.IBlogAboutMeService;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.blog.common.query.BaseQuery;
import com.blog.common.utils.MessageSourceUtil;
import com.blog.common.result.R;
import com.blog.pojo.entity.BlogWebInfo;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.*;
import springfox.documentation.annotations.ApiIgnore;

/**
 * @author wangfj
 * @date 2018-08-16
 * @description 关于我 前端控制器
 */
@RestController
@RequestMapping("/blogAboutMe" )
@Api(value = "关于我接口",description = "用作关于我演示")
public class BlogAboutMeController {
                                                                                                                                    
    @Autowired
    private IBlogAboutMeService iBlogAboutMeService;

    @Autowired
    private IBlogWebInfoService webInfoService;
    /**
     * 列表
     */
    @GetMapping("/list" )
    @RequiresPermissions("blogAboutMe:list" )
    @ApiOperation(value = "关于我", notes = "获取关于我分页列表" )
    @ApiImplicitParams({
            @ApiImplicitParam(name = "currentPage", value = "当前页码", paramType = "query" ),
            @ApiImplicitParam(name = "pageSize", value = "每页条数", paramType = "query" )
    })
    public R list(@ApiIgnore BaseQuery baseQuery){
            //查询列表数据
            Page page=new Page(baseQuery.getCurrentPage(),baseQuery.getPageSize());
            Page pageList=iBlogAboutMeService.selectPage(page,new EntityWrapper<BlogAboutMe>());
            if (CollectionUtils.isEmpty(pageList.getRecords())) {
                return R.notFound();
            }
            return R.fillPageData(pageList);
    }


    /**
     * 信息
     */
    @GetMapping("/info/{id}" )
    @RequiresPermissions("blogAboutMe:info" )
    @ApiOperation(value = "关于我", notes = "获取关于我详情信息" )
    public R info(@PathVariable("id" ) Integer id){
        BlogAboutMe blogAboutMe = iBlogAboutMeService.selectById(id);
        if (blogAboutMe == null) {
            return R.notFound();
        }
        //博客浏览总数
        Object browseTotal = webInfoService.selectObj(new EntityWrapper<BlogWebInfo>().setSqlSelect("sum(web_browse_num)"));
        //今日浏览数
        Object todayBrowse = webInfoService.selectObj(new EntityWrapper<BlogWebInfo>()
                .setSqlSelect("web_browse_num")
                .eq("update_time", DateUtil.today()));
        return R.fillSingleData(blogAboutMe).put("browseTotal", browseTotal).put("todayBrowse", todayBrowse);
    }

    /**
     * 保存
     */
    @PostMapping("/save" )
    @RequiresPermissions("blogAboutMe:save" )
    @ApiOperation(value = "关于我", notes = "保存关于我信息" )
    public R save(@RequestBody BlogAboutMe blogAboutMe){
        boolean retFlag = iBlogAboutMeService.insert(blogAboutMe);
        if (!retFlag) {
            return R.error(MessageSourceUtil.getMessage("500"));
        }
        return R.ok();
    }

    /**
     * 修改
     */
    @PostMapping("/update" )
    @RequiresPermissions("blogAboutMe:update" )
    @ApiOperation(value = "关于我", notes = "更新关于我信息" )
    public R update(@RequestBody BlogAboutMe blogAboutMe){
        boolean retFlag = iBlogAboutMeService.updateById(blogAboutMe);
        if (!retFlag) {
            return R.error(MessageSourceUtil.getMessage("500"));
        }
        return R.ok();
    }

    /**
     * 删除
     */
    @PostMapping("/delete/{id}" )
    @RequiresPermissions("blogAboutMe:delete" )
    @ApiOperation(value = "关于我", notes = "删除关于我信息" )
    public R delete(@PathVariable("id" ) Integer id){
        boolean retFlag = iBlogAboutMeService.deleteById(id);
        if (!retFlag) {
            return R.error(MessageSourceUtil.getMessage("500"));
        }
        return R.ok();
    }
}
