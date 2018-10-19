package com.example.springalltest.business.bean;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
/**
 * @author byp
 */
@Data
public class User implements Serializable {
    private static final long serialVersionUID = 5008638544639374785L;
    private Integer id;

    private String userName;

    private String password;

    private Date createTime;

    private String status;

}