package com.example.springalltest.business.bean;

import lombok.Data;

import java.io.Serializable;

/**
 * @author byp
 */
@Data
public class RolePermission implements Serializable {
    private static final long serialVersionUID = 1377888698787570943L;
    private Integer rid;

    private Integer pid;

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }
}