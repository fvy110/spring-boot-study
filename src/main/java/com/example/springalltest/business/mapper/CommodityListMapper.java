package com.example.springalltest.business.mapper;

import com.example.springalltest.business.bean.CommodityList;

import java.util.List;

public interface CommodityListMapper {
    int deleteByPrimaryKey(String goodId);

    int insert(CommodityList record);

    CommodityList selectByPrimaryKey(String goodId);

    List<CommodityList> selectAll();

    int updateByPrimaryKey(CommodityList record);
}