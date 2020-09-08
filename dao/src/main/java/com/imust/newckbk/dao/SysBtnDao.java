package com.imust.newckbk.dao;

import java.util.List;
import java.util.Map;

import com.imust.newckbk.base.BaseDao;
import com.imust.newckbk.domain.SysBtn;

/**
 * @date 2017-08-24
 * @author jkzzk
 *
 */
public interface SysBtnDao extends BaseDao<SysBtn, String> {
    List<SysBtn> getByMapPage(Map data);
}



