package com.imust.newckbk.dao;

import com.imust.newckbk.domain.CetStuscore;
import com.imust.newckbk.base.BaseDao;
import com.imust.newckbk.domain.excel.StatisticReport;
import com.imust.newckbk.domain.ext.CetStuscoreExt;
import com.imust.newckbk.domain.ext.LangStisticExt;

import java.util.List;
import java.util.Map;


/**
* @date 2020-10-06
* @author zzk
* 
*/
public interface CetStuscoreDao extends BaseDao<CetStuscore, String>{

    /**
     * 查询所有考试时间
     *
     * @return
     */
    List<String> getAllExamDate();

    /**
     * 统计各个专业班级学籍人数
     *
     * @return
     */
    List<StatisticReport> statisticBaseNumberRegister(LangStisticExt langStisticExt);

    /**
     * 统计各个专业班级报考人数
     *
     * @return
     */
    List<StatisticReport> statisticBaseNumberEnter(LangStisticExt langStisticExt);

    /**
     * 统计缺考人数
     *
     * @param langStisticExt
     * @return
     */
    List<StatisticReport> statisticMissingNumber(LangStisticExt langStisticExt);

    /**
     * 统计通过人数
     *
     * @param langStisticExt
     * @return
     */
    List<StatisticReport> statisticPassNumber(LangStisticExt langStisticExt);

    /**
     * 统计平均分
     *
     * @param langStisticExt
     * @return
     */
    List<StatisticReport> statisticAvgScore(LangStisticExt langStisticExt);

    /**
     * 统计最高分
     *
     * @param langStisticExt
     * @return
     */
    List<StatisticReport> statisticMaxScore(LangStisticExt langStisticExt);

    /**
     * 分页查询
     *
     * @param data
     * @return
     */
    List<CetStuscoreExt> getByExtPage(Map data);
}