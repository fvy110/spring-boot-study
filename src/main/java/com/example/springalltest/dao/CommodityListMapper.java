package com.example.springalltest.dao;

import com.example.springalltest.bean.CommodityList;
import java.util.List;

public interface CommodityListMapper {
    int deleteByPrimaryKey(String goodId);

    int insert(CommodityList record);

    CommodityList selectByPrimaryKey(String goodId);

    List<CommodityList> selectAll();

    int updateByPrimaryKey(CommodityList record);
}