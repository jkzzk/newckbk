package com.imust.newckbk.dao;

import com.imust.newckbk.domain.LanguageExam;
import com.imust.newckbk.base.BaseDao;
import com.imust.newckbk.domain.ext.CET4TJExt;
import com.imust.newckbk.domain.ext.LanguageExamExt;

import java.util.List;
import java.util.Map;


/**
* @date 2020-09-10
* @author zzk
* 
*/
public interface LanguageExamDao extends BaseDao<LanguageExam, String>{

    /**
     * 分页查询
     *
     * @param data
     * @return
     */
    List<LanguageExamExt> getExtByPage(Map data);

    /**
     * 批量删除
     *
     * @param ids
     * @return
     */
    int deleteByIdArr(String[] ids);

    /**
     * 获取所有学期
     *
     * @param zxjxjhh
     * @return
     */
    List<LanguageExam> getAllByTerm(String zxjxjhh);

    /**
     * 大一本科英语四级生成
     *
     * @param currentAllCET4TJ
     * @return
     */
    List<LanguageExam> generateCET4ForFirstGrade(CET4TJExt currentAllCET4TJ);

    /**
     * 专科英语四级生成
     *
     * @param currentAllCET4TJ
     * @return
     */
    List<LanguageExam> generateCET4ForJunior(CET4TJExt currentAllCET4TJ);

    /**
     * 其他本科年级英语四级生成
     *
     * @param currentAllCET4TJ
     * @return
     */
    List<LanguageExam> generateCET4ForOther(CET4TJExt currentAllCET4TJ);

    /**
     * 英语六级学生生成
     *
     * @param currentAllCET4TJ
     * @return
     */
    List<LanguageExam> generateCET6ForAll(CET4TJExt currentAllCET4TJ);

    /**
     * 俄语四级学生生成
     *
     * @param currentAllCET4TJ
     * @return
     */
    List<LanguageExam> generateCRT4ForAll(CET4TJExt currentAllCET4TJ);

    /**
     * 俄语六级级学生生成
     *
     * @param currentAllCET4TJ
     * @return
     */
    List<LanguageExam> generateCRT6ForAll(CET4TJExt currentAllCET4TJ);

    /**
     * 日语四级学生生成
     *
     * @param currentAllCET4TJ
     * @return
     */
    List<LanguageExam> generateCJT4ForAll(CET4TJExt currentAllCET4TJ);

    /**
     * 日语六级学生生成
     *
     * @param currentAllCET4TJ
     * @return
     */
    List<LanguageExam> generateCJT6ForAll(CET4TJExt currentAllCET4TJ);

    /**
     * 批量删除
     *
     * @param languageExamsForFirstGrade
     * @return
     */
    int insertBatch(List<LanguageExam> languageExamsForFirstGrade);

    /**
     * 删除全部数据
     *
     * @return
     */
    int deleteAll();
}