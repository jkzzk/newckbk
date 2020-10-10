package com.imust.newckbk.domain.excel;

import java.util.ArrayList;
import java.util.List;

public class GradeCalc {

    private List<StatisticReportExcel> statisticReportExcels = new ArrayList<StatisticReportExcel>();

    private StatisticReportExcel statisticReportExcelCalc;

    private String key;

    public GradeCalc() {
    }

    public GradeCalc(String key) {
        this.key = key;
    }

    public List<StatisticReportExcel> getStatisticReportExcels() {
        return statisticReportExcels;
    }

    public void setStatisticReportExcels(List<StatisticReportExcel> statisticReportExcels) {
        this.statisticReportExcels = statisticReportExcels;
    }

    public StatisticReportExcel getStatisticReportExcelCalc() {
        return statisticReportExcelCalc;
    }

    public void setStatisticReportExcelCalc(StatisticReportExcel statisticReportExcelCalc) {
        this.statisticReportExcelCalc = statisticReportExcelCalc;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GradeCalc that = (GradeCalc) o;
        return key.equals(that.key);
    }
}
