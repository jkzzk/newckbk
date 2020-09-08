package com.imust.newckbk.domain;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Bktjjl {
    private String id;

    private String zxjxjhh;

    private String sxqzxjxjhh;

    private String bkdx;

    private String zxnj;

    private Byte bkfs;

    private Byte bklx;

    private Byte status;

    private Date createTime;

    private String createBy;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getZxjxjhh() {
        return zxjxjhh;
    }

    public void setZxjxjhh(String zxjxjhh) {
        this.zxjxjhh = zxjxjhh;
    }

    public String getSxqzxjxjhh() {
        return sxqzxjxjhh;
    }

    public void setSxqzxjxjhh(String sxqzxjxjhh) {
        this.sxqzxjxjhh = sxqzxjxjhh;
    }

    public String getBkdx() {
        return bkdx;
    }

    public void setBkdx(String bkdx) {
        this.bkdx = bkdx;
    }

    public String getZxnj() {
        return zxnj;
    }

    public void setZxnj(String zxnj) {
        this.zxnj = zxnj;
    }

    public Byte getBkfs() {
        return bkfs;
    }

    public void setBkfs(Byte bkfs) {
        this.bkfs = bkfs;
    }

    public Byte getBklx() {
        return bklx;
    }

    public void setBklx(Byte bklx) {
        this.bklx = bklx;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
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
        this.createBy = createBy;
    }
}