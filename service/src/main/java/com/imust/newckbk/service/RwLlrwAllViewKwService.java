package com.imust.newckbk.service;

import com.github.pagehelper.PageInfo;
import com.imust.newckbk.base.PageEntity;
import com.imust.newckbk.common.RespData;
import com.imust.newckbk.domain.RwLlrwAllViewKw;
import com.imust.newckbk.base.BaseService;
import com.imust.newckbk.domain.ext.RwLlrwAllViewKwExt;

import java.util.Map;


/**
* @date 2020-05-04
* @author jkzzk
* 
*/
public interface RwLlrwAllViewKwService extends BaseService<RwLlrwAllViewKw, String>{

    PageInfo<RwLlrwAllViewKwExt> query(PageEntity<Map> mapPageEntity);

    RespData setRetake(RwLlrwAllViewKwExt rwLlrwAllViewKwExt);

    RespData reSetRetake(RwLlrwAllViewKwExt rwLlrwAllViewKwExt);
}