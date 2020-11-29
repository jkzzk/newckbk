package com.imust.newckbk.domain.ext;

public class GradeParam {

    private String grade;

    private String academy;

    private String major;

    private String classes;

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

    public String getGradeParamStr() {
        return this.grade + '#' + this.academy + '#' + this.major + '#' + this.classes;
    }
}
