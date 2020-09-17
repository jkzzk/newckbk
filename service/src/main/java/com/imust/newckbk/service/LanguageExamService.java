package com.imust.newckbk.service;

import com.github.pagehelper.PageInfo;
import com.imust.newckbk.base.PageEntity;
import com.imust.newckbk.common.RespData;
import com.imust.newckbk.domain.LanguageExam;
import com.imust.newckbk.base.BaseService;
import com.imust.newckbk.domain.ext.LanguageExamExt;

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
     * 清除全部数据
     *
     * @return
     */
    RespData clearMaupData();
}