package com.example.springalltest.business.mapper;

import com.example.springalltest.business.bean.RolePermission;
import java.util.List;

public interface RolePermissionMapper {
    int insert(RolePermission record);

    List<RolePermission> selectAll();
}