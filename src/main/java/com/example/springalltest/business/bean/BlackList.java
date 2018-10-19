package com.example.springalltest.business.bean;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Data
public class BlackList implements Serializable {
    private static final long serialVersionUID = -3733099766276065747L;
    private Long id;

    private Long blackUserId;

    private Long userId;

}