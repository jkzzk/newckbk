package com.imust.newckbk.domain.excel;

public class StatisticReportExcel {
    private String langType;

    private String academy;

    private String major;

    private String grade;

    private String classes;

    private String schoolNumber;

    private String baseNumber;

    private String actualNumber;

    private String missingNumber;

    private String missingRate;

    private String passNumber;

    private String schoolPassRate;

    private String passRate;

    private String avgScore;

    private String maxScore;

    public String getLangType() {
        return langType;
    }

    public void setLangType(String langType) {
        this.langType = langType == null ? null : langType.trim();
    }

    public String getAcademy() {
        return academy;
    }

    public void setAcademy(String academy) {
        this.academy = academy == null ? null : academy.trim();
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major == null ? null : major.trim();
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade == null ? null : grade.trim();
    }

    public String getClasses() {
        return classes;
    }

    public void setClasses(String classes) {
        this.classes = classes == null ? null : classes.trim();
    }

    public String getSchoolNumber() {
        return schoolNumber;
    }

    public void setSchoolNumber(String schoolNumber) {
        this.schoolNumber = schoolNumber == null ? null : schoolNumber.trim();
    }

    public String getBaseNumber() {
        return baseNumber;
    }

    public void setBaseNumber(String baseNumber) {
        this.baseNumber = baseNumber == null ? null : baseNumber.trim();
    }

    public String getActualNumber() {
        return actualNumber;
    }

    public void setActualNumber(String actualNumber) {
        this.actualNumber = actualNumber == null ? null : actualNumber.trim();
    }

    public String getMissingNumber() {
        return missingNumber;
    }

    public void setMissingNumber(String missingNumber) {
        this.missingNumber = missingNumber == null ? null : missingNumber.trim();
    }

    public String getMissingRate() {
        return missingRate;
    }

    public void setMissingRate(String missingRate) {
        this.missingRate = missingRate == null ? null : missingRate.trim();
    }

    public String getPassNumber() {
        return passNumber;
    }

    public void setPassNumber(String passNumber) {
        this.passNumber = passNumber == null ? null : passNumber.trim();
    }

    public String getSchoolPassRate() {
        return schoolPassRate;
    }

    public void setSchoolPassRate(String schoolPassRate) {
        this.schoolPassRate = schoolPassRate == null ? null : schoolPassRate.trim();
    }

    public String getPassRate() {
        return passRate;
    }

    public void setPassRate(String passRate) {
        this.passRate = passRate == null ? null : passRate.trim();
    }

    public String getAvgScore() {
        return avgScore;
    }

    public void setAvgScore(String avgScore) {
        this.avgScore = avgScore == null ? null : avgScore.trim();
    }

    public String getMaxScore() {
        return maxScore;
    }

    public void setMaxScore(String maxScore) {
        this.maxScore = maxScore == null ? null : maxScore.trim();
    }
}