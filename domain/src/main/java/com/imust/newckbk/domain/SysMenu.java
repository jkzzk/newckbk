package com.imust.newckbk.domain;

import java.util.List;

import com.imust.newckbk.base.BaseEntity;

public class SysMenu extends BaseEntity {
    private String       parentId;
    private String        menuName;
    private String        menuText;
    private String        menuUrl;
    private List<SysMenu> childs;
    private List<SysBtn>  btns;
    private boolean       checked;

    public List<SysBtn> getBtns() {
        return btns;
    }

    public void setBtns(List<SysBtn> btns) {
        this.btns = btns;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public List<SysMenu> getChilds() {
        return childs;
    }

    public void setChilds(List<SysMenu> childs) {
        this.childs = childs;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = (menuName == null)
                        ? null
                        : menuName.trim();
    }

    public String getMenuText() {
        return menuText;
    }

    public void setMenuText(String menuText) {
        this.menuText = menuText;
    }

    public String getMenuUrl() {
        return menuUrl;
    }

    public void setMenuUrl(String menuUrl) {
        this.menuUrl = (menuUrl == null)
                       ? null
                       : menuUrl.trim();
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }
}



