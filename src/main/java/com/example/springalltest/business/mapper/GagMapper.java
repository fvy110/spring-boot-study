package com.example.springalltest.business.mapper;

import com.example.springalltest.business.bean.Gag;

import java.util.List;

public interface GagMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Gag record);

    Gag selectByPrimaryKey(Long id);

    List<Gag> selectAll();

    int updateByPrimaryKey(Gag record);
}