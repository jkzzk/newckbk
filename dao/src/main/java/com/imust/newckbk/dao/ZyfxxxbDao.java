package com.imust.newckbk.dao;

import com.imust.newckbk.domain.Zyfxxxb;
import com.imust.newckbk.base.BaseDao;

import java.util.List;
import java.util.Map;


/**
* @date 2020-08-23
* @author zzk
* 
*/
public interface ZyfxxxbDao extends BaseDao<Zyfxxxb, String>{

    /**
     * 分页查询
     * @param data
     * @return
     */
    List<Zyfxxxb> getByExtPage(Map data);

    /**
     * 根据ID删除
     *
     * @param asList
     * @return
     */
    int deleteByArr(List<String> asList);
}