package com.imust.newckbk.domain;

public class Cet4FirstTerm {
    private String classaMin;

    private String classaMax;

    private String classbMin;

    private String classbMax;

    private String classcMin;

    private String classcMax;

    private String id;

    public String getClassaMin() {
        return classaMin;
    }

    public void setClassaMin(String classaMin) {
        this.classaMin = classaMin == null ? null : classaMin.trim();
    }

    public String getClassaMax() {
        return classaMax;
    }

    public void setClassaMax(String classaMax) {
        this.classaMax = classaMax == null ? null : classaMax.trim();
    }

    public String getClassbMin() {
        return classbMin;
    }

    public void setClassbMin(String classbMin) {
        this.classbMin = classbMin == null ? null : classbMin.trim();
    }

    public String getClassbMax() {
        return classbMax;
    }

    public void setClassbMax(String classbMax) {
        this.classbMax = classbMax == null ? null : classbMax.trim();
    }

    public String getClasscMin() {
        return classcMin;
    }

    public void setClasscMin(String classcMin) {
        this.classcMin = classcMin == null ? null : classcMin.trim();
    }

    public String getClasscMax() {
        return classcMax;
    }

    public void setClasscMax(String classcMax) {
        this.classcMax = classcMax == null ? null : classcMax.trim();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }
}