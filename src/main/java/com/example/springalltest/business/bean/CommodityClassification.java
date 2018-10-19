package com.example.springalltest.business.bean;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Data
public class CommodityClassification implements Serializable {
    private static final long serialVersionUID = -5647441959736144573L;
    private Integer classifyId;

    private String goodKindsName;

    private Integer upperId;

    private String upperName;

    private String description;

}