package com.imust.newckbk.controller;

import com.github.pagehelper.PageInfo;
import com.imust.newckbk.base.PageEntity;
import com.imust.newckbk.common.DefaultPage;
import com.imust.newckbk.common.RespData;
import com.imust.newckbk.domain.CetStuYyfbcj;
import com.imust.newckbk.domain.Zyxxb;
import com.imust.newckbk.domain.ext.BktjjlExt;
import com.imust.newckbk.domain.ext.CetStuYyfbcjExt;
import com.imust.newckbk.exception.CustomException;
import com.imust.newckbk.service.CetStuYyfbcjService;
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
import java.util.Arrays;
import java.util.Map;

@RequestMapping("/cetyyfbcj")
@Controller
public class CetStuYyfbcjController {


    @Autowired
    private CetStuYyfbcjService cetStuYyfbcjService;
    @Autowired
    private CodeZxjxjhxnxqxxService codeZxjxjhxnxqxxService;

    /**
     * 英语分班成绩分页查询表
     *
     * @url /cetyyfbcj/list
     * @param pageParams
     * @param m
     * @return
     */
    @RequestMapping("/list")
    public String list(@RequestParam Map<String,String> pageParams, Model m)  {
        try {

            PageEntity<Map> mapPageEntity = DefaultPage.setDefaultPage(pageParams);
            PageInfo<CetStuYyfbcjExt> page = cetStuYyfbcjService.query(mapPageEntity);

            m.addAttribute("page", page);
            m.addAttribute("term",codeZxjxjhxnxqxxService.getAllTerm().getData());

            return "cetyyfbcj/list";
        }catch (Exception e) {
            throw new CustomException("########" + e.getMessage());
        }
    }

    /**
     * 修改分班成绩
     *
     * @url /cetyyfbcj/edit
     * @param id
     * @param m
     * @return
     */
    @RequestMapping("edit")
    public String edit(String id,Model m) {
        try {
            m.addAttribute("term",codeZxjxjhxnxqxxService.getAllTerm().getData());

            if(id == null || "".equals(id)) {
                return "cetyyfbcj/edit";
            }

            CetStuYyfbcj cetStuYyfbcj = cetStuYyfbcjService.getById(id);
            m.addAttribute("cetStufbcj", cetStuYyfbcj);

            return "cetyyfbcj/edit";
        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 保存分班成绩
     *
     * @url /cetyyfbcj/save
     * @param cetStuYyfbcj
     * @return
     */
    @RequestMapping("save")
    @ResponseBody
    public RespData save(@RequestBody CetStuYyfbcj cetStuYyfbcj) {
        try {
            if(cetStuYyfbcj.getId() == null || "".equals(cetStuYyfbcj.getId())) {
                return cetStuYyfbcjService.saveCetStuYyfbcj(cetStuYyfbcj);
            }

            return RespData.successMsg("修改成功！",cetStuYyfbcjService.updateById(cetStuYyfbcj));
        }catch (Exception e) {
            e.printStackTrace();
            throw new CustomException(e.getMessage());
        }
    }

    /**
     * 批量删除
     *
     * @url /cetyyfbcj/del
     * @param ids
     * @return
     */
    @RequestMapping("del")
    @ResponseBody
    public RespData del(String ids) {
        try {
            return cetStuYyfbcjService.delCetStuYyfbcj(Arrays.asList(ids.split(",")));
        }catch (Exception e) {
            e.printStackTrace();
            throw new CustomException(e.getMessage());
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
            return cetStuYyfbcjService.importCetStuYyfbcj(file);
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
            InputStream resourceAsStream = request.getSession().getServletContext().getResourceAsStream("/temp/分班成绩导入模板.xlsx");
            FileUtils.downloadFile(resourceAsStream,response,"分班成绩导入模板.xls");
        }catch(Exception e) {
            e.printStackTrace();
            throw new CustomException(e.getMessage());
        }
    }

}
