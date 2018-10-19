package com.example.springalltest.business.service;

import com.example.springalltest.business.bean.User;
import com.example.springalltest.common.base.model.GridListJson;

public interface IndexService {
    GridListJson<User> listUser();

    int testLog();
}
