package com.example.springalltest.controller;

import com.example.springalltest.bean.TestBean;
import com.example.springalltest.service.IndexService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName IndexController
 * @Description TODO
 * @Author byp
 * @Date 2018/10/12 9:50
 * @Verison 0.0.1
 */
@Slf4j
@RestController
public class IndexController {
    private static final Logger LOG = LoggerFactory.getLogger(IndexController.class);
    @Autowired
    private TestBean testBean;
    @Autowired
    private IndexService indexService;
    @RequestMapping("/")
    public String hellWorld(){
        return testBean.getName()+ " + " + testBean.getPass();
    }

    @RequestMapping("/listUser")
    @ResponseBody
    public String listUser(){
        log.info("打印日志！");
        return indexService.listUser().toString();
    }
}
