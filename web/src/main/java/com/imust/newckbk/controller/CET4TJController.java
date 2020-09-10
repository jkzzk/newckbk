package com.imust.newckbk.controller;

import com.github.pagehelper.PageInfo;
import com.imust.newckbk.base.PageEntity;
import com.imust.newckbk.common.DefaultPage;
import com.imust.newckbk.common.RespData;
import com.imust.newckbk.common.SessionUtils;
import com.imust.newckbk.domain.Bktjjl;
import com.imust.newckbk.domain.Cet4Tjjl;
import com.imust.newckbk.domain.SysUser;
import com.imust.newckbk.domain.ext.BktjjlExt;
import com.imust.newckbk.domain.ext.CET4TJExt;
import com.imust.newckbk.exception.CustomException;
import com.imust.newckbk.service.Cet4TjService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RequestMapping("/cet4tj")
@Controller
public class CET4TJController {

    @Autowired
    private Cet4TjService cet4TjService;

    /**
     * 英语4级考试条件分页列表
     * @url /cet4tj/list
     * @param pageParams
     * @param m
     * @return
     */
    @RequestMapping("/list")
    public String list(@RequestParam Map<String,String> pageParams, Model m) {
        try {
            PageEntity<Map> mapPageEntity = DefaultPage.setDefaultPage(pageParams);
            PageInfo<CET4TJExt> page = cet4TjService.query(mapPageEntity);

            m.addAttribute("page", page);

            return "cet4tj/list";
        }catch (Exception e) {
            throw new CustomException("########" + e.getMessage());
        }
    }

    /**
     * 英语4级考试条件详情页回显
     * @url /cet4tj/getInfo
     * @param m
     * @return
     */
    @RequestMapping("/getInfo")
    public String setPage(String id,Model m) {
        try {
            //查询当前设置
            CET4TJExt cet4TJExt = cet4TjService.getCurrentSet(id);

            m.addAttribute("cet4tj",cet4TJExt);

            return "cet4tj/info";
        }catch (Exception e) {
            throw new CustomException("########" + e.getMessage());
        }
    }

    /**
     * 设置英语4级考试条件页面
     * @url /cet4tj/edit
     * @param m
     * @return
     */
    @RequestMapping("/edit")
    public String edit(Model m) {
        try {
            return "cet4tj/edit";
        }catch (Exception e) {
            throw new CustomException("########" + e.getMessage());
        }
    }

    /**
     * 保存英语四级条件
     * @url /cet4tj/save
     * @param cet4TJExt
     * @return
     */
    @RequestMapping("/save")
    public @ResponseBody
    RespData save(@RequestBody CET4TJExt cet4TJExt) {
        try {
            return cet4TjService.saveCet4TJExt(cet4TJExt);
        }catch (Exception e) {
            e.printStackTrace();
            throw new CustomException("########" + e.getMessage());
        }
    }

    /**
     * 清除无效记录，保留有效记录
     * @url /cet4tj/clear
     * @return
     */
    @RequestMapping("/clear")
    public @ResponseBody
    RespData clear() {
        try {
            return cet4TjService.clearCet4Tjjl();
        }catch (Exception e) {
            e.printStackTrace();
            throw new CustomException("########" + e.getMessage());
        }
    }
}
