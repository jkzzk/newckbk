package com.imust.newckbk.service;

import com.github.pagehelper.PageInfo;
import com.imust.newckbk.base.PageEntity;
import com.imust.newckbk.common.RespData;
import com.imust.newckbk.domain.LanguageExam;
import com.imust.newckbk.base.BaseService;
import com.imust.newckbk.domain.ext.LangStisticExt;
import com.imust.newckbk.domain.ext.LanguageExamExt;
import com.imust.newckbk.domain.ext.QueryTreeExt;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;


/**
* @date 2020-09-10
* @author jkzzk
* 
*/
public interface LanguageExamService extends BaseService<LanguageExam, String>{

    /**
     * 分页查询
     *
     * @param mapPageEntity
     * @return
     */
    PageInfo<LanguageExamExt> query(PageEntity<Map> mapPageEntity);

    /**
     * 保存语种考试信息
     *
     * @param languageExam
     * @return
     */
    RespData saveLanguageExam(LanguageExam languageExam);

    /**
     * 修改语种考试信息
     *
     * @param languageExam
     * @return
     */
    RespData editLanguageExam(LanguageExam languageExam);

    /**
     * 批量删除
     *
     * @param ids
     * @return
     */
    RespData deleteLanguageExam(String[] ids);

    /**
     * 查询当期资质名单
     *
     * @param zxjxjhh
     * @return
     */
    List<LanguageExam> getAllByTerm(String zxjxjhh);

    /**
     * 生成英语4级数据
     *
     * @return
     */
    RespData generateCET4();

    /**
     * 生成英语6级数据
     *
     * @return
     */
    RespData generateCET6();

    /**
     * 生成俄语4级数据
     *
     * @return
     */
    RespData generateCRT4();

    /**
     * 生成俄语6级数据
     *
     * @return
     */
    RespData generateCRT6();

    /**
     * 生成日语4级数据
     *
     * @return
     */
    RespData generateCJT4();

    /**
     * 生成日语6级数据
     *
     * @return
     */
    RespData generateCJT6();

    /**
     * 生成德语4级数据
     *
     * @return
     */
    RespData generateCGT4();

    /**
     * 生成德语6级数据
     *
     * @return
     */
    RespData generateCGT6();

    /**
     * 清除全部数据
     *
     * @return
     */
    RespData clearMaupData();

    /**
     * 获取所有考试时间
     *
     * @return
     */
    RespData getAllExamDate();

    /**
     * 获取在校年级
     *
     * @return
     */
    RespData getGradeInSchool();

    /**
     * 获取所有学院数据
     *
     * @param queryTreeExt
     * @return
     */
    RespData getAcademy(QueryTreeExt queryTreeExt);

    /**
     * 获取所有班级数据
     *
     * @param queryTreeExt
     * @return
     */
    RespData getMajor(QueryTreeExt queryTreeExt);

    /**
     * 获取所有班级数据
     *
     * @param queryTreeExt
     * @return
     */
    RespData getClasses(QueryTreeExt queryTreeExt);

    /**
     * 统计报表
     *
     * @param langStisticExt
     * @return
     */
    RespData statisticReport(LangStisticExt langStisticExt);

    /**
     * 导出统计报表
     *
     * @param response
     */
    void exportStatistic(HttpServletResponse response);

    /**
     * 通过语种类别获取所有记录
     *
     * @param exportType
     * @return
     */
    List<LanguageExam> getAllByType(String exportType);

    /**
     * 生成3级名单
     *
     * @return
     */
    RespData generatePoretcoB();
}