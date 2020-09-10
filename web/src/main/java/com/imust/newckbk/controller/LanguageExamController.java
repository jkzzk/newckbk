package com.imust.newckbk.controller;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.TemplateExportParams;
import com.github.pagehelper.PageInfo;
import com.imust.newckbk.base.PageEntity;
import com.imust.newckbk.common.DefaultPage;
import com.imust.newckbk.common.ExcelExportCommon;
import com.imust.newckbk.common.RespData;
import com.imust.newckbk.domain.Bkkcxxb;
import com.imust.newckbk.domain.Cet4Tjjl;
import com.imust.newckbk.domain.LanguageExam;
import com.imust.newckbk.domain.ext.BkkcxxbExt;
import com.imust.newckbk.domain.ext.LanguageExamExt;
import com.imust.newckbk.exception.CustomException;
import com.imust.newckbk.service.Cet4TjjlService;
import com.imust.newckbk.service.CodeZxjxjhxnxqxxService;
import com.imust.newckbk.service.LanguageExamService;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("/langExam")
@Controller
public class LanguageExamController {

    @Autowired
    private LanguageExamService languageExamService;
    @Autowired
    private CodeZxjxjhxnxqxxService codeZxjxjhxnxqxxService;
    @Autowired
    private Cet4TjjlService cet4TjjlService;

    /**
     * 语种考试列表
     * @url /langExam/list
     * @param pageParams
     * @param m
     * @return
     */
    @RequestMapping("/list")
    public String list(@RequestParam Map<String,String> pageParams, Model m) {
        try {
            PageEntity<Map> mapPageEntity = DefaultPage.setDefaultPage(pageParams);
            PageInfo<LanguageExamExt> page = languageExamService.query(mapPageEntity);

            m.addAttribute("term",codeZxjxjhxnxqxxService.getAllTerm().getData());
            m.addAttribute("page", page);
            m.addAttribute("param",pageParams);
            return "langExam/list";
        }catch (Exception e) {
            throw new CustomException("########" + e.getMessage());
        }
    }

    /**
     * 新增页面
     * @url /langExam/edit
     * @param m
     * @return
     */
    @RequestMapping("/edit")
    public String edit(String id,Model m) {
        try {

            m.addAttribute("term",codeZxjxjhxnxqxxService.getAllTerm().getData());

            if(id != null && !id.equals("")) {
                m.addAttribute("langExam",languageExamService.getById(id));
                return "langExam/edit";
            }

            m.addAttribute("langExam",new LanguageExam());
            return "langExam/edit";
        }catch (Exception e) {
            throw new CustomException("########" + e.getMessage());
        }
    }

    /**
     * 保存补考
     * @url /langExam/save
     * @param languageExam
     * @return
     */
    @RequestMapping("/save")
    public @ResponseBody
    RespData save(@RequestBody LanguageExam languageExam) {
        try {
            if(languageExam.getId() == null || languageExam.getId().equals("")) {
                return languageExamService.saveLanguageExam(languageExam);
            }

            return languageExamService.editLanguageExam(languageExam);
        }catch (Exception e) {
            e.printStackTrace();
            throw new CustomException("########" + e.getMessage());
        }
    }

    /**
     * 批量删除
     *
     * @param ids
     * @return
     */
    @RequestMapping("/delete")
    public @ResponseBody
    RespData delete(String[] ids) {
        try {
            return languageExamService.deleteLanguageExam(ids);
        }catch (Exception e) {
            e.printStackTrace();
            throw new CustomException("#########" + e.getMessage());
        }
    }

    /**
     * 导出
     *
     * @param request
     * @param response
     */
    @RequestMapping("/export")
    public void export(HttpServletRequest request,HttpServletResponse response) {
        try {

            Cet4Tjjl cet4Tjjl = cet4TjjlService.getCurrentSet();

            List<LanguageExam> languageExams = new ArrayList<>();
            if(cet4Tjjl != null ) {
                languageExams = languageExamService.getAllByTerm(cet4Tjjl.getZxjxjhh());
            }

            Map params = new HashMap();
            params.put("lang", languageExams);
            String path = request.getSession().getServletContext().getRealPath("/temp/语种考试资质名单模板.xlsx");//获取模板路径
            TemplateExportParams tep = new TemplateExportParams(path);
            Workbook workbook = ExcelExportUtil.exportExcel(tep, params);
            ExcelExportCommon.exprotExcel(workbook,"语种考试资质名单",response);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    @RequestMapping("/generateLangExam")
    public @ResponseBody
    RespData generateLangExam(int type) {
        switch (type) {
            case 1: return languageExamService.generateCET4();
            case 2: return languageExamService.generateCET6();
            case 3: return languageExamService.generateCRT4();
            case 4: return languageExamService.generateCRT6();
            case 5: return languageExamService.generateCJT4();
            case 6: return languageExamService.generateCJT6();
            default: return RespData.errorMsg("未知的语言种类");
        }
    }
}