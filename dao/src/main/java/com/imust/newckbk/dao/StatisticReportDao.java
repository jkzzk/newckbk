package com.imust.newckbk.dao;

import com.imust.newckbk.base.BaseDao;
import com.imust.newckbk.domain.excel.StatisticReport;
import com.imust.newckbk.domain.excel.StatisticReportExcel;

import java.util.List;


/**
* @date 2020-10-08
* @author zzk
* 
*/
public interface StatisticReportDao extends BaseDao<StatisticReport, String>{

    /**
     * 获取全部数据
     *
     * @return
     */
    List<StatisticReportExcel> getAll();

    /**
     * 清除旧数据
     *
     */
    void deleteAll();

    /**
     * 按语种类别合计
     *
     * @return
     */
    List<StatisticReportExcel> sumByLangType();

    /**
     * 按学院合计
     *
     * @return
     */
    List<StatisticReportExcel> sumByAcademy();

    /**
     * 按专业合计
     *
     * @return
     */
    List<StatisticReportExcel> sumByMajor();

    /**
     * 按年级合计
     *
     * @return
     */
    List<StatisticReportExcel> sumByGrade();
}