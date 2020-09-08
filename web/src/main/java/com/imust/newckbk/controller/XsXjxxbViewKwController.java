package com.imust.newckbk.controller;

import com.github.pagehelper.PageInfo;
import com.imust.newckbk.base.PageEntity;
import com.imust.newckbk.common.DefaultPage;
import com.imust.newckbk.common.SessionUtils;
import com.imust.newckbk.domain.SysUser;
import com.imust.newckbk.domain.XsXjxxbViewKw;
import com.imust.newckbk.domain.XsXpbView;
import com.imust.newckbk.service.XsXjxxbViewKwService;
import com.imust.newckbk.service.XsXpbViewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@Controller
@RequestMapping("/studentInfo")
public class XsXjxxbViewKwController {

    @Autowired
    private XsXjxxbViewKwService xsXjxxbViewKwService;

    @Autowired
    private XsXpbViewService xsXpbViewService;

    /**
     * 学生列表
     * @param pageParams
     * @param m
     * @return
     */
    @RequestMapping("/list")
    public String list(@RequestParam Map<String,String> pageParams, Model m) {

        PageEntity<Map> mapPageEntity = DefaultPage.setDefaultPage(pageParams);
        PageInfo<XsXjxxbViewKw> page = xsXjxxbViewKwService.query(mapPageEntity);

        m.addAttribute("page", page);
        m.addAttribute("pageParams", mapPageEntity);

        return "studentInfo/list";
    }

    /**
     * 学生个人信息
     * @url /studentInfo/info
     * @param m
     * @param request
     * @return
     */
    @RequestMapping("/info")
    public String info(Model m, HttpServletRequest request) {
        SysUser currentSysUser = SessionUtils.getCurrentSysUser(request);

        XsXjxxbViewKw xsXjxxbViewKw = xsXjxxbViewKwService.getById(currentSysUser.getLoginName());

        m.addAttribute("student",xsXjxxbViewKw);

        return "studentInfo/info";
    }

    /**
     * 查询学生照片
     * @url /studentInfo/showPhoto
     * @param request
     * @param response
     */
    @RequestMapping("/showPhoto")
    public void showPhoto(HttpServletRequest request,HttpServletResponse response) {
        try {
            SysUser currentSysUser = SessionUtils.getCurrentSysUser(request);
            XsXpbView xsXpbView = xsXpbViewService.getById(currentSysUser.getLoginName());
            response.getOutputStream().write(xsXpbView.getZp());
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

}
