package com.imust.newckbk.domain;

import java.io.Serializable;

public class SysAuthor implements Serializable {
    private String roleId;
    private Integer resId;
    private Byte    resType;

    public Integer getResId() {
        return resId;
    }

    public void setResId(Integer resId) {
        this.resId = resId;
    }

    public Byte getResType() {
        return resType;
    }

    public void setResType(Byte resType) {
        this.resType = resType;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }
}
