package com.example.springalltest.business.controller;

import com.example.springalltest.business.bean.User;
import com.example.springalltest.business.service.IndexService;
import com.example.springalltest.common.base.controller.BaseController;
import com.example.springalltest.common.base.model.GridListJson;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.util.Date;

/**
 * @ClassName IndexController
 * @Description TODO
 * @Author byp
 * @Date 2018/10/12 9:50
 * @Verison 0.0.1
 */
@Slf4j
@Controller
public class IndexController extends BaseController {
    private static final Logger LOG = LoggerFactory.getLogger(IndexController.class);
    @Autowired
    private IndexService indexService;

    @RequestMapping("/ftl/index")
    public String index(Model model){
        model.addAttribute("time",new Date());
        return "index";
    }
    @RequestMapping("/listUser")
    public void listUser(HttpServletResponse response){
        GridListJson<User> json = null;
        try{
            json = indexService.listUser();
        }catch (Exception e){
            json = new GridListJson<>();
            log.error("获取用户信息异常！",e);
        }
        writeJson(json,response);
    }

    @RequestMapping("/testLog")
    public int testLog(){
        return indexService.testLog();
    }
}
