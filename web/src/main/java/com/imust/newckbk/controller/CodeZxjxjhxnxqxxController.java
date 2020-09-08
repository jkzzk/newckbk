package com.imust.newckbk.controller;

import com.imust.newckbk.common.RespData;
import com.imust.newckbk.common.RetCode;
import com.imust.newckbk.exception.CustomException;
import com.imust.newckbk.service.CodeZxjxjhxnxqxxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/term")
public class CodeZxjxjhxnxqxxController {

    @Autowired
    private CodeZxjxjhxnxqxxService codeZxjxjhxnxqxxService;

    @RequestMapping("/getAllTerm")
    public RespData getAllTerm() {
        try {
            return codeZxjxjhxnxqxxService.getAllTerm();
        } catch (Exception e) {
            e.printStackTrace();
            throw new CustomException(RetCode.ACTIVE_FAILURE.getMsg());
        }
    }
}
