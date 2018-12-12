package com.blog.manage.modules.resource.controller;

import com.baomidou.mybatisplus.plugins.Page;
import com.blog.common.result.R;
import com.blog.common.utils.MessageSourceUtil;
import com.blog.manage.common.result.LayPageQuery;
import com.blog.manage.common.result.ResultLay;
import com.blog.manage.modules.resource.service.IBlogResourceInfoService;
import com.blog.manage.modules.resource.vo.ResourceInfoVo;
import com.blog.pojo.entity.BlogResourceInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
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
    private IBlogResourceInfoService resourceInfoService;

    /**
     * 列表
     */
    @GetMapping("/list" )
    @ApiOperation(value = "资源分享信息表", notes = "获取资源分享信息表分页列表" )
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "当前页码", paramType = "query" ),
            @ApiImplicitParam(name = "limit", value = "每页条数", paramType = "query" )
    })
    public ResultLay list(@ApiIgnore LayPageQuery layPageQuery){
            //查询列表数据
            Page<ResourceInfoVo> page=new Page(layPageQuery.getPage(),layPageQuery.getLimit());
            return ResultLay.fillPageData(resourceInfoService.selectPageInfo(page));
    }


    /**
     * 信息
     */
    @GetMapping("/info/{id}" )
    @ApiOperation(value = "资源分享信息表", notes = "获取资源分享信息表详情信息" )
    public R info(@PathVariable("id" ) Integer id){
        BlogResourceInfo blogResourceInfo = resourceInfoService.selectById(id);
        if (blogResourceInfo == null) {
            return R.notFound();
        }
        return R.fillSingleData(blogResourceInfo);
    }

    /**
     * 保存
     */
    @PostMapping("/save" )
    @ApiOperation(value = "资源分享信息表", notes = "保存资源分享信息表信息" )
    public R save(@RequestBody BlogResourceInfo blogResourceInfo){
        boolean retFlag = resourceInfoService.insert(blogResourceInfo);
        if (!retFlag) {
            return R.error(MessageSourceUtil.getMessage("500"));
        }
        return R.ok();
    }

    /**
     * 修改
     */
    @PostMapping("/update" )
    @ApiOperation(value = "资源分享信息表", notes = "更新资源分享信息表信息" )
    public R update(@RequestBody BlogResourceInfo blogResourceInfo){
        boolean retFlag = resourceInfoService.updateById(blogResourceInfo);
        if (!retFlag) {
            return R.error(MessageSourceUtil.getMessage("500"));
        }
        return R.ok();
    }

    /**
     * 删除
     */
    @PostMapping("/delete/{id}" )
    @ApiOperation(value = "资源分享信息表", notes = "删除资源分享信息表信息" )
    public R delete(@PathVariable("id" ) Integer id){
        boolean retFlag = resourceInfoService.deleteById(id);
        if (!retFlag) {
            return R.error(MessageSourceUtil.getMessage("500"));
        }
        return R.ok();
    }
}
