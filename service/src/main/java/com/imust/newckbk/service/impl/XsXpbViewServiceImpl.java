package com.imust.newckbk.service.impl;
import com.imust.newckbk.domain.XsXpbView;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imust.newckbk.dao.XsXpbViewDao;
import com.imust.newckbk.service.XsXpbViewService;
import com.imust.newckbk.base.AbstractService;
import javax.annotation.PostConstruct;


/**
* @date 2020-05-05
* @author jkzzk
* 
*/
@Service("xsXpbViewService")
public class XsXpbViewServiceImpl extends AbstractService<XsXpbView, String> implements XsXpbViewService {

	@Autowired
	private XsXpbViewDao xsXpbViewDao;

	@PostConstruct
	public void setBaseDao() {
		super.setBaseDao(xsXpbViewDao);
	}
}