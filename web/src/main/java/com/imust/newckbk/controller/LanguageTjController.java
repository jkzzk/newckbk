package com.imust.newckbk.controller;

import com.imust.newckbk.common.RespData;
import com.imust.newckbk.domain.ext.LanguageTjExt;
import com.imust.newckbk.service.LanguageTjService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("/languageTj")
@Controller
public class LanguageTjController {

    @Autowired
    private LanguageTjService languageTjService;

    /**
     * 保存条件
     *
     * /languageTj/save
     *
     * @return
     */
    @RequestMapping("/save")
    public @ResponseBody
    RespData save(@RequestBody LanguageTjExt languageTjExt) {
        try {

            return languageTjService.save(languageTjExt);

        }catch (Exception e) {
            e.printStackTrace();
            return RespData.errorMsg("错误：" + "##############" + e.getMessage());
        }
    }
}
