package com.imust.newckbk.service.impl;
import com.imust.newckbk.domain.XsXjydbViewKw;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imust.newckbk.dao.XsXjydbViewKwDao;
import com.imust.newckbk.service.XsXjydbViewKwService;
import com.imust.newckbk.base.AbstractService;
import javax.annotation.PostConstruct;


/**
* @date 2020-05-21
* @author jkzzk
* 
*/
@Service("xsXjydbViewKwService")
public class XsXjydbViewKwServiceImpl extends AbstractService<XsXjydbViewKw, String> implements XsXjydbViewKwService {

	@Autowired
	private XsXjydbViewKwDao xsXjydbViewKwDao;

	@PostConstruct
	public void setBaseDao() {
		super.setBaseDao(xsXjydbViewKwDao);
	}
}