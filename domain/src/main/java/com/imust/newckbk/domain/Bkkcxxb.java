package com.imust.newckbk.domain;

import com.imust.newckbk.domain.excel.BkkcxxbExcel;

public class Bkkcxxb {
    private String id;

    private String jxjhh;

    private String xsm;

    private String kch;

    private String kcm;

    private String kcsx;

    private String xs;

    private String xf;

    private String kslx;

    private String sfzzbk;

    public Bkkcxxb() {
    }

    public Bkkcxxb(BkkcxxbExcel bkkcxxbExcel) {
        this.jxjhh = bkkcxxbExcel.getJxjhh();
        this.xsm = bkkcxxbExcel.getXsm();
        this.kch = bkkcxxbExcel.getKch();
        this.kcm = bkkcxxbExcel.getKcm();
        this.kcsx = bkkcxxbExcel.getKcsx();
        this.xs = bkkcxxbExcel.getXs();
        this.xf = bkkcxxbExcel.getXf();
        this.kslx = bkkcxxbExcel.getKslx();
        this.sfzzbk = bkkcxxbExcel.getSfzzbk();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getJxjhh() {
        return jxjhh;
    }

    public void setJxjhh(String jxjhh) {
        this.jxjhh = jxjhh == null ? null : jxjhh.trim();
    }

    public String getXsm() {
        return xsm;
    }

    public void setXsm(String xsm) {
        this.xsm = xsm == null ? null : xsm.trim();
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

    public String getKcsx() {
        return kcsx;
    }

    public void setKcsx(String kcsx) {
        this.kcsx = kcsx == null ? null : kcsx.trim();
    }

    public String getXs() {
        return xs;
    }

    public void setXs(String xs) {
        this.xs = xs == null ? null : xs.trim();
    }

    public String getXf() {
        return xf;
    }

    public void setXf(String xf) {
        this.xf = xf == null ? null : xf.trim();
    }

    public String getKslx() {
        return kslx;
    }

    public void setKslx(String kslx) {
        this.kslx = kslx == null ? null : kslx.trim();
    }

    public String getSfzzbk() {
        return sfzzbk;
    }

    public void setSfzzbk(String sfzzbk) {
        this.sfzzbk = sfzzbk == null ? null : sfzzbk.trim();
    }
}