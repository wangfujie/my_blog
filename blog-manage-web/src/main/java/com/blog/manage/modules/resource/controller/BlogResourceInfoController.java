package com.blog.manage.modules.resource.controller;

import com.baomidou.mybatisplus.plugins.Page;
import com.blog.common.result.R;
import com.blog.common.utils.MessageSourceUtil;
import com.blog.manage.common.result.LayPageQuery;
import com.blog.manage.common.result.ResultLay;
import com.blog.manage.modules.others.service.IBlogTagsService;
import com.blog.manage.modules.resource.service.IBlogResourceInfoService;
import com.blog.manage.modules.resource.vo.ResourceInfoVo;
import com.blog.pojo.entity.BlogResourceInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.Date;

/**
 * @author wangfj
 * @date 2018-12-11
 * @description 资源分享信息表 前端控制器
 */
@RestController
@RequestMapping("/blogResourceInfo" )
@Api(value = "资源分享信息表接口",tags = "用作资源分享信息表演示")
public class BlogResourceInfoController {

    @Autowired
    private IBlogResourceInfoService resourceInfoService;

    @Autowired
    private IBlogTagsService tagsService;
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
        return R.fillSingleData(resourceInfoService.getResourceInfoVoById(id));
    }

    /**
     * 新增或修改
     */
    @PostMapping("/insertOrUpdate" )
    @ApiOperation(value = "资源分享信息表", notes = "新增或修改资源分享信息表" )
    public R insertOrUpdate(BlogResourceInfo blogResourceInfo){
        if (StringUtils.isEmpty(blogResourceInfo.getId())){
            //增加标签使用数量
            tagsService.addTagsUseNum(blogResourceInfo.getTags());
            //创建时间
            blogResourceInfo.setCreateTime(new Date());
        }
        //更新时间
        blogResourceInfo.setLastUpdateTime(new Date());
        boolean retFlag = resourceInfoService.insertOrUpdate(blogResourceInfo);
        if (!retFlag) {
            return R.error(MessageSourceUtil.getMessage("500"));
        }
        return R.ok();
    }

    /**
     * 启用或停用
     */
    @PostMapping("/status/{id}" )
    @ApiOperation(value = "资源分享信息表", notes = "启用或停止资源分享信息" )
    public R status(@PathVariable("id" ) Integer id){
        BlogResourceInfo resourceInfo = resourceInfoService.selectById(id);
        if (resourceInfo != null){
            Integer status = resourceInfo.getStatus();
            resourceInfo.setStatus(status == 1 ? 0 : 1);
        }
        boolean retFlag = resourceInfoService.updateById(resourceInfo);
        if (!retFlag) {
            return R.error(MessageSourceUtil.getMessage("500"));
        }
        return R.ok();
    }
}
