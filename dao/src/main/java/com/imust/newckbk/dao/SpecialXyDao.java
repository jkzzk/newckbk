package com.imust.newckbk.dao;

import com.imust.newckbk.domain.SpecialXy;
import com.imust.newckbk.base.BaseDao;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;


/**
* @date 2020-09-30
* @author zzk
* 
*/
public interface SpecialXyDao extends BaseDao<SpecialXy, String>{

    /**
     * 分页查询
     *
     * @param data
     * @return
     */
    List<SpecialXy> getExtByPage(Map data);

    /**
     * 批量删除，通过逗号分隔的id字符串
     *
     * @param ids
     * @return
     */
    int deleteByIds(@Param("ids") String ids);
}