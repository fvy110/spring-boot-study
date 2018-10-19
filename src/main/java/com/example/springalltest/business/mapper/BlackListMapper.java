package com.example.springalltest.business.mapper;

import com.example.springalltest.business.bean.BlackList;

import java.util.List;

public interface BlackListMapper {
    int deleteByPrimaryKey(Long id);

    int insert(BlackList record);

    BlackList selectByPrimaryKey(Long id);

    List<BlackList> selectAll();

    int updateByPrimaryKey(BlackList record);
}