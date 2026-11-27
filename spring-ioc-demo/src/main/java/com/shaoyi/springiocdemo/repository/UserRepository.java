package com.shaoyi.springiocdemo.repository;

//仓库存储

import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {
    public void sayHi(){
        System.out.println("Hello, User Repository!");
    }
}
