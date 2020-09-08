package com.imust.newckbk.service;

import com.github.pagehelper.PageInfo;
import com.imust.newckbk.base.PageEntity;
import com.imust.newckbk.common.RespData;
import com.imust.newckbk.domain.Zyxxb;
import com.imust.newckbk.base.BaseService;

import java.util.List;
import java.util.Map;


/**
* @date 2020-05-12
* @author jkzzk
* 
*/
public interface ZyxxbService extends BaseService<Zyxxb, String>{


    PageInfo<Zyxxb> query(PageEntity<Map> mapPageEntity);

    RespData saveZyxxb(Zyxxb zyxxb);

    RespData delZyxxb(List<String> ids);

    List<String> getAllXsm(Map<String, Object> params);

    List<String> getAllZym(Map<String, Object> params);
}