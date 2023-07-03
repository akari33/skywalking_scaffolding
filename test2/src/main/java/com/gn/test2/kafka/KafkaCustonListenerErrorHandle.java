package com.gn.test2.kafka;

import org.apache.skywalking.apm.toolkit.trace.TraceContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.listener.ConsumerAwareListenerErrorHandler;

@Configuration
public class KafkaCustonListenerErrorHandle {

    @Bean
    public ConsumerAwareListenerErrorHandler listenerErrorHandler() {
        return (message, exception, consumer) -> {
            System.out.println("消费异常：" + message.getPayload() + "   " + TraceContext.traceId());
//            throw new RuntimeException("消费异常：" + message.getPayload() + TraceContext.traceId());
            return null;
        };
    }
}
