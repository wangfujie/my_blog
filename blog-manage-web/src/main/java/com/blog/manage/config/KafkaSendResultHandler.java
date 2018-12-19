package com.blog.manage.config;

import org.apache.kafka.clients.producer.RecordMetadata;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.support.ProducerListener;
import org.springframework.stereotype.Component;

/**
 * @author wangfj
 * @date 2018-12-19 17:33
 * @description 消息结果回调类
 */
@Component
public class KafkaSendResultHandler implements ProducerListener {

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public void onSuccess(String s, Integer integer, Object o, Object o2, RecordMetadata recordMetadata) {
        logger.info("Message send success : " + s);
    }

    @Override
    public void onError(String s, Integer integer, Object o, Object o2, Exception e) {
        logger.info("Message send error : " + s);
    }

    @Override
    public boolean isInterestedInSuccess() {
        return false;
    }
}
