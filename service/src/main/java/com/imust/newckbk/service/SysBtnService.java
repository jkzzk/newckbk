package com.imust.newckbk.service;

import java.util.Map;

import com.github.pagehelper.PageInfo;

import com.imust.newckbk.base.BaseService;
import com.imust.newckbk.base.PageEntity;
import com.imust.newckbk.domain.SysBtn;

/**
 * @date 2017-08-24
 * @author jkzzk
 *
 */
public interface SysBtnService extends BaseService<SysBtn, String> {
    PageInfo<SysBtn> query(PageEntity<Map> params);
}



