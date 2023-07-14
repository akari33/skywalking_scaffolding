package com.gn.test2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableDiscoveryClient
@ComponentScan(basePackages = {"com.gn.common", "com.gn.test2"})
public class Test2Application {

//    @DubboReference
//    private Test1Api test1Api;
//
//    @PostConstruct
//    public void init() {
//        for (int i = 0; i < 10; i++) {
//            System.out.println(test1Api.sendTest1Task("Nacos"));
//        }
//    }

    public static void main(String[] args) {
        SpringApplication.run(Test2Application.class, args);
    }

}
