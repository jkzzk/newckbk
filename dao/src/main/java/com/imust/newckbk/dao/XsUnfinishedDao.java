package com.imust.newckbk.dao;

import com.imust.newckbk.domain.XsUnfinished;
import com.imust.newckbk.base.BaseDao;
import com.imust.newckbk.domain.ext.XsUnfinishedExt;

import java.util.List;
import java.util.Map;


/**
* @date 2020-05-05
* @author zzk
* 
*/
public interface XsUnfinishedDao extends BaseDao<XsUnfinished, String>{

    /**
     * ��ҳ��ѯ
     * @param data
     * @return
     */
    List<XsUnfinishedExt> getExtByPage(Map data);

    /**
     * ͨ��ѧ�Ų�ѯ����
     *
     * @param loginName
     * @return
     */
    String getByXh(String loginName);
}