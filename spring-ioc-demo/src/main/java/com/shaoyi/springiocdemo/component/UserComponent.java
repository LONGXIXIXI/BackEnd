package com.shaoyi.springiocdemo.component;

//组件存储

import org.springframework.stereotype.Component;

@Component
public class UserComponent {
    public void sayHi(){
        System.out.println("Hello, User Component!");
    }
}
