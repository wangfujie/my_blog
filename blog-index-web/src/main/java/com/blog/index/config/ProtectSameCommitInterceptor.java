package com.blog.index.config;

import com.alibaba.fastjson.JSON;
import com.blog.common.utils.RRException;
import com.blog.index.utils.RedisUtils;
import org.apache.catalina.connector.RequestFacade;
import org.apache.shiro.util.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * @author wangfj
 * @date 2018-11-19
 * @description 防止表单重复提交拦截器-基于Redis缓存
 */
@Component
public class ProtectSameCommitInterceptor extends HandlerInterceptorAdapter {
    @Autowired
    private RedisUtils redisUtils;
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Value("${samecommit.time-out-time}")
    private long timeOutTime;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (request instanceof RequestFacade) {
            RequestFacade requestFacade = (RequestFacade) request;
            String requestURI = requestFacade.getRequestURI();
            String method = requestFacade.getMethod();

            if ("post".equalsIgnoreCase(method)) {
                Map<String, String[]> parameterMap = requestFacade.getParameterMap();
                StringBuilder key = new StringBuilder(requestURI);
                key.append(JSON.toJSONString(parameterMap));
                String value = redisUtils.get(key.toString());
                if (StringUtils.hasLength(value)) {
                    logger.info("发现重复记录:" + key.toString());
                    throw new RRException(timeOutTime + "秒内不能重复提交");
                } else {
                    logger.info("未发现重复记录:" + key.toString());
                    redisUtils.set(key.toString(), key.toString(), timeOutTime);
                    return true;
                }
            } else {
                return true;
            }
        } else {
            return true;
        }

    }
}
