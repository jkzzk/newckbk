package com.imust.newckbk.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;

import com.imust.newckbk.common.DefaultPage;
import com.imust.newckbk.common.RespData;
import com.imust.newckbk.common.SessionUtils;
import com.imust.newckbk.domain.SysMenu;
import com.imust.newckbk.domain.SysRole;
import com.imust.newckbk.domain.SysUser;
import com.imust.newckbk.service.SysMenuService;
import com.imust.newckbk.service.SysRoleService;

/**
 * 角色
 */
@Controller
@RequestMapping("role")
public class SysRoleController {
    private static final Logger log = LoggerFactory.getLogger("controller");
    @Autowired
    private SysRoleService      sysRoleService;
    @Autowired
    private SysMenuService      sysMenuService;

    /**
     * Description: 角色删除<br>
     * url: /<br>
     * create by: dong gui peng<br>
     * date: 2019/7/3 0003 18:29 <br>
     * @param: JSON:{}<br>
     * @return: com.imust.newckbk.common.RespData<br>
     */
    @RequestMapping("del")
    public @ResponseBody
    RespData del(@RequestParam Map params) {
        log.info("删除角色 params=【" + params + "】");

        try {
            if (sysRoleService.deleteByMap(params) > 0) {
                return RespData.successMsg("已删除！");
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.error("系统异常！" + e);

            return RespData.errorMsg("系统异常！");
        }

        return RespData.errorMsg("删除失败!");
    }

    /**
     * Description: 角色添加修改页面<br>
     * url: /<br>
     * create by: dong gui peng<br>
     * date: 2019/7/3 0003 18:28 <br>
     * @param: JSON:{}<br>
     * @return: java.lang.String<br>
     */
    @RequestMapping("edit")
    public String edit(SysRole role, Model m) {
        List<SysMenu> menus = null;

        if ((role.getId() != null) && (!role.getId().equals(""))) {
            role = sysRoleService.getById(role.getId());
        }

        menus = sysMenuService.getMenuAndBtn((role.getId() != null)
                                             ? role.getId().toString()
                                             : null);
        m.addAttribute("role", role);
        m.addAttribute("menus", menus);

        return "role/edit";
    }

    /**
     * 角色列表
     * @param params
     * @param m
     * @return
     */
    @RequestMapping("list")
    public String list(@RequestParam Map params, Model m) {
        PageInfo<SysRole> page = sysRoleService.query(DefaultPage.setDefaultPage(params));

        m.addAttribute("page", page);
        m.addAttribute("params", params);

        return "role/list";
    }

    /**
     * Description: 角色添加修改信息保存<br>
     * url: /<br>
     * create by: dong gui peng<br>
     * date: 2019/7/3 0003 18:29 <br>
     * @param: JSON:{}<br>
     * @return: com.imust.newckbk.common.RespData<br>
     */
    @RequestMapping("save")
    public @ResponseBody
    RespData save(SysRole role, HttpServletRequest request) {
        log.info("添加角色");

        SysUser user   = SessionUtils.getCurrentSysUser(request);
        int     result = 0;

        try {
            if ((role.getId() != null) && (!role.getId().equals(""))) {
                role.setUpdateBy(user.getId());
                result = sysRoleService.updateById(role);
            } else {
                role.setCreateBy(user.getId());
                role = sysRoleService.insert(role);
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.error("系统异常！" + e);

            return RespData.errorMsg("系统异常！");
        }

        if ((result > 0) || (role != null)) {
            return RespData.successMsg("操作成功!");
        }

        return RespData.errorMsg("操作失败!");
    }
}



