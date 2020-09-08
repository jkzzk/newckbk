package com.imust.newckbk.service.impl;

import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import com.imust.newckbk.base.AbstractService;
import com.imust.newckbk.base.PageEntity;
import com.imust.newckbk.dao.SysBtnDao;
import com.imust.newckbk.domain.SysBtn;
import com.imust.newckbk.service.SysBtnService;

/**
 * @date 2017-08-24
 * @author jkzzk
 *
 */
@Service("sysBtnService")
public class SysBtnServiceImpl extends AbstractService<SysBtn, String> implements SysBtnService {
    @Autowired
    private SysBtnDao sysBtnDao;

    @Override
    public PageInfo<SysBtn> query(PageEntity<Map> params) {
        PageHelper.startPage(params.getPageNumber(), params.getPageSize());

        return new PageInfo<SysBtn>(sysBtnDao.getByMapPage(params.getData()));
    }

    @PostConstruct
    public void setBaseDao() {
        super.setBaseDao(sysBtnDao);
    }
}


