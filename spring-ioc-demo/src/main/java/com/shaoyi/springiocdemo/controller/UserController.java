package com.shaoyi.springiocdemo.controller;

import com.shaoyi.springiocdemo.model.UserInfo;
import com.shaoyi.springiocdemo.service.UserService;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;


//控制存储器：控制层，接受请求，对请求进行处理，并进行响应
@Controller //将对象存储到Spring中
public class UserController {

    //属性注入
    //注入方法1：属性注入
    //优点：简洁，使用方便
    //缺点：只能用于Ioc容器，并且只有在使用的时候才会出现空指针异常，不能注入一个Fianl修饰的属性
//    @Autowired
//    private UserService userService;

    //注入方法2：构造方法注入
    //如果类只有一个构造方法，那么注解可以省略，如果类中有多个构造方法，就需要添加上注解来指明到底使用哪个构造方法
//    UserService userService;
//    @Autowired
//    public UserController(UserService userService){
//        this.userService = userService;
//    }

    //注入方法3：Setter注入
    private UserService userService;
    @Autowired
    public void setUserService(UserService userService){
        this.userService = userService;
    }

    //当同一类型存在多个bean时，需要：
    //1.使用@Primary注解：当存在多个相同类型的Bean注入时，来确定默认的实现
    //2.使用@Qualifier注解：指定当前要注入的bean对象，必须配合@Autowired一起使用
    //3.使用@Resource注解：是按照bean的名称进行注入。通过name属性指定要注入的bean的名称

//    @Qualifier("u2")
//    @Autowired
    @Resource(name = "user1")
    private UserInfo userInfo;

    public void sayHi(){
        System.out.println("Hello, User Controller!");
        userService.sayHi();
        System.out.println(userInfo);
    }
}
