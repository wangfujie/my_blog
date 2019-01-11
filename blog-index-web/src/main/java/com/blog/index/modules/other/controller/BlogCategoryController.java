package com.blog.index.modules.other.controller;

import com.blog.pojo.entity.BlogCategory;
import com.blog.index.modules.other.service.IBlogCategoryService;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.blog.common.query.BaseQuery;
import com.blog.common.utils.MessageSourceUtil;
import com.blog.common.result.R;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.*;
import springfox.documentation.annotations.ApiIgnore;
import java.util.List;

/**
 * @author wangfj
 * @date 2018-08-16
 * @description 博客类型表 前端控制器
 */
@RestController
@RequestMapping("/blogCategory" )
@Api(value = "博客类型表接口",description = "用作博客类型表演示")
public class BlogCategoryController {
                                                                                    
    @Autowired
    private IBlogCategoryService iBlogCategoryService;

    /**
     * 获取菜单分类列表
     */
    @GetMapping("/getBlogMenuNode" )
    @ApiOperation(value = "获取菜单分类列表", notes = "获取菜单分类列表" )
    public R getBlogMenuNode(){
        return R.fillListData(iBlogCategoryService.getBlogMenuNode());
    }

    /**
     * 列表
     */
    @GetMapping("/list" )
    @ApiOperation(value = "博客类型表", notes = "获取博客类型表分页列表" )
    @ApiImplicitParams({
            @ApiImplicitParam(name = "currentPage", value = "当前页码", paramType = "query" ),
            @ApiImplicitParam(name = "pageSize", value = "每页条数", paramType = "query" )
    })
    public R list(@ApiIgnore BaseQuery baseQuery){
            //查询列表数据
            Page page=new Page(baseQuery.getCurrentPage(),baseQuery.getPageSize());
            Page pageList=iBlogCategoryService.selectPage(page,new EntityWrapper<BlogCategory>());
            if (CollectionUtils.isEmpty(pageList.getRecords())) {
                return R.notFound();
            }
            return R.fillPageData(pageList);
    }

    /**
     * 通过categoryId获取分类
     */
    @GetMapping("/getCategoryList" )
    @ApiOperation(value = "通过categoryId获取分类", notes = "通过categoryId获取分类" )
    public R getCategoryList(Integer categoryId){
        //查询列表数据
        List<BlogCategory> categoryList = iBlogCategoryService.selectList(new EntityWrapper<BlogCategory>().eq("f_id",categoryId).eq("status",1));
        if (CollectionUtils.isEmpty(categoryList)) {
            return R.notFound();
        }
        return R.fillListData(categoryList);
    }

    /**
     * 信息
     */
    @GetMapping("/info/{id}" )
    @ApiOperation(value = "博客类型表", notes = "获取博客类型表详情信息" )
    public R info(@PathVariable("id" ) Integer id){
        BlogCategory blogCategory = iBlogCategoryService.selectById(id);
        if (blogCategory == null) {
            return R.notFound();
        }
        return R.fillSingleData(blogCategory);
    }

    /**
     * 保存
     */
    @PostMapping("/save" )
    @ApiOperation(value = "博客类型表", notes = "保存博客类型表信息" )
    public R save(@RequestBody BlogCategory blogCategory){
        boolean retFlag = iBlogCategoryService.insert(blogCategory);
        if (!retFlag) {
            return R.error(MessageSourceUtil.getMessage("500"));
        }
        return R.ok();
    }

    /**
     * 修改
     */
    @PostMapping("/update" )
    @ApiOperation(value = "博客类型表", notes = "更新博客类型表信息" )
    public R update(@RequestBody BlogCategory blogCategory){
        boolean retFlag = iBlogCategoryService.updateById(blogCategory);
        if (!retFlag) {
            return R.error(MessageSourceUtil.getMessage("500"));
        }
        return R.ok();
    }

    /**
     * 删除
     */
    @PostMapping("/delete/{id}" )
    @ApiOperation(value = "博客类型表", notes = "删除博客类型表信息" )
    public R delete(@PathVariable("id" ) Integer id){
        boolean retFlag = iBlogCategoryService.deleteById(id);
        if (!retFlag) {
            return R.error(MessageSourceUtil.getMessage("500"));
        }
        return R.ok();
    }
}
