package com.kgc.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.kgc.service.HelloService;
import org.springframework.stereotype.Component;

@Service(interfaceClass = HelloService.class)
@Component
public class HelloServiceImpl implements HelloService {
    @Override
    public String getHello() {
        return "HelloWorld";
    }
}
