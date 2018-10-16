package com.example.springalltest.bean;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @ClassName TestBean
 * @Description TODO
 * @Author byp
 * @Date 2018/10/12 9:34
 * @Verison 0.0.1
 */
@Component
@ConfigurationProperties(prefix = "test")
@Data
public class TestBean {
    private String name;
    private String pass;
}
