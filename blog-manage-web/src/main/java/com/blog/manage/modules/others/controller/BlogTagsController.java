package com.blog.manage.modules.others.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.blog.manage.common.result.LayPageQuery;
import com.blog.manage.common.result.ResultLay;
import com.blog.manage.modules.others.service.IBlogTagsService;
import com.blog.manage.modules.others.vo.BlogTagsVo;
import com.blog.pojo.entity.BlogTags;
import com.baomidou.mybatisplus.plugins.Page;
import com.blog.common.utils.MessageSourceUtil;
import com.blog.common.result.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.*;
import springfox.documentation.annotations.ApiIgnore;
import java.util.List;

/**
 * @author wangfj
 * @date 2018-09-10
 * @description 标签表 前端控制器
 */
@RestController
@RequestMapping("/blogTags" )
@Api(value = "标签表接口",description = "用作标签表演示")
public class BlogTagsController {

    @Autowired
    private IBlogTagsService tagsService;

    /**
     * 列表
     */
    @GetMapping("/list" )
    @ApiOperation(value = "标签表", notes = "获取标签表分页列表" )
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "当前页码", paramType = "query" ),
            @ApiImplicitParam(name = "limit", value = "每页条数", paramType = "query" )
    })
    public ResultLay list(@ApiIgnore LayPageQuery baseQuery){
        //查询列表数据
        Page<BlogTagsVo> pageList = tagsService.getBlogTagsPage(new Page(baseQuery.getPage(),baseQuery.getLimit()));
        return ResultLay.fillPageData(pageList);
    }

    /**
     * 获取标签列表，通过分类id
     */
    @GetMapping("/getList" )
    @ApiOperation(value = "获取标签列表，通过分类id", notes = "获取标签列表，通过分类id" )
    public R getList(Integer categoryId){
        EntityWrapper<BlogTags> blogTagWrapper = new EntityWrapper<>();
        if (categoryId != null){
            blogTagWrapper.eq("category_id",categoryId);
        }
        blogTagWrapper.orderBy("click_num", false);
        List<BlogTags> blogTagsList = tagsService.selectList(blogTagWrapper);
        return R.fillListData(blogTagsList);
    }

    /**
     * 信息
     */
    @GetMapping("/info/{id}" )
    @ApiOperation(value = "标签表", notes = "获取标签表详情信息" )
    public R info(@PathVariable("id" ) Integer id){
        BlogTags blogTags = tagsService.selectById(id);
        if (blogTags == null) {
            return R.notFound();
        }
        return R.fillSingleData(blogTags);
    }

    /**
     * 保存
     */
    @PostMapping("/save" )
    @ApiOperation(value = "标签表", notes = "保存标签表信息" )
    public R save(@RequestBody BlogTags blogTags){
        boolean retFlag = tagsService.insert(blogTags);
        if (!retFlag) {
            return R.error(MessageSourceUtil.getMessage("500"));
        }
        return R.ok();
    }

    /**
     * 修改
     */
    @PostMapping("/update" )
    @ApiOperation(value = "标签表", notes = "更新标签表信息" )
    public R update(@RequestBody BlogTags blogTags){
        boolean retFlag = tagsService.updateById(blogTags);
        if (!retFlag) {
            return R.error(MessageSourceUtil.getMessage("500"));
        }
        return R.ok();
    }

    /**
     * 删除
     */
    @PostMapping("/delete/{id}" )
    @ApiOperation(value = "标签表", notes = "删除标签表信息" )
    public R delete(@PathVariable("id" ) Integer id){
        boolean retFlag = tagsService.deleteById(id);
        if (!retFlag) {
            return R.error(MessageSourceUtil.getMessage("500"));
        }
        return R.ok();
    }
}
