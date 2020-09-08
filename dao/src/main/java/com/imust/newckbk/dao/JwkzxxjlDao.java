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
     * �������ü�¼��ҳ��ѯ
     * @param data
     * @return
     */
    List<JwkzxxjlExt> getExtByMapPage(Map data);

    /**
     * ���ҵ�ǰ��������
     * @return
     */
    Jwkzxxjl getCurrentSet();

    /**
     * ���ø��µ�ǰ��¼
     * @param value
     */
    void setCurrentSet(int value);

    /**
     * ����������ü�¼
     * @return
     */
    int clearRecord();
}