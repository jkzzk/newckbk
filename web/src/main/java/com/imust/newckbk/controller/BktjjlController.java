package com.imust.newckbk.controller;

import com.github.pagehelper.PageInfo;
import com.imust.newckbk.base.PageEntity;
import com.imust.newckbk.common.DefaultPage;
import com.imust.newckbk.common.RespData;
import com.imust.newckbk.common.SessionUtils;
import com.imust.newckbk.domain.Bktjjl;
import com.imust.newckbk.domain.SysUser;
import com.imust.newckbk.domain.ext.BktjjlExt;
import com.imust.newckbk.exception.CustomException;
import com.imust.newckbk.service.BktjjlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 *  补考条件设置
 */
@Controller
@RequestMapping("/bktjjl")
public class BktjjlController {

    @Autowired
    private BktjjlService bktjjlServicel;

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
            PageInfo<BktjjlExt> page = bktjjlServicel.query(mapPageEntity);

            m.addAttribute("page", page);

            return "bktjjl/list";
        }catch (Exception e) {
            throw new CustomException("########" + e.getMessage());
        }
    }

    /**
     * 设置补考条件页面
     * @url /bktjjl/edit
     * @param m
     * @return
     */
    @RequestMapping("/edit")
    public String edit(Model m) {
        try {
            return "bktjjl/edit";
        }catch (Exception e) {
            throw new CustomException("########" + e.getMessage());
        }
    }

    /**
     * 补考条件详情页回显
     * @url /bktjjl/getInfo
     * @param m
     * @return
     */
    @RequestMapping("/getInfo")
    public String setPage(String id,Model m) {
        try {
            //查询当前设置
            BktjjlExt bktjjlExt = bktjjlServicel.getCurrentSet(id);

            m.addAttribute("bktj",bktjjlExt);

            return "bktjjl/info";
        }catch (Exception e) {
            throw new CustomException("########" + e.getMessage());
        }
    }

    /**
     * 保存补考条件
     * @url /bktjjl/save
     * @param bktjjl
     * @param request
     * @return
     */
    @RequestMapping("/save")
    public @ResponseBody
    RespData save(@RequestBody Bktjjl bktjjl, HttpServletRequest request) {
        try {
            SysUser currentSysUser = SessionUtils.getCurrentSysUser(request);
            return bktjjlServicel.saveBktjjl(bktjjl,currentSysUser);
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
            return bktjjlServicel.clearBktjjl();
        }catch (Exception e) {
            e.printStackTrace();
            throw new CustomException("########" + e.getMessage());
        }
    }

}
