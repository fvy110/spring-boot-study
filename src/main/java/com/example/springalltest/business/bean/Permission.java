package com.example.springalltest.business.bean;

import lombok.Data;

import java.io.Serializable;

/**
 * @author byp
 */
@Data
public class Permission implements Serializable {
    private static final long serialVersionUID = -5549910678397708712L;
    private Integer id;

    private String url;

    private String name;

}