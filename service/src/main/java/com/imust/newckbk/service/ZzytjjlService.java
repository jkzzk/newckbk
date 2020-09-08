package com.imust.newckbk.service;

import com.github.pagehelper.PageInfo;
import com.imust.newckbk.base.PageEntity;
import com.imust.newckbk.common.RespData;
import com.imust.newckbk.domain.SysUser;
import com.imust.newckbk.domain.Zzytjjl;
import com.imust.newckbk.base.BaseService;
import com.imust.newckbk.domain.ext.BktjjlExt;
import com.imust.newckbk.domain.ext.ZzytjjlExt;

import java.util.Map;


/**
* @date 2020-05-13
* @author jkzzk
* 
*/
public interface ZzytjjlService extends BaseService<Zzytjjl, String>{

    /**
     * 分页查询转专业条件记录
     * @param mapPageEntity
     * @return
     */
    PageInfo<ZzytjjlExt> query(PageEntity<Map> mapPageEntity);

    /**
     * 保存转专业条件
     * @param zzytjjl
     * @param currentSysUser
     * @return
     */
    RespData saveZzytjjl(Zzytjjl zzytjjl, SysUser currentSysUser);

    /**
     * 清除无效记录
     *
     * @return
     */
    RespData clearZzytjjl();

    Zzytjjl getCurrentSet();
}