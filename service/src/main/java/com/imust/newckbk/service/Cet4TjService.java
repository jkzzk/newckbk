package com.imust.newckbk.service;

import com.github.pagehelper.PageInfo;
import com.imust.newckbk.base.PageEntity;
import com.imust.newckbk.common.RespData;
import com.imust.newckbk.domain.Cet4Tjjl;
import com.imust.newckbk.domain.SysUser;
import com.imust.newckbk.domain.ext.BktjjlExt;
import com.imust.newckbk.domain.ext.CET4TJExt;

import java.util.Map;

public interface Cet4TjService {

    /**
     * 四级条件表分页查询
     *
     * @param mapPageEntity
     * @return
     */
    PageInfo<CET4TJExt> query(PageEntity<Map> mapPageEntity);

    /**
     * 查询四级条件详细信息
     *
     * @param id
     * @return
     */
    CET4TJExt getCurrentSet(String id);

    /**
     * 保存四级条件
     *
     * @param cet4TJExt
     * @return
     */
    RespData saveCet4TJExt(CET4TJExt cet4TJExt);

    /**
     * 清除无效条件记录
     *
     * @return
     */
    RespData clearCet4Tjjl();
}
