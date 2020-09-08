package com.imust.newckbk.dao;

import com.imust.newckbk.domain.RwLlrwAllViewKw;
import com.imust.newckbk.base.BaseDao;
import com.imust.newckbk.domain.ext.RwLlrwAllViewKwExt;

import java.util.List;
import java.util.Map;


/**
* @date 2020-05-04
* @author zzk
* 
*/
public interface RwLlrwAllViewKwDao extends BaseDao<RwLlrwAllViewKw, String>{

    /**
     * ∑÷“≥≤È—Ø
     * @param data
     * @return
     */
    List<RwLlrwAllViewKwExt> getExtByPage(Map data);
}