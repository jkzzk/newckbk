package com.imust.newckbk.domain.excel;

import cn.afterturn.easypoi.excel.annotation.Excel;

/**
 * 补考课程导出表
 *
 */
public class BkkcxxbExcel {

    @Excel(name = "教学计划号")
    private String jxjhh;

    @Excel(name = "学院名称")
    private String xsm;

    @Excel(name = "课程编号")
    private String kch;

    @Excel(name = "课程名称")
    private String kcm;

    @Excel(name = "课程属性")
    private String kcsx;

    @Excel(name = "学时")
    private String xs;

    @Excel(name = "学分")
    private String xf;

    @Excel(name = "考试类型")
    private String kslx;

    @Excel(name = "是否组织补考")
    private String sfzzbk;

    public String getJxjhh() {
        return jxjhh;
    }

    public void setJxjhh(String jxjhh) {
        this.jxjhh = jxjhh;
    }

    public String getXsm() {
        return xsm;
    }

    public void setXsm(String xsm) {
        this.xsm = xsm;
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

    public String getKcsx() {
        return kcsx;
    }

    public void setKcsx(String kcsx) {
        this.kcsx = kcsx;
    }

    public String getXs() {
        return xs;
    }

    public void setXs(String xs) {
        this.xs = xs;
    }

    public String getXf() {
        return xf;
    }

    public void setXf(String xf) {
        this.xf = xf;
    }

    public String getKslx() {
        return kslx;
    }

    public void setKslx(String kslx) {
        this.kslx = kslx;
    }

    public String getSfzzbk() {
        return sfzzbk;
    }

    public void setSfzzbk(String sfzzbk) {
        this.sfzzbk = sfzzbk;
    }
}
