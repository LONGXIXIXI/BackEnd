package com.shaoyi.bookdemo.controller;


import jakarta.servlet.http.HttpSession;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/login")
    public boolean login(String userName, String password, HttpSession session){
        if(!StringUtils.hasText(userName) || !StringUtils.hasText(password)){
            return false;
        }

        if("admin".equals(userName) && "123456".equals(password)){
            session.setAttribute("userName",userName);
            return true;
        }

        return false;
    }
}
