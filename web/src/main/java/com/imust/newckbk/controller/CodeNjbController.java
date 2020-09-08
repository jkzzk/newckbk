package com.imust.newckbk.controller;

import com.imust.newckbk.common.RespData;
import com.imust.newckbk.common.RetCode;
import com.imust.newckbk.exception.CustomException;
import com.imust.newckbk.service.CodeNjbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/grade")
public class CodeNjbController {
    @Autowired
    private CodeNjbService codeNjbService;

    @RequestMapping("/getAllGrade")
    public RespData getAllGrade() {
        try {
            return codeNjbService.getAllGrade();
        } catch (Exception e) {
            e.printStackTrace();
            throw new CustomException(RetCode.ACTIVE_FAILURE.getMsg());
        }
    }
}
