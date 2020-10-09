package com.imust.newckbk.dao;

import com.imust.newckbk.domain.LanguageTjjl;
import com.imust.newckbk.base.BaseDao;
import com.imust.newckbk.domain.ext.LanguageInfoExt;


/**
* @date 2020-09-29
* @author zzk
* 
*/
public interface LanguageTjjlDao extends BaseDao<LanguageTjjl, String>{

    /**
     * 查询所有条件信息
     *
     * @return
     */
    LanguageInfoExt getAllTj();
}