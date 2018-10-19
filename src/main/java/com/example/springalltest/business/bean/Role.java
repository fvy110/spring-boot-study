package com.example.springalltest.business.bean;

import lombok.Data;

import java.io.Serializable;

/**
 * @author byp
 */
@Data
public class Role implements Serializable {
    private static final long serialVersionUID = -655789933747500398L;
    private Integer id;

    private String name;

    private String memo;

}