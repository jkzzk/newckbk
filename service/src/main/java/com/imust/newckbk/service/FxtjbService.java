package com.imust.newckbk.service;

import com.github.pagehelper.PageInfo;
import com.imust.newckbk.base.PageEntity;
import com.imust.newckbk.common.RespData;
import com.imust.newckbk.domain.Fxtjb;
import com.imust.newckbk.base.BaseService;
import com.imust.newckbk.domain.ext.FxtjbExt;

import java.util.Map;


/**
* @date 2020-08-23
* @author jkzzk
* 
*/
public interface FxtjbService extends BaseService<Fxtjb, String>{

    /**
     * 分页查询辅修条件
     *
     * @param mapPageEntity
     * @return
     */
    PageInfo<FxtjbExt> query(PageEntity<Map> mapPageEntity);

    /**
     * 保存辅修条件表
     *
     * @param fxtjb
     * @return
     */
    RespData saveFxtjb(Fxtjb fxtjb);

    /**
     * 清除无效记录
     *
     * @return
     */
    RespData clearFxtjb();
}