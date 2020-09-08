package com.imust.newckbk.dao;

import com.imust.newckbk.domain.Bktjjl;
import com.imust.newckbk.base.BaseDao;
import com.imust.newckbk.domain.ext.BktjjlExt;

import java.util.List;
import java.util.Map;


/**
* @date 2020-03-07
* @author zzk
* 
*/
public interface BktjjlDao extends BaseDao<Bktjjl, String>{

    /**
     * 查询分页
     * @param data
     * @return
     */
    List<BktjjlExt> getExtByPage(Map data);

    /**
     * 查询当前设置
     * @return
     */
    BktjjlExt getCurrentSet(String id);

    /**
     * 更新状态标志
     * @return
     */
    int abandonOld();


    /**
     * 清除标志为0的记录
     * @return
     */
    int clearBktjjl();

    /**
     * 查询生效设置
     * @return
     */
    BktjjlExt getEffectiveSet();
}