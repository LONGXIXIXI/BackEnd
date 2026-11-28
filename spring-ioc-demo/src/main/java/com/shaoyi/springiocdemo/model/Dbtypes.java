package com.shaoyi.springiocdemo.model;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.Map;


@ConfigurationProperties(prefix = "dbtypes")
@Configuration
@Data
public class Dbtypes {
    private List<String> name;
    private Map<String, String> map;
}
