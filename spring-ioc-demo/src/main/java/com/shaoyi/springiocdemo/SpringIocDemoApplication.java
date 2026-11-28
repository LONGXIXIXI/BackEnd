package com.shaoyi.springiocdemo;

import com.shaoyi.springiocdemo.controller.UserController;
import com.shaoyi.springiocdemo.model.UserInfo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = "com.shaoyi.springiocdemo")//使用五大注解声明的bean，要想生效，还需要配置扫描路径，让Spring扫描到这些注解
@SpringBootApplication
public class SpringIocDemoApplication {

    public static void main(String[] args) {
        //获取Spring上下文对象
        ApplicationContext context = SpringApplication.run(SpringIocDemoApplication.class, args);
//        //从Spring上下文中获取对象
//        UserController bean = context.getBean(UserController.class);
//        //使用对象
//        bean.sayHi();

//        //获取bean对象的方式
//        //根据bean的类型，从Spring上下文中获取对象
//        UserController bean1 = context.getBean(UserController.class);
//
//        //根据bean的名称，从Spring上下文中获取对象
//        UserController bean2 = (UserController)context.getBean("userController");
//
//        //根据bean的名称+类型,从Spring上下⽂中获取对象
//        UserController bean3 = context.getBean("userController",UserController.class);
//
//        System.out.println(bean1);
//        System.out.println(bean2);
//        System.out.println(bean3);

//        UserService userService = context.getBean(UserService.class);
//        userService.sayHi();


//        //当定义了多个相同类型的bean时，可以通过名称来区分
//        UserInfo bean = context.getBean("user1",UserInfo.class);
//        System.out.println(bean);
//        UserInfo bean2 = context.getBean("u2",UserInfo.class);
//        System.out.println(bean2);

//        //属性注入
//        UserController userController = context.getBean(UserController.class);
//        userController.sayHi();
    }

}
