package com.imust.newckbk.dao;

import com.imust.newckbk.domain.Cet4Tjjl;
import com.imust.newckbk.base.BaseDao;
import com.imust.newckbk.domain.ext.CET4TJExt;

import java.util.List;
import java.util.Map;


/**
* @date 2020-09-09
* @author zzk
* 
*/
public interface Cet4TjjlDao extends BaseDao<Cet4Tjjl, String>{

    /**
     * 分页查询
     *
     * @param data
     * @return
     */
    List<CET4TJExt> getExtByPage(Map data);

    /**
     * 更新所有记录状态为
     *
     * @param status
     */
    void updateByStatus(int status);

    /**
     * 根据状态查询
     *
     * @param status
     * @return
     */
    List<Cet4Tjjl> getByStatus(String status);

    /**
     * 根据ID获取
     *
     * @param id
     * @return
     */
    CET4TJExt getExtById(String id);
}