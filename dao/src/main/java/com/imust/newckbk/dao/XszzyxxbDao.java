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
     * 分页查询
     *
     * @param data
     * @return
     */
    List<XszzyxxbExt> getExtByPage(Map data);

    /**
     * 批量删除
     *
     * @param ids
     * @return
     */
    int deleteByArr(List<String> ids);

    /**
     * 通过Id获取数据
     * @param id
     * @return
     */
    XszzyxxbExt getExtById(String id);

    /**
     * 通过学号获取数据
     * @param loginName
     * @return
     */
    XszzyxxbExt getExtByXh(@Param("xh") String loginName);

    /**
     * 查询报表数据
     *
     * @param xh
     * @return
     */
    XszzyxxReportExt getByXh(String xh);
}