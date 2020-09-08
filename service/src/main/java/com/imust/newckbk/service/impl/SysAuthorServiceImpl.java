package com.imust.newckbk.service.impl;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imust.newckbk.base.AbstractService;
import com.imust.newckbk.dao.SysAuthorDao;
import com.imust.newckbk.domain.SysAuthor;
import com.imust.newckbk.service.SysAuthorService;

/**
 * @date 2017-08-24
 * @author jkzzk
 *
 */
@Service("sysAuthorService")
public class SysAuthorServiceImpl extends AbstractService<SysAuthor, String> implements SysAuthorService {
    @Autowired
    private SysAuthorDao sysAuthorDao;

    @PostConstruct
    public void setBaseDao() {
        super.setBaseDao(sysAuthorDao);
    }
}


