package com.imust.newckbk.dao;

import com.imust.newckbk.domain.CodeNjb;
import com.imust.newckbk.base.BaseDao;

import java.util.List;


/**
* @date 2020-03-07
* @author zzk
* 
*/
public interface CodeNjbDao extends BaseDao<CodeNjb, String>{

    /**
     * ²éÑ¯ËùÓĞ
     * @return
     */
    List<CodeNjb> getAll();
}