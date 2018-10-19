package com.example.springalltest;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@MapperScan("com.example.springalltest.business.mapper")
public class SpringalltestApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringalltestApplication.class, args);
    }

}
