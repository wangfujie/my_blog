package com.blog.index.config;

import com.alibaba.fastjson.JSON;
import com.blog.common.utils.CustomException;
import com.blog.common.utils.WebUtil;
import com.blog.index.utils.RedisUtils;
import org.apache.catalina.connector.RequestFacade;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * @author wangfj
 * @date 2018-11-19
 * @description 防止表单重复提交拦截器，限制同一个ip请求次数-基于Redis缓存
 */
@Component
@Profile({"pro"})
public class ProtectCommitInterceptor extends HandlerInterceptorAdapter {
    @Autowired
    private RedisUtils redisUtils;
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    /**
     * 请求方法设置，post
     */
    private static String REQUEST_METHOD = "post";
    /**
     * 限制提交时间
     */
    @Value("${commit.time-out-time}")
    private long timeOutTime;
    /**
     * 限制时间内的，限制提交次数
     */
    @Value("${commit.commit-count}")
    private long commitCount;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (request instanceof RequestFacade) {
            RequestFacade requestFacade = (RequestFacade) request;
            //获取请求类型
            String method = requestFacade.getMethod();
            //获取请求地址
            String requestURI = requestFacade.getRequestURI();
            //获取ip地址
            String ipAddress = WebUtil.getRealIpAddress(request);
            //post请求才限制
            if (REQUEST_METHOD.equalsIgnoreCase(method)) {
                //拦截请求频率过高的请求，redis计数
                String requestKey = ipAddress + requestURI;
                long thisCount = redisUtils.setMyIncr(requestKey, 1 , timeOutTime);
                //如果在指定时间内请求次数超过限制值，则返回异常
                if (thisCount > commitCount){
                    logger.info("同一ip请求频率过高:" + requestKey);
                    throw new CustomException(timeOutTime + "秒内你的请求频率过高，过会儿再试");
                }
                //获取post的提交内容
                Map<String, String[]> parameterMap = requestFacade.getParameterMap();
                //拼接redis要存入的key
                StringBuilder key = new StringBuilder(requestURI);
                key.append(ipAddress).append(JSON.toJSONString(parameterMap));
                String value = redisUtils.get(key.toString());
                if (StringUtils.hasLength(value)) {
                    logger.info("发现重复记录:" + key.toString());
                    throw new CustomException(timeOutTime + "秒内不能重复提交");
                } else {
                    //未发现重复记录，添加参数缓存，有效期timeOutTime
                    redisUtils.set(key.toString(), key.toString(), timeOutTime);
                }
            }
        }
        return true;
    }
}
