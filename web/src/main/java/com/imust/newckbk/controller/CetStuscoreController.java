package com.imust.newckbk.controller;

import com.github.pagehelper.PageInfo;
import com.imust.newckbk.base.PageEntity;
import com.imust.newckbk.common.DefaultPage;
import com.imust.newckbk.common.RespData;
import com.imust.newckbk.domain.CetStuscore;
import com.imust.newckbk.domain.Zyxxb;
import com.imust.newckbk.domain.ext.CetStuscoreExt;
import com.imust.newckbk.exception.CustomException;
import com.imust.newckbk.service.CetStuscoreService;
import com.imust.newckbk.utils.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;
import java.util.Map;

@RequestMapping("/stuScore")
@Controller
public class CetStuscoreController {

    @Autowired
    private CetStuscoreService cetStuscoreService;

    /**
     * 历史成绩列表
     *
     * @url /stuScore/list
     * @param pageParams
     * @param m
     * @return
     */
    @RequestMapping("list")
    public String list(@RequestParam Map<String,String> pageParams, Model m) {
        try {
            PageEntity<Map> mapPageEntity = DefaultPage.setDefaultPage(pageParams);
            PageInfo<CetStuscoreExt> page = cetStuscoreService.query(mapPageEntity);

            m.addAttribute("page", page);

            return "stuScore/list";
        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 导入补考课程
     *
     * @param file
     * @return
     */
    @RequestMapping("import")
    public @ResponseBody
    RespData importCetStuscore(MultipartFile file) {
        try {
            return cetStuscoreService.importCetStuscore(file);
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
            InputStream resourceAsStream = request.getSession().getServletContext().getResourceAsStream("/temp/历史成绩导入模板.xlsx");
            FileUtils.downloadFile(resourceAsStream,response,"历史成绩导入模板.xls");
        }catch(Exception e) {
            e.printStackTrace();
            throw new CustomException(e.getMessage());
        }
    }
}
