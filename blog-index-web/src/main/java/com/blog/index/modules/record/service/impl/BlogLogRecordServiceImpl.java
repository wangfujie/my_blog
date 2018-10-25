package com.blog.index.modules.record.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.blog.common.result.R;
import com.blog.common.utils.DateUtils;
import com.blog.common.utils.IpAddressUtil;
import com.blog.index.modules.other.service.IBlogWebInfoService;
import com.blog.index.modules.record.mapper.BlogLogRecordMapper;
import com.blog.index.modules.record.service.IBlogLogRecordService;
import com.blog.pojo.entity.BlogLogRecord;
import com.blog.pojo.entity.BlogWebInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
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

    /**
     * 增加日志记录信息
     *
     * @param blogLogRecord
     * @param request
     * @return
     */
    @Override
    public R addBlogLogRecord(BlogLogRecord blogLogRecord, HttpServletRequest request) {
        //获取访问ip地址
        String ipAddress = IpAddressUtil.getRealIpAddress(request);
        switch (blogLogRecord.getRecordType()){
            case 1:
                //网站浏览记录
                break;
            case 2:
                //文章浏览记录
                break;
            case 3:
                //文章点赞记录
                if (blogLogRecord.getRecordType() == 3){
                    //查询该ip是今日否点过赞
                    Integer recordNum = selectCount(new EntityWrapper<BlogLogRecord>()
                            .eq("ip_address",ipAddress)
                            .eq("record_type",3)
                            .like("create_time",DateUtils.formatYmd(new Date()))
                    );
                    if (recordNum != null && recordNum > 0){
                        return R.error("谢谢您的支持，今天已经赞过了");
                    }
                }
                break;
            default:break;
        }
        blogLogRecord.setIpAddress(ipAddress);
        blogLogRecord.setCreateTime(new Date());
        //新增记录
        insert(blogLogRecord);
        return R.ok("谢谢您的支持");
    }

    /**
     * 按照时间查询网站浏览信息汇总
     * @return
     */
    private BlogWebInfo getWebInfoByDate(String today){
        return webInfoService.selectOne(new EntityWrapper<BlogWebInfo>());
    }
}