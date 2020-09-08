package com.imust.newckbk.controller;

import com.github.pagehelper.PageInfo;
import com.imust.newckbk.base.PageEntity;
import com.imust.newckbk.common.DefaultPage;
import com.imust.newckbk.common.RespData;
import com.imust.newckbk.common.RetCode;
import com.imust.newckbk.domain.Bkkcxxb;
import com.imust.newckbk.domain.ext.BkkcxxbExt;
import com.imust.newckbk.exception.CustomException;
import com.imust.newckbk.service.BkkcxxbService;
import com.imust.newckbk.service.CodeZxjxjhxnxqxxService;
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
import java.util.Map;

@Controller
@RequestMapping("/bkkcxxb")
public class BkkcxxbController {

    @Autowired
    private BkkcxxbService bkkcxxbService;
    @Autowired
    private CodeZxjxjhxnxqxxService codeZxjxjhxnxqxxService;

    /**
     * 补考课程列表
     * @url /bkkcxxb/list
     * @param pageParams
     * @param m
     * @return
     */
    @RequestMapping("/list")
    public String list(@RequestParam Map<String,String> pageParams, Model m) {
        try {
            PageEntity<Map> mapPageEntity = DefaultPage.setDefaultPage(pageParams);
            PageInfo<BkkcxxbExt> page = bkkcxxbService.query(mapPageEntity);

            m.addAttribute("term",codeZxjxjhxnxqxxService.getAllTerm().getData());
            m.addAttribute("page", page);
            m.addAttribute("param",pageParams);
            return "bkkcxxb/list";
        }catch (Exception e) {
            throw new CustomException("########" + e.getMessage());
        }
    }

    /**
     * 新增页面
     * @url /bkkcxxb/edit
     * @param m
     * @return
     */
    @RequestMapping("/edit")
    public String edit(String id,Model m) {
        try {

            m.addAttribute("term",codeZxjxjhxnxqxxService.getAllTerm().getData());

            if(id != null && !id.equals("")) {
                m.addAttribute("course",bkkcxxbService.getById(id));
                return "bkkcxxb/edit";
            }

            m.addAttribute("course",new Bkkcxxb());
            return "bkkcxxb/edit";
        }catch (Exception e) {
            throw new CustomException("########" + e.getMessage());
        }
    }

    /**
     * 保存补考课程
     * @url /bkkcxxb/save
     * @param bkkcxxb
     * @return
     */
    @RequestMapping("/save")
    public @ResponseBody
    RespData save(@RequestBody Bkkcxxb bkkcxxb) {
        try {
            if(bkkcxxb.getId() == null || bkkcxxb.getId().equals("")) {
                return bkkcxxbService.saveBkkcxxb(bkkcxxb);
            }

            return bkkcxxbService.editBkkcxxb(bkkcxxb);
        }catch (Exception e) {
            e.printStackTrace();
            throw new CustomException("########" + e.getMessage());
        }
    }

    /**
     * 批量删除补考课程
     *
     * @param ids
     * @return
     */
    @RequestMapping("/delete")
    public @ResponseBody
    RespData delete(String[] ids) {
        try {
            return bkkcxxbService.deleteBkkcxxb(ids);
        }catch (Exception e) {
            e.printStackTrace();
            throw new CustomException("#########" + e.getMessage());
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
    RespData importBkkcxxb(MultipartFile file) {
        try {
            return bkkcxxbService.importBkkcxxb(file);
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
            InputStream resourceAsStream = request.getSession().getServletContext().getResourceAsStream("/temp/补考课程导入模板.xlsx");
            FileUtils.downloadFile(resourceAsStream,response,"补考课程导入模板.xls");
        }catch(Exception e) {
            e.printStackTrace();
            throw new CustomException(e.getMessage());
        }
    }

}
