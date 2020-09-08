package com.imust.newckbk.domain;

import java.util.List;

import com.imust.newckbk.base.BaseEntity;

public class SysRole extends BaseEntity {
    private String        roleName;
    private String        content;
    private String        menuIds;
    private String        btnIds;
    private List<SysMenu> menus;
    private Byte          preset;

    public String getBtnIds() {
        return btnIds;
    }

    public void setBtnIds(String btnIds) {
        this.btnIds = btnIds;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = (content == null)
                       ? null
                       : content.trim();
    }

    public String getMenuIds() {
        return menuIds;
    }

    public void setMenuIds(String menuIds) {
        this.menuIds = (menuIds == null)
                       ? null
                       : menuIds.trim();
    }

    public List<SysMenu> getMenus() {
        return menus;
    }

    public void setMenus(List<SysMenu> menus) {
        this.menus = menus;
    }

    public Byte getPreset() {
        return preset;
    }

    public void setPreset(Byte preset) {
        this.preset = preset;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = (roleName == null)
                        ? null
                        : roleName.trim();
    }
}



