package com.imust.newckbk.dao;

import com.imust.newckbk.domain.Zzytjjl;
import com.imust.newckbk.base.BaseDao;
import com.imust.newckbk.domain.ext.ZzytjjlExt;

import java.util.List;
import java.util.Map;


/**
* @date 2020-05-13
* @author zzk
* 
*/
public interface ZzytjjlDao extends BaseDao<Zzytjjl, String>{

    /**
     * 分页查询
     *
     * @param data
     * @return
     */
    List<ZzytjjlExt> getExtByPage(Map data);

    /**
     * 失效所有
     *
     * @return
     */
    int invalidAll();

    /**
     * 清除失效记录
     *
     * @return
     */
    int clearInvalid();

    /**
     * 查询当前记录
     * @return
     */
    Zzytjjl getCurrentSet();
}