package com.gn.test1.xxljob;

import com.gn.common.constant.CommonConstant;
import com.xxl.job.core.handler.annotation.XxlJob;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Slf4j
@Component
public class PullDataHandle {

    @Resource
    private KafkaTemplate<String, String> kafkaTemplate;

    @XxlJob("pullDataHandle")
    public void pullDataHandle(String param) {
        log.info("拉取数据任务开始执行，参数：{}", param);
        kafkaTemplate.send(CommonConstant.PULL_DATA_SERVICE_TOPIC, "test");
        log.info("拉取数据任务执行结束，参数：{}", param);
    }
}
