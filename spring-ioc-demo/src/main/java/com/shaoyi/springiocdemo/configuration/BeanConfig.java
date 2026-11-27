package com.shaoyi.springiocdemo.configuration;
//方法注解@Bean

import com.shaoyi.springiocdemo.model.UserInfo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
public class BeanConfig {

    //方法注解要配合类注解使用
    //可以通过设置name属性给Bean对象进行重命名操作，name={}可以省略
    //@Primary//指定该bean为默认bean的实现
    @Bean(name = "user1")
    public UserInfo u1(){
        UserInfo userInfo = new UserInfo(1,"zhangsan");
        return userInfo;
    }

    //当定义了多个相同类型的bean时，可以通过名称来区分
    @Bean
    public UserInfo u2(){
        UserInfo userInfo = new UserInfo(2,"lisi");
        return userInfo;
    }
}
