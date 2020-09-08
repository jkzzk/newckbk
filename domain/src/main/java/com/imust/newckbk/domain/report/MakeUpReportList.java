package com.imust.newckbk.domain.report;

import java.math.BigDecimal;

public class MakeUpReportList {

    private String KCH;

    private String KCM;

    private BigDecimal XF;

    private BigDecimal MAXSCORE;

    private String IFPAY;

    public String getKCH() {
        return KCH;
    }

    public void setKCH(String KCH) {
        this.KCH = KCH;
    }

    public String getKCM() {
        return KCM;
    }

    public void setKCM(String KCM) {
        this.KCM = KCM;
    }

    public BigDecimal getXF() {
        return XF;
    }

    public void setXF(BigDecimal XF) {
        this.XF = XF;
    }

    public BigDecimal getMAXSCORE() {
        return MAXSCORE;
    }

    public void setMAXSCORE(BigDecimal MAXSCORE) {
        this.MAXSCORE = MAXSCORE;
    }

    public String getIFPAY() {
        return IFPAY;
    }

    public void setIFPAY(String IFPAY) {
        this.IFPAY = IFPAY;
    }
}
