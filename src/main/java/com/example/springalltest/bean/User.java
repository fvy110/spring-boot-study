package com.example.springalltest.bean;

import lombok.Data;

import java.util.Date;
@Data
public class User {
    private Long id;

    private String account;

    private String avatar;

    private Long payMoney;

    private String country;

    private Date createTime;

    private Long score;

    private Double latitude;

    private Double longitude;

    private String province;

    private String sex;

    private String password;
}