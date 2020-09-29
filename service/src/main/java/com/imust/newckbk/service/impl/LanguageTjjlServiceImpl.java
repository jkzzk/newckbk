package com.imust.newckbk.service.impl;
import com.imust.newckbk.domain.LanguageTjjl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imust.newckbk.dao.LanguageTjjlDao;
import com.imust.newckbk.service.LanguageTjjlService;
import com.imust.newckbk.base.AbstractService;
import javax.annotation.PostConstruct;


/**
* @date 2020-09-29
* @author jkzzk
* 
*/
@Service("languageTjjlService")
public class LanguageTjjlServiceImpl extends AbstractService<LanguageTjjl, String> implements LanguageTjjlService {

	@Autowired
	private LanguageTjjlDao languageTjjlDao;

	@PostConstruct
	public void setBaseDao() {
		super.setBaseDao(languageTjjlDao);
	}
}