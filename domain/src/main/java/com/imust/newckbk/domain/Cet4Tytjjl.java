package com.imust.newckbk.domain;

public class Cet4Tytjjl {
    private String missingExam;

    private String passedExam;

    private String isJapanese;

    private String isRussian;

    private String japaneseKch;

    private String russianKch;

    private String specialXsm;

    private String id;

    private String cet3Score;

    public String getMissingExam() {
        return missingExam;
    }

    public void setMissingExam(String missingExam) {
        this.missingExam = missingExam == null ? null : missingExam.trim();
    }

    public String getPassedExam() {
        return passedExam;
    }

    public void setPassedExam(String passedExam) {
        this.passedExam = passedExam == null ? null : passedExam.trim();
    }

    public String getIsJapanese() {
        return isJapanese;
    }

    public void setIsJapanese(String isJapanese) {
        this.isJapanese = isJapanese == null ? null : isJapanese.trim();
    }

    public String getIsRussian() {
        return isRussian;
    }

    public void setIsRussian(String isRussian) {
        this.isRussian = isRussian == null ? null : isRussian.trim();
    }

    public String getJapaneseKch() {
        return japaneseKch;
    }

    public void setJapaneseKch(String japaneseKch) {
        this.japaneseKch = japaneseKch == null ? null : japaneseKch.trim();
    }

    public String getRussianKch() {
        return russianKch;
    }

    public void setRussianKch(String russianKch) {
        this.russianKch = russianKch == null ? null : russianKch.trim();
    }

    public String getSpecialXsm() {
        return specialXsm;
    }

    public void setSpecialXsm(String specialXsm) {
        this.specialXsm = specialXsm == null ? null : specialXsm.trim();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getCet3Score() {
        return cet3Score;
    }

    public void setCet3Score(String cet3Score) {
        this.cet3Score = cet3Score == null ? null : cet3Score.trim();
    }
}