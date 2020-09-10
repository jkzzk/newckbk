package com.imust.newckbk.domain.excel;

import cn.afterturn.easypoi.excel.annotation.Excel;

public class CetStuYyfbcjExcel {

    private String id;

    @Excel(name = "学期")
    private String zxjxjhh;

    @Excel(name = "课程号")
    private String kch;

    @Excel(name = "课程名称")
    private String kcmc;

    @Excel(name = "课程序号")
    private String kxh;

    @Excel(name = "学号")
    private String xh;

    @Excel(name = "姓名")
    private String xm;

    @Excel(name = "班级号")
    private String bjh;

    @Excel(name = "分班等级")
    private String fbdj;

    @Excel(name = "等级成绩")
    private Double djcj;

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
        this.kch = kch;
    }

    public String getKcmc() {
        return kcmc;
    }

    public void setKcmc(String kcmc) {
        this.kcmc = kcmc;
    }

    public String getKxh() {
        return kxh;
    }

    public void setKxh(String kxh) {
        this.kxh = kxh;
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

    public String getBjh() {
        return bjh;
    }

    public void setBjh(String bjh) {
        this.bjh = bjh;
    }

    public String getFbdj() {
        return fbdj;
    }

    public void setFbdj(String fbdj) {
        this.fbdj = fbdj;
    }

    public Double getDjcj() {
        return djcj;
    }

    public void setDjcj(Double djcj) {
        this.djcj = djcj;
    }
}
