package com.example.springalltest.business.bean;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Data
public class CommodityList implements Serializable {
    private static final long serialVersionUID = 120555046908806735L;
    private String goodId;

    private Integer classifyId;

    private String classifyDescription;

    private String goodBrand;

    private String goodName;

    private String goodPrice;

    private String storeAdd;

    private Integer monthsaleNum;

    private String colorClassification;

    private Integer commentNum;

    private String goodAfterrate;

    private String industrycompare;

    private String goodLink;

    private String storeName;

    private String storeLink;

    private Integer goodHot;

    private String storeAge;

    private String sellerCredit;

    private Integer ishasLicense;

    private Double descriptionsituation;

    private Double serviceattitude;

    private Double logisticsservice;

    private String size;

}