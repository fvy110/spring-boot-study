package com.example.springalltest.business.bean;

import lombok.Data;

import java.io.Serializable;

/**
 * @author byp
 */
@Data
public class UserRole implements Serializable {
    private static final long serialVersionUID = -3619979319248758467L;
    private Integer userId;

    private Integer rid;

}