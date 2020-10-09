package com.imust.newckbk.dao;

import com.imust.newckbk.base.BaseDao;
import com.imust.newckbk.common.RespData;
import com.imust.newckbk.domain.XsXjxxbViewKw;
import com.imust.newckbk.domain.report.XszzyxxReportExt;
import org.apache.ibatis.annotations.Param;

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

    /**
     * 获取年级下学院
     *
     * @param grade
     * @return
     */
    List<String> getAcademy(@Param("grade") String grade);

    /**
     * 获取年级下学院下专业
     *
     * @param grade
     * @param academy
     * @return
     */
    List<String> getMajor(@Param("grade") String grade, @Param("academy") String academy);

    /**
     * 获取年级下学院下专业下班级
     *
     * @param grade
     * @param academy
     * @param major
     * @return
     */
    List<String> getClasses(@Param("grade") String grade, @Param("academy") String academy, @Param("major") String major);
}



