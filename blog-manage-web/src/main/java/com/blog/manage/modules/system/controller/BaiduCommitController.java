package com.blog.manage.modules.system.controller;

import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson.JSONObject;
import com.blog.common.result.R;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wangfj
 * @date 2019-06-28 14:40
 * @description DESCRIPTION
 */
@RestController
@RequestMapping("/baidu")
public class BaiduCommitController {

    private static final String urlPrefix = "https://blog.wwolf.wang/detail/";
    private static final String commitUrl = "http://data.zz.baidu.com/urls?site=https://blog.wwolf.wang&token=41yNdFtZz949DxDk";

    @PostMapping("/commit/urls")
    public R commitUrls(String uuidList) {
        JSONObject resultJson = new JSONObject();
        Integer remain = 0;
        Integer success = 0;
        String[] uuidArray = uuidList.split(",");
        if (uuidArray.length > 0){
            for (String uuid : uuidArray){
                String url = urlPrefix + uuid;
                //调用请求
                String result = HttpUtil.post(commitUrl, url);
                //处理返回值
                JSONObject resultJsonObject = JSONObject.parseObject(result);
                remain = resultJsonObject.getInteger("remain");
                success += resultJsonObject.getInteger("success");
                System.out.println("百度链接手动提交 ==> url:" + url + ",result:" + result);
            }
        }
        resultJson.put("remain", remain);
        resultJson.put("success", success);
        return R.ok(resultJson.toJSONString());
    }
}
