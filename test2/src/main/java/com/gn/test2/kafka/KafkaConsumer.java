package com.gn.test2.kafka;

import com.gn.common.constant.CommonConstant;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumer {

    @KafkaListener(topics = CommonConstant.PULL_DATA_SERVICE_TOPIC, groupId = "pulldata_service_customer")
    public void pulldataService(String message) {
        System.out.println("pulldata_service_customer接收到消息：" + message);
    }

}
