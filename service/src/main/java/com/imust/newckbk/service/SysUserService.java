package com.imust.newckbk.service;

import java.util.Map;

import com.github.pagehelper.PageInfo;

import com.imust.newckbk.base.BaseService;
import com.imust.newckbk.base.PageEntity;
import com.imust.newckbk.domain.SysUser;

/**
 * @date 2017-08-19
 * @author jkzzk
 *
 */
public interface SysUserService extends BaseService<SysUser, String> {
    boolean changePwd(SysUser user);

    PageInfo<SysUser> query(PageEntity<Map> params);
}



