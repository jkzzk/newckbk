package com.imust.newckbk.service;

import com.github.pagehelper.PageInfo;
import com.imust.newckbk.base.PageEntity;
import com.imust.newckbk.common.RespData;
import com.imust.newckbk.domain.Bktjjl;
import com.imust.newckbk.base.BaseService;
import com.imust.newckbk.domain.SysUser;
import com.imust.newckbk.domain.ext.BktjjlExt;

import java.util.Map;


/**
* @date 2020-03-07
* @author jkzzk
* 
*/
public interface BktjjlService extends BaseService<Bktjjl, String>{

    /**
     * 查询记录分页页面
     * @param pageParams
     * @return
     */
    PageInfo<BktjjlExt> query(PageEntity<Map> pageParams);

    /**
     * 查询当前补考条件设置
     * @return
     */
    BktjjlExt getCurrentSet(String id);

    /**
     * 保存补考条件记录
     * @param bktjjl
     * @param currentSysUser
     * @return
     */
    RespData saveBktjjl(Bktjjl bktjjl, SysUser currentSysUser);

    /**
     * 清除所有记录数据
     * @return
     */
    RespData clearBktjjl();
}