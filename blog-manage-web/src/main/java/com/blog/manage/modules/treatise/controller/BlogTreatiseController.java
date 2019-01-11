package com.blog.manage.modules.treatise.controller;

import com.blog.manage.common.result.ResultLay;
import com.blog.manage.modules.others.service.IBlogTagsService;
import com.blog.manage.modules.treatise.query.BlogTreatiseQuery;
import com.blog.manage.modules.treatise.service.IBlogTreatiseService;
import com.blog.manage.modules.treatise.vo.BlogTreatiseVo;
import com.blog.pojo.entity.BlogTreatise;
import com.baomidou.mybatisplus.plugins.Page;
import com.blog.common.utils.MessageSourceUtil;
import com.blog.common.result.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.*;
import springfox.documentation.annotations.ApiIgnore;
import java.util.Date;

/**
 * @author wangfj
 * @date 2018-09-10
 * @description 文章详情表 前端控制器
 */
@RestController
@RequestMapping("/blogTreatise" )
@Api(value = "文章详情表接口",description = "用作文章详情表演示")
public class BlogTreatiseController {

    @Autowired
    private IBlogTreatiseService treatiseService;

    @Autowired
    private IBlogTagsService tagsService;

    /**
     * 列表
     */
    @GetMapping("/list" )
    @ApiOperation(value = "文章详情表", notes = "获取文章详情表分页列表" )
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "当前页码", paramType = "query" ),
            @ApiImplicitParam(name = "limit", value = "每页条数", paramType = "query" ),
            @ApiImplicitParam(name = "categoryId", value = "分类ID", paramType = "query" ),
            @ApiImplicitParam(name = "tagInfo", value = "标签信息", paramType = "query" ),
            @ApiImplicitParam(name = "keyWord", value = "关键词", paramType = "query" )
    })
    public ResultLay list(@ApiIgnore BlogTreatiseQuery treatiseQuery){
        //查询列表数据
        Page<BlogTreatiseVo> page = new Page<>(treatiseQuery.getPage(),treatiseQuery.getLimit());
        return ResultLay.fillPageData(treatiseService.getTreatisePage(page,treatiseQuery));
    }

    /**
     * 信息
     */
    @GetMapping("/info/{uuid}" )
    @ApiOperation(value = "文章详情表", notes = "获取文章详情表详情信息" )
    public R info(@PathVariable("uuid" ) String uuid){
        BlogTreatiseVo blogTreatise = treatiseService.getTreatiseVoById(uuid);
        if (blogTreatise == null) {
            return R.notFound();
        }
        return R.fillSingleData(blogTreatise);
    }

    /**
     *  修改或新增
     */
    @PostMapping("/insertOrUpdate" )
    @ApiOperation(value = "文章详情表", notes = "修改或新增文章详情表信息" )
    public R save(BlogTreatise blogTreatise){
        if (StringUtils.isEmpty(blogTreatise.getUuid())){
            //增加标签使用数量
            tagsService.addTagsUseNum(blogTreatise.getTags());
            blogTreatise.setCreateTime(new Date());
        }
        boolean retFlag = treatiseService.insertOrUpdate(blogTreatise);
        if (!retFlag) {
            return R.error(MessageSourceUtil.getMessage("500"));
        }
        return R.ok();
    }

    /**
     * 删除
     */
    @PostMapping("/delete/{uuid}" )
    @ApiOperation(value = "文章详情表", notes = "删除文章详情表信息" )
    public R delete(@PathVariable("uuid" ) String uuid){
        BlogTreatise blogTreatise = treatiseService.selectById(uuid);
        if (blogTreatise != null){
            blogTreatise.setDelFlag(1);
            boolean retFlag = treatiseService.updateById(blogTreatise);
            if (!retFlag) {
                return R.error(MessageSourceUtil.getMessage("500"));
            }
        }else {
            return R.error("错误的uuid");
        }
        return R.ok();
    }
}
