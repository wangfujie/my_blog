package com.blog.manage.modules.others.controller;

import com.blog.manage.modules.others.service.IBlogAboutMeService;
import com.blog.pojo.entity.BlogAboutMe;
import com.blog.common.utils.MessageSourceUtil;
import com.blog.common.result.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.*;

/**
 * @author wangfj
 * @date 2018-09-10
 * @description 关于我 前端控制器
 */
@RestController
@RequestMapping("/blogAboutMe" )
@Api(value = "关于我接口",tags = "用作关于我演示")
public class BlogAboutMeController {

    @Autowired
    private IBlogAboutMeService iBlogAboutMeService;

    /**
     * 信息
     */
    @GetMapping("/info/{id}" )
    @ApiOperation(value = "关于我", notes = "获取关于我详情信息" )
    public R info(@PathVariable("id" ) Integer id){
        BlogAboutMe blogAboutMe = iBlogAboutMeService.selectById(id);
        if (blogAboutMe == null) {
            return R.notFound();
        }
        return R.fillSingleData(blogAboutMe);
    }

    /**
     * 新增或修改
     */
    @PostMapping("/insertOrUpdate" )
    @ApiOperation(value = "关于我,新增或修改", notes = "新增或修改关于我信息" )
    public R insertOrUpdate(BlogAboutMe blogAboutMe){
        boolean retFlag = iBlogAboutMeService.insertOrUpdate(blogAboutMe);
        if (!retFlag) {
            return R.error(MessageSourceUtil.getMessage("500"));
        }
        return R.ok();
    }
}
