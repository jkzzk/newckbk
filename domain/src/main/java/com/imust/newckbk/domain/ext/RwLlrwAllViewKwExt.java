package com.imust.newckbk.domain.ext;

import com.imust.newckbk.domain.RwLlrwAllViewKw;

public class RwLlrwAllViewKwExt extends RwLlrwAllViewKw {

    private String zxjxjhm;

    /**
     * 是否为重修课程
     */
    private Byte ifRetake;

    private String kchs;

    public String getZxjxjhm() {
        return zxjxjhm;
    }

    public void setZxjxjhm(String zxjxjhm) {
        this.zxjxjhm = zxjxjhm;
    }

    public Byte getIfRetake() {
        return ifRetake;
    }

    public void setIfRetake(Byte ifRetake) {
        this.ifRetake = ifRetake;
    }

    public String getKchs() {
        return kchs;
    }

    public void setKchs(String kchs) {
        this.kchs = kchs;
    }
}
