package com.blog.index.modules.other.controller;

import com.blog.common.utils.RandomUtils;
import com.blog.common.utils.WebUtil;
import com.blog.pojo.entity.BlogLeaveMessage;
import com.blog.index.modules.other.service.IBlogLeaveMessageService;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.blog.common.query.BaseQuery;
import com.blog.common.utils.MessageSourceUtil;
import com.blog.common.result.R;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.*;
import springfox.documentation.annotations.ApiIgnore;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * @author wangfj
 * @date 2018-08-16
 * @description 留言表 前端控制器
 */
@RestController
@RequestMapping("/blogLeaveMessage" )
@Api(value = "留言表接口",description = "用作留言表演示")
public class BlogLeaveMessageController {

    @Autowired
    private IBlogLeaveMessageService iBlogLeaveMessageService;

    /**
     * 列表
     */
    @GetMapping("/list" )
    @RequiresPermissions("blogLeaveMessage:list" )
    @ApiOperation(value = "留言表", notes = "获取留言表分页列表" )
    @ApiImplicitParams({
            @ApiImplicitParam(name = "currentPage", value = "当前页码", paramType = "query" ),
            @ApiImplicitParam(name = "pageSize", value = "每页条数", paramType = "query" )
    })
    public R list(@ApiIgnore BaseQuery baseQuery){
            //查询列表数据
            Page page=new Page(baseQuery.getCurrentPage(),baseQuery.getPageSize());
            Page pageList=iBlogLeaveMessageService.selectPage(page,
                    new EntityWrapper<BlogLeaveMessage>()
                            .eq("status",1)
                            .orderBy("create_time",false));
            if (CollectionUtils.isEmpty(pageList.getRecords())) {
                return R.notFound();
            }
            return R.fillPageData(pageList);
    }

    /**
     * 保存
     */
    @PostMapping("/save" )
    @ApiOperation(value = "留言表", notes = "保存留言表信息" )
    public R save(@RequestBody BlogLeaveMessage blogLeaveMessage, HttpServletRequest request){
        //设置随机头像数字
        blogLeaveMessage.setHeadImgNum(RandomUtils.getRandomNum(1,16));
        blogLeaveMessage.setCreateTime(new Date());
        //获取访问ip地址
        blogLeaveMessage.setIpAddress(WebUtil.getRealIpAddress(request));
        boolean retFlag = iBlogLeaveMessageService.insert(blogLeaveMessage);
        if (!retFlag) {
            return R.error(MessageSourceUtil.getMessage("500"));
        }
        return R.ok();
    }

}
