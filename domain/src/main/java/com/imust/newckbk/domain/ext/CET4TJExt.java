package com.imust.newckbk.domain.ext;

import com.imust.newckbk.domain.Cet4FirstTerm;
import com.imust.newckbk.domain.Cet4SecondTerm;
import com.imust.newckbk.domain.Cet4Tjjl;
import com.imust.newckbk.domain.Cet4Tytjjl;

public class CET4TJExt extends Cet4Tjjl {

    private String zxjxjhm;

    private String statusName;

    private String halfTermName;

    private Cet4Tytjjl cet4Tytjjl;

    private Cet4FirstTerm cet4FirstTerm;

    private Cet4SecondTerm cet4SecondTerm;

    public CET4TJExt(Cet4Tjjl cet4Tjjl) {
        super.setZxjxjhh(cet4Tjjl.getZxjxjhh());
        super.setFirstGrade(cet4Tjjl.getFirstGrade());
        super.setLastExamTerm(cet4Tjjl.getLastExamTerm());
        super.setHalfTerm(cet4Tjjl.getHalfTerm());
        super.setCet4PassScore(cet4Tjjl.getCet4PassScore());
        super.setCrt4PassScore(cet4Tjjl.getCrt4PassScore());
        super.setCjt4PassScore(cet4Tjjl.getCjt4PassScore());
        super.setTyId(cet4Tjjl.getTyId());
        super.setFirstTermId(cet4Tjjl.getFirstTermId());
        super.setSecondTermId(cet4Tjjl.getSecondTermId());
    }

    public String getZxjxjhm() {
        return zxjxjhm;
    }

    public void setZxjxjhm(String zxjxjhm) {
        this.zxjxjhm = zxjxjhm;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

    public String getHalfTermName() {
        return halfTermName;
    }

    public void setHalfTermName(String halfTermName) {
        this.halfTermName = halfTermName;
    }

    public Cet4Tytjjl getCet4Tytjjl() {
        return cet4Tytjjl;
    }

    public void setCet4Tytjjl(Cet4Tytjjl cet4Tytjjl) {
        this.cet4Tytjjl = cet4Tytjjl;
    }

    public Cet4FirstTerm getCet4FirstTerm() {
        return cet4FirstTerm;
    }

    public void setCet4FirstTerm(Cet4FirstTerm cet4FirstTerm) {
        this.cet4FirstTerm = cet4FirstTerm;
    }

    public Cet4SecondTerm getCet4SecondTerm() {
        return cet4SecondTerm;
    }

    public void setCet4SecondTerm(Cet4SecondTerm cet4SecondTerm) {
        this.cet4SecondTerm = cet4SecondTerm;
    }
}
