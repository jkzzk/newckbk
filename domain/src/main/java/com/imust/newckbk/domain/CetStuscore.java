package com.imust.newckbk.domain;

import cn.afterturn.easypoi.excel.annotation.Excel;
import org.springframework.web.bind.annotation.RequestMapping;

public class CetStuscore {

    @Excel(name = "考试时间")
    private String ksKssj;

    @Excel(name = "语种类别")
    private String ksYyjb;

    @Excel(name = "学号")
    private String ksXh;

    @Excel(name = "总分")
    private String ksZf;

    @Excel(name = "缺考")
    private String ksQk;

    @Excel(name = "违纪")
    private String ksWj;

    @Excel(name = "学院名称")
    private String ksXymc;

    @Excel(name = "专业名称")
    private String ksZymc;

    @Excel(name = "所属年级")
    private String ksNj;

    @Excel(name = "班级名称")
    private String ksBjmc;

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

    public String getKsWj() {
        return ksWj;
    }

    public void setKsWj(String ksWj) {
        this.ksWj = ksWj == null ? null : ksWj.trim();
    }

    public String getKsXymc() {
        return ksXymc;
    }

    public void setKsXymc(String ksXymc) {
        this.ksXymc = ksXymc;
    }

    public String getKsZymc() {
        return ksZymc;
    }

    public void setKsZymc(String ksZymc) {
        this.ksZymc = ksZymc;
    }

    public String getKsNj() {
        return ksNj;
    }

    public void setKsNj(String ksNj) {
        this.ksNj = ksNj;
    }

    public String getKsBjmc() {
        return ksBjmc;
    }

    public void setKsBjmc(String ksBjmc) {
        this.ksBjmc = ksBjmc;
    }
}