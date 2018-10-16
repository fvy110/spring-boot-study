package com.example.springalltest.dao;

import com.example.springalltest.bean.CommodityClassification;
import java.util.List;

public interface CommodityClassificationMapper {
    int deleteByPrimaryKey(Integer classifyId);

    int insert(CommodityClassification record);

    CommodityClassification selectByPrimaryKey(Integer classifyId);

    List<CommodityClassification> selectAll();

    int updateByPrimaryKey(CommodityClassification record);
}