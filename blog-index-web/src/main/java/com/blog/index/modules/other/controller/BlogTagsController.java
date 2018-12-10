package com.blog.index.modules.other.controller;

import com.blog.pojo.entity.BlogTags;
import com.blog.index.modules.other.service.IBlogTagsService;
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
import java.util.List;

/**
 * @author wangfj
 * @date 2018-08-20
 * @description 标签表 前端控制器
 */
@RestController
@RequestMapping("/blogTags" )
@Api(value = "标签表接口",description = "用作标签表演示")
public class BlogTagsController {
                                                                                    
    @Autowired
    private IBlogTagsService iBlogTagsService;

    /**
     * 列表
     */
    @GetMapping("/list" )
    @RequiresPermissions("blogTags:list" )
    @ApiOperation(value = "标签表", notes = "获取标签表分页列表" )
    @ApiImplicitParams({
            @ApiImplicitParam(name = "currentPage", value = "当前页码", paramType = "query" ),
            @ApiImplicitParam(name = "pageSize", value = "每页条数", paramType = "query" )
    })
    public R list(@ApiIgnore BaseQuery baseQuery){
            //查询列表数据
            Page page=new Page(baseQuery.getCurrentPage(),baseQuery.getPageSize());
            Page pageList=iBlogTagsService.selectPage(page,new EntityWrapper<BlogTags>());
            if (CollectionUtils.isEmpty(pageList.getRecords())) {
                return R.notFound();
            }
            return R.fillPageData(pageList);
    }

    /**
     * 获取标签云展示列表
     */
    @GetMapping("/getShowTags" )
    @ApiOperation(value = "获取标签云展示列表", notes = "获取标签云展示列表" )
    public R getShowTags(){
        //查询列表数据
        List<BlogTags> tagList=iBlogTagsService.selectList(new EntityWrapper<BlogTags>().orderBy("use_num",false));
        if (CollectionUtils.isEmpty(tagList)) {
            return R.notFound();
        }
        return R.fillListData(tagList);
    }

    /**
     * 信息
     */
    @GetMapping("/info/{id}" )
    @RequiresPermissions("blogTags:info" )
    @ApiOperation(value = "标签表", notes = "获取标签表详情信息" )
    public R info(@PathVariable("id" ) Integer id){
        BlogTags blogTags = iBlogTagsService.selectById(id);
        if (blogTags == null) {
            return R.notFound();
        }
        return R.fillSingleData(blogTags);
    }

    /**
     * 保存
     */
    @PostMapping("/save" )
    @RequiresPermissions("blogTags:save" )
    @ApiOperation(value = "标签表", notes = "保存标签表信息" )
    public R save(@RequestBody BlogTags blogTags){
        boolean retFlag = iBlogTagsService.insert(blogTags);
        if (!retFlag) {
            return R.error(MessageSourceUtil.getMessage("500"));
        }
        return R.ok();
    }

    /**
     * 修改
     */
    @PostMapping("/update" )
    @RequiresPermissions("blogTags:update" )
    @ApiOperation(value = "标签表", notes = "更新标签表信息" )
    public R update(@RequestBody BlogTags blogTags){
        boolean retFlag = iBlogTagsService.updateById(blogTags);
        if (!retFlag) {
            return R.error(MessageSourceUtil.getMessage("500"));
        }
        return R.ok();
    }

    /**
     * 删除
     */
    @PostMapping("/delete/{id}" )
    @RequiresPermissions("blogTags:delete" )
    @ApiOperation(value = "标签表", notes = "删除标签表信息" )
    public R delete(@PathVariable("id" ) Integer id){
        boolean retFlag = iBlogTagsService.deleteById(id);
        if (!retFlag) {
            return R.error(MessageSourceUtil.getMessage("500"));
        }
        return R.ok();
    }
}
