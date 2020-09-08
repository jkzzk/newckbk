package com.imust.newckbk.dao;

import java.util.List;
import java.util.Map;

import com.imust.newckbk.base.BaseDao;
import com.imust.newckbk.domain.SysUser;

/**
 * @date 2017-08-19
 * @author jkzzk
 *
 */
public interface SysUserDao extends BaseDao<SysUser, String> {
    List<SysUser> getByMapPage(Map data);
}



