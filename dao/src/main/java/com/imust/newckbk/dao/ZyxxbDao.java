package com.imust.newckbk.dao;

import com.imust.newckbk.domain.Zyxxb;
import com.imust.newckbk.base.BaseDao;

import java.util.List;
import java.util.Map;


/**
* @date 2020-05-12
* @author zzk
* 
*/
public interface ZyxxbDao extends BaseDao<Zyxxb, String>{

    /**
     * ��ҳ��ѯ
     *
     * @param data
     * @return
     */
    List<Zyxxb> getByExtPage(Map data);

    /**
     * ͨ������ɾ��
     *
     * @param ids
     * @return
     */
    int deleteByArr(List<String> ids);

    /**
     * ��ѯ����ѧԺ
     *
     * @param params
     * @return
     */
    List<String> getAllXsm(Map<String, Object> params);

    /**
     * ��ѯ����רҵ
     *
     * @param params
     * @return
     */
    List<String> getAllZym(Map<String, Object> params);
}