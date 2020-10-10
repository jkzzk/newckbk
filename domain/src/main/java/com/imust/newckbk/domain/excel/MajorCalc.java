package com.imust.newckbk.domain.excel;

import java.util.ArrayList;
import java.util.List;

public class MajorCalc {

    private List<GradeCalc> statisticReportExcels = new ArrayList<GradeCalc>();

    private StatisticReportExcel statisticReportExcelCalc;

    private String key;

    public MajorCalc() {
    }

    public MajorCalc(String key) {
        this.key = key;
    }

    public List<GradeCalc> getStatisticReportExcels() {
        return statisticReportExcels;
    }

    public void setStatisticReportExcels(List<GradeCalc> statisticReportExcels) {
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
        MajorCalc that = (MajorCalc) o;
        return key.equals(that.key);
    }
}
