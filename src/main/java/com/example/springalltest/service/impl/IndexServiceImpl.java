package com.example.springalltest.service.impl;

import com.example.springalltest.bean.User;
import com.example.springalltest.dao.UserMapper;
import com.example.springalltest.service.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
    @Override
    public List<User> listUser() {
        return userMapper.selectAll();
    }
}
