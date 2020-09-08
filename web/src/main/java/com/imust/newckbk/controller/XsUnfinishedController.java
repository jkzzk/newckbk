package com.imust.newckbk.controller;

import com.github.pagehelper.PageInfo;
import com.imust.newckbk.base.PageEntity;
import com.imust.newckbk.common.DefaultPage;
import com.imust.newckbk.common.RespData;
import com.imust.newckbk.common.SessionUtils;
import com.imust.newckbk.domain.Bktjjl;
import com.imust.newckbk.domain.SysUser;
import com.imust.newckbk.domain.XsUnfinished;
import com.imust.newckbk.domain.ext.BktjjlExt;
import com.imust.newckbk.domain.ext.XsUnfinishedExt;
import com.imust.newckbk.exception.CustomException;
import com.imust.newckbk.service.XsUnfinishedService;
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
@RequestMapping("/graduation")
public class XsUnfinishedController {

    @Autowired
    private XsUnfinishedService xsUnfinishedService;

    /**
     * 结业学生列表
     * @url /graduation/list
     * @param pageParams
     * @param m
     * @return
     */
    @RequestMapping("/list")
    public String list(@RequestParam Map<String,String> pageParams, Model m) {
        try {
            PageEntity<Map> mapPageEntity = DefaultPage.setDefaultPage(pageParams);
            PageInfo<XsUnfinishedExt> page = xsUnfinishedService.query(mapPageEntity);

            m.addAttribute("page", page);
            m.addAttribute("param",pageParams);

            return "graduation/list";
        }catch (Exception e) {
            throw new CustomException("########" + e.getMessage());
        }
    }

    /**
     * 添加结业学生页面
     * @url /graduation/edit
     * @param m
     * @return
     */
    @RequestMapping("/edit")
    public String edit(Model m) {
        try {
            return "graduation/edit";
        }catch (Exception e) {
            throw new CustomException("########" + e.getMessage());
        }
    }


    /**
     * 保存结业学生
     * @url /graduation/save
     * @param xsUnfinished
     * @return
     */
    @RequestMapping("/save")
    public @ResponseBody
    RespData save(@RequestBody XsUnfinished xsUnfinished) {
        try {
            return xsUnfinishedService.saveXsUnfinished(xsUnfinished);
        }catch (Exception e) {
            e.printStackTrace();
            throw new CustomException("########" + e.getMessage());
        }
    }

    /**
     * 批量删除方法
     * @url /graduation/clear
     * @return
     */
    @RequestMapping("/clear")
    public @ResponseBody
    RespData clear(String ids) {
        try {
            return xsUnfinishedService.clearXsUnfinished(ids);
        }catch (Exception e) {
            e.printStackTrace();
            throw new CustomException("########" + e.getMessage());
        }
    }

}
