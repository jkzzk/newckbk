package com.imust.newckbk.domain.excel;

import com.alibaba.fastjson.support.odps.udf.CodecCheck;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class StatisticStruct {

    List<StatisticReportExcel> statisticReportExcelsBase;

    List<StatisticReportExcel> statisticReportExcelsByLangType;

    List<StatisticReportExcel> statisticReportExcelsByAcademy;

    List<StatisticReportExcel> statisticReportExcelsByMajor;

    List<StatisticReportExcel> statisticReportExcelsByGrade;

    List<StatisticReportExcel> statisticReportExcelsCalc = new ArrayList<StatisticReportExcel>();

    List<LanTypeCalc> lanTypeCalcs = new ArrayList<LanTypeCalc>();

    public StatisticStruct() {
    }

    public StatisticStruct(List<StatisticReportExcel> statisticReportExcelsBase,List<StatisticReportExcel> statisticReportExcelsByLangType, List<StatisticReportExcel> statisticReportExcelsByAcademy, List<StatisticReportExcel> statisticReportExcelsByMajor, List<StatisticReportExcel> statisticReportExcelsByGrade) {
        this.statisticReportExcelsBase = statisticReportExcelsBase;
        this.statisticReportExcelsByLangType = statisticReportExcelsByLangType;
        this.statisticReportExcelsByAcademy = statisticReportExcelsByAcademy;
        this.statisticReportExcelsByMajor = statisticReportExcelsByMajor;
        this.statisticReportExcelsByGrade = statisticReportExcelsByGrade;
    }

    public List<StatisticReportExcel> getStatisticReportExcelsBase() {
        return statisticReportExcelsBase;
    }

    public void setStatisticReportExcelsBase(List<StatisticReportExcel> statisticReportExcelsBase) {
        this.statisticReportExcelsBase = statisticReportExcelsBase;
    }

    public List<StatisticReportExcel> getStatisticReportExcelsByLangType() {
        return statisticReportExcelsByLangType;
    }

    public void setStatisticReportExcelsByLangType(List<StatisticReportExcel> statisticReportExcelsByLangType) {
        this.statisticReportExcelsByLangType = statisticReportExcelsByLangType;
    }

    public List<StatisticReportExcel> getStatisticReportExcelsByAcademy() {
        return statisticReportExcelsByAcademy;
    }

    public void setStatisticReportExcelsByAcademy(List<StatisticReportExcel> statisticReportExcelsByAcademy) {
        this.statisticReportExcelsByAcademy = statisticReportExcelsByAcademy;
    }

    public List<StatisticReportExcel> getStatisticReportExcelsByMajor() {
        return statisticReportExcelsByMajor;
    }

    public void setStatisticReportExcelsByMajor(List<StatisticReportExcel> statisticReportExcelsByMajor) {
        this.statisticReportExcelsByMajor = statisticReportExcelsByMajor;
    }

    public List<StatisticReportExcel> getStatisticReportExcelsByGrade() {
        return statisticReportExcelsByGrade;
    }

    public void setStatisticReportExcelsByGrade(List<StatisticReportExcel> statisticReportExcelsByGrade) {
        this.statisticReportExcelsByGrade = statisticReportExcelsByGrade;
    }

    public List<StatisticReportExcel> getStatisticReportExcelsCalc() {
        return statisticReportExcelsCalc;
    }

    public void setStatisticReportExcelsCalc(List<StatisticReportExcel> statisticReportExcelsCalc) {
        this.statisticReportExcelsCalc = statisticReportExcelsCalc;
    }

    public List<LanTypeCalc> getLanTypeCalcs() {
        return lanTypeCalcs;
    }

    public void setLanTypeCalcs(List<LanTypeCalc> lanTypeCalcs) {
        this.lanTypeCalcs = lanTypeCalcs;
    }

    // 获取统计合计结构
    public StatisticStruct getStatisticStruct() {

        for (StatisticReportExcel statisticReportExcel : this.statisticReportExcelsBase) {
            LanTypeCalc key_lanType = new LanTypeCalc(statisticReportExcel.getLangType());
            if(this.lanTypeCalcs.contains(key_lanType)) {
                int index = this.lanTypeCalcs.indexOf(key_lanType);
                joinAcademyCalc(this.lanTypeCalcs.get(index), statisticReportExcel);
            }else {
                this.lanTypeCalcs.add(key_lanType);
                joinAcademyCalc(key_lanType,statisticReportExcel);
            }
        }

        return this;
    }

    // 插入合计数据到结构中
    public StatisticStruct insertCalcStatisticStruct() {

        for (StatisticReportExcel statisticReportExcel : this.statisticReportExcelsByLangType) {
            for (LanTypeCalc lanTypeCalc : this.lanTypeCalcs) {
                if(lanTypeCalc.getKey().equals(statisticReportExcel.getLangType())) {
                    lanTypeCalc.setStatisticReportExcelCalc(statisticReportExcel);
                }
            }
        }

        for (StatisticReportExcel statisticReportExcel : this.statisticReportExcelsByAcademy) {
            for (LanTypeCalc lanTypeCalc : this.lanTypeCalcs) {
                for (AcademyCalc academyCalc : lanTypeCalc.getStatisticReportExcels()) {
                    if(academyCalc.getKey().equals(statisticReportExcel.getLangType()+statisticReportExcel.getAcademy())) {
                        academyCalc.setStatisticReportExcelCalc(statisticReportExcel);
                    }
                }
            }
        }

        for (StatisticReportExcel statisticReportExcel : this.statisticReportExcelsByMajor) {
            for (LanTypeCalc lanTypeCalc : this.lanTypeCalcs) {
                for (AcademyCalc academyCalc : lanTypeCalc.getStatisticReportExcels()) {
                    for (MajorCalc majorCalc : academyCalc.getStatisticReportExcels()) {
                        if(majorCalc.getKey().equals(statisticReportExcel.getLangType()+statisticReportExcel.getAcademy()+statisticReportExcel.getMajor())) {
                            majorCalc.setStatisticReportExcelCalc(statisticReportExcel);
                        }
                    }
                }
            }
        }

        for (StatisticReportExcel statisticReportExcel : this.statisticReportExcelsByGrade) {
            for (LanTypeCalc lanTypeCalc : this.lanTypeCalcs) {
                for (AcademyCalc academyCalc : lanTypeCalc.getStatisticReportExcels()) {
                    for (MajorCalc majorCalc : academyCalc.getStatisticReportExcels()) {
                        for (GradeCalc gradeCalc : majorCalc.getStatisticReportExcels()) {
                            if(gradeCalc.getKey().equals(statisticReportExcel.getLangType()+statisticReportExcel.getAcademy()+statisticReportExcel.getMajor()+statisticReportExcel.getGrade())) {
                                gradeCalc.setStatisticReportExcelCalc(statisticReportExcel);
                            }
                        }
                    }
                }
            }
        }

        return this;
    }

    // 获取合计后数据
    public StatisticStruct getCalcStatisticStruct() {

        for (LanTypeCalc lanTypeCalc : this.lanTypeCalcs) {
            for (AcademyCalc academyCalc : lanTypeCalc.getStatisticReportExcels()) {
                for (MajorCalc majorCalc : academyCalc.getStatisticReportExcels()) {
                    for (GradeCalc gradeCalc : majorCalc.getStatisticReportExcels()) {
                        this.statisticReportExcelsCalc.addAll(gradeCalc.getStatisticReportExcels());
                        this.statisticReportExcelsCalc.add(gradeCalc.getStatisticReportExcelCalc());
                    }
                    this.statisticReportExcelsCalc.add(majorCalc.getStatisticReportExcelCalc());
                }
                this.statisticReportExcelsCalc.add(academyCalc.getStatisticReportExcelCalc());
            }
            this.statisticReportExcelsCalc.add(lanTypeCalc.getStatisticReportExcelCalc());
        }

        return this;
    }

    private void joinAcademyCalc(LanTypeCalc lanTypeCalc, StatisticReportExcel statisticReportExcel) {
        AcademyCalc key_academy = new AcademyCalc(statisticReportExcel.getLangType()+statisticReportExcel.getAcademy());
        if(lanTypeCalc.getStatisticReportExcels().contains(key_academy)) {
            int index = lanTypeCalc.getStatisticReportExcels().indexOf(key_academy);
            joinMajorCalc(lanTypeCalc.getStatisticReportExcels().get(index), statisticReportExcel);
        }else {
            lanTypeCalc.getStatisticReportExcels().add(key_academy);
            joinMajorCalc(key_academy, statisticReportExcel);
        }
    }

    private void joinMajorCalc(AcademyCalc academyCalc,StatisticReportExcel statisticReportExcel) {
        MajorCalc key_major = new MajorCalc(statisticReportExcel.getLangType()+statisticReportExcel.getAcademy()+statisticReportExcel.getMajor());
        if(academyCalc.getStatisticReportExcels().contains(key_major)) {
            int index = academyCalc.getStatisticReportExcels().indexOf(key_major);
            joinGradeCalc(academyCalc.getStatisticReportExcels().get(index),statisticReportExcel);
        }else {
            academyCalc.getStatisticReportExcels().add(key_major);
            joinGradeCalc(key_major,statisticReportExcel);
        }
    }

    private void joinGradeCalc(MajorCalc majorCalc, StatisticReportExcel statisticReportExcel) {
        GradeCalc key_grade = new GradeCalc(statisticReportExcel.getLangType()+statisticReportExcel.getAcademy()+statisticReportExcel.getMajor()+statisticReportExcel.getGrade());
        key_grade.getStatisticReportExcels().add(statisticReportExcel);
        if(majorCalc.getStatisticReportExcels().contains(key_grade)) {
            int index = majorCalc.getStatisticReportExcels().indexOf(key_grade);
            majorCalc.getStatisticReportExcels().get(index).getStatisticReportExcels().add(statisticReportExcel);
        }else {
            majorCalc.getStatisticReportExcels().add(key_grade);
        }
    }
}
