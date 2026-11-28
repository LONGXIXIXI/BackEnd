package com.shaoyi.captchademo.controller;

import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.LineCaptcha;
import com.shaoyi.captchademo.model.CaptchaProperties;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/captcha")
public class CaptchaController {
    private final static long VALID_MILLIS_TIME = 2 * 60 * 1000; //2分钟
    @Autowired
    private CaptchaProperties captchaProperties;

    @RequestMapping("/getCaptcha")
    public void getCaptcha(HttpSession session, HttpServletResponse response) {
        LineCaptcha lineCaptcha = CaptchaUtil.createLineCaptcha(captchaProperties.getWidth(),captchaProperties.getHeight());
        String code = lineCaptcha.getCode();

        session.setAttribute(captchaProperties.getSession().getKey(), code);
        session.setAttribute(captchaProperties.getSession().getDate(), System.currentTimeMillis());

        response.setContentType("image/png");
        response.setHeader("Pragma", "no-cache");

        try {
            lineCaptcha.write(response.getOutputStream());
            response.getOutputStream().close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @RequestMapping("check")
    public boolean checkCaptcha(String captcha, HttpSession session) {

        if(!StringUtils.hasText(captcha)){
            return false;
        }

        String saveCaptcha = (String)session.getAttribute(captchaProperties.getSession().getKey());
        long time = (long)session.getAttribute(captchaProperties.getSession().getDate());
        if(saveCaptcha.equalsIgnoreCase(captcha) && System.currentTimeMillis() - time < VALID_MILLIS_TIME){
            return true;
        }

        return false;
    }


}
