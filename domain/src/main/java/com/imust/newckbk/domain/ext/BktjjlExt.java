package com.imust.newckbk.domain.ext;

import com.imust.newckbk.domain.Bktjjl;

public class BktjjlExt extends Bktjjl {

    /**
     * 补考对象名称
     */
    private String bkdxmc;

    /**
     * 补考类型名称
     */
    private String bklxmc;

    /**
     * 是否是当前条件设置
     */
    private String isCurrentName;

    /**
     * 本学期名称
     */
    private String zxjxjhm;

    /**
     * 上学期名称
     */
    private String sxqzxjxjhm;

    /**
     * 创建人名称
     */
    private String realName;

    public String getBkdxmc() {
        return bkdxmc;
    }

    public void setBkdxmc(String bkdxmc) {
        this.bkdxmc = bkdxmc;
    }

    public String getBklxmc() {
        return bklxmc;
    }

    public void setBklxmc(String bklxmc) {
        this.bklxmc = bklxmc;
    }

    public String getIsCurrentName() {
        return isCurrentName;
    }

    public void setIsCurrentName(String isCurrentName) {
        this.isCurrentName = isCurrentName;
    }

    public String getZxjxjhm() {
        return zxjxjhm;
    }

    public void setZxjxjhm(String zxjxjhm) {
        this.zxjxjhm = zxjxjhm;
    }

    public String getSxqzxjxjhm() {
        return sxqzxjxjhm;
    }

    public void setSxqzxjxjhm(String sxqzxjxjhm) {
        this.sxqzxjxjhm = sxqzxjxjhm;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }
}
