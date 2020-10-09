package com.imust.newckbk.dao;

import com.imust.newckbk.domain.CodeXxxxb;
import com.imust.newckbk.base.BaseDao;

import java.util.List;


/**
* @date 2020-10-06
* @author zzk
* 
*/
public interface CodeXxxxbDao extends BaseDao<CodeXxxxb, String>{

    /**
     * 通过年级获取所有记录
     *
     * @param gradeInSchool
     * @return
     */
    List<CodeXxxxb> getByGrades(List<String> gradeInSchool);
}