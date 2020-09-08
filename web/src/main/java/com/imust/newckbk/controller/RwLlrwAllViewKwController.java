package com.imust.newckbk.controller;

import com.github.pagehelper.PageInfo;
import com.imust.newckbk.base.PageEntity;
import com.imust.newckbk.common.DefaultPage;
import com.imust.newckbk.common.RespData;
import com.imust.newckbk.domain.ext.RwLlrwAllViewKwExt;
import com.imust.newckbk.exception.CustomException;
import com.imust.newckbk.service.RwLlrwAllViewKwService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@RequestMapping("/course")
@Controller
public class RwLlrwAllViewKwController {

    @Autowired
    private RwLlrwAllViewKwService rwLlrwAllViewKwService;

    /**
     * 补考条件设置记录列表
     * @url /bktjjl/list
     * @param pageParams
     * @param m
     * @return
     */
    @RequestMapping("/list")
    public String list(@RequestParam Map<String,String> pageParams, Model m) {
        try {
            PageEntity<Map> mapPageEntity = DefaultPage.setDefaultPage(pageParams);
            PageInfo<RwLlrwAllViewKwExt> page = rwLlrwAllViewKwService.query(mapPageEntity);

            m.addAttribute("page", page);
            m.addAttribute("param",pageParams);

            return "course/list";
        }catch (Exception e) {
            throw new CustomException("########" + e.getMessage());
        }
    }


    /**
     * 设置重修课程
     * @url /course/setRetake
     * @param rwLlrwAllViewKwExt
     * @return
     */
    @RequestMapping("/setRetake")
    public @ResponseBody
    RespData setRetake(@RequestBody RwLlrwAllViewKwExt rwLlrwAllViewKwExt) {
        try {
            return rwLlrwAllViewKwService.setRetake(rwLlrwAllViewKwExt);
        }catch (Exception e) {
            throw new CustomException("########" + e.getMessage());
        }
    }

    /**
     * 设置补考课程
     * @url /course/reSetRetake
     * @param rwLlrwAllViewKwExt
     * @return
     */
    @RequestMapping("/reSetRetake")
    public @ResponseBody
    RespData reSetRetake(@RequestBody RwLlrwAllViewKwExt rwLlrwAllViewKwExt) {
        try {
            return rwLlrwAllViewKwService.reSetRetake(rwLlrwAllViewKwExt);
        }catch (Exception e) {
            throw new CustomException("########" + e.getMessage());
        }
    }
}
