package com.imust.newckbk.service.impl;
import com.imust.newckbk.domain.CodeXxxxb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imust.newckbk.dao.CodeXxxxbDao;
import com.imust.newckbk.service.CodeXxxxbService;
import com.imust.newckbk.base.AbstractService;
import javax.annotation.PostConstruct;


/**
* @date 2020-10-06
* @author jkzzk
* 
*/
@Service("codeXxxxbService")
public class CodeXxxxbServiceImpl extends AbstractService<CodeXxxxb, String> implements CodeXxxxbService {

	@Autowired
	private CodeXxxxbDao codeXxxxbDao;

	@PostConstruct
	public void setBaseDao() {
		super.setBaseDao(codeXxxxbDao);
	}
}