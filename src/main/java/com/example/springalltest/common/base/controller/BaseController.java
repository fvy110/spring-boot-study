package com.example.springalltest.common.base.controller;

import com.example.springalltest.common.util.JsonUtil;
import org.springframework.beans.propertyeditors.CustomNumberEditor;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import javax.servlet.http.HttpServletResponse;
import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * @ClassName BaseController
 * @Description TODO
 * @Author byp
 * @Date 2018/10/17 15:52
 * @Verison 0.0.1
 */
public class BaseController {
    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
        binder.registerCustomEditor(Short.class, new CustomNumberEditor(Short.class, true));
        binder.registerCustomEditor(Integer.class, new CustomNumberEditor(Integer.class, true));
        binder.registerCustomEditor(Long.class, new CustomNumberEditor(Long.class, true));
        binder.registerCustomEditor(Float.class, new CustomNumberEditor(Float.class, true));
        binder.registerCustomEditor(Double.class, new CustomNumberEditor(Double.class, true));
        binder.registerCustomEditor(BigDecimal.class, new CustomNumberEditor(BigDecimal.class, true));
        binder.registerCustomEditor(BigInteger.class, new CustomNumberEditor(BigInteger.class, true));
        // java.util.Date需要根据具体使用的格式不同在子类做不同的bind。
    }

    /**
     * 将object对象转化为json字符串发送给前台
     *
     * @param object
     * @param response
     */
    protected void writeJson(Object object, HttpServletResponse response) {
        JsonUtil.writeJson(object, response);
    }
}
