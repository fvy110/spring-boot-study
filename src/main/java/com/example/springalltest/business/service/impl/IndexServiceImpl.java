package com.example.springalltest.business.service.impl;

import com.example.springalltest.business.bean.User;
import com.example.springalltest.business.mapper.UserMapper;
import com.example.springalltest.common.annotation.Log;
import com.example.springalltest.business.service.IndexService;
import com.example.springalltest.common.base.model.GridListJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName IndexServiceImpl
 * @Description TODO
 * @Author byp
 * @Date 2018/10/12 13:40
 * @Verison 0.0.1
 */
@Service
public class IndexServiceImpl implements IndexService {

    @Autowired
    private UserMapper userMapper;
    @Log("listUser")
    @Override
    public GridListJson<User> listUser() {
        GridListJson<User> json = new GridListJson<>();
        json.setData(userMapper.selectAll());
        return json;
    }

    @Log("testLog")
    @Override
    public int testLog(){
        return 1/0;
    }
}

