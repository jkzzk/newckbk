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
     * ��ҳ��ѯ
     *
     * @param data
     * @return
     */
    List<ZzytjjlExt> getExtByPage(Map data);

    /**
     * ʧЧ����
     *
     * @return
     */
    int invalidAll();

    /**
     * ���ʧЧ��¼
     *
     * @return
     */
    int clearInvalid();

    /**
     * ��ѯ��ǰ��¼
     * @return
     */
    Zzytjjl getCurrentSet();
}