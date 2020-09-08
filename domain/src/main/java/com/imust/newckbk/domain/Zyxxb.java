package com.imust.newckbk.domain;

import java.math.BigDecimal;

public class Zyxxb {
    private String id;

    private String xsm;

    private String zym;

    private String xkfl;

    private BigDecimal lqdm;

    private String lqpc;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getXsm() {
        return xsm;
    }

    public void setXsm(String xsm) {
        this.xsm = xsm == null ? null : xsm.trim();
    }

    public String getZym() {
        return zym;
    }

    public void setZym(String zym) {
        this.zym = zym == null ? null : zym.trim();
    }

    public String getXkfl() {
        return xkfl;
    }

    public void setXkfl(String xkfl) {
        this.xkfl = xkfl == null ? null : xkfl.trim();
    }

    public BigDecimal getLqdm() {
        return lqdm;
    }

    public void setLqdm(BigDecimal lqdm) {
        this.lqdm = lqdm;
    }

    public String getLqpc() {
        return lqpc;
    }

    public void setLqpc(String lqpc) {
        this.lqpc = lqpc == null ? null : lqpc.trim();
    }
}