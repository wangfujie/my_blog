package com.blog.index.modules.other.controller;

import com.blog.index.modules.other.query.BlogTreatiseQuery;
import com.blog.index.modules.other.vo.BlogTreatiseVo;
import com.blog.pojo.entity.BlogTreatise;
import com.blog.index.modules.other.service.IBlogTreatiseService;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.blog.common.query.BaseQuery;
import com.blog.common.utils.MessageSourceUtil;
import com.blog.common.result.R;
import org.apache.commons.collections.CollectionUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.*;
import springfox.documentation.annotations.ApiIgnore;
import javax.annotation.Resource;
import java.util.List;

/**
 * @author wangfj
 * @date 2018-08-16
 *  文章详情表 前端控制器
 */
@RestController
@RequestMapping("/blogTreatise" )
@Api(value = "文章详情表接口",description = "用作文章详情表演示")
public class BlogTreatiseController {

    @Resource
    private IBlogTreatiseService treatiseService;

    /**
     * 列表
     */
    @GetMapping("/list" )
    @RequiresPermissions("blogTreatise:list" )
    @ApiOperation(value = "文章详情表", notes = "获取文章详情表分页列表" )
    @ApiImplicitParams({
            @ApiImplicitParam(name = "currentPage", value = "当前页码", paramType = "query" ),
            @ApiImplicitParam(name = "pageSize", value = "每页条数", paramType = "query" ),
            @ApiImplicitParam(name = "categoryId", value = "分类ID", paramType = "query" ),
            @ApiImplicitParam(name = "tagInfo", value = "标签信息", paramType = "query" ),
            @ApiImplicitParam(name = "keyWord", value = "关键词", paramType = "query" )
    })
    public R list(@ApiIgnore BlogTreatiseQuery treatiseQuery){
            //查询列表数据
            Page<BlogTreatiseVo> page=new Page<>(treatiseQuery.getCurrentPage(),treatiseQuery.getPageSize());
            Page<BlogTreatiseVo> pageList=treatiseService.getTreatisePage(page,treatiseQuery);
            if (CollectionUtils.isEmpty(pageList.getRecords())) {
                return R.notFound();
            }
            return R.fillPageData(pageList);
    }

    /**
     * 获取文章推荐列表
     */
    @GetMapping("/getRecommend" )
    @ApiOperation(value = "文章推荐", notes = "获取文章推荐列表" )
    public R getRecommend(){
        //查询列表数据
        List<BlogTreatise> treatiseList=treatiseService.selectList(
                new EntityWrapper<BlogTreatise>()
                        .eq("del_flag",0)
                        .eq("recommend",1)
                        .orderBy("create_time",false));
        if (CollectionUtils.isEmpty(treatiseList)) {
            return R.notFound();
        }
        return R.fillListData(treatiseList);
    }

    /**
     * 获取阅读排行
     */
    @GetMapping("/getReadRanking" )
    @ApiOperation(value = "获取阅读排行", notes = "获取阅读排行" )
    @ApiImplicitParams({
            @ApiImplicitParam(name = "currentPage", value = "当前页码", paramType = "query" ),
            @ApiImplicitParam(name = "pageSize", value = "每页条数", paramType = "query" )
    })
    public R getReadRanking(@ApiIgnore BaseQuery baseQuery){
        //查询列表数据
        Page<BlogTreatise> page = new Page<>(baseQuery.getCurrentPage(),baseQuery.getPageSize());
        Page<BlogTreatise> pageList=treatiseService.selectPage(page,
                new EntityWrapper<BlogTreatise>()
                        .eq("del_flag",0)
                        .orderBy("read_num",false));
        if (CollectionUtils.isEmpty(pageList.getRecords())) {
            return R.notFound();
        }
        return R.fillPageData(pageList);
    }

    /**
     * 信息
     */
    @GetMapping("/info/{uuid}" )
    @RequiresPermissions("blogTreatise:info" )
    @ApiOperation(value = "文章详情表", notes = "获取文章详情表详情信息" )
    public R info(@PathVariable("uuid" ) String uuid){
        BlogTreatiseVo blogTreatise = treatiseService.getBlogTreatiseVoById(uuid);
        if (blogTreatise == null) {
            return R.notFound();
        }
        return R.fillSingleData(blogTreatise);
    }

    /**
     * 保存
     */
    @PostMapping("/save" )
    @RequiresPermissions("blogTreatise:save" )
    @ApiOperation(value = "文章详情表", notes = "保存文章详情表信息" )
    public R save(@RequestBody BlogTreatise blogTreatise){
        boolean retFlag = treatiseService.insert(blogTreatise);
        if (!retFlag) {
            return R.error(MessageSourceUtil.getMessage("500"));
        }
        return R.ok();
    }

    /**
     * 修改
     */
    @PostMapping("/update" )
    @RequiresPermissions("blogTreatise:update" )
    @ApiOperation(value = "文章详情表", notes = "更新文章详情表信息" )
    public R update(@RequestBody BlogTreatise blogTreatise){
        boolean retFlag = treatiseService.updateById(blogTreatise);
        if (!retFlag) {
            return R.error(MessageSourceUtil.getMessage("500"));
        }
        return R.ok();
    }

    /**
     * 删除
     */
    @PostMapping("/delete/{uuid}" )
    @RequiresPermissions("blogTreatise:delete" )
    @ApiOperation(value = "文章详情表", notes = "删除文章详情表信息" )
    public R delete(@PathVariable("uuid" ) String uuid){
        boolean retFlag = treatiseService.deleteById(uuid);
        if (!retFlag) {
            return R.error(MessageSourceUtil.getMessage("500"));
        }
        return R.ok();
    }
}
