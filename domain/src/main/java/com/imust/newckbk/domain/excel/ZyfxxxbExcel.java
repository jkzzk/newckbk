package com.imust.newckbk.domain.excel;

import cn.afterturn.easypoi.excel.annotation.Excel;

public class ZyfxxxbExcel {

    @Excel(name = "专业名称")
    private String zym;

    @Excel(name = "学院名称")
    private String xsm;

    @Excel(name = "学科类型名称")
    private String xkfl;

    @Excel(name = "录取批次代码")
    private String lqdm;

    @Excel(name = "录取批次名称")
    private String lqpc;

    public String getZym() {
        return zym;
    }

    public void setZym(String zym) {
        this.zym = zym;
    }

    public String getXsm() {
        return xsm;
    }

    public void setXsm(String xsm) {
        this.xsm = xsm;
    }

    public String getXkfl() {
        return xkfl;
    }

    public void setXkfl(String xkfl) {
        this.xkfl = xkfl;
    }

    public String getLqdm() {
        return lqdm;
    }

    public void setLqdm(String lqdm) {
        this.lqdm = lqdm;
    }

    public String getLqpc() {
        return lqpc;
    }

    public void setLqpc(String lqpc) {
        this.lqpc = lqpc;
    }
}
