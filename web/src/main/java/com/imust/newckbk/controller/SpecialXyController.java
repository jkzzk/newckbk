package com.imust.newckbk.controller;

import com.github.pagehelper.PageInfo;
import com.imust.newckbk.base.PageEntity;
import com.imust.newckbk.common.DefaultPage;
import com.imust.newckbk.common.RespData;
import com.imust.newckbk.domain.SpecialXy;
import com.imust.newckbk.exception.CustomException;
import com.imust.newckbk.service.SpecialXyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@RequestMapping("/specialxy")
@Controller
public class SpecialXyController {

    @Autowired
    private SpecialXyService specialXyService;

    /**
     * 学生类别记录列表
     * @url /specialxy/list
     * @param pageParams
     * @param m
     * @return
     */
    @RequestMapping("/list")
    public String list(@RequestParam Map<String,String> pageParams, Model m) {
        try {
            PageEntity<Map> mapPageEntity = DefaultPage.setDefaultPage(pageParams);
            PageInfo<SpecialXy> page = specialXyService.query(mapPageEntity);

            m.addAttribute("page", page);

            return "specialxy/list";
        }catch (Exception e) {
            throw new CustomException("########" + e.getMessage());
        }
    }

    /**
     * 设置学生类别条件页面
     * @url /specialxy/edit
     * @param m
     * @return
     */
    @RequestMapping("/edit")
    public String edit(String id,Model m) {
        try {
            if(id != null && !"".equals(id)) {
                SpecialXy specialXy = specialXyService.getById(id);
                m.addAttribute("specialxy", specialXy);
            }

            return "specialxy/edit";
        }catch (Exception e) {
            throw new CustomException("########" + e.getMessage());
        }
    }

    /**
     * 保存学生类别
     * @url /specialxy/save
     * @param specialXy
     * @return
     */
    @RequestMapping("/save")
    public @ResponseBody
    RespData save(@RequestBody SpecialXy specialXy) {
        try {
            if(specialXy != null && !specialXy.getId().equals("")) {
                return RespData.successMsg("修改成功",specialXyService.updateById(specialXy));
            }
            return specialXyService.saveSpecialXy(specialXy);
        }catch (Exception e) {
            e.printStackTrace();
            throw new CustomException("########" + e.getMessage());
        }
    }

    /**
     * 批量删除
     * @url /specialxy/del
     *
     * @return
     */
    @RequestMapping("/del")
    public @ResponseBody
    RespData del(String ids) {
        try {
            return specialXyService.deleteSpecialXy(ids);
        }catch (Exception e) {
            e.printStackTrace();
            throw new CustomException("########" + e.getMessage());
        }
    }

    @RequestMapping("/getAll")
    public @ResponseBody
    RespData getAll() {
        try {
            return RespData.successMsg("查询成功",specialXyService.getAll());
        }catch (Exception e) {
            e.printStackTrace();
            throw new CustomException("########" + e.getMessage());
        }
    }
}
