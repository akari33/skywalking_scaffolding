package com.gn.test2.kafka;

import com.gn.common.api.Test1Api;
import com.gn.common.constant.CommonConstant;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class KafkaConsumer {

    @DubboReference
    private Test1Api test1Api;

    //    @RetryableTopic
    @KafkaListener(topics = CommonConstant.PULL_DATA_SERVICE_TOPIC, groupId = "pulldata_service_customer", errorHandler = "listenerErrorHandler")
    public void pulldataService(String message) {
        System.out.println("pulldata_service_customer接收到消息：" + message);
        test1Api.sendTest1Task(message);
//        testDatapull(message);
    }


//    @DltHandler
//    public void dltHandler(ConsumerRecord<String, String> record) {
//        //这里可以将错误放入数据库（用来第二天早上在后台系统进行人工兜底），并且通过im预警
//        //获取skywalking的traceid
//        String traceId = TraceContext.traceId();
//        log.error("traceId:{},消费失败，topic:{},partition:{},offset:{},key:{},value:{}",
//                traceId, record.topic(), record.partition(), record.offset(), record.key(), record.value());
//        log.debug("模拟存入数据库");
//    }

    private void testDatapull(String message) {
        //这里假设重试了三次，都异常然后直接抛出异常
        for (int i = 0; i < 3; i++) {
            log.debug("模拟重试第{}次", i + 1);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        throw new RuntimeException("拉取数据失败" + message);
    }
}

