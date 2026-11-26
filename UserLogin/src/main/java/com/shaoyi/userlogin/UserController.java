package com.shaoyi.userlogin;

import jakarta.servlet.http.HttpSession;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    @PostMapping("/login")
    public Boolean login(String userName, String password, HttpSession session) {
        if (!StringUtils.hasText(userName) || !StringUtils.hasText(password)) {
            return false;
        }
        //TODO 还未学习数据库, 暂且写死
        if ("admin".equals(userName) && "admin".equals(password)) {
            session.setAttribute("userName", userName);
            return true;
        }
        return false;
    }

    @RequestMapping("/getLoginUser")
    public String getLoginUser(HttpSession session) {
        String userName = (String)session.getAttribute("userName");
        return userName;
    }

}
