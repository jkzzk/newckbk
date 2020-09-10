package com.imust.newckbk.dao;

import com.imust.newckbk.domain.CetStuYyfbcj;
import com.imust.newckbk.base.BaseDao;
import com.imust.newckbk.domain.ext.CetStuYyfbcjExt;

import java.util.List;
import java.util.Map;


/**
* @date 2020-07-05
* @author zzk
* 
*/
public interface CetStuYyfbcjDao extends BaseDao<CetStuYyfbcj, String>{

    /**
     * 分页查询
     *
     * @param data
     * @return
     */
    List<CetStuYyfbcjExt> getExtByPage(Map data);

    /**
     * 批量删除
     *
     * @param ids
     * @return
     */
    int deleteByArr(List<String> ids);
}