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
import com.imust.newckbk.domain.SysUser;
import com.imust.newckbk.service.SysMenuService;

/**
 * Created by sunwei on 2017/8/23.
 */
@Controller
@RequestMapping("menu")
public class SysMenuController {
    private static final Logger log = LoggerFactory.getLogger("controller");
    @Autowired
    private SysMenuService      sysMenuService;

    /**
     * Description: 菜单删除<br>
     * url: /<br>
     * create by: dong gui peng<br>
     * date: 2019/7/3 0003 18:28 <br>
     * @param: JSON:{}<br>
     * @return: com.imust.newckbk.common.RespData<br>
     */
    @RequestMapping("del")
    public @ResponseBody
    RespData del(@RequestParam Map params) {
        log.info("删除菜单 params=【" + params + "】");

        try {
            if (sysMenuService.deleteByMap(params) > 0) {
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
     * Description: 菜单添加修改页面<br>
     * url: /<br>
     * create by: dong gui peng<br>
     * date: 2019/7/3 0003 18:27 <br>
     * @param: JSON:{}<br>
     * @return: java.lang.String<br>
     */
    @RequestMapping("edit")
    public String edit(SysMenu menu, Model m) {
        List<SysMenu> menus = null;

        if ((menu.getId() != null) &&  (menu.getId() != null) && (!menu.getId().equals(""))) {
            menu = sysMenuService.getById(menu.getId());
        }

        menus = sysMenuService.getByMap(null);
        m.addAttribute("menu", menu);
        m.addAttribute("menus", menus);

        return "menu/edit";
    }

    /**
     * Description: 菜单列表<br>
     * url: /<br>
     * create by: dong gui peng<br>
     * date: 2019/7/3 0003 18:27 <br>
     * @param: JSON:{}<br>
     * @return: java.lang.String<br>
     */
    @RequestMapping("list")
    public String list(@RequestParam Map params, Model m) {
        PageInfo<SysMenu> page = sysMenuService.query(DefaultPage.setDefaultPage(params));

        m.addAttribute("page", page);
        m.addAttribute("params", params);

        return "menu/list";
    }

    /**
     * Description: 菜单添加与修改信息保存<br>
     * url: /<br>
     * create by: dong gui peng<br>
     * date: 2019/7/3 0003 18:28 <br>
     * @param: JSON:{}<br>
     * @return: com.imust.newckbk.common.RespData<br>
     */
    @RequestMapping("save")
    public @ResponseBody
    RespData save(SysMenu menu, HttpServletRequest request) {
        log.info("添加菜单");

        SysUser user   = SessionUtils.getCurrentSysUser(request);
        int     result = 0;

        try {
            if ((menu.getId() != null) && (!menu.getId().equals(""))) {
                menu.setUpdateBy(user.getId());
                result = sysMenuService.updateById(menu);
            } else {
                menu.setCreateBy(user.getId());
                menu = sysMenuService.insert(menu);
            }

            if ((result > 0) ||  ((menu.getId() != null) && (!menu.getId().equals("")))) {
                return RespData.successMsg("操作成功!");
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.error("系统异常！" + e);

            return RespData.errorMsg("系统异常！");
        }

        return RespData.errorMsg("操作失败!");
    }
}



