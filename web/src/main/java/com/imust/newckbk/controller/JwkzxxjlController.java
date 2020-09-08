package com.imust.newckbk.controller;

import com.github.pagehelper.PageInfo;
import com.imust.newckbk.base.PageEntity;
import com.imust.newckbk.common.DefaultPage;
import com.imust.newckbk.common.RespData;
import com.imust.newckbk.common.SessionUtils;
import com.imust.newckbk.domain.Jwkzxxjl;
import com.imust.newckbk.domain.SysUser;
import com.imust.newckbk.domain.ext.JwkzxxjlExt;
import com.imust.newckbk.exception.CustomException;
import com.imust.newckbk.service.JwkzxxjlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
@RequestMapping("/jwkzxxjl")
public class JwkzxxjlController {

    @Autowired
    private JwkzxxjlService jwkzxxjlService;

    /**
     * 教务控制记录列表
     * @url /jwkzxxjl/list
     * @param pageParams
     * @param m
     * @return
     */
    @RequestMapping("/list")
    public String list(@RequestParam Map<String,String> pageParams, Model m) {
        try {
            PageEntity<Map> mapPageEntity = DefaultPage.setDefaultPage(pageParams);
            PageInfo<JwkzxxjlExt> page = jwkzxxjlService.query(mapPageEntity);

            m.addAttribute("page", page);

            return "jwkgjl/list";
        }catch (Exception e) {
            throw new CustomException("########" + e.getMessage());
        }
    }


    /**
     * 设置教务控制开关页面回显
     * @url /jwkzxxjl/setPage
     * @param m
     * @return
     */
    @RequestMapping("/setPage")
    public String setPage(Model m) {
        try {
            Jwkzxxjl jwkzxxjl = jwkzxxjlService.getCurrentSet();

            m.addAttribute("kz",jwkzxxjl);
            return "jwkgjl/edit";
        }catch (Exception e) {
            throw new CustomException("########" + e.getMessage());
        }
    }


    /**
     * 设置教务控制开关（保存）
     * @url /jwkzxxjl/set
     * @param jwkzxxjl
     * @param request
     * @return
     */
    @RequestMapping("/set")
    public @ResponseBody RespData set(Jwkzxxjl jwkzxxjl, HttpServletRequest request) {
        try {
            SysUser currentSysUser = SessionUtils.getCurrentSysUser(request);
            return RespData.successMsg("设置成功", jwkzxxjlService.setCurrentSet(jwkzxxjl,currentSysUser));
        }catch (Exception e) {
            throw new CustomException("########" + e.getMessage());
        }
    }

    /**
     * 清除记录数据
     * @url /jwkzxxjl/clear
     * @param
     * @return
     */
    @RequestMapping("/clear")
    public @ResponseBody RespData clear() {
        try {
            return RespData.successMsg("清除成功", jwkzxxjlService.clearRecord());
        }catch (Exception e) {
            throw new CustomException("########" + e.getMessage());
        }
    }

}
