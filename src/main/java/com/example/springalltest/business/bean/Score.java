package com.example.springalltest.business.bean;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Date;

@Data
public class Score implements Serializable {
    private static final long serialVersionUID = 9111851027689276466L;
    private Long id;

    private String changeType;

    private Date createTime;

    private Integer score;

    private Long userId;
}