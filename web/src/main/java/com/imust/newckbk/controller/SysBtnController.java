package com.imust.newckbk.controller;

import java.util.List;
import java.util.Map;

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
import com.imust.newckbk.domain.SysBtn;
import com.imust.newckbk.domain.SysMenu;
import com.imust.newckbk.service.SysBtnService;
import com.imust.newckbk.service.SysMenuService;

@Controller
@RequestMapping("btn")
public class SysBtnController {
    private static final Logger log = LoggerFactory.getLogger("controller");
    @Autowired
    private SysBtnService       sysBtnService;
    @Autowired
    private SysMenuService      sysMenuService;

    /**
     * Description: 权限删除<br>
     * url: /<br>
     * create by: dong gui peng<br>
     * date: 2019/7/3 0003 18:26 <br>
     */
    @RequestMapping("del")
    public @ResponseBody
    RespData del(@RequestParam Map params) {
        try {
            if (sysBtnService.deleteByMap(params) > 0) {
                return RespData.successMsg("删除成功！");
            }
        } catch (Exception e) {
            e.printStackTrace();

            return RespData.errorMsg("系统发生异常！");
        }

        return RespData.errorMsg("删除失败");
    }

    /**
     * Description: 权限添加与修改页面<br>
     * url: /<br>
     * create by: dong gui peng<br>
     * date: 2019/7/3 0003 18:25 <br>
     */
    @RequestMapping("edit")
    public String edit(SysBtn btn, Model m) {
        if ((btn.getId() != null) && (!btn.getId().equals(""))) {
            btn = sysBtnService.getById(btn.getId());
        }

        List<SysMenu> menus = sysMenuService.getByMap(null);

        m.addAttribute("menus", menus);
        m.addAttribute("btn", btn);

        return "btn/edit";
    }

    /**
     * Description: 权限列表<br>
     * url: /<br>
     * create by: dong gui peng<br>
     * date: 2019/7/3 0003 18:25 <br>
     */
    @RequestMapping("list")
    public String list(@RequestParam Map params, Model m) {
        PageInfo<SysBtn> page  = sysBtnService.query(DefaultPage.setDefaultPage(params));
        List<SysMenu>    menus = sysMenuService.getByMap(null);

        m.addAttribute("page", page);
        m.addAttribute("params", params);
        m.addAttribute("menus", menus);

        return "btn/list";
    }

    /**
     * Description: 权限添加修改信息保存<br>
     * url: /<br>
     * create by: dong gui peng<br>
     * date: 2019/7/3 0003 18:26 <br>
     */
    @RequestMapping("save")
    public @ResponseBody
    RespData save(SysBtn btn) {
        int flag = 0;

        try {
            if ((btn.getId() != null) && (!btn.getId().equals(""))) {
                flag = sysBtnService.updateById(btn);
            } else {
                btn = sysBtnService.insert(btn);
            }
        } catch (Exception e) {
            e.printStackTrace();

            return RespData.errorMsg("系统发生异常!");
        }

        if ((flag > 0) || ((btn.getId() != null) && (!btn.getId().equals("")))) {
            return RespData.successMsg("操作成功!");
        }

        return RespData.errorMsg("操作失败！");
    }
}



