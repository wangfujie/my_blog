package com.blog.manage.modules.others.controller;

import com.blog.manage.common.result.LayPageQuery;
import com.blog.manage.common.result.ResultLay;
import com.blog.manage.modules.others.service.IBlogFriendlyLinksService;
import com.blog.pojo.entity.BlogFriendlyLinks;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.blog.common.utils.MessageSourceUtil;
import com.blog.common.result.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.*;
import springfox.documentation.annotations.ApiIgnore;
import java.util.Date;

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
    private IBlogFriendlyLinksService friendlyLinksService;

    /**
     * 列表
     */
    @GetMapping("/list" )
    @ApiOperation(value = "友情链接", notes = "获取友情链接分页列表" )
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "当前页码", paramType = "query" ),
            @ApiImplicitParam(name = "limit", value = "每页条数", paramType = "query" )
    })
    public ResultLay list(@ApiIgnore LayPageQuery baseQuery){
            //查询列表数据
            Page pageList = friendlyLinksService.selectPage(new Page(baseQuery.getPage(),baseQuery.getLimit()),
                    new EntityWrapper<BlogFriendlyLinks>().eq("del_flag", 0));
            return ResultLay.fillPageData(pageList);
    }

    /**
     * 信息
     */
    @GetMapping("/info/{id}" )
    @ApiOperation(value = "友情链接", notes = "获取友情链接详情信息" )
    public R info(@PathVariable("id" ) Integer id){
        BlogFriendlyLinks blogFriendlyLinks = friendlyLinksService.selectById(id);
        if (blogFriendlyLinks == null) {
            return R.notFound();
        }
        return R.fillSingleData(blogFriendlyLinks);
    }

    /**
     * 新增或修改
     */
    @PostMapping("/insertOrUpdate" )
    @ApiOperation(value = "友情链接", notes = "新增或修改友情链接信息" )
    public R insertOrUpdate(BlogFriendlyLinks friendlyLinks){
        if (friendlyLinks != null){
            if (friendlyLinks.getId() == null){
                friendlyLinks.setCreateTime(new Date());
            }
        }
        boolean retFlag = friendlyLinksService.insertOrUpdate(friendlyLinks);
        if (!retFlag) {
            return R.error(MessageSourceUtil.getMessage("500"));
        }
        return R.ok();
    }

    /**
     * 删除
     */
    @PostMapping("/delete/{id}" )
    @ApiOperation(value = "友情链接", notes = "删除友情链接信息" )
    public R delete(@PathVariable("id" ) Integer id){
        BlogFriendlyLinks friendlyLink = friendlyLinksService.selectById(id);
        if (friendlyLink != null){
            friendlyLink.setDelFlag(1);
            friendlyLink.setDeleteTime(new Date());
        }
        boolean retFlag = friendlyLinksService.updateById(friendlyLink);
        if (!retFlag) {
            return R.error(MessageSourceUtil.getMessage("500"));
        }
        return R.ok();
    }
}
