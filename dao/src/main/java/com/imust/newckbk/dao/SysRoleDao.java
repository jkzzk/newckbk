package com.imust.newckbk.dao;

import java.util.List;
import java.util.Map;

import com.imust.newckbk.base.BaseDao;
import com.imust.newckbk.domain.SysRole;

/**
 * @date 2017-08-19
 * @author jkzzk
 *
 */
public interface SysRoleDao extends BaseDao<SysRole, String> {
    List<SysRole> getByMapPage(Map data);
}



