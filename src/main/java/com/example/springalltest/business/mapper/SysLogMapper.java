package com.example.springalltest.business.mapper;

import com.example.springalltest.business.bean.SysLog;
import java.util.List;

public interface SysLogMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SysLog record);

    SysLog selectByPrimaryKey(Integer id);

    List<SysLog> selectAll();

    int updateByPrimaryKey(SysLog record);
}