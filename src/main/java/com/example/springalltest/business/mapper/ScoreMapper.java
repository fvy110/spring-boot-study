package com.example.springalltest.business.mapper;

import com.example.springalltest.business.bean.Score;

import java.util.List;

public interface ScoreMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Score record);

    Score selectByPrimaryKey(Long id);

    List<Score> selectAll();

    int updateByPrimaryKey(Score record);
}