package com.example.springalltest.business.bean;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Date;

@Data
public class Gag implements Serializable {
    private static final long serialVersionUID = -8649049835489578107L;
    private Long id;

    private Date createTime;

    private Date gagTime;

    private Long userId;
}