package com.imust.newckbk.dao;

import com.imust.newckbk.domain.Xszzyxxb;
import com.imust.newckbk.base.BaseDao;
import com.imust.newckbk.domain.ext.XszzyxxbExt;
import com.imust.newckbk.domain.report.XszzyxxReportExt;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;


/**
* @date 2020-05-13
* @author zzk
* 
*/
public interface XszzyxxbDao extends BaseDao<Xszzyxxb, String>{

    /**
     * ��ҳ��ѯ
     *
     * @param data
     * @return
     */
    List<XszzyxxbExt> getExtByPage(Map data);

    /**
     * ����ɾ��
     *
     * @param ids
     * @return
     */
    int deleteByArr(List<String> ids);

    /**
     * ͨ��Id��ȡ����
     * @param id
     * @return
     */
    XszzyxxbExt getExtById(String id);

    /**
     * ͨ��ѧ�Ż�ȡ����
     * @param loginName
     * @return
     */
    XszzyxxbExt getExtByXh(@Param("xh") String loginName);

    /**
     * ��ѯ��������
     *
     * @param xh
     * @return
     */
    XszzyxxReportExt getByXh(String xh);
}