package com.imust.newckbk.domain;

public class CodeNjb {
    private String njdm;

    private String njmc;

    private String bz;

    public String getNjdm() {
        return njdm;
    }

    public void setNjdm(String njdm) {
        this.njdm = njdm == null ? null : njdm.trim();
    }

    public String getNjmc() {
        return njmc;
    }

    public void setNjmc(String njmc) {
        this.njmc = njmc == null ? null : njmc.trim();
    }

    public String getBz() {
        return bz;
    }

    public void setBz(String bz) {
        this.bz = bz == null ? null : bz.trim();
    }
}