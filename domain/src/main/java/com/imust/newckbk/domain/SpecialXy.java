package com.imust.newckbk.domain;

public class SpecialXy {
    private String id;

    private String xyName;

    private String isEnable;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getXyName() {
        return xyName;
    }

    public void setXyName(String xyName) {
        this.xyName = xyName == null ? null : xyName.trim();
    }

    public String getIsEnable() {
        return isEnable;
    }

    public void setIsEnable(String isEnable) {
        this.isEnable = isEnable == null ? null : isEnable.trim();
    }
}