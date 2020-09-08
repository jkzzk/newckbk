package com.imust.newckbk.service;

import com.imust.newckbk.common.RespData;
import com.imust.newckbk.domain.CodeNjb;
import com.imust.newckbk.base.BaseService;


/**
* @date 2020-03-07
* @author jkzzk
* 
*/
public interface CodeNjbService extends BaseService<CodeNjb, String>{

    RespData getAllGrade();
}