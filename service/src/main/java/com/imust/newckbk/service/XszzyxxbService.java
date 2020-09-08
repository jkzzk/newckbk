package com.imust.newckbk.service;

import com.github.pagehelper.PageInfo;
import com.imust.newckbk.base.PageEntity;
import com.imust.newckbk.common.RespData;
import com.imust.newckbk.domain.Xszzyxxb;
import com.imust.newckbk.base.BaseService;
import com.imust.newckbk.domain.ext.XszzyxxbExt;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;


/**
* @date 2020-05-13
* @author jkzzk
* 
*/
public interface XszzyxxbService extends BaseService<Xszzyxxb, String>{

    /**
     * 分页查询
     * @param mapPageEntity
     * @return
     */
    PageInfo<XszzyxxbExt> query(PageEntity<Map> mapPageEntity);

    /**
     * 保存学生转专业信息
     * @param xszzyxxb
     * @return
     */
    RespData saveXszzyxxb(Xszzyxxb xszzyxxb);

    /**
     * 批量删除学生转专业信息
     * @param ids
     * @return
     */
    RespData delXszzyxxb(List<String> ids);

    /**
     * 获取学生转专业信息
     * @param id
     * @return
     */
    XszzyxxbExt getXszzyxxbById(String id);

    /**
     * 获取学生转专业信息 ，通过学号
     * @param loginName
     * @return
     */
    XszzyxxbExt getXszzyxxbByXh(String loginName);

    /**
     * 打印学生转专业信息表
     * @param xh
     */
    void printApplyTable(String xh) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException, Exception;

    /**
     * 根据参数查询表格
     *
     * @param xszzyxxb
     * @return
     */
    List<Xszzyxxb> getExtByEnity(Xszzyxxb xszzyxxb);
}