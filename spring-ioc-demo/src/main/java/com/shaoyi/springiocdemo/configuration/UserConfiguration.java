package com.shaoyi.springiocdemo.configuration;


import org.springframework.context.annotation.Configuration;

//配置存储:配置层，处理项目中的一些配置信息
@Configuration
public class UserConfiguration {

    public void sayHi(){
        System.out.println("Hello, User Configuration!");
    }
}
