package com.imust.newckbk.dao;

import com.imust.newckbk.domain.Jwkzxxjl;
import com.imust.newckbk.base.BaseDao;
import com.imust.newckbk.domain.XsXjxxbViewKw;
import com.imust.newckbk.domain.ext.JwkzxxjlExt;

import java.util.List;
import java.util.Map;


/**
* @date 2020-02-29
* @author zzk
* 
*/
public interface JwkzxxjlDao extends BaseDao<Jwkzxxjl, String>{

    /**
     * 开关设置记录分页查询
     * @param data
     * @return
     */
    List<JwkzxxjlExt> getExtByMapPage(Map data);

    /**
     * 查找当前开关设置
     * @return
     */
    Jwkzxxjl getCurrentSet();

    /**
     * 设置更新当前记录
     * @param value
     */
    void setCurrentSet(int value);

    /**
     * 清除开关设置记录
     * @return
     */
    int clearRecord();
}