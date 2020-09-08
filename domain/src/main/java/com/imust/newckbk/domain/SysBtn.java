package com.imust.newckbk.domain;

import java.io.Serializable;

public class SysBtn implements Serializable {
    private String id;
    private String  btnName;
    private String  btnCode;
    private String  btnUrl;
    private Integer menuId;
    private String  menuName;
    private boolean checked;

    public String getBtnCode() {
        return btnCode;
    }

    public void setBtnCode(String btnCode) {
        this.btnCode = (btnCode == null)
                       ? null
                       : btnCode.trim();
    }

    public String getBtnName() {
        return btnName;
    }

    public void setBtnName(String btnName) {
        this.btnName = (btnName == null)
                       ? null
                       : btnName.trim();
    }

    public String getBtnUrl() {
        return btnUrl;
    }

    public void setBtnUrl(String btnUrl) {
        this.btnUrl = (btnUrl == null)
                      ? null
                      : btnUrl.trim();
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getMenuId() {
        return menuId;
    }

    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }
}



