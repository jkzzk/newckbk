package com.imust.newckbk.domain.ext;

import com.imust.newckbk.domain.excel.StatisticReport;

import java.util.List;

public class StatisticReportExt {

    List<StatisticReport> schoolBaseNumber;

    List<StatisticReport> baseNumber;

    List<StatisticReport> missingNumber;

    List<StatisticReport> passNumber;

    List<StatisticReport> avgScore;

    List<StatisticReport> maxScore;

    public List<StatisticReport> getSchoolBaseNumber() {
        return schoolBaseNumber;
    }

    public void setSchoolBaseNumber(List<StatisticReport> schoolBaseNumber) {
        this.schoolBaseNumber = schoolBaseNumber;
    }

    public List<StatisticReport> getBaseNumber() {
        return baseNumber;
    }

    public void setBaseNumber(List<StatisticReport> baseNumber) {
        this.baseNumber = baseNumber;
    }

    public List<StatisticReport> getMissingNumber() {
        return missingNumber;
    }

    public void setMissingNumber(List<StatisticReport> missingNumber) {
        this.missingNumber = missingNumber;
    }

    public List<StatisticReport> getPassNumber() {
        return passNumber;
    }

    public void setPassNumber(List<StatisticReport> passNumber) {
        this.passNumber = passNumber;
    }

    public List<StatisticReport> getAvgScore() {
        return avgScore;
    }

    public void setAvgScore(List<StatisticReport> avgScore) {
        this.avgScore = avgScore;
    }

    public List<StatisticReport> getMaxScore() {
        return maxScore;
    }

    public void setMaxScore(List<StatisticReport> maxScore) {
        this.maxScore = maxScore;
    }
}
