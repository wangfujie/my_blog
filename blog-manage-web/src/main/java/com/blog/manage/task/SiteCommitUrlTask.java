package com.blog.manage.task;

import cn.hutool.http.HttpUtil;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.blog.manage.modules.treatise.service.IBlogTreatiseService;
import com.blog.pojo.entity.BlogTreatise;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import java.util.List;

/**
 * @author wangfj
 * @date 2019-06-28 16:17
 * @description seo百度提交链接
 */
@Component
public class SiteCommitUrlTask {

    private static final Logger log = LoggerFactory.getLogger(SiteCommitUrlTask.class);
    public static final String urlPrefix = "https://blog.wwolf.wang/detail/";
    public static final String commitUrl = "http://data.zz.baidu.com/urls?site=https://blog.wwolf.wang&token=41yNdFtZz949DxDk";

    @Autowired
    private IBlogTreatiseService treatiseService;

    /**
     * 百度提交链接定时任务
     */
    @Scheduled(cron = "${baidu.commitUrls.syncTime}")
//    @Scheduled(cron = "0 0/2 * * * ?")
    public void baiduCommitUrls(){
        //查询所有文章博客
        List<BlogTreatise> treatiseList = treatiseService.selectList(
                new EntityWrapper<BlogTreatise>().eq("del_flag",0));
        if (treatiseList != null && treatiseList.size() > 0){
            for (BlogTreatise blogTreatise : treatiseList){
                String url = SiteCommitUrlTask.urlPrefix + blogTreatise.getUuid();
                //调用请求
                String result = HttpUtil.post(SiteCommitUrlTask.commitUrl, url);
                //处理返回值
                log.info("百度链接定时提交 ==> url:" + url + ",result:" + result);
            }
            log.info("百度链接定时提交成功：共（" + treatiseList.size() + "）条");
        }

    }
}
