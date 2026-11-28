package com.shaoyi.captchademo.model;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix = "captcha")
@Component
@Data
public class CaptchaProperties {
    private Integer width;
    private Integer height;
    private Session session;

    @Data
    public static class Session{
        private String key;
        private String date;
    }
}
