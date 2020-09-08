package com.imust.newckbk.service;

import com.github.pagehelper.PageInfo;
import com.imust.newckbk.base.PageEntity;
import com.imust.newckbk.domain.CetStuYyfbcj;
import com.imust.newckbk.base.BaseService;
import com.imust.newckbk.domain.ext.BktjjlExt;

import java.util.Map;


/**
* @date 2020-07-05
* @author jkzzk
* 
*/
public interface CetStuYyfbcjService extends BaseService<CetStuYyfbcj, String>{

    /**
     * 分页查询
     *
     * @param mapPageEntity
     * @return
     */
    PageInfo<CetStuYyfbcj> query(PageEntity<Map> mapPageEntity);
}