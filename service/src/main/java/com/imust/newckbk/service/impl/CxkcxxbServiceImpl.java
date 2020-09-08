package com.imust.newckbk.service.impl;
import com.imust.newckbk.domain.Cxkcxxb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imust.newckbk.dao.CxkcxxbDao;
import com.imust.newckbk.service.CxkcxxbService;
import com.imust.newckbk.base.AbstractService;
import javax.annotation.PostConstruct;


/**
* @date 2020-05-04
* @author jkzzk
* 
*/
@Service("cxkcxxbService")
public class CxkcxxbServiceImpl extends AbstractService<Cxkcxxb, String> implements CxkcxxbService {

	@Autowired
	private CxkcxxbDao cxkcxxbDao;

	@PostConstruct
	public void setBaseDao() {
		super.setBaseDao(cxkcxxbDao);
	}
}