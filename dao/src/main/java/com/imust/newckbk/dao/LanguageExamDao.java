package com.imust.newckbk.dao;

import com.imust.newckbk.domain.LanguageExam;
import com.imust.newckbk.base.BaseDao;
import com.imust.newckbk.domain.ext.CET4TJExt;
import com.imust.newckbk.domain.ext.LanguageExamExt;
import com.imust.newckbk.domain.ext.LanguageInfoExt;
import org.apache.ibatis.annotations.Param;

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
     * 大一本科CET4名单
     *
     * @param languageInfoExt
     * @return
     */
    List<LanguageExam> generateCET4CollageForFirstGrade(LanguageInfoExt languageInfoExt);

    /**
     * 筛选大二本科CET4名单
     *
     * @param languageInfoExt
     * @return
     */
    List<LanguageExam> generateCET4CollageForSecondGrade(LanguageInfoExt languageInfoExt);

    /**
     * 筛选大三本科CET4名单
     *
     * @param languageInfoExt
     * @return
     */
    List<LanguageExam> generateCET4CollageForThirdGrade(LanguageInfoExt languageInfoExt);

    /**
     * 筛选大四本科CET4名单
     *
     * @param languageInfoExt
     * @return
     */
    List<LanguageExam> generateCET4CollageForFoGrade(LanguageInfoExt languageInfoExt);

    /**
     * 筛选大五本科CET4名单
     *
     * @param languageInfoExt
     * @return
     */
    List<LanguageExam> generateCET4CollageForFifGrade(LanguageInfoExt languageInfoExt);

    /**
     * 筛选专一CET4名单
     *
     * @param languageInfoExt
     * @return
     */
    List<LanguageExam> generateCET4JuniorForFirstGrade(LanguageInfoExt languageInfoExt);

    /**
     * 筛选专二CET4名单
     *
     * @param languageInfoExt
     * @return
     */
    List<LanguageExam> generateCET4JuniorForSecondGrade(LanguageInfoExt languageInfoExt);

    /**
     * 筛选专三CET4名单
     *
     * @param languageInfoExt
     * @return
     */
    List<LanguageExam> generateCET4JuniorForThirdGrade(LanguageInfoExt languageInfoExt);

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
     * @param languageInfoExt
     * @return
     */
    List<LanguageExam> generateCET6ForAll(LanguageInfoExt languageInfoExt);

    /**
     * 俄语四级学生生成
     *
     * @param languageInfoExt
     * @return
     */
    List<LanguageExam> generateCRT4ForAll(LanguageInfoExt languageInfoExt);

    /**
     * 俄语六级级学生生成
     *
     * @param languageInfoExt
     * @return
     */
    List<LanguageExam> generateCRT6ForAll(LanguageInfoExt languageInfoExt);

    /**
     * 日语四级学生生成
     *
     * @param languageInfoExt
     * @return
     */
    List<LanguageExam> generateCJT4ForAll(LanguageInfoExt languageInfoExt);

    /**
     * 日语六级学生生成
     *
     * @param languageInfoExt
     * @return
     */
    List<LanguageExam> generateCJT6ForAll(LanguageInfoExt languageInfoExt);

    /**
     * 德语四级学生生成
     *
     * @param languageInfoExt
     * @return
     */
    List<LanguageExam> generateCGT4ForAll(LanguageInfoExt languageInfoExt);

    /**
     * 德语六级学生生成
     *
     * @param languageInfoExt
     * @return
     */
    List<LanguageExam> generateCGT6ForAll(LanguageInfoExt languageInfoExt);

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

    /**
     * 根据语种类别查询
     *
     * @param exportType
     * @return
     */
    List<LanguageExam> getAllByType(@Param("exportType") String exportType);

    /**
     * 生成英语三级名单
     *
     * @param languageInfoExt
     * @return
     */
    List<LanguageExam> generatePoretcoBForAll(LanguageInfoExt languageInfoExt);
}