package com.blog.index.modules.record.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.blog.common.result.R;
import com.blog.common.utils.DateUtils;
import com.blog.common.utils.WebUtil;
import com.blog.index.modules.other.service.IBlogTreatiseService;
import com.blog.index.modules.other.service.IBlogWebInfoService;
import com.blog.index.modules.record.mapper.BlogLogRecordMapper;
import com.blog.index.modules.record.service.IBlogLogRecordService;
import com.blog.index.utils.RedisUtils;
import com.blog.pojo.entity.BlogLogRecord;
import com.blog.pojo.entity.BlogTreatise;
import com.blog.pojo.entity.BlogWebInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * @author wangfj
 * @date 2018-10-25
 * @description 日志记录 服务接口实现类
 */
@Service
@Transactional
public class BlogLogRecordServiceImpl extends ServiceImpl<BlogLogRecordMapper, BlogLogRecord> implements IBlogLogRecordService {

    @Autowired
    private IBlogWebInfoService webInfoService;
    @Autowired
    private IBlogTreatiseService treatiseService;
    @Autowired
    private RedisUtils redisUtils;

    /**
     * 增加日志记录信息
     *
     * @param blogLogRecord
     * @param request
     * @return
     */
    @Override
    public R addBlogLogRecord(BlogLogRecord blogLogRecord, HttpServletRequest request) {
        //获取当前时间
        Date now = new Date();
        //获取访问ip地址
        String ipAddress = WebUtil.getRealIpAddress(request);
        switch (blogLogRecord.getRecordType()){
            case 1:
                //文章点赞记录
                //查询该ip是今日否点过赞
                //拼接redis的key
                String redisKey = blogLogRecord.getTreatiseUuid() + ipAddress;

                //获取redis，存的临时ip和uuid
                String record = redisUtils.get(redisKey);
                if (StringUtils.isEmpty(record)){
                    //存入记录ip和uuid，默认24小时过期
                    redisUtils.set(redisKey,"点击时间：" + DateUtils.formatYmdHms(new Date()));
                }else {
                    return R.error("谢谢支持，今天已经赞过这篇了");
                }
                //修改文章点赞总数量
                BlogTreatise blogTreatise = treatiseService.selectById(blogLogRecord.getTreatiseUuid());
                if (blogTreatise != null) {
                    Integer praiseNum = blogTreatise.getPraiseNum();
                    blogTreatise.setPraiseNum(praiseNum != null ? praiseNum + 1 : 1);
                    treatiseService.updateById(blogTreatise);
                }
                break;
            case 2:
                //文章浏览记录
                //这一操作已经在查询那里操作了，这里只添加记录
                break;
            case 3:
                //网站浏览记录
                BlogWebInfo webInfo = getWebInfoByDate(DateUtils.formatYmd(now));
                if (webInfo != null){
                    webInfo.setWebBrowseNum(webInfo.getWebBrowseNum() + 1);
                    webInfoService.updateById(webInfo);
                }else {
                    webInfo = new BlogWebInfo();
                    webInfo.setWebSummary(DateUtils.formatYmd(now) + "的记录统计信息");
                    webInfo.setWebBrowseNum(1);
                    webInfo.setUpdateTime(now);
                    webInfoService.insert(webInfo);
                }
                break;
            default:break;
        }
        blogLogRecord.setIpAddress(ipAddress);
        blogLogRecord.setCreateTime(now);
        //新增记录
        insert(blogLogRecord);
        return R.ok("谢谢支持，感谢点赞");
    }

    /**
     * 按照时间查询网站浏览信息汇总
     * @return
     */
    private BlogWebInfo getWebInfoByDate(String today){
        return webInfoService.selectOne(new EntityWrapper<BlogWebInfo>().eq("update_time", today));
    }

    /**
     * 检查ip是否今日已经记录了
     */
    private boolean checkIpRecord(String ipAddress, Integer recordType, String treatiseUuid, String nowDate){
        Wrapper wrapper = new EntityWrapper<BlogLogRecord>();
        wrapper.eq("ip_address",ipAddress);
        wrapper.eq("record_type",recordType);
        if (!StringUtils.isEmpty(treatiseUuid)){
            wrapper.eq("treatise_uuid",treatiseUuid);
        }
        wrapper.like("create_time", nowDate);
        //查询该ip是今日否点过赞
        Integer recordNum = selectCount(wrapper);
        return (recordNum != null && recordNum > 0);
    }
}