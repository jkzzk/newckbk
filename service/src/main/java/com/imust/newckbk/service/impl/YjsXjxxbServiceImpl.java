package com.imust.newckbk.service.impl;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imust.newckbk.base.AbstractService;
import com.imust.newckbk.dao.YjsXjxxbDao;
import com.imust.newckbk.domain.YjsXjxxb;
import com.imust.newckbk.service.YjsXjxxbService;

/**
 * @date 2019-09-02
 * @author jkzzk
 *
 */
@Service("yjsXjxxbService")
public class YjsXjxxbServiceImpl extends AbstractService<YjsXjxxb, String> implements YjsXjxxbService {
    @Autowired
    private YjsXjxxbDao yjsXjxxbDao;

    @PostConstruct
    public void setBaseDao() {
        super.setBaseDao(yjsXjxxbDao);
    }
}



