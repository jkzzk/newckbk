package com.imust.newckbk.domain;

import java.math.BigDecimal;
import java.util.Date;

public class Jwkzxxjl {
    private String id;

    private Byte bkkg;

    private Byte fxkg;

    private Byte zzykg;

    private Byte cetkg;

    private Date createTime;

    private String createBy;

    private Byte status;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public Byte getBkkg() {
        return bkkg;
    }

    public void setBkkg(Byte bkkg) {
        this.bkkg = bkkg;
    }

    public Byte getFxkg() {
        return fxkg;
    }

    public void setFxkg(Byte fxkg) {
        this.fxkg = fxkg;
    }

    public Byte getZzykg() {
        return zzykg;
    }

    public void setZzykg(Byte zzykg) {
        this.zzykg = zzykg;
    }

    public Byte getCetkg() {
        return cetkg;
    }

    public void setCetkg(Byte cetkg) {
        this.cetkg = cetkg;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy == null ? null : createBy.trim();
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }
}