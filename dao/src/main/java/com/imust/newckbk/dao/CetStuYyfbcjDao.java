package com.imust.newckbk.dao;

import com.imust.newckbk.domain.CetStuYyfbcj;
import com.imust.newckbk.base.BaseDao;

import java.util.List;
import java.util.Map;


/**
* @date 2020-07-05
* @author zzk
* 
*/
public interface CetStuYyfbcjDao extends BaseDao<CetStuYyfbcj, String>{

    List<CetStuYyfbcj> getExtByPage(Map data);
}