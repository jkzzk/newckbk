package com.imust.newckbk.dao;

import com.imust.newckbk.base.BaseDao;
import com.imust.newckbk.domain.XsXjxxbViewKw;
import com.imust.newckbk.domain.report.XszzyxxReportExt;

import java.util.List;
import java.util.Map;

/**
 * @date 2019-09-02
 * @author zzk
 *
 */
public interface XsXjxxbViewKwDao extends BaseDao<XsXjxxbViewKw, String> {
    /**
     * 通过map查找
     *
     * @param data
     * @return
     */
    List<XsXjxxbViewKw> getByMapPage(Map data);
}



