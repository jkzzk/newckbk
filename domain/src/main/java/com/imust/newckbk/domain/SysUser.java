package com.imust.newckbk.domain;

import java.util.List;

import com.imust.newckbk.base.BaseEntity;

public class SysUser extends BaseEntity {
    private String        loginName;
    private String        realName;
    private String        password;
    private String        roleIds;
    private String        salt;
    private String        remark;
    private List<SysRole> roles;

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = (loginName == null)
                         ? null
                         : loginName.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = (password == null)
                        ? null
                        : password.trim();
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = (realName == null)
                        ? null
                        : realName.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = (remark == null)
                      ? null
                      : remark.trim();
    }

    public String getRoleIds() {
        return roleIds;
    }

    public void setRoleIds(String roleIds) {
        this.roleIds = (roleIds == null)
                       ? null
                       : roleIds.trim();
    }

    public List<SysRole> getRoles() {
        return roles;
    }

    public void setRoles(List<SysRole> roles) {
        this.roles = roles;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }
}



