package com.imust.newckbk.service;

import com.github.pagehelper.PageInfo;
import com.imust.newckbk.base.PageEntity;
import com.imust.newckbk.domain.Jwkzxxjl;
import com.imust.newckbk.base.BaseService;
import com.imust.newckbk.domain.SysUser;
import com.imust.newckbk.domain.ext.JwkzxxjlExt;

import java.util.Map;


/**
* @date 2020-02-29
* @author jkzzk
* 
*/
public interface JwkzxxjlService extends BaseService<Jwkzxxjl, String>{

    PageInfo<JwkzxxjlExt> query(PageEntity<Map> pageParams);

    Jwkzxxjl getCurrentSet();

    int setCurrentSet(Jwkzxxjl jwkzxxjl, SysUser currentSysUser);

    int clearRecord();
}