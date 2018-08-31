package com.blog.index.modules.system.controller;

import com.blog.common.result.R;
import com.blog.index.utils.RedisUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Date;
import java.util.Map;

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
        Map map = new HashedMap();
        map.put("currentDateTime", new Date());
        return R.fillSingleData(map);
    }

    @GetMapping("testRedis")
    @ApiOperation(value = "redis测试")
    public R testRedis(String key , String value){
        if (!StringUtils.isEmpty(value)){
            redisUtils.set(key, value);
        }
        return R.ok(redisUtils.get(key));
    }
}
