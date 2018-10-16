package com.example.springalltest.dao;

import com.example.springalltest.bean.BlackList;
import java.util.List;

public interface BlackListMapper {
    int deleteByPrimaryKey(Long id);

    int insert(BlackList record);

    BlackList selectByPrimaryKey(Long id);

    List<BlackList> selectAll();

    int updateByPrimaryKey(BlackList record);
}