package com.blog.index.modules.other.controller;

import cn.hutool.core.date.DateUtil;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.blog.common.query.BaseQuery;
import com.blog.common.result.R;
import com.blog.common.utils.MessageSourceUtil;
import com.blog.index.modules.other.query.BlogTreatiseQuery;
import com.blog.index.modules.other.service.IBlogTreatiseService;
import com.blog.index.modules.other.vo.BlogTreatiseVo;
import com.blog.index.modules.record.service.IBlogLogRecordService;
import com.blog.pojo.entity.BlogLogRecord;
import com.blog.pojo.entity.BlogTreatise;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.collections.CollectionUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.*;

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
    @Resource
    private IBlogLogRecordService logRecordService;

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
     * 获取时间轴列表
     */
    @GetMapping("/getTimeAxis" )
    @ApiOperation(value = "文章详情表", notes = "获取文章详情表分页列表" )
    public R getTimeAxis(@ApiIgnore BlogTreatiseQuery treatiseQuery){
        //分页查询数据
        Page<BlogTreatiseVo> page=new Page<>(treatiseQuery.getCurrentPage(),treatiseQuery.getPageSize());
        page = treatiseService.getTreatisePage(page,treatiseQuery);
        //获取本页数据
        List<BlogTreatiseVo> blogTreatiseList = page.getRecords();
        //按月归档
        List<Map<String,Object>> newBlogList = new ArrayList<>();
        Map<String, List<BlogTreatise>> monthMapBlog = new LinkedHashMap<>();
        blogTreatiseList.forEach(blogTreatiseVo -> {
            String dateMonth = DateUtil.format(blogTreatiseVo.getCreateTime(),"yyyy年MM月");
            if (monthMapBlog.containsKey(dateMonth)){
                monthMapBlog.get(dateMonth).add(blogTreatiseVo);
            }else {
                List<BlogTreatise> monthList = new ArrayList<>();
                monthList.add(blogTreatiseVo);
                monthMapBlog.put(dateMonth, monthList);
            }
        });
        monthMapBlog.keySet().forEach(key -> {
            Map<String,Object> newMap = new HashMap<>();
            newMap.put("type", 1);
            newMap.put("dateMonth", key);
            newMap.put("number", monthMapBlog.get(key).size());
            newBlogList.add(newMap);
            monthMapBlog.get(key).forEach(blogTreatiseVo -> {
                Map<String,Object> newMap2 = new HashMap<>();
                newMap2.put("type", 2);
                newMap2.put("blogTreatise", blogTreatiseVo);
                newBlogList.add(newMap2);
            });
        });
        //设置新分页数据
        Page<Map<String,Object>> newBlogPage=new Page<>(treatiseQuery.getCurrentPage(),treatiseQuery.getPageSize());
        newBlogPage.setRecords(newBlogList);
        newBlogPage.setTotal(page.getTotal());
        return R.fillPageData(newBlogPage);
    }

    /**
     * 信息
     */
    @GetMapping("/info/{uuid}" )
    @RequiresPermissions("blogTreatise:info" )
    @ApiOperation(value = "文章详情表", notes = "获取文章详情表详情信息" )
    public R info(@PathVariable("uuid" ) String uuid, HttpServletRequest request){
        BlogTreatiseVo blogTreatise = treatiseService.getBlogTreatiseVoById(uuid);
        //文章增加阅读数量
        if (blogTreatise != null) {
            Integer readNum = blogTreatise.getReadNum();
            blogTreatise.setReadNum(readNum != null ? readNum + 1 : 1);
            //使阅读数量+1
            treatiseService.updateById(blogTreatise);
            //增加阅读记录
            BlogLogRecord logRecord = new BlogLogRecord();
            logRecord.setRecordType(2);
            logRecord.setTreatiseUuid(uuid);
            logRecordService.addBlogLogRecord(logRecord, request);
        }
        return R.fillSingleData(blogTreatise);
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
