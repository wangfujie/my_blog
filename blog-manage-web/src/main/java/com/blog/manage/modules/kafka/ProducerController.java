package com.blog.manage.modules.kafka;

import com.alibaba.fastjson.JSON;
import com.blog.common.result.R;
import com.blog.manage.modules.treatise.service.IBlogTreatiseService;
import com.blog.pojo.entity.BlogTreatise;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wangfujie
 * @date 2018-10-30 16:30
 * @description 生产者Controller
 */
@RestController
@RequestMapping("/kafka")
public class ProducerController {

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private KafkaTemplate kafkaTemplate;

    @Autowired
    private IBlogTreatiseService treatiseService;

    @Value("${kafka.topic.topicName}")
    private String topicName;

    /**
     * 发生文章消息
     * @return
     */
    @RequestMapping(value = "/sendTreatiseList")
    public R syncTreatiseSendMsg() {
        List<BlogTreatise> treatiseList = treatiseService.selectList(null);
        try {
            Map<String,Object> map = new HashMap<>(1);
            map.put("treatiseList", treatiseList);
            for (int i = 0 ; i < 1 ; i++){
                ProducerRecord collectTopicMsg = new ProducerRecord (topicName, null, JSON.toJSONString(treatiseList));
                kafkaTemplate.send(collectTopicMsg);
                logger.info("发送kafka消息={}", JSON.toJSONString(treatiseList) );
            }
            return R.ok();
        } catch (Exception e) {
            logger.error("发送kafka失败：" + e);
            return R.error("失败" + e);
        }
    }
}
