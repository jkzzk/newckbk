package com.imust.newckbk.controller;

import com.github.pagehelper.PageInfo;
import com.imust.newckbk.base.PageEntity;
import com.imust.newckbk.common.DefaultPage;
import com.imust.newckbk.common.RespData;
import com.imust.newckbk.common.SessionUtils;
import com.imust.newckbk.domain.*;
import com.imust.newckbk.domain.ext.XszzyxxbExt;
import com.imust.newckbk.exception.CustomException;
import com.imust.newckbk.service.XsXjxxbViewKwService;
import com.imust.newckbk.service.XsXjydbViewKwService;
import com.imust.newckbk.service.XszzyxxbService;
import com.imust.newckbk.service.ZyxxbService;
import com.imust.newckbk.utils.easypoi.ExcelUtiles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/xszzyxxb")
public class XszzyxxbController {

    @Autowired
    private XszzyxxbService xszzyxxbService;
    @Autowired
    private ZyxxbService zyxxbService;
    @Autowired
    private XsXjxxbViewKwService xsXjxxbViewKwService;

    /**
     * 专业列表
     *
     * @url /xszzyxxb/list
     * @param pageParams
     * @param m
     * @return
     */
    @RequestMapping("list")
    public String list(@RequestParam Map<String,String> pageParams, Model m) {
        try {
            PageEntity<Map> mapPageEntity = DefaultPage.setDefaultPage(pageParams);
            PageInfo<XszzyxxbExt> page = xszzyxxbService.query(mapPageEntity);

            m.addAttribute("page", page);

            return "xszzyxxb/list";
        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * @url /xszzyxxb/edit
     * @param id
     * @param m
     * @return
     */
    @RequestMapping("edit")
    public String edit(String id,Model m) {
        try {
            if(id == null || "".equals(id)) {
                return "xszzyxxb/edit";
            }

            XszzyxxbExt xszzyxxbExt = xszzyxxbService.getXszzyxxbById(id);
            Map<String,Object> params = new HashMap<>();
            params.put("xkfl",xszzyxxbExt.getSylb());
            // 不需要根据录取批次来进行筛选 2020年5月21日20:26:54
//            params.put("lqpc",xszzyxxbExt.getLqpc());
            List<String> xsmList = zyxxbService.getAllXsm(params);
            List<String> zymList = zyxxbService.getAllZym(params);
            m.addAttribute("xszzyxxb", xszzyxxbExt);
            m.addAttribute("xsms", xsmList);
            m.addAttribute("zyms", zymList);

            return "xszzyxxb/edit";
        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 保存专业
     * @url /xszzyxxb/save
     * @param xszzyxxb
     * @return
     */
    @RequestMapping("save")
    @ResponseBody
    public RespData save(@RequestBody Xszzyxxb xszzyxxb, HttpServletRequest request) {
        try {

            if(xszzyxxb.getId() == null || "".equals(xszzyxxb.getId())) {
                SysUser currentSysUser = SessionUtils.getCurrentSysUser(request);
                String xh = "";
                if(currentSysUser.getRoleIds().equals("2")) {
                    xh = currentSysUser.getLoginName();
                }else {
                    xh = xszzyxxb.getXh();
                }
                XsXjxxbViewKw xsXjxxbViewKw = xsXjxxbViewKwService.getById(xh);
                if(xsXjxxbViewKw == null) {
                    return RespData.errorMsg("没有该学生！");
                }
                if("否".equals(xsXjxxbViewKw.getSfyxj())) {
                    return RespData.errorMsg("该学生没有学籍！");
                }
                xszzyxxb.setYxsm(xsXjxxbViewKw.getXsm());
                xszzyxxb.setYzym(xsXjxxbViewKw.getZym());
                xszzyxxb.setYbjh(xsXjxxbViewKw.getBjh());
                xszzyxxb.setYnjdm(xsXjxxbViewKw.getDqnj());
                return xszzyxxbService.saveXszzyxxb(xszzyxxb);
            }

            return RespData.successMsg("修改成功！",xszzyxxbService.updateById(xszzyxxb));
        }catch (Exception e) {
            e.printStackTrace();
            throw new CustomException(e.getMessage());
        }
    }

    /**
     * 批量删除
     * @url /xszzyxxb/del
     * @param ids
     * @return
     */
    @RequestMapping("del")
    @ResponseBody
    public RespData del(String ids) {
        try {
            return xszzyxxbService.delXszzyxxb(Arrays.asList(ids.split(",")));
        }catch (Exception e) {
            e.printStackTrace();
            throw new CustomException(e.getMessage());
        }
    }

    /**
     * 导出学生转专业信息表
     * @url /xszzyxxb/exportXszzyxx
     * @param xszzyxxbExt
     * @param response
     */
    @RequestMapping("/exportXszzyxx")
    public void exportXszzyxx(XszzyxxbExt xszzyxxbExt, HttpServletResponse response) {
        try {
            List<Xszzyxxb> xszzyxxbs =  xszzyxxbService.getExtByEnity(xszzyxxbExt);
            ExcelUtiles.exportExcel(xszzyxxbs,"学生转专业信息","sheet1", Xszzyxxb.class,"学生转专业信息.xls",response);
        }catch (Exception e) {
            e.printStackTrace();
            throw new CustomException("#############" + e.getMessage());
        }
    }
}
