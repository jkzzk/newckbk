package com.imust.newckbk.domain.excel;

import java.util.ArrayList;
import java.util.List;

public class LanTypeCalc {

    private List<AcademyCalc> statisticReportExcels = new ArrayList<AcademyCalc>();

    private StatisticReportExcel statisticReportExcelCalc;

    private String key;

    public LanTypeCalc() {
    }

    public LanTypeCalc(String key) {
        this.key = key;
    }

    public List<AcademyCalc> getStatisticReportExcels() {
        return statisticReportExcels;
    }

    public void setStatisticReportExcels(List<AcademyCalc> statisticReportExcels) {
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
        LanTypeCalc that = (LanTypeCalc) o;
        return key.equals(that.key);
    }
}
