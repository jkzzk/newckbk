package com.imust.newckbk.dao;

import com.imust.newckbk.domain.LanguageExam;
import com.imust.newckbk.base.BaseDao;
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
}