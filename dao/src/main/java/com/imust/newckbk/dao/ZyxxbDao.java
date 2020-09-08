package com.imust.newckbk.dao;

import com.imust.newckbk.domain.Zyxxb;
import com.imust.newckbk.base.BaseDao;

import java.util.List;
import java.util.Map;


/**
* @date 2020-05-12
* @author zzk
* 
*/
public interface ZyxxbDao extends BaseDao<Zyxxb, String>{

    /**
     * 分页查询
     *
     * @param data
     * @return
     */
    List<Zyxxb> getByExtPage(Map data);

    /**
     * 通过数组删除
     *
     * @param ids
     * @return
     */
    int deleteByArr(List<String> ids);

    /**
     * 查询所有学院
     *
     * @param params
     * @return
     */
    List<String> getAllXsm(Map<String, Object> params);

    /**
     * 查询所有专业
     *
     * @param params
     * @return
     */
    List<String> getAllZym(Map<String, Object> params);
}