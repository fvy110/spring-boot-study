package com.example.springalltest.dao;

import com.example.springalltest.bean.Score;
import java.util.List;

public interface ScoreMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Score record);

    Score selectByPrimaryKey(Long id);

    List<Score> selectAll();

    int updateByPrimaryKey(Score record);
}