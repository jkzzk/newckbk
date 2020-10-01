package com.imust.newckbk.controller;

import com.github.pagehelper.PageInfo;
import com.imust.newckbk.base.PageEntity;
import com.imust.newckbk.common.DefaultPage;
import com.imust.newckbk.common.RespData;
import com.imust.newckbk.domain.XsType;
import com.imust.newckbk.exception.CustomException;
import com.imust.newckbk.service.XsTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@RequestMapping("/xstype")
@Controller
public class XsTypeController {

    @Autowired
    private XsTypeService xsTypeService;

    /**
     * 学生类别记录列表
     * @url /xstype/list
     * @param pageParams
     * @param m
     * @return
     */
    @RequestMapping("/list")
    public String list(@RequestParam Map<String,String> pageParams, Model m) {
        try {
            PageEntity<Map> mapPageEntity = DefaultPage.setDefaultPage(pageParams);
            PageInfo<XsType> page = xsTypeService.query(mapPageEntity);

            m.addAttribute("page", page);

            return "xstype/list";
        }catch (Exception e) {
            throw new CustomException("########" + e.getMessage());
        }
    }

    /**
     * 设置学生类别条件页面
     * @url /xstype/edit
     * @param m
     * @return
     */
    @RequestMapping("/edit")
    public String edit(String id,Model m) {
        try {
            if(id != null && !"".equals(id)) {
                XsType xsType = xsTypeService.getById(id);
                m.addAttribute("xstype", xsType);
            }

            return "xstype/edit";
        }catch (Exception e) {
            throw new CustomException("########" + e.getMessage());
        }
    }

    /**
     * 保存学生类别
     * @url /xstype/save
     * @param xsType
     * @return
     */
    @RequestMapping("/save")
    public @ResponseBody
    RespData save(@RequestBody XsType xsType) {
        try {
            if(xsType != null && !xsType.getId().equals("")) {
                return RespData.successMsg("修改成功",xsTypeService.updateById(xsType));
            }
            return xsTypeService.saveXsType(xsType);
        }catch (Exception e) {
            e.printStackTrace();
            throw new CustomException("########" + e.getMessage());
        }
    }

    /**
     * 批量删除
     * @url /xstype/del
     *
     * @return
     */
    @RequestMapping("/del")
    public @ResponseBody
    RespData del(String ids) {
        try {
            return xsTypeService.deleteXsType(ids);
        }catch (Exception e) {
            e.printStackTrace();
            throw new CustomException("########" + e.getMessage());
        }
    }

    /**
     * @url /xstype/getAll
     *
     * @param typeAttr
     * @return
     */
    @RequestMapping("/getAll")
    public @ResponseBody
    RespData getAll(String typeAttr) {
        try {
            Map<String,Object> params = new HashMap<>();
            params.put("typeAttr",typeAttr);
            return RespData.successMsg("查询成功",xsTypeService.getByMap(params));
        }catch (Exception e) {
            e.printStackTrace();
            throw new CustomException("########" + e.getMessage());
        }
    }
}
