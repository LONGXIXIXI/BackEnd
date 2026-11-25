package com.shaoyi.springbootdemo;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/request2")
public class RequestController2 {

    /**
     *获取Cookie
     * 传统获取Cookie
     * HttpServletRequest
     * 对象代表客⼾端的请求,当客⼾端通过HTTP协议访问服务器时，HTTP请求头中的所有信息都封装在这个对象中，
     * 通过这个对象提供的⽅法，可以获得客⼾端请求的所有信息
     *
     * HttpServletResponse
     * 对象代表服务器的响应.HTTP响应的信息都在这个对象中,⽐如向客⼾
     * 端发送的数据,响应头,状态码等.通过这个对象提供的⽅法,可以获得服务器响应的所有内容
     */
    @RequestMapping("/getCookie")
    public String getCookie(HttpServletRequest request){
        //获取所有cookie信息
        Cookie[] cookies = request.getCookies();
        //打印Cookie信息
        if(cookies != null){
            for(Cookie cookie : cookies){
                System.out.println(cookie.getName() + ":" + cookie.getValue());
            }
        }
        return "获取Cookie成功";
    }

    /**
     * 简洁方式获取Cookie
     * @return
     */
    @RequestMapping("/getCookie2")
    public String getCookie2(@CookieValue("bite666") String bite){
        return "获取Cookie成功,bite：" + bite;
    }


    /**
     * 存储Session
     * Session是服务端的机制，需要先存储才能获取
     */
    @RequestMapping("/setSession")
    public String setSession(HttpServletRequest request){
        //默认值为true，没有session时，则创建
        HttpSession session = request.getSession();
        if(session != null){
            session.setAttribute("username","java");
        }

        return "session存储成功";
    }

    /**
     * 获取Session
     */
    @RequestMapping("/getSession")
    public String getSession(HttpServletRequest request){
        HttpSession session = request.getSession();
        String username = null;
        if(session != null && session.getAttribute("username") != null){
            username = (String)session.getAttribute("username");
        }

        return "session获取成功,username：" + username;
    }

    /**
     * 简洁获取Session1
     */
    @RequestMapping("/getSession2")
    public String getSession2(HttpSession session){
        String username = (String)session.getAttribute("username");
        return "username" + username;
    }

    /**
     * 简洁获取Session2
     */
    @RequestMapping("/getSession3")
    public String getSession3(@SessionAttribute("username") String username){
        return "username:" + username;
    }


    /**
     * 获取Header
     */
    @RequestMapping("/getHeader")
    public String getHeader(HttpServletRequest request){
        String userAgent = request.getHeader("User-Agent");
        return "User-Agent:" + userAgent;
    }

    /**
     * 简洁获取Header
     */
    @RequestMapping("/getHeader2")
    public String getHeader2(@RequestHeader("User-Agent") String userAgent ){
        return "User-Agent:" + userAgent;
    }
}
