package com.imust.newckbk.service;

import com.github.pagehelper.PageInfo;
import com.imust.newckbk.base.BaseService;
import com.imust.newckbk.base.PageEntity;
import com.imust.newckbk.common.RespData;
import com.imust.newckbk.domain.XsXjxxbViewKw;

import java.util.Map;

/**
 * @date 2019-09-02
 * @author jkzzk
 *
 */
public interface XsXjxxbViewKwService extends BaseService<XsXjxxbViewKw, String> {

    /**
     * 学生的分页查询
     * @param pageParams
     * @return
     */
    PageInfo<XsXjxxbViewKw> query(PageEntity<Map> pageParams);

    /**
     * 学生登录
     * @param username
     * @param password
     * @return
     */
    RespData login(String username, String password);
}



