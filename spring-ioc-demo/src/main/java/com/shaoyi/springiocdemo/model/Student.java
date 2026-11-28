package com.shaoyi.springiocdemo.model;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix = "student")
@Component
@Data
public class Student {
    private int id;
    private String name;
    private int age;
}
