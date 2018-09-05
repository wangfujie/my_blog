package com.blog.index.modules.system.controller;

import com.blog.common.result.R;
import com.blog.common.utils.DateUtils;
import com.blog.index.utils.RedisUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
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
@Api(value = "系统的配置信息", description = "系统的配置信息")
public class SysConfigController {

    @Autowired
    private RedisUtils redisUtils;

    @GetMapping("/time")
    @ApiOperation(value = "获取系统时间")
    public R getSystemTime() {
        return R.ok().put("currentDateTime", DateUtils.formatYmdHms(new Date()));
    }

    @GetMapping("testRedis")
    @ApiOperation(value = "redis测试")
    public R testRedis(String key , String value){
        String result = "查询";
        if (!StringUtils.isEmpty(value)){
            result = "新增";
            redisUtils.set(key, value);
        }
        return R.ok(result + " --> " + key + ":" + redisUtils.get(key));
    }
}
