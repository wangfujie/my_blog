package com.blog.index.modules.system.controller;

import com.blog.common.result.R;
import com.blog.common.utils.DateUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Date;

/**
 * @author wangfujie
 * @date 2018-08-10 16:10
 * @description 系统的配置信息
 */
@RestController
@RequestMapping("/sys/config")
@Api(value = "系统的配置信息", tags = "系统的配置信息")
public class SysConfigController {


    @GetMapping("/time")
    @ApiOperation(value = "获取系统时间")
    public R getSystemTime() {
        return R.ok().put("currentDateTime", DateUtils.formatYmdHms(new Date()));
    }
}
