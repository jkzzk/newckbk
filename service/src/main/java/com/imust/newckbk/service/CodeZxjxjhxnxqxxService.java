package com.imust.newckbk.service;

import com.imust.newckbk.common.RespData;
import com.imust.newckbk.domain.CodeZxjxjhxnxqxx;
import com.imust.newckbk.base.BaseService;


/**
* @date 2020-03-07
* @author jkzzk
* 
*/
public interface CodeZxjxjhxnxqxxService extends BaseService<CodeZxjxjhxnxqxx, String>{

    /**
     * 查询所有年级信息
     * @return
     */
    RespData getAllTerm();
}