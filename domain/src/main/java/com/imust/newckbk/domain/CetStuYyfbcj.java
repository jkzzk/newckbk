package com.imust.newckbk.domain;

import com.imust.newckbk.domain.excel.CetStuYyfbcjExcel;

import java.math.BigDecimal;

public class CetStuYyfbcj {
    private String id;

    private String zxjxjhh;

    private String kch;

    private String kcmc;

    private String kxh;

    private String xh;

    private String xm;

    private String bjh;

    private String fbdj;

    private Double djcj;

    public CetStuYyfbcj() {
    }

    public CetStuYyfbcj(CetStuYyfbcjExcel cetStuYyfbcjExcel) {
        this.zxjxjhh = cetStuYyfbcjExcel.getZxjxjhh();
        this.kch = cetStuYyfbcjExcel.getKch();
        this.kcmc = cetStuYyfbcjExcel.getKcmc();
        this.kch = cetStuYyfbcjExcel.getKch();
        this.xh = cetStuYyfbcjExcel.getXh();
        this.xm = cetStuYyfbcjExcel.getXm();
        this.bjh = cetStuYyfbcjExcel.getBjh();
        this.fbdj = cetStuYyfbcjExcel.getFbdj();
        this.djcj = cetStuYyfbcjExcel.getDjcj();
    }

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

    public String getKch() {
        return kch;
    }

    public void setKch(String kch) {
        this.kch = kch == null ? null : kch.trim();
    }

    public String getKcmc() {
        return kcmc;
    }

    public void setKcmc(String kcmc) {
        this.kcmc = kcmc == null ? null : kcmc.trim();
    }

    public String getKxh() {
        return kxh;
    }

    public void setKxh(String kxh) {
        this.kxh = kxh == null ? null : kxh.trim();
    }

    public String getXh() {
        return xh;
    }

    public void setXh(String xh) {
        this.xh = xh == null ? null : xh.trim();
    }

    public String getXm() {
        return xm;
    }

    public void setXm(String xm) {
        this.xm = xm == null ? null : xm.trim();
    }

    public String getBjh() {
        return bjh;
    }

    public void setBjh(String bjh) {
        this.bjh = bjh == null ? null : bjh.trim();
    }

    public String getFbdj() {
        return fbdj;
    }

    public void setFbdj(String fbdj) {
        this.fbdj = fbdj == null ? null : fbdj.trim();
    }

    public Double getDjcj() {
        return djcj;
    }

    public void setDjcj(Double djcj) {
        this.djcj = djcj;
    }
}