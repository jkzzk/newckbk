package com.imust.newckbk.dao;

import com.imust.newckbk.domain.Fxtjb;
import com.imust.newckbk.base.BaseDao;
import com.imust.newckbk.domain.ext.BktjjlExt;
import com.imust.newckbk.domain.ext.FxtjbExt;

import java.util.List;
import java.util.Map;


/**
* @date 2020-08-23
* @author zzk
* 
*/
public interface FxtjbDao extends BaseDao<Fxtjb, String>{

    /**
     * 分页查询
     *
     * @param data
     * @return
     */
    List<FxtjbExt> getExtByPage(Map data);

    /**
     * 更新所有记录状态为 2
     */
    void abandonOld();

    /**
     * 删除所有状态为2的记录
     */
    int clearFxtjb();

    /**
     * 查询当前生效的辅修条件
     *
     * @return
     */
    FxtjbExt getEffectiveSet();
}