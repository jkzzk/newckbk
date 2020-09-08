package com.imust.newckbk.controller;

import com.github.pagehelper.PageInfo;
import com.imust.newckbk.base.PageEntity;
import com.imust.newckbk.common.DefaultPage;
import com.imust.newckbk.common.RespData;
import com.imust.newckbk.domain.Zyfxxxb;
import com.imust.newckbk.exception.CustomException;
import com.imust.newckbk.service.ZyfxxxbService;
import com.imust.newckbk.utils.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Map;

@Controller
@RequestMapping("/zyfxxxb")
public class ZyfxxxbController {

    @Autowired
    private ZyfxxxbService zyfxxxbService;

    /**
     * 辅修专业列表
     *
     * @url /zyfxxxb/list
     * @param pageParams
     * @param m
     * @return
     */
    @RequestMapping("list")
    public String list(@RequestParam Map<String,String> pageParams, Model m) {
        try {
            PageEntity<Map> mapPageEntity = DefaultPage.setDefaultPage(pageParams);
            PageInfo<Zyfxxxb> page = zyfxxxbService.query(mapPageEntity);

            m.addAttribute("page", page);

            return "zyfxxxb/list";
        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * @url /zyfxxxb/edit
     * @param id
     * @param m
     * @return
     */
    @RequestMapping("edit")
    public String edit(String id,Model m) {
        try {
            if(id == null || "".equals(id)) {
                return "zyfxxxb/edit";
            }

            Zyfxxxb zyfxxxb = zyfxxxbService.getById(id);
            m.addAttribute("zyfxxxb", zyfxxxb);

            return "zyfxxxb/edit";
        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 保存辅修专业
     * @url /zyfxxxb/save
     * @param zyfxxxb
     * @return
     */
    @RequestMapping("save")
    @ResponseBody
    public RespData save(@RequestBody Zyfxxxb zyfxxxb) {
        try {
            if(zyfxxxb.getId() == null || "".equals(zyfxxxb.getId())) {
                return zyfxxxbService.saveZyxxb(zyfxxxb);
            }

            return RespData.successMsg("修改成功！",zyfxxxbService.updateById(zyfxxxb));
        }catch (Exception e) {
            e.printStackTrace();
            throw new CustomException(e.getMessage());
        }
    }

    /**
     * 批量删除
     * @url /zyfxxxb/del
     * @param ids
     * @return
     */
    @RequestMapping("del")
    @ResponseBody
    public RespData del(String ids) {
        try {
            return zyfxxxbService.delZyxxb(Arrays.asList(ids.split(",")));
        }catch (Exception e) {
            e.printStackTrace();
            throw new CustomException(e.getMessage());
        }
    }

    /**
     * 导入辅修专业
     *
     * @param file
     * @return
     */
    @RequestMapping("import")
    public @ResponseBody
    RespData importBkkcxxb(MultipartFile file) {
        try {
            return zyfxxxbService.importBkkcxxb(file);
        }catch (Exception e) {
            e.getMessage();
            return RespData.errorMsg(e.getMessage());
        }
    }

    /**
     * 下载导入模板
     *
     * @param request
     * @param response
     */
    @RequestMapping("/download")
    public void download(HttpServletRequest request, HttpServletResponse response) {
        try {
            InputStream resourceAsStream = request.getSession().getServletContext().getResourceAsStream("/temp/辅修专业导入模板.xlsx");
            FileUtils.downloadFile(resourceAsStream,response,"辅修专业导入模板.xls");
        }catch(Exception e) {
            e.printStackTrace();
            throw new CustomException(e.getMessage());
        }
    }

}
