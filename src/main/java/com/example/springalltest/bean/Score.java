package com.example.springalltest.bean;

import lombok.Data;

import java.util.Date;

@Data
public class Score {
    private Long id;

    private String changeType;

    private Date createTime;

    private Integer score;

    private Long userId;
}