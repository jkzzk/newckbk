package com.imust.newckbk.domain.excel;

import cn.afterturn.easypoi.excel.annotation.Excel;

import java.math.BigDecimal;

/**
 * @author jkzzk
 * @description
 * @data 2020/10/7
 */
public class StatisticReport {

    private String langType;

    private String academy;

    private String major;

    private String grade;

    private String classes;

    private Integer schoolNumber = 0;

    private Integer baseNumber = 0;

    private Integer actualNumber = 0;

    private Integer missingNumber = 0;

    private BigDecimal missingRate = new BigDecimal(0);

    private Integer passNumber = 0;

    private BigDecimal schoolPassRate = new BigDecimal(0);

    private BigDecimal passRate  = new BigDecimal(0);

    private BigDecimal avgScore  = new BigDecimal(0);

    private BigDecimal maxScore  = new BigDecimal(0);

    public String getLangType() {
        return langType;
    }

    public void setLangType(String langType) {
        this.langType = langType;
    }

    public String getAcademy() {
        return academy;
    }

    public void setAcademy(String academy) {
        this.academy = academy;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getClasses() {
        return classes;
    }

    public void setClasses(String classes) {
        this.classes = classes;
    }

    public Integer getBaseNumber() {
        return baseNumber;
    }

    public void setBaseNumber(Integer baseNumber) {
        this.baseNumber = baseNumber;
    }

    public Integer getActualNumber() {
        return actualNumber;
    }

    public void setActualNumber(Integer actualNumber) {
        this.actualNumber = actualNumber;
    }

    public Integer getMissingNumber() {
        return missingNumber;
    }

    public void setMissingNumber(Integer missingNumber) {
        this.missingNumber = missingNumber;
    }

    public BigDecimal getMissingRate() {
        return missingRate;
    }

    public void setMissingRate(BigDecimal missingRate) {
        this.missingRate = missingRate;
    }

    public Integer getPassNumber() {
        return passNumber;
    }

    public void setPassNumber(Integer passNumber) {
        this.passNumber = passNumber;
    }

    public BigDecimal getPassRate() {
        return passRate;
    }

    public void setPassRate(BigDecimal passRate) {
        this.passRate = passRate;
    }

    public BigDecimal getAvgScore() {
        return avgScore;
    }

    public void setAvgScore(BigDecimal avgScore) {
        this.avgScore = avgScore;
    }

    public BigDecimal getMaxScore() {
        return maxScore;
    }

    public void setMaxScore(BigDecimal maxScore) {
        this.maxScore = maxScore;
    }

    public Integer getSchoolNumber() {
        return schoolNumber;
    }

    public void setSchoolNumber(Integer schoolNumber) {
        this.schoolNumber = schoolNumber;
    }

    public BigDecimal getSchoolPassRate() {
        return schoolPassRate;
    }

    public void setSchoolPassRate(BigDecimal schoolPassRate) {
        this.schoolPassRate = schoolPassRate;
    }
}
