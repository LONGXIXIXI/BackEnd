package com.shaoyi.springiocdemo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PropertiesController {
    //使用@Value注解来读取配置文件中的内容
    @Value("${mykey.key1}")
    private String key1;

    @RequestMapping("/key")
    public String key(){
        return "读取到值:" + key1;
    }

}
