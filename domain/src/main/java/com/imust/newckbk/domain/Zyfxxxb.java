package com.imust.newckbk.domain;

import com.imust.newckbk.domain.excel.ZyfxxxbExcel;

public class Zyfxxxb {
    private String id;

    private String zym;

    private String xsm;

    private String xkfl;

    private String lqdm;

    private String lqpc;

    public Zyfxxxb() {
    }

    public Zyfxxxb(ZyfxxxbExcel zyfxxxbExcel) {
        this.zym = zyfxxxbExcel.getZym();
        this.xsm = zyfxxxbExcel.getXsm();
        this.xkfl = zyfxxxbExcel.getXkfl();
        this.lqdm = zyfxxxbExcel.getLqdm();
        this.lqpc = zyfxxxbExcel.getLqpc();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getZym() {
        return zym;
    }

    public void setZym(String zym) {
        this.zym = zym == null ? null : zym.trim();
    }

    public String getXsm() {
        return xsm;
    }

    public void setXsm(String xsm) {
        this.xsm = xsm == null ? null : xsm.trim();
    }

    public String getXkfl() {
        return xkfl;
    }

    public void setXkfl(String xkfl) {
        this.xkfl = xkfl == null ? null : xkfl.trim();
    }

    public String getLqdm() {
        return lqdm;
    }

    public void setLqdm(String lqdm) {
        this.lqdm = lqdm == null ? null : lqdm.trim();
    }

    public String getLqpc() {
        return lqpc;
    }

    public void setLqpc(String lqpc) {
        this.lqpc = lqpc == null ? null : lqpc.trim();
    }
}