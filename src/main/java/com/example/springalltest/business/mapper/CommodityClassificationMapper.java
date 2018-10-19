package com.example.springalltest.business.mapper;

import com.example.springalltest.business.bean.CommodityClassification;

import java.util.List;

public interface CommodityClassificationMapper {
    int deleteByPrimaryKey(Integer classifyId);

    int insert(CommodityClassification record);

    CommodityClassification selectByPrimaryKey(Integer classifyId);

    List<CommodityClassification> selectAll();

    int updateByPrimaryKey(CommodityClassification record);
}