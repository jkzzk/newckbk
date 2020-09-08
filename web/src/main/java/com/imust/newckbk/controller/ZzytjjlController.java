package com.imust.newckbk.controller;

import com.github.pagehelper.PageInfo;
import com.imust.newckbk.base.PageEntity;
import com.imust.newckbk.common.DefaultPage;
import com.imust.newckbk.common.RespData;
import com.imust.newckbk.common.SessionUtils;
import com.imust.newckbk.domain.Bktjjl;
import com.imust.newckbk.domain.SysUser;
import com.imust.newckbk.domain.Zzytjjl;
import com.imust.newckbk.domain.ext.BktjjlExt;
import com.imust.newckbk.domain.ext.ZzytjjlExt;
import com.imust.newckbk.exception.CustomException;
import com.imust.newckbk.service.ZzytjjlService;
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
@RequestMapping("/zzytjjl")
public class ZzytjjlController {

    @Autowired
    private ZzytjjlService zzytjjlService;

    /**
     * 转专业条件设置记录列表
     * @url /zzytjjl/list
     * @param pageParams
     * @param m
     * @return
     */
    @RequestMapping("/list")
    public String list(@RequestParam Map<String,String> pageParams, Model m) {
        try {
            PageEntity<Map> mapPageEntity = DefaultPage.setDefaultPage(pageParams);
            PageInfo<ZzytjjlExt> page = zzytjjlService.query(mapPageEntity);

            m.addAttribute("page", page);

            return "zzytjjl/list";
        }catch (Exception e) {
            throw new CustomException("########" + e.getMessage());
        }
    }


    /**
     * 设置转专业条件页面
     * @url /zzytjjl/edit
     * @param m
     * @return
     */
    @RequestMapping("/edit")
    public String edit(Model m) {
        try {
            return "zzytjjl/edit";
        }catch (Exception e) {
            throw new CustomException("########" + e.getMessage());
        }
    }

    /**
     * 保存补考条件
     * @url /zzytjjl/save
     * @param zzytjjl
     * @param request
     * @return
     */
    @RequestMapping("/save")
    public @ResponseBody
    RespData save(@RequestBody Zzytjjl zzytjjl, HttpServletRequest request) {
        try {
            SysUser currentSysUser = SessionUtils.getCurrentSysUser(request);
            return zzytjjlService.saveZzytjjl(zzytjjl,currentSysUser);
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
            return zzytjjlService.clearZzytjjl();
        }catch (Exception e) {
            e.printStackTrace();
            throw new CustomException("########" + e.getMessage());
        }
    }

}
