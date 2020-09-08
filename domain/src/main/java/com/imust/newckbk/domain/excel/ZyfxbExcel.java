package com.imust.newckbk.domain.excel;

import cn.afterturn.easypoi.excel.annotation.Excel;

public class ZyfxbExcel {

    @Excel(name = "学期")
    private String zxjxjhm;

    @Excel(name = "学号")
    private String xh;

    @Excel(name = "姓名")
    private String xm;

    @Excel(name = "当前学院")
    private String xsm;

    @Excel(name = "当前专业")
    private String zym;

    @Excel(name = "当前班级")
    private String bjh;

    @Excel(name = "拟辅修学院")
    private String nfxxsm;

    @Excel(name = "拟辅修专业")
    private String nfxzym;

    @Excel(name = "联系电话")
    private String lxdh;

    public String getZxjxjhm() {
        return zxjxjhm;
    }

    public void setZxjxjhm(String zxjxjhm) {
        this.zxjxjhm = zxjxjhm;
    }

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

    public String getXsm() {
        return xsm;
    }

    public void setXsm(String xsm) {
        this.xsm = xsm;
    }

    public String getZym() {
        return zym;
    }

    public void setZym(String zym) {
        this.zym = zym;
    }

    public String getBjh() {
        return bjh;
    }

    public void setBjh(String bjh) {
        this.bjh = bjh;
    }

    public String getNfxxsm() {
        return nfxxsm;
    }

    public void setNfxxsm(String nfxxsm) {
        this.nfxxsm = nfxxsm;
    }

    public String getNfxzym() {
        return nfxzym;
    }

    public void setNfxzym(String nfxzym) {
        this.nfxzym = nfxzym;
    }

    public String getLxdh() {
        return lxdh;
    }

    public void setLxdh(String lxdh) {
        this.lxdh = lxdh;
    }
}
