package com.imust.newckbk.controller;

import com.github.pagehelper.PageInfo;
import com.imust.newckbk.base.PageEntity;
import com.imust.newckbk.common.DefaultPage;
import com.imust.newckbk.domain.CetStuYyfbcj;
import com.imust.newckbk.domain.ext.BktjjlExt;
import com.imust.newckbk.exception.CustomException;
import com.imust.newckbk.service.CetStuYyfbcjService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@RequestMapping("/cetyyfbcj")
@Controller
public class CetStuYyfbcjController {


    @Autowired
    private CetStuYyfbcjService cetStuYyfbcjService;

    /**
     * 英语分班成绩分页查询表
     *
     * @param pageParams
     * @param m
     * @return
     */
    @RequestMapping("/list")
    public String list(@RequestParam Map<String,String> pageParams, Model m)  {
        try {
            PageEntity<Map> mapPageEntity = DefaultPage.setDefaultPage(pageParams);
            PageInfo<CetStuYyfbcj> page = cetStuYyfbcjService.query(mapPageEntity);

            m.addAttribute("page", page);

            return "cetyyfbcj/list";
        }catch (Exception e) {
            throw new CustomException("########" + e.getMessage());
        }
    }

}
