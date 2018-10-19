package com.example.springalltest.business.mapper;

import com.example.springalltest.business.bean.Permission;

import java.util.List;

public interface UserPermissionMapper {
    List<Permission> findByUserName(String username);
}
