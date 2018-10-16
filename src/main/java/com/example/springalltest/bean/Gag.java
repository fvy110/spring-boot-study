package com.example.springalltest.bean;

import lombok.Data;

import java.util.Date;
@Data
public class Gag {
    private Long id;

    private Date createTime;

    private Date gagTime;

    private Long userId;
}