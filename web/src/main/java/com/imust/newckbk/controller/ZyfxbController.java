package com.imust.newckbk.controller;

import com.github.pagehelper.PageInfo;
import com.imust.newckbk.base.PageEntity;
import com.imust.newckbk.common.DefaultPage;
import com.imust.newckbk.common.RespData;
import com.imust.newckbk.common.RetCode;
import com.imust.newckbk.common.SessionUtils;
import com.imust.newckbk.domain.SysUser;
import com.imust.newckbk.domain.Zyfxb;
import com.imust.newckbk.domain.Zyfxxxb;
import com.imust.newckbk.exception.CustomException;
import com.imust.newckbk.service.CodeZxjxjhxnxqxxService;
import com.imust.newckbk.service.ZyfxbService;
import com.imust.newckbk.service.ZyfxxxbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/zyfxb")
public class ZyfxbController {

    @Autowired
    private ZyfxbService zyfxbService;
    @Autowired
    private CodeZxjxjhxnxqxxService codeZxjxjhxnxqxxService;
    @Autowired
    private ZyfxxxbService zyfxxxbService;

    /**
     * 判断是否有报名权限
     * @url /zyfxb/listST
     * @param request
     * @param m
     * @return
     */
    @RequestMapping("/listST")
    public String list(HttpServletRequest request, Model m) {
        SysUser currentSysUser = SessionUtils.getCurrentSysUser(request);

        if(!zyfxbService.ifOpen()) {
            m.addAttribute("msg","补考报名尚未开始！");
            return "authority/message";
        }

        if(!zyfxbService.ifInScope(currentSysUser)) {
            m.addAttribute("msg","您不在报名范围内！");
            return "authority/message";
        }

        List<Zyfxb> makeupExts = zyfxbService.query(currentSysUser);

        m.addAttribute("zyfxbST",makeupExts);

        return "zyfxb/list";
    }

    /**
     * 后台分页查询所有学生辅修数据
     * @url /zyfxb/list
     * @param pageParams
     * @param m
     * @return
     */
    @RequestMapping("/list")
    public String list(@RequestParam Map<String,String> pageParams, Model m) {
        try {
            PageEntity<Map> mapPageEntity = DefaultPage.setDefaultPage(pageParams);
            PageInfo<Zyfxb> page = zyfxbService.queryList(mapPageEntity);

            m.addAttribute("term",codeZxjxjhxnxqxxService.getAllTerm().getData());
            m.addAttribute("page", page);
            m.addAttribute("param",pageParams);

            return "zyfxb/adminList";
        }catch (Exception e) {
            throw new CustomException("########" + e.getMessage());
        }
    }

    /**
     * 新增页面,没有修改页面
     *
     * @url /zyfxb/edit
     * @param m
     * @return
     */
    @RequestMapping("/edit")
    public String edit(Model m,HttpServletRequest request) {
        try {
            List<Zyfxxxb> zyfxxxbList = zyfxxxbService.getAll();
            m.addAttribute("zyfxxxb",zyfxxxbList);
            SysUser currentSysUser = SessionUtils.getCurrentSysUser(request);
            if(currentSysUser.getRoleIds().equals("2")) {
                Zyfxb zyfxb = zyfxbService.getByXh(currentSysUser.getLoginName());
                m.addAttribute("zyfxb",zyfxb);

                return "zyfxb/editST";
            }
            return "zyfxb/edit";
        }catch (Exception e) {
            throw new CustomException("########" + e.getMessage());
        }
    }

    /**
     * 学生保存接口
     *
     * @param zyfxb
     * @return
     */
    @RequestMapping("/studentSave")
    public @ResponseBody
    RespData studentSave(@RequestBody Zyfxb zyfxb,HttpServletRequest request) {
        try {
            if(zyfxb.getXh() != null && !zyfxb.getXh().equals("")) {
                return zyfxbService.updateByXh(zyfxb);
            }
            SysUser currentSysUser = SessionUtils.getCurrentSysUser(request);
            zyfxb.setXh(currentSysUser.getLoginName());
            return zyfxbService.save(zyfxb);
        }catch (Exception e) {
            e.printStackTrace();
            throw new CustomException("##########" + e.getMessage());
        }
    }

    /**
     * 查询是否已报名
     *
     * @param request
     * @return
     */
    @RequestMapping("/exsit")
    public @ResponseBody
    RespData studentSave(HttpServletRequest request) {
        SysUser currentSysUser = SessionUtils.getCurrentSysUser(request);
        Zyfxb zyfxb = zyfxbService.getByXh(currentSysUser.getLoginName());
        if(zyfxb != null && zyfxb.getXh() != null && !zyfxb.getXh().equals("")) {
            return RespData.successMsg("查询成功",1);
        }else {
            return RespData.successMsg("查询成功",0);
        }
    }

    /**
     * 后台保存接口
     *
     * @param zyfxb
     * @return
     */
    @RequestMapping("/save")
    public @ResponseBody
    RespData save(@RequestBody Zyfxb zyfxb) {
        try {
            return zyfxbService.save(zyfxb);
        }catch (Exception e) {
            e.printStackTrace();
            throw new CustomException("##########" + e.getMessage());
        }
    }

    /**
     * 批量删除学生辅修信息
     *
     * @param ids
     * @return
     */
    @RequestMapping("/delete")
    public @ResponseBody
    RespData delete(String[] ids) {
        try {
            return zyfxbService.deleteMakeUp(ids);
        }catch (Exception e) {
            e.printStackTrace();
            throw new CustomException("#########" + e.getMessage());
        }
    }

    /**
     * 导出本学期的学生辅修报名数据
     *
     * @return
     */
    @RequestMapping("/export")
    public void export(HttpServletResponse response) {
        try {
            zyfxbService.export(response);
        }catch (Exception e) {
            e.printStackTrace();
            throw new CustomException("#########" + e.getMessage());
        }
    }

    /**
     * @url /zyfxb/print
     * @param xh
     * @return
     */
    @RequestMapping("/print")
    @ResponseBody
    public RespData print(String xh) {
        try {
            zyfxbService.printApplyTable(xh);
            return RespData.successMsg("");
        }catch (Exception e) {
            e.printStackTrace();
            throw new CustomException(RetCode.ACTIVE_EXCEPTION.getMsg() + "###################" + e.getMessage());
        }
    }
}
