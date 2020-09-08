package com.imust.newckbk.domain.excel;

import cn.afterturn.easypoi.excel.annotation.Excel;

import java.math.BigDecimal;

public class MakeUPExcel {

    @Excel(name = "学号")
    private String xh;

    @Excel(name = "姓名")
    private String xm;

    @Excel(name = "课程号")
    private String kch;

    @Excel(name = "课程名")
    private String kcm;

    @Excel(name = "学分")
    private BigDecimal xf;

    @Excel(name = "最大分数")
    private BigDecimal maxScore;

    @Excel(name = "学期")
    private String zxjxjhm;

    @Excel(name = "是否缴费")
    private String ifPay;

    public String getXh() {
        return xh;
    }

    public void setXh(String xh) {
        this.xh = xh;
    }

    public String getXm() {
        return xm;
    }

    public void setXm(String xm) {
        this.xm = xm;
    }

    public String getKch() {
        return kch;
    }

    public void setKch(String kch) {
        this.kch = kch;
    }

    public String getKcm() {
        return kcm;
    }

    public void setKcm(String kcm) {
        this.kcm = kcm;
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

    public String getZxjxjhm() {
        return zxjxjhm;
    }

    public void setZxjxjhm(String zxjxjhm) {
        this.zxjxjhm = zxjxjhm;
    }

    public String getIfPay() {
        return ifPay;
    }

    public void setIfPay(String ifPay) {
        this.ifPay = ifPay;
    }
}
