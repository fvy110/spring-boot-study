package com.example.springalltest.business.mapper;

import com.example.springalltest.business.bean.Role;
import com.example.springalltest.business.bean.UserRole;
import java.util.List;

public interface UserRoleMapper {
    int insert(UserRole record);

    List<UserRole> selectAll();

    List<Role> findByUserName(String username);
}