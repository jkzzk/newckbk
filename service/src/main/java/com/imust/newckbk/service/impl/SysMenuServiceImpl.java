package com.imust.newckbk.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import com.imust.newckbk.base.AbstractService;
import com.imust.newckbk.base.PageEntity;
import com.imust.newckbk.dao.SysAuthorDao;
import com.imust.newckbk.dao.SysBtnDao;
import com.imust.newckbk.dao.SysMenuDao;
import com.imust.newckbk.domain.SysAuthor;
import com.imust.newckbk.domain.SysBtn;
import com.imust.newckbk.domain.SysMenu;
import com.imust.newckbk.eunm.ResType;
import com.imust.newckbk.service.SysMenuService;

/**
 * @date 2017-08-19
 * @author jkzzk
 *
 */
@Service("sysMenuService")
public class SysMenuServiceImpl extends AbstractService<SysMenu, String> implements SysMenuService {
    @Autowired
    private SysMenuDao   sysMenuDao;
    @Autowired
    private SysBtnDao    sysBtnDao;
    @Autowired
    private SysAuthorDao sysAuthorDao;

    @Override
    public SysMenu insert(SysMenu record) {
        record.setCreateTime(new Date());
        record.setDeleted((byte) 0);

        return super.insert(record);
    }

    @Override
    public PageInfo<SysMenu> query(PageEntity<Map> params) {
        PageHelper.startPage(params.getPageNumber(), params.getPageSize());

        return new PageInfo<SysMenu>(sysMenuDao.getByMapPage(params.getData()));
    }

    private List<SysMenu> recursion(List<SysMenu> menus) {
        Map<String, Object> params = new HashMap<String, Object>();

        for (SysMenu menu : menus) {
            params.put("parentId", menu.getId());

            List<SysMenu> child = sysMenuDao.getMenus(params);

            if ((null != child) && (child.size() > 0)) {
                menu.setChilds(child);
                recursion(child);
            }
        }

        return menus;
    }

    @Override
    public int updateById(SysMenu record) {
        record.setUpdateTime(new Date());

        return super.updateById(record);
    }

    @Override
    public List<SysMenu> getAll() {
        Map<String, Object> params = new HashMap<String, Object>();

        params.put("parentId", -1);

        List<SysMenu> menus = sysMenuDao.getMenus(params);

        return recursion(menus);
    }

    @PostConstruct
    public void setBaseDao() {
        super.setBaseDao(sysMenuDao);
    }

    public List<SysMenu> getMenu(Map<String, Object> params) {
        params.put("parentId", "-1");

        List<SysMenu> menus = sysMenuDao.getMenu(params);

        for (SysMenu menu : menus) {
            params.replace("parentId", menu.getId());

            List<SysMenu> child = sysMenuDao.getMenu(params);

            if ((null != child) && (child.size() > 0)) {
                params.put("resType", ResType.RES_TYPE_BTN.getCode());

                List<SysBtn> btns = sysBtnDao.getByMap(params);

                menu.setBtns(btns);
                menu.setChilds(child);
            }
        }

        return menus;
    }

    @Override
    public List<SysMenu> getMenuAndBtn(String roleIds) {
        Map<String, Object> params = new HashMap<>();
        List<SysMenu>       menus  = this.getAll();

        for (SysMenu menu : menus) {
            if (menu.getChilds() != null) {
                for (SysMenu child : menu.getChilds()) {
                    params.clear();
                    params.put("menuId", child.getId());

                    List<SysBtn> btns = sysBtnDao.getByMap(params);

                    child.setBtns(btns);
                }
            }
        }

        if (roleIds != null) {
            params.clear();
            params.put("roleIds", roleIds);

            List<SysAuthor> authors = sysAuthorDao.getByMap(params);

            for (SysAuthor author : authors) {
                for (SysMenu menu : menus) {
                    if (author.getResType().byteValue() == ResType.RES_TYPE_MENU.getCode().byteValue()) {
                        if (menu.getId().equals(author.getResId())) {
                            menu.setChecked(true);
                        }
                    }

                    if (menu.getChilds() != null) {
                        for (SysMenu child : menu.getChilds()) {
                            if (author.getResType().byteValue() == ResType.RES_TYPE_MENU.getCode().byteValue()) {
                                if (child.getId().equals(author.getResId())) {
                                    child.setChecked(true);
                                }
                            }

                            for (SysBtn btn : child.getBtns()) {
                                if (author.getResType().byteValue() == ResType.RES_TYPE_BTN.getCode().byteValue()) {
                                    if (btn.getId().equals(author.getResId().intValue())) {
                                        btn.setChecked(true);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        return menus;
    }
}


