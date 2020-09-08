package com.imust.newckbk.controller;

import com.github.pagehelper.PageInfo;
import com.imust.newckbk.base.PageEntity;
import com.imust.newckbk.common.DefaultPage;
import com.imust.newckbk.common.RespData;
import com.imust.newckbk.domain.Zyxxb;
import com.imust.newckbk.exception.CustomException;
import com.imust.newckbk.service.ZyxxbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.Map;

@Controller
@RequestMapping("/zyxxb")
public class ZyxxbController {

    @Autowired
    private ZyxxbService zyxxbService;


    /**
     * 专业列表
     *
     * @url /zyxxb/list
     * @param pageParams
     * @param m
     * @return
     */
    @RequestMapping("list")
    public String list(@RequestParam Map<String,String> pageParams, Model m) {
        try {
            PageEntity<Map> mapPageEntity = DefaultPage.setDefaultPage(pageParams);
            PageInfo<Zyxxb> page = zyxxbService.query(mapPageEntity);

            m.addAttribute("page", page);

            return "zyxxb/list";
        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * @url /zyxxb/edit
     * @param id
     * @param m
     * @return
     */
    @RequestMapping("edit")
    public String edit(String id,Model m) {
        try {
            if(id == null || "".equals(id)) {
                return "zyxxb/edit";
            }

            Zyxxb zyxxb = zyxxbService.getById(id);
            m.addAttribute("major", zyxxb);

            return "zyxxb/edit";
        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 保存专业
     * @url /zyxxb/save
     * @param zyxxb
     * @return
     */
    @RequestMapping("save")
    @ResponseBody
    public RespData save(@RequestBody Zyxxb zyxxb) {
        try {
            if(zyxxb.getId() == null || "".equals(zyxxb.getId())) {
                return zyxxbService.saveZyxxb(zyxxb);
            }

            return RespData.successMsg("修改成功！",zyxxbService.updateById(zyxxb));
        }catch (Exception e) {
            e.printStackTrace();
            throw new CustomException(e.getMessage());
        }
    }

    /**
     * 批量删除
     * @url /zyxxb/del
     * @param ids
     * @return
     */
    @RequestMapping("del")
    @ResponseBody
    public RespData del(String ids) {
        try {
            return zyxxbService.delZyxxb(Arrays.asList(ids.split(",")));
        }catch (Exception e) {
            e.printStackTrace();
            throw new CustomException(e.getMessage());
        }
    }

    /**
     * 条件查询所有学院
     * @url /zyxxb/getAllXsm
     * @param params
     * @return
     */
    @RequestMapping("getAllXsm")
    @ResponseBody
    public RespData getAllXsm(@RequestBody Map<String,Object> params) {
        try {
            return RespData.successMsg("",zyxxbService.getAllXsm(params));
        }catch (Exception e) {
            e.printStackTrace();
            throw new CustomException(e.getMessage());
        }
    }


    /**
     * 条件查询所有专业
     * @url /zyxxb/getAllZym
     * @param params
     * @return
     */
    @RequestMapping("getAllZym")
    @ResponseBody
    public RespData getAllZym(@RequestBody Map<String,Object> params) {
        try {
            return RespData.successMsg("",zyxxbService.getAllZym(params));
        }catch (Exception e) {
            e.printStackTrace();
            throw new CustomException(e.getMessage());
        }
    }
}
