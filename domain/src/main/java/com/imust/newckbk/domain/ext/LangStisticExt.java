package com.imust.newckbk.domain.ext;

/**
 * @author jkzzk
 * @description
 * @data 2020/10/7
 */
public class LangStisticExt {

    private String dataSource;

    private String langType;

    private String examDate;

    private String statisticType;

    private String grade;

    private String academy;

    private String major;

    private String classes;

    private Boolean hasLangType = false;

    private Boolean hasAcademy = false;

    private Boolean hasMajor = false;

    private Boolean hasGrade = false;

    private Boolean hasClasses = false;

    public String getDataSource() {
        return dataSource;
    }

    public void setDataSource(String dataSource) {
        this.dataSource = dataSource;
    }

    public String getLangType() {
        return langType;
    }

    public void setLangType(String langType) {
        this.langType = langType;
    }

    public String getExamDate() {
        return examDate;
    }

    public void setExamDate(String examDate) {
        this.examDate = examDate;
    }

    public String getStatisticType() {
        return statisticType;
    }

    public void setStatisticType(String statisticType) {
        this.statisticType = statisticType;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
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

    public String getClasses() {
        return classes;
    }

    public void setClasses(String classes) {
        this.classes = classes;
    }

    public Boolean getHasLangType() {
        return hasLangType;
    }

    public void setHasLangType(Boolean hasLangType) {
        this.hasLangType = hasLangType;
    }

    public Boolean getHasAcademy() {
        return hasAcademy;
    }

    public void setHasAcademy(Boolean hasAcademy) {
        this.hasAcademy = hasAcademy;
    }

    public Boolean getHasMajor() {
        return hasMajor;
    }

    public void setHasMajor(Boolean hasMajor) {
        this.hasMajor = hasMajor;
    }

    public Boolean getHasGrade() {
        return hasGrade;
    }

    public void setHasGrade(Boolean hasGrade) {
        this.hasGrade = hasGrade;
    }

    public Boolean getHasClasses() {
        return hasClasses;
    }

    public void setHasClasses(Boolean hasClasses) {
        this.hasClasses = hasClasses;
    }

    public boolean
    cleanUpStatisticType() {
        if(this.statisticType != null && !this.statisticType.equals("")) {

            if(this.statisticType.contains("1")) {
                this.hasLangType = true;
            }
            if(this.statisticType.contains("2")) {
                this.hasAcademy = true;
            }
            if(this.statisticType.contains("3")) {
                this.hasMajor = true;
            }
            if(this.statisticType.contains("4")) {
                this.hasGrade = true;
            }
            if(this.statisticType.contains("5")) {
                this.hasClasses = true;
            }

            return true;
        }else {
            return false;
        }
    }
}
