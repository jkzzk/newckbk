package com.imust.newckbk.service.impl;
import com.imust.newckbk.domain.CjAllKwView;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imust.newckbk.dao.CjAllKwViewDao;
import com.imust.newckbk.service.CjAllKwViewService;
import com.imust.newckbk.base.AbstractService;
import javax.annotation.PostConstruct;


/**
* @date 2020-09-08
* @author jkzzk
* 
*/
@Service("cjAllKwViewService")
public class CjAllKwViewServiceImpl extends AbstractService<CjAllKwView, String> implements CjAllKwViewService {

	@Autowired
	private CjAllKwViewDao cjAllKwViewDao;

	@PostConstruct
	public void setBaseDao() {
		super.setBaseDao(cjAllKwViewDao);
	}
}