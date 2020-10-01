package com.imust.newckbk.dao;

import com.imust.newckbk.domain.XsType;
import com.imust.newckbk.base.BaseDao;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;


/**
* @date 2020-09-30
* @author zzk
* 
*/
public interface XsTypeDao extends BaseDao<XsType, String>{

    /**
     * 分页查询
     *
     * @param data
     * @return
     */
    List<XsType> getExtByPage(Map data);

    /**
     * 批量删除，根据逗号分隔id字符串
     *
     * @param ids
     * @return
     */
    int deleteByIds(@Param("ids") String ids);
}