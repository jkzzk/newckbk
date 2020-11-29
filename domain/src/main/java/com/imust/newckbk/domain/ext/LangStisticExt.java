package com.imust.newckbk.domain.ext;

import java.util.ArrayList;
import java.util.List;

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

    private List<GradeParam> gradeParam;

    private GradeParam currentParam;

    private String gradeParamStrs;

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

    public List<GradeParam> getGradeParam() {
        return gradeParam;
    }

    public void setGradeParam(List<GradeParam> gradeParam) {
        this.gradeParam = gradeParam;
    }

    public GradeParam getCurrentParam() {
        return currentParam;
    }

    public void setCurrentParam(GradeParam currentParam) {
        this.currentParam = currentParam;
    }

    public String deCodeGradeParamStrs() {
        String gradeParamStrs = "";
        if(this.gradeParam != null && !this.gradeParam.isEmpty()) {
            for (GradeParam param : this.gradeParam) {
                gradeParamStrs += param.getGradeParamStr() + "@";
            }
            gradeParamStrs = gradeParamStrs.substring(0,gradeParamStrs.length()-1);
        }

        return gradeParamStrs;
    }

    public List<GradeParam> enCodeGradeParamStrs(String gradeParamStrs) {
        List<GradeParam> gradeParams = new ArrayList<GradeParam>();
        String[] gradeParamStr = gradeParamStrs.split("@");
        for (String _gradeParam : gradeParamStr) {
            GradeParam gradeParam = new GradeParam();
            String[] paramChildren = _gradeParam.split("#");
            gradeParam.setGrade(paramChildren[0]);
            gradeParam.setAcademy(paramChildren[1]);
            gradeParam.setMajor(paramChildren[2]);
            gradeParam.setClasses(paramChildren[3]);
            gradeParams.add(gradeParam);
        }

        return gradeParams;
    }

    public String getGradeParamStrs() {
        return gradeParamStrs;
    }

    public void setGradeParamStrs(String gradeParamStrs) {
        this.gradeParamStrs = gradeParamStrs;
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
