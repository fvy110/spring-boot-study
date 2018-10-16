package com.example.springalltest;

import com.example.springalltest.bean.TestBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@MapperScan("com.example.springalltest.dao")
public class SpringalltestApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringalltestApplication.class, args);
    }

}
