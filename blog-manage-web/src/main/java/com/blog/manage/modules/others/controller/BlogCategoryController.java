package com.blog.manage.modules.others.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.blog.manage.common.result.LayPageQuery;
import com.blog.manage.common.result.ResultLay;
import com.blog.manage.modules.others.service.IBlogCategoryService;
import com.blog.pojo.entity.BlogCategory;
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
 * @description 博客类型表 前端控制器
 */
@RestController
@RequestMapping("/blogCategory" )
@Api(value = "博客类型表接口",tags = "用作博客类型表演示")
public class BlogCategoryController {

    @Autowired
    private IBlogCategoryService categoryService;

    /**
     * 列表
     */
    @GetMapping("/list" )
    @ApiOperation(value = "博客类型表", notes = "获取博客类型表分页列表" )
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "当前页码", paramType = "query" ),
            @ApiImplicitParam(name = "limit", value = "每页条数", paramType = "query" )
    })
    public ResultLay list(@ApiIgnore LayPageQuery baseQuery){
        //查询列表数据
        Page pageList = categoryService.getBlogCategoryPage(new Page(baseQuery.getPage(),baseQuery.getLimit()));
        return ResultLay.fillPageData(pageList);
    }

    /**
     * 获取分类下拉列表
     */
    @GetMapping("/getCategoryList" )
    @ApiOperation(value = "博客类型，获取分类下拉列表", notes = "获取分类下拉列表" )
    @ApiImplicitParams({
            @ApiImplicitParam(name = "categoryId", value = "分类id", paramType = "query" )
    })
    public R getCategoryList(Integer categoryId){
        List<BlogCategory> categoryList;
        //如果参数不为空，查询子分类
        if (categoryId != null){
            categoryList = categoryService.selectList(new EntityWrapper<BlogCategory>().eq("f_id", categoryId).eq("status",1));
        }else {
            //查询二级分类
            categoryList = categoryService.selectList(new EntityWrapper<BlogCategory>().ne("f_id", 0).eq("status",1));
        }
        return R.fillListData(categoryList);
    }

    /**
     * 获取分类下拉列表
     */
    @GetMapping("/getAllCategoryList" )
    @ApiOperation(value = "博客类型，获取全部启用的分类下拉列表", notes = "获取全部启用的分类下拉列表" )
    @ApiImplicitParams({
            @ApiImplicitParam(name = "categoryId", value = "分类id", paramType = "query" )
    })
    public R getAllCategoryList(){
        List<BlogCategory> categoryList = categoryService.selectList(new EntityWrapper<BlogCategory>().eq("status",1));
        return R.fillListData(categoryList);
    }

    /**
     * 新增或修改
     */
    @PostMapping("/insertOrUpdate" )
    @ApiOperation(value = "博客类型表", notes = "新增或修改博客类型表信息" )
    public R insertOrUpdate(BlogCategory blogCategory){
        boolean retFlag = categoryService.insertOrUpdate(blogCategory);
        if (!retFlag) {
            return R.error(MessageSourceUtil.getMessage("500"));
        }
        return R.ok();
    }

    /**
     * 改变状态
     */
    @PostMapping("/status/{id}" )
    @ApiOperation(value = "博客类型表", notes = "修改博客类型状态" )
    public R delete(@PathVariable("id" ) Integer id){
        BlogCategory blogCategory = categoryService.selectById(id);
        if (blogCategory != null){
            Integer status = blogCategory.getStatus();
            blogCategory.setStatus(status == 1 ? 0 : 1);
        }
        boolean retFlag = categoryService.updateById(blogCategory);
        if (!retFlag) {
            return R.error(MessageSourceUtil.getMessage("500"));
        }
        return R.ok();
    }
}
