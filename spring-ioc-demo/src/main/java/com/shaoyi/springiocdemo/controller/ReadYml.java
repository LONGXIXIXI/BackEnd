package com.shaoyi.springiocdemo.controller;

import com.shaoyi.springiocdemo.model.Dbtypes;
import com.shaoyi.springiocdemo.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ReadYml {
    @Value("${string.str1}")
    private String str1;
    @Value("${string.str2}")
    private String str2;
    @Value("${string.str3}")
    private String str3;

    @Autowired
    private Student student;

    @Autowired
    private Dbtypes dbtypes;



    @RequestMapping("/yml")
    public String readYml(){
        System.out.println(str1);
        System.out.println(str2);
        System.out.println(str3);
        System.out.println(student);
        System.out.println(dbtypes);

        return "yml";
    }
}
