package com.imust.newckbk.service.impl;
import com.imust.newckbk.domain.CetStuscore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imust.newckbk.dao.CetStuscoreDao;
import com.imust.newckbk.service.CetStuscoreService;
import com.imust.newckbk.base.AbstractService;
import javax.annotation.PostConstruct;


/**
* @date 2020-09-09
* @author jkzzk
* 
*/
@Service("cetStuscoreService")
public class CetStuscoreServiceImpl extends AbstractService<CetStuscore, String> implements CetStuscoreService {

	@Autowired
	private CetStuscoreDao cetStuscoreDao;

	@PostConstruct
	public void setBaseDao() {
		super.setBaseDao(cetStuscoreDao);
	}
}