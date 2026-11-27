package com.shaoyi.springiocdemo.service;

//服务存储：业务逻辑层，也称为持久层，负责数据访问操作

import org.springframework.stereotype.Service;
@Service
public class UserService {
    public void sayHi() {
        System.out.println("Hello, User Service!");
    }
}
