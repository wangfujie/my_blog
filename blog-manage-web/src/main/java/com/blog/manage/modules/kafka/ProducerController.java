package com.blog.manage.modules.kafka;

import com.blog.common.result.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wangfujie
 * @date 2018-10-30 16:30
 * @description 生产者Controller
 */
@RestController
@RequestMapping("/kafka")
public class ProducerController {

/*    @Autowired
    private KafkaTemplate kafkaTemplate;

    @RequestMapping(value = "/send", method = RequestMethod.GET)
    public R sendKafka(@RequestParam("message") String message) {
        try {
            kafkaTemplate.send("topic_1", "key", message);
            System.out.println("发送kafka成功:" + message);
            return R.ok("发送kafka成功：" + message);
        } catch (Exception e) {
            e.printStackTrace();
            return R.error("发送kafka失败：" + message);
        }
    }*/
}
