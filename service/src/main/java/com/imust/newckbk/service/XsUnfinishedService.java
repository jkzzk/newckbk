package com.imust.newckbk.service;

import com.github.pagehelper.PageInfo;
import com.imust.newckbk.base.PageEntity;
import com.imust.newckbk.common.RespData;
import com.imust.newckbk.domain.SysUser;
import com.imust.newckbk.domain.XsUnfinished;
import com.imust.newckbk.base.BaseService;
import com.imust.newckbk.domain.ext.BktjjlExt;
import com.imust.newckbk.domain.ext.XsUnfinishedExt;

import java.util.Map;


/**
* @date 2020-05-05
* @author jkzzk
* 
*/
public interface XsUnfinishedService extends BaseService<XsUnfinished, String>{

    /**
     * 分页查询补考结业学生
     * @param mapPageEntity
     * @return
     */
    PageInfo<XsUnfinishedExt> query(PageEntity<Map> mapPageEntity);

    /**
     * 保存结业学生
     * @param xsUnfinished
     * @return
     */
    RespData saveXsUnfinished(XsUnfinished xsUnfinished);

    /**
     * 批量删除结业学生
     * @param ids
     * @return
     */
    RespData clearXsUnfinished(String ids);
}