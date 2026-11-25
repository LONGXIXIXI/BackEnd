package com.shaoyi.springbootdemo;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("response")
public class ResponseController {

    /**
     * 返回静态页面
     */
    @RequestMapping("re1")
    public String re1(){
        return "/test.html";
    }

    /**
     * 返回数据
     */
    @ResponseBody
    @RequestMapping("re2")
    public String re2(){
        return "/test.html";
    }


    /**
     * 返回HTML代码片段
     */
    @RequestMapping("returnHtml")
    @ResponseBody
    public String returnHtml(){
        return "<h1>Hello,HTML</h1>";
    }

    /**
     * 返回JSON
     */
    @RequestMapping("/returnJson")
    @ResponseBody
    public Person returnJson(){
        Person p = new Person();
        p.setId(1);
        p.setName("zhangsan");
        p.setAge(18);
        p.setPassword("123456");
        return p;
    }

    /**
     * 设置状态码
     */
    @RequestMapping("/setStatus")
    @ResponseBody
    public String setStatus(HttpServletResponse response){
        response.setStatus(401);
        return "设置状态码成功";
    }

    /**
     * 设置Content-Type
     */
    @RequestMapping(value = "/setContentType",produces = "application/json")
    @ResponseBody
    public String setContentType(){
        return "{\\\"success\\\":true}";
    }

    /**
     * 设置其他Header
     */
    @RequestMapping("/setHeader")
    @ResponseBody
    public String setHeader(HttpServletResponse response){
        response.setHeader("MyHeader","MyHeaderValue");
        return "设置Header成功";
    }
}
