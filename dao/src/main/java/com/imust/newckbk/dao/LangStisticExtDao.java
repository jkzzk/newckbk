package com.imust.newckbk.dao;

import com.imust.newckbk.base.BaseDao;
import com.imust.newckbk.domain.ext.LangStisticExt;

import java.util.List;


/**
* @date 2020-10-08
* @author zzk
* 
*/
public interface LangStisticExtDao extends BaseDao<LangStisticExt, String>{

    /**
     * 删除全部数据
     */
    void deleteAll();

    /**
     * 查询一条记录
     *
     * @return
     */
    List<LangStisticExt> getOne();
}