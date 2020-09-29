package com.imust.newckbk.service.impl;
import com.imust.newckbk.domain.LanguageTjjlSpecial;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imust.newckbk.dao.LanguageTjjlSpecialDao;
import com.imust.newckbk.service.LanguageTjjlSpecialService;
import com.imust.newckbk.base.AbstractService;
import javax.annotation.PostConstruct;


/**
* @date 2020-09-29
* @author jkzzk
* 
*/
@Service("languageTjjlSpecialService")
public class LanguageTjjlSpecialServiceImpl extends AbstractService<LanguageTjjlSpecial, String> implements LanguageTjjlSpecialService {

	@Autowired
	private LanguageTjjlSpecialDao languageTjjlSpecialDao;

	@PostConstruct
	public void setBaseDao() {
		super.setBaseDao(languageTjjlSpecialDao);
	}
}