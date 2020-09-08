package com.imust.newckbk.controller;

import com.github.pagehelper.PageInfo;
import com.imust.newckbk.base.PageEntity;
import com.imust.newckbk.common.DefaultPage;
import com.imust.newckbk.common.RespData;
import com.imust.newckbk.domain.Fxtjb;
import com.imust.newckbk.domain.ext.FxtjbExt;
import com.imust.newckbk.exception.CustomException;
import com.imust.newckbk.service.FxtjbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
@RequestMapping("/fxtjb")
public class FxtjbController {

    @Autowired
    private FxtjbService fxtjbService;

    /**
     * 辅修条件设置记录列表
     * @url /fxtjb/list
     * @param pageParams
     * @param m
     * @return
     */
    @RequestMapping("/list")
    public String list(@RequestParam Map<String,String> pageParams, Model m) {
        try {
            PageEntity<Map> mapPageEntity = DefaultPage.setDefaultPage(pageParams);
            PageInfo<FxtjbExt> page = fxtjbService.query(mapPageEntity);

            m.addAttribute("page", page);

            return "fxtjb/list";
        }catch (Exception e) {
            throw new CustomException("########" + e.getMessage());
        }
    }

    /**
     * 设置辅修条件页面
     * @url /fxtjb/edit
     * @param m
     * @return
     */
    @RequestMapping("/edit")
    public String edit(Model m) {
        try {
            return "fxtjb/edit";
        }catch (Exception e) {
            throw new CustomException("########" + e.getMessage());
        }
    }

    /**
     * 保存辅修条件
     * @url /fxtjb/save
     * @param fxtjb
     * @param request
     * @return
     */
    @RequestMapping("/save")
    public @ResponseBody
    RespData save(@RequestBody Fxtjb fxtjb, HttpServletRequest request) {
        try {
            return fxtjbService.saveFxtjb(fxtjb);
        }catch (Exception e) {
            e.printStackTrace();
            throw new CustomException("########" + e.getMessage());
        }
    }

    /**
     * 清除无效记录，保留有效记录
     * @return
     */
    @RequestMapping("/clear")
    public @ResponseBody
    RespData clear() {
        try {
            return fxtjbService.clearFxtjb();
        }catch (Exception e) {
            e.printStackTrace();
            throw new CustomException("########" + e.getMessage());
        }
    }
}
