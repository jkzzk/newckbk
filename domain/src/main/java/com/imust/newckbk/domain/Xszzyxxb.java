package com.imust.newckbk.domain;

import cn.afterturn.easypoi.excel.annotation.Excel;

public class Xszzyxxb {
    private String id;

    @Excel(name = "学号")
    private String xh;

    @Excel(name = "生源类别")
    private String sylb;

    @Excel(name = "录取批次")
    private String lqpc;

    @Excel(name = "拟转入学院名")
    private String nzrxsm;

    @Excel(name = "拟转入专业名")
    private String nzrzym;

    @Excel(name = "手机号")
    private String sjh;

    @Excel(name = "原学院名称")
    private String yxsm;

    @Excel(name = "原专业名称")
    private String yzym;

    @Excel(name = "原所在年级")
    private String ynjdm;

    @Excel(name = "原班级")
    private String ybjh;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getXh() {
        return xh;
    }

    public void setXh(String xh) {
        this.xh = xh == null ? null : xh.trim();
    }

    public String getSylb() {
        return sylb;
    }

    public void setSylb(String sylb) {
        this.sylb = sylb == null ? null : sylb.trim();
    }

    public String getLqpc() {
        return lqpc;
    }

    public void setLqpc(String lqpc) {
        this.lqpc = lqpc == null ? null : lqpc.trim();
    }

    public String getNzrxsm() {
        return nzrxsm;
    }

    public void setNzrxsm(String nzrxsm) {
        this.nzrxsm = nzrxsm;
    }

    public String getNzrzym() {
        return nzrzym;
    }

    public void setNzrzym(String nzrzym) {
        this.nzrzym = nzrzym;
    }

    public String getYxsm() {
        return yxsm;
    }

    public void setYxsm(String yxsm) {
        this.yxsm = yxsm;
    }

    public String getYzym() {
        return yzym;
    }

    public void setYzym(String yzym) {
        this.yzym = yzym;
    }

    public String getYnjdm() {
        return ynjdm;
    }

    public void setYnjdm(String ynjdm) {
        this.ynjdm = ynjdm;
    }

    public String getYbjh() {
        return ybjh;
    }

    public void setYbjh(String ybjh) {
        this.ybjh = ybjh;
    }

    public String getSjh() {
        return sjh;
    }

    public void setSjh(String sjh) {
        this.sjh = sjh == null ? null : sjh.trim();
    }
}