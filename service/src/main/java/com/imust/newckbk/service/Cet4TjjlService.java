package com.imust.newckbk.service;

import com.imust.newckbk.domain.Cet4Tjjl;
import com.imust.newckbk.base.BaseService;


/**
* @date 2020-09-09
* @author jkzzk
* 
*/
public interface Cet4TjjlService extends BaseService<Cet4Tjjl, String>{

    /**
     * 查询当前条件
     *
     * @return
     */
    Cet4Tjjl getCurrentSet();
}