package com.gn.test1.controller;

import com.gn.common.constant.CommonConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pulldata")
public class PullDataTestController {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @RequestMapping("/test")
    public String test() {
        kafkaTemplate.send(CommonConstant.PULL_DATA_SERVICE_TOPIC, "2023-01-01");
        return "success";
    }
}
