package com.imust.newckbk.controller;

import com.github.pagehelper.PageInfo;
import com.imust.newckbk.base.PageEntity;
import com.imust.newckbk.common.DefaultPage;
import com.imust.newckbk.common.RespData;
import com.imust.newckbk.common.RetCode;
import com.imust.newckbk.common.SessionUtils;
import com.imust.newckbk.domain.Makeup;
import com.imust.newckbk.domain.SysUser;
import com.imust.newckbk.domain.ext.MakeupExt;
import com.imust.newckbk.exception.CustomException;
import com.imust.newckbk.service.CodeZxjxjhxnxqxxService;
import com.imust.newckbk.service.MakeupService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
@RequestMapping("/makeup")
public class MakeupController {

    Logger logger = LoggerFactory.getLogger(MakeupController.class);

    @Autowired
    private MakeupService makeUpService;
    @Autowired
    private CodeZxjxjhxnxqxxService codeZxjxjhxnxqxxService;

    /**
     * 判断是否有报名权限以及列出所有可报名课程
     * @url /makeup/listMK
     * @param request
     * @param m
     * @return
     */
    @RequestMapping("/listMK")
    public String list(HttpServletRequest request, Model m) {
        SysUser currentSysUser = SessionUtils.getCurrentSysUser(request);

        if(!makeUpService.ifOpen()) {
            m.addAttribute("msg","补考报名尚未开始！");
            return "authority/message";
        }

        if(!makeUpService.ifInScope(currentSysUser)) {
            m.addAttribute("msg","您没有报名的权限！");
            return "authority/message";
        }

        List<MakeupExt> makeupExts = makeUpService.query(currentSysUser);

        logger.debug("makeupExts",makeupExts);

        m.addAttribute("courseMk",makeupExts);

        return "makeup/list";
    }

    /**
     * 补考报名接口
     *
     * @param ids
     * @return
     */
    @RequestMapping("/enter")
    public @ResponseBody
    RespData enter(String[] ids) {
        try {
            return makeUpService.enter(ids);
        }catch (Exception e) {
            e.printStackTrace();
            throw new CustomException("##########" + e.getMessage());
        }
    }

    /**
     * 补考缴费接口
     *
     * @param ids
     * @return
     */
    @RequestMapping("/inpay")
    public @ResponseBody
    RespData inpay(String[] ids) {
        try {
            return makeUpService.inpay(ids);
        }catch (Exception e) {
            e.printStackTrace();
            throw new CustomException("##########" + e.getMessage());
        }
    }

    /**
     * 补考取消缴费接口
     *
     * @param ids
     * @return
     */
    @RequestMapping("/outpay")
    public @ResponseBody
    RespData outpay(String[] ids) {
        try {
            return makeUpService.outpay(ids);
        }catch (Exception e) {
            e.printStackTrace();
            throw new CustomException("##########" + e.getMessage());
        }
    }

    /**
     * 补考报名接口
     *
     * @param ids
     * @return
     */
    @RequestMapping("/outer")
    public @ResponseBody
    RespData outer(String[] ids) {
        try {
            return makeUpService.outer(ids);
        }catch (Exception e) {
            e.printStackTrace();
            throw new CustomException("##########" + e.getMessage());
        }
    }


    /**
     * 后台分页查询所有学生补考数据
     * @url /makeup/list
     * @param pageParams
     * @param m
     * @return
     */
    @RequestMapping("/list")
    public String list(@RequestParam Map<String,String> pageParams, Model m) {
        try {
            PageEntity<Map> mapPageEntity = DefaultPage.setDefaultPage(pageParams);
            PageInfo<MakeupExt> page = makeUpService.queryList(mapPageEntity);

            m.addAttribute("term",codeZxjxjhxnxqxxService.getAllTerm().getData());
            m.addAttribute("page", page);
            m.addAttribute("param",pageParams);

            return "makeup/adminList";
        }catch (Exception e) {
            throw new CustomException("########" + e.getMessage());
        }
    }

    /**
     * 新增页面,没有修改页面
     *
     * @url /makeup/edit
     * @param m
     * @return
     */
    @RequestMapping("/edit")
    public String edit(String xh,Model m) {
        try {
            m.addAttribute("courseEx",makeUpService.getExtraCourse(xh));
            m.addAttribute("xh",xh);
            return "makeup/edit";
        }catch (Exception e) {
            throw new CustomException("########" + e.getMessage());
        }
    }

    /**
     * 后台保存接口
     *
     * @param makeup
     * @return
     */
    @RequestMapping("/save")
    public @ResponseBody
    RespData save(@RequestBody Makeup makeup) {
        try {
            return makeUpService.save(makeup);
        }catch (Exception e) {
            e.printStackTrace();
            throw new CustomException("##########" + e.getMessage());
        }
    }

    /**
     * 批量删除学生补考数据
     *
     * @param ids
     * @return
     */
    @RequestMapping("/delete")
    public @ResponseBody
    RespData delete(String[] ids) {
        try {
            return makeUpService.deleteMakeUp(ids);
        }catch (Exception e) {
            e.printStackTrace();
            throw new CustomException("#########" + e.getMessage());
        }
    }

    /**
     * 导出本学期的学生补考报名数据
     *
     * @return
     */
    @RequestMapping("/export")
    public void export(HttpServletResponse response) {
        try {
            makeUpService.export(response);
        }catch (Exception e) {
            e.printStackTrace();
            throw new CustomException("#########" + e.getMessage());
        }
    }

    /**
     * @url /makeup/print
     * @param xh
     * @return
     */
    @RequestMapping("/print")
    @ResponseBody
    public RespData print(String xh,HttpServletResponse response) {
        try {
            makeUpService.printEnterCard(xh,response);
            return RespData.successMsg("");
        }catch (Exception e) {
            e.printStackTrace();
            throw new CustomException(RetCode.ACTIVE_EXCEPTION.getMsg() + "###################" + e.getMessage());
        }
    }

    /**
     * 清除全部数据
     * @url /makeup/clear
     *
     * @return
     */
    @RequestMapping("/clear")
    @ResponseBody
    public RespData clear() {
        try {
            return makeUpService.clearMaupData();
        }catch (Exception e) {
            e.printStackTrace();
            throw new CustomException(RetCode.ACTIVE_EXCEPTION.getMsg() + "###################" + e.getMessage());
        }
    }
}
