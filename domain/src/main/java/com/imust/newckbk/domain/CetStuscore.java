package com.imust.newckbk.domain;

public class CetStuscore {
    private String ksKssj;

    private String ksYyjb;

    private String ksXh;

    private String ksZf;

    private String ksQk;

    public String getKsKssj() {
        return ksKssj;
    }

    public void setKsKssj(String ksKssj) {
        this.ksKssj = ksKssj == null ? null : ksKssj.trim();
    }

    public String getKsYyjb() {
        return ksYyjb;
    }

    public void setKsYyjb(String ksYyjb) {
        this.ksYyjb = ksYyjb == null ? null : ksYyjb.trim();
    }

    public String getKsXh() {
        return ksXh;
    }

    public void setKsXh(String ksXh) {
        this.ksXh = ksXh == null ? null : ksXh.trim();
    }

    public String getKsZf() {
        return ksZf;
    }

    public void setKsZf(String ksZf) {
        this.ksZf = ksZf == null ? null : ksZf.trim();
    }

    public String getKsQk() {
        return ksQk;
    }

    public void setKsQk(String ksQk) {
        this.ksQk = ksQk == null ? null : ksQk.trim();
    }
}