package com.blog.manage.modules.kafka;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * @author wangfujie
 * @date 2018-10-30 15:33
 * @description kafka消费者controller
 */
@Component
public class ConsumerController {

    @KafkaListener(topics = "topic_1")
    public void listen (ConsumerRecord<?, ?> record) throws Exception {
        System.out.printf("topic = %s, offset = %s, value = %s \n", record.topic(), record.key(), record.value());
    }

    @KafkaListener(topics = "test")
    public void listen2 (ConsumerRecord<?, ?> record) throws Exception {
        System.out.printf("topic = %s, offset = %s, value = %s \n", record.topic(), record.key(), record.value());
    }
}
