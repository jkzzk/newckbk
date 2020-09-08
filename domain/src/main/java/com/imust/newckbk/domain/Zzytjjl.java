package com.imust.newckbk.domain;

import java.math.BigDecimal;

public class Zzytjjl {
    private String id;

    private String grades;

    private BigDecimal status;

    private String zxjxjhh;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getGrades() {
        return grades;
    }

    public void setGrades(String grades) {
        this.grades = grades == null ? null : grades.trim();
    }

    public BigDecimal getStatus() {
        return status;
    }

    public void setStatus(BigDecimal status) {
        this.status = status;
    }

    public String getZxjxjhh() {
        return zxjxjhh;
    }

    public void setZxjxjhh(String zxjxjhh) {
        this.zxjxjhh = zxjxjhh;
    }
}