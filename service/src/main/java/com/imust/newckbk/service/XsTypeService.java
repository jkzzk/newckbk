package com.imust.newckbk.service;

import com.github.pagehelper.PageInfo;
import com.imust.newckbk.base.PageEntity;
import com.imust.newckbk.common.RespData;
import com.imust.newckbk.domain.XsType;
import com.imust.newckbk.base.BaseService;
import com.imust.newckbk.domain.ext.BktjjlExt;

import java.util.Map;


/**
* @date 2020-09-30
* @author jkzzk
* 
*/
public interface XsTypeService extends BaseService<XsType, String>{

    /**
     * 分页查询
     *
     * @param mapPageEntity
     * @return
     */
    PageInfo<XsType> query(PageEntity<Map> mapPageEntity);

    /**
     * 保存学生类别
     *
     * @param xsType
     * @return
     */
    RespData saveXsType(XsType xsType);

    /**
     * 批量删除学生类别
     *
     * @param ids
     * @return
     */
    RespData deleteXsType(String ids);
}