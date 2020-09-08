package com.imust.newckbk.dao;

import com.imust.newckbk.domain.Bkkcxxb;
import com.imust.newckbk.base.BaseDao;
import com.imust.newckbk.domain.ext.BkkcxxbExt;

import java.util.List;
import java.util.Map;


/**
* @date 2020-07-17
* @author zzk
* 
*/
public interface BkkcxxbDao extends BaseDao<Bkkcxxb, String>{

    /**
     * ��ҳ��ѯ
     *
     * @param data
     * @return
     */
    List<BkkcxxbExt> getExtByPage(Map data);

    /**
     * ����ɾ��
     *
     * @param ids
     * @return
     */
    int deleteByIdArr(String[] ids);
}