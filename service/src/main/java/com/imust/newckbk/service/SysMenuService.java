package com.imust.newckbk.service;

import java.util.List;
import java.util.Map;

import com.github.pagehelper.PageInfo;

import com.imust.newckbk.base.BaseService;
import com.imust.newckbk.base.PageEntity;
import com.imust.newckbk.domain.SysMenu;

/**
 * @date 2017-08-19
 * @author jkzzk
 *
 */
public interface SysMenuService extends BaseService<SysMenu, String> {
    PageInfo<SysMenu> query(PageEntity<Map> params);

    List<SysMenu> getMenu(Map<String, Object> params);

    List<SysMenu> getMenuAndBtn(String roleIds);
}



