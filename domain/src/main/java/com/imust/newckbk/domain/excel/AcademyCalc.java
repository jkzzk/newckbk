package com.imust.newckbk.domain.excel;

import java.util.ArrayList;
import java.util.List;

public class AcademyCalc {

    private List<MajorCalc> statisticReportExcels = new ArrayList<MajorCalc>();

    private StatisticReportExcel statisticReportExcelCalc;

    private String key;

    public AcademyCalc() {
    }

    public AcademyCalc(String key) {
        this.key = key;
    }

    public List<MajorCalc> getStatisticReportExcels() {
        return statisticReportExcels;
    }

    public void setStatisticReportExcels(List<MajorCalc> statisticReportExcels) {
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
        AcademyCalc that = (AcademyCalc) o;
        return key.equals(that.key);
    }
}
