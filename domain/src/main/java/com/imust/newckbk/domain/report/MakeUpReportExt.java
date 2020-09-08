package com.imust.newckbk.domain.report;

import com.imust.newckbk.domain.XsXjxxbViewKw;
import com.imust.newckbk.utils.Base64;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

public class MakeUpReportExt {

    private String xh;

    private String xm;

    private String xb;

    private String xsm;

    private String bjh;

    private String sfzh;

    private String zym;

    private String xslb;

    private String term;

    public MakeUpReportExt(XsXjxxbViewKw xsXjxxbViewKw, String zxjxjhm) throws UnsupportedEncodingException {
        this.xh = xsXjxxbViewKw.getXh();
        this.xm = xsXjxxbViewKw.getXm();
        this.xb = xsXjxxbViewKw.getXb();
        this.xsm = xsXjxxbViewKw.getXsm();
        this.bjh = xsXjxxbViewKw.getBjh();
        this.sfzh = xsXjxxbViewKw.getSfzh();
        this.zym = xsXjxxbViewKw.getZym();
        this.xslb = xsXjxxbViewKw.getXslbsm();
        this.term = zxjxjhm;
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

    public String getXb() {
        return xb;
    }

    public void setXb(String xb) {
        this.xb = xb;
    }

    public String getXsm() {
        return xsm;
    }

    public void setXsm(String xsm) {
        this.xsm = xsm;
    }

    public String getBjh() {
        return bjh;
    }

    public void setBjh(String bjh) {
        this.bjh = bjh;
    }

    public String getSfzh() {
        return sfzh;
    }

    public void setSfzh(String sfzh) {
        this.sfzh = sfzh;
    }

    public String getZym() {
        return zym;
    }

    public void setZym(String zym) {
        this.zym = zym;
    }

    public String getXslb() {
        return xslb;
    }

    public void setXslb(String xslb) {
        this.xslb = xslb;
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }
}
