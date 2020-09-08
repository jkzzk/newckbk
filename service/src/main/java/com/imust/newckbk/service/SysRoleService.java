package com.imust.newckbk.service;

import java.util.Map;

import com.github.pagehelper.PageInfo;

import com.imust.newckbk.base.BaseService;
import com.imust.newckbk.base.PageEntity;
import com.imust.newckbk.domain.SysRole;

/**
 * @date 2017-08-19
 * @author jkzzk
 *
 */
public interface SysRoleService extends BaseService<SysRole, String> {
    PageInfo<SysRole> query(PageEntity<Map> params);
}



