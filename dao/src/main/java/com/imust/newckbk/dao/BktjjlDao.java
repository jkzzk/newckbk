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
     * ��ѯ��ҳ
     * @param data
     * @return
     */
    List<BktjjlExt> getExtByPage(Map data);

    /**
     * ��ѯ��ǰ����
     * @return
     */
    BktjjlExt getCurrentSet(String id);

    /**
     * ����״̬��־
     * @return
     */
    int abandonOld();


    /**
     * �����־Ϊ0�ļ�¼
     * @return
     */
    int clearBktjjl();

    /**
     * ��ѯ��Ч����
     * @return
     */
    BktjjlExt getEffectiveSet();
}