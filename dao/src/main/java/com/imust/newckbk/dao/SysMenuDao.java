package com.imust.newckbk.dao;

import java.util.List;
import java.util.Map;

import com.imust.newckbk.base.BaseDao;
import com.imust.newckbk.domain.SysMenu;

/**
 * @date 2017-08-19
 * @author jkzzk
 *
 */
public interface SysMenuDao extends BaseDao<SysMenu, String> {
    List<SysMenu> getByMapPage(Map data);

    List<SysMenu> getMenu(Map<String, Object> params);

    List<SysMenu> getMenus(Map<String, Object> params);
}



