package com.blog.manage.modules.resource.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.blog.common.query.BaseQuery;
import com.blog.common.result.R;
import com.blog.common.utils.CustomException;
import com.blog.common.utils.MessageSourceUtil;
import com.blog.manage.modules.resource.service.IBlogFileService;
import com.blog.manage.modules.resource.service.IBlogResourceInfoService;
import com.blog.pojo.entity.BlogFile;
import com.blog.pojo.entity.BlogResourceInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import springfox.documentation.annotations.ApiIgnore;
import javax.servlet.http.HttpServletResponse;

/**
 * @author wangfj
 * @date 2018-12-11
 * @description 文件信息表 前端控制器
 */
@RestController
@RequestMapping("/blogFile" )
@Api(value = "文件信息表接口",tags = "用作文件信息表演示")
public class BlogFileController {

    @Autowired
    private IBlogFileService fileService;

    @Autowired
    private IBlogResourceInfoService resourceInfoService;

    /**
     * 列表
     */
    @GetMapping("/list" )
    @ApiOperation(value = "文件信息表", notes = "获取文件信息表分页列表" )
    @ApiImplicitParams({
            @ApiImplicitParam(name = "currentPage", value = "当前页码", paramType = "query" ),
            @ApiImplicitParam(name = "pageSize", value = "每页条数", paramType = "query" )
    })
    public R list(@ApiIgnore BaseQuery baseQuery){
            //查询列表数据
            Page page=new Page(baseQuery.getCurrentPage(),baseQuery.getPageSize());
            Page pageList=fileService.selectPage(page,new EntityWrapper<BlogFile>());
            if (CollectionUtils.isEmpty(pageList.getRecords())) {
                return R.notFound();
            }
            return R.fillPageData(pageList);
    }

    /**
     * 信息
     */
    @GetMapping("/info/{id}" )
    @ApiOperation(value = "文件信息表", notes = "获取文件信息表详情信息" )
    public R info(@PathVariable("id" ) Integer id){
        BlogFile blogFile = fileService.selectById(id);
        if (blogFile == null) {
            return R.notFound();
        }
        return R.fillSingleData(blogFile);
    }

    /**
     * 保存
     */
    @PostMapping("/save" )
    @ApiOperation(value = "文件信息表", notes = "保存文件信息表信息" )
    public R save(@RequestBody BlogFile blogFile){
        boolean retFlag = fileService.insert(blogFile);
        if (!retFlag) {
            return R.error(MessageSourceUtil.getMessage("500"));
        }
        return R.ok();
    }

    /**
     * 修改
     */
    @PostMapping("/update" )
    @ApiOperation(value = "文件信息表", notes = "更新文件信息表信息" )
    public R update(@RequestBody BlogFile blogFile){
        boolean retFlag = fileService.updateById(blogFile);
        if (!retFlag) {
            return R.error(MessageSourceUtil.getMessage("500"));
        }
        return R.ok();
    }

    /**
     * 上传文件
     * @return
     */
    @PostMapping("/uploadFile" )
    @ApiOperation(value = "上传文件", notes = "上传文件" )
    public R uploadFile(@RequestParam("file") MultipartFile file){
        if (file == null){
            throw new CustomException("上传失败",708);
        }
        return fileService.uploadFile(file);
    }

    /**
     * 通过资源id，下载文件
     * @param resourceId
     * @param response
     */
    @RequestMapping("/downloadFile" )
    @ApiOperation(value = "通过资源id，下载文件", notes = "通过资源id，下载文件" )
    public void downloadFile(Integer resourceId, HttpServletResponse response) throws Exception {
        //查询资源信息
        BlogResourceInfo resourceInfo = resourceInfoService.selectById(resourceId);
        //查询文件信息
        BlogFile blogFile = fileService.selectById(resourceInfo.getFileId());
        //设置文件名称，资源名称 + 文件名称
        blogFile.setFileName(resourceInfo.getResourceName() + "-" + blogFile.getFileName());
        //下载文件
        fileService.downloadFile(blogFile, response);
    }
}
