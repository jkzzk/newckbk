package com.imust.newckbk.service;

import com.github.pagehelper.PageInfo;
import com.imust.newckbk.base.PageEntity;
import com.imust.newckbk.common.RespData;
import com.imust.newckbk.domain.SpecialXy;
import com.imust.newckbk.base.BaseService;
import com.imust.newckbk.domain.XsType;

import java.util.Map;


/**
* @date 2020-09-30
* @author jkzzk
* 
*/
public interface SpecialXyService extends BaseService<SpecialXy, String>{

    /**
     * 保存特殊学院
     *
     * @param mapPageEntity
     * @return
     */
    PageInfo<SpecialXy> query(PageEntity<Map> mapPageEntity);

    /**
     * 保存特殊学院
     *
     * @param specialXy
     * @return
     */
    RespData saveSpecialXy(SpecialXy specialXy);

    /**
     * 批量删除特殊学院
     *
     * @param ids
     * @return
     */
    RespData deleteSpecialXy(String ids);
}