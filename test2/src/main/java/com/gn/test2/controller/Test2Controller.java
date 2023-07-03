package com.gn.test2.controller;

import com.gn.common.api.Test1Api;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test2")
public class Test2Controller {

    @DubboReference
    private Test1Api test1Api;

    @RequestMapping("/test")
    public void test() {
        test1Api.sendTest1Task("test2");
    }

}
