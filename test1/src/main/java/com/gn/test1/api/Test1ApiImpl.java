package com.gn.test1.api;

import com.gn.common.api.Test1Api;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboService;

import java.util.Map;
import java.util.Objects;

@Slf4j
@DubboService(timeout = 1200000)
public class Test1ApiImpl implements Test1Api {

    @Override
    public Map<String, Objects> sendTest1Task(String date) {
        log.info("Test1ApiImpl.sendTest1Task() called with: date = [{}]", date);
        return null;
    }
}
