package com.imust.newckbk.domain;

import java.math.BigDecimal;

public class XsUnfinished {
    private String xh;

    private BigDecimal xslbdm;

    public String getXh() {
        return xh;
    }

    public void setXh(String xh) {
        this.xh = xh == null ? null : xh.trim();
    }

    public BigDecimal getXslbdm() {
        return xslbdm;
    }

    public void setXslbdm(BigDecimal xslbdm) {
        this.xslbdm = xslbdm;
    }
}