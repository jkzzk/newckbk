package com.imust.newckbk.controller;

import com.imust.newckbk.common.RespData;
import com.imust.newckbk.common.RetCode;
import com.imust.newckbk.common.SessionUtils;
import com.imust.newckbk.domain.*;
import com.imust.newckbk.domain.ext.XszzyxxbExt;
import com.imust.newckbk.exception.CustomException;
import com.imust.newckbk.service.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/reswitch")
public class ReSwitchMajorController {

    @Autowired
    private XszzyxxbService xszzyxxbService;
    @Autowired
    private XsXjxxbViewKwService xsXjxxbViewKwService;
    @Autowired
    private ZyxxbService zyxxbService;
    @Autowired
    private JwkzxxjlService jwkzxxjlService;
    @Autowired
    private ZzytjjlService zzytjjlService;

    @Autowired
    private XsXjydbViewKwService xsXjydbViewKwService;

    Logger logger = LoggerFactory.getLogger(ReSwitchMajorController.class);

    @RequestMapping("stuList")
    public String stuList(HttpServletRequest request, Model model) {
        try {

            Jwkzxxjl currentSet = jwkzxxjlService.getCurrentSet();

            if(0 == currentSet.getZzykg()) {
                model.addAttribute("msg","转专业报名未开启");

                return "authority/message";
            }

            SysUser currentSysUser = SessionUtils.getCurrentSysUser(request);
            XsXjxxbViewKw xsXjxxbViewKw = xsXjxxbViewKwService.getById(currentSysUser.getLoginName());

            logger.debug("学生信息" + "===============>" + xsXjxxbViewKw.toString());

            if("否".equals(xsXjxxbViewKw.getSfyxj())) {
                model.addAttribute("msg","您不在可报名范围内！");

                return "authority/message";
            }


            Zzytjjl zzytjjl = zzytjjlService.getCurrentSet();

            logger.debug("分解后数组" + "===============>" + zzytjjl.getGrades().split(",").toString());
            logger.debug("转化后List" + "===============>" + Arrays.asList(zzytjjl.getGrades().split(",")).toString());
            logger.debug("是否包含当前年级" + "===============>" + Arrays.asList(zzytjjl.getGrades().split(",")).contains(xsXjxxbViewKw.getDqnj()));

            if(!Arrays.asList(zzytjjl.getGrades().split(",")).contains(xsXjxxbViewKw.getDqnj())) {
                model.addAttribute("msg","您不属于可报名年级！");

                return "authority/message";
            }

            Map<String,Object> params = new HashMap<>();
            params.put("xh",currentSysUser.getLoginName());
            params.put("ydlb","转专业");
            List<XsXjydbViewKw> xsXjydbViewKws = xsXjydbViewKwService.getByMap(params);

            if(xsXjydbViewKws != null && !xsXjydbViewKws.isEmpty()) {
                model.addAttribute("msg","您已经转过一次专业，不能再次申请！");

                return "authority/message";
            }


            XszzyxxbExt xszzyxxbExt = xszzyxxbService.getXszzyxxbByXh(xsXjxxbViewKw.getXh());
            model.addAttribute("xszzyxxb",xszzyxxbExt);

            return "reswitch/stuList";
        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * @url /reswitch/edit
     * @param id
     * @param m
     * @return
     */
    @RequestMapping("edit")
    public String edit(String id,Model m,HttpServletRequest request) {
        try {

            SysUser currentSysUser = SessionUtils.getCurrentSysUser(request);
            XsXjxxbViewKw xsXjxxbViewKw = xsXjxxbViewKwService.getById(currentSysUser.getLoginName());
            m.addAttribute("xszzyxxb", xsXjxxbViewKw);

            if(id == null || "".equals(id)) {
                return "reswitch/edit";
            }

            XszzyxxbExt xszzyxxbExt = xszzyxxbService.getXszzyxxbByXh(currentSysUser.getLoginName());
            Map<String,Object> params = new HashMap<>();
            params.put("xkfl",xszzyxxbExt.getSylb());
            // 不需要根据录取批次来进行筛选 2020年5月21日20:26:54
//            params.put("lqpc",xszzyxxbExt.getLqpc());
            List<String> xsmList = zyxxbService.getAllXsm(params);
            List<String> zymList = zyxxbService.getAllZym(params);
            m.addAttribute("xszzyxxb", xszzyxxbExt);
            m.addAttribute("xsms", xsmList);
            m.addAttribute("zyms", zymList);

            return "reswitch/stuEdit";
        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * @url /reswitch/print
     * @param xh
     * @return
     */
    @RequestMapping("/print")
    @ResponseBody
    public RespData print(String xh) {
        try {
            xszzyxxbService.printApplyTable(xh);
            return RespData.successMsg("");
        }catch (Exception e) {
            e.printStackTrace();
            throw new CustomException(RetCode.ACTIVE_EXCEPTION.getMsg() + "###################" + e.getMessage());
        }
    }

    /**
     * 检测是否有转专业数据
     *
     * @url /reswitch/check
     * @return
     */
    @RequestMapping("/check")
    @ResponseBody
    public RespData check(HttpServletRequest request) {
        try {
            SysUser currentSysUser = SessionUtils.getCurrentSysUser(request);
            XszzyxxbExt xszzyxxbExt = xszzyxxbService.getXszzyxxbByXh(currentSysUser.getLoginName());
            if(xszzyxxbExt == null || xszzyxxbExt.getId() == null || xszzyxxbExt.getId().equals("")) {
                return RespData.successMsg("没有转专业报名数据",false);
            }else {
                return RespData.successMsg("有转专业报名数据",true);
            }
        }catch (Exception e) {
            e.printStackTrace();
            throw new CustomException(RetCode.ACTIVE_EXCEPTION.getMsg() + "###################" + e.getMessage());
        }
    }

}
