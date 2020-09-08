package com.imust.newckbk.domain;

import java.math.BigDecimal;

public class Makeup {

    private String id;

    private String xh;

    private String xm;

    private String kch;

    private String kcm;

    private BigDecimal xf;

    private BigDecimal maxScore;

    private byte ifMakeUp;

    private byte ifPay;

    private String jxjhh;

    public String getJxjhh() {
        return jxjhh;
    }

    public void setJxjhh(String jxjhh) {
        this.jxjhh = jxjhh;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getKch() {
        return kch;
    }

    public void setKch(String kch) {
        this.kch = kch == null ? null : kch.trim();
    }

    public String getKcm() {
        return kcm;
    }

    public void setKcm(String kcm) {
        this.kcm = kcm == null ? null : kcm.trim();
    }

    public BigDecimal getXf() {
        return xf;
    }

    public void setXf(BigDecimal xf) {
        this.xf = xf;
    }

    public BigDecimal getMaxScore() {
        return maxScore;
    }

    public void setMaxScore(BigDecimal maxScore) {
        this.maxScore = maxScore;
    }

    public byte getIfMakeUp() {
        return ifMakeUp;
    }

    public void setIfMakeUp(byte ifMakeUp) {
        this.ifMakeUp = ifMakeUp;
    }

    public byte getIfPay() {
        return ifPay;
    }

    public void setIfPay(byte ifPay) {
        this.ifPay = ifPay;
    }
}