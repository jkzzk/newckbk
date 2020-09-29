package com.imust.newckbk.service.impl;
import com.imust.newckbk.domain.LanguageTjjlStudent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imust.newckbk.dao.LanguageTjjlStudentDao;
import com.imust.newckbk.service.LanguageTjjlStudentService;
import com.imust.newckbk.base.AbstractService;
import javax.annotation.PostConstruct;


/**
* @date 2020-09-29
* @author jkzzk
* 
*/
@Service("languageTjjlStudentService")
public class LanguageTjjlStudentServiceImpl extends AbstractService<LanguageTjjlStudent, String> implements LanguageTjjlStudentService {

	@Autowired
	private LanguageTjjlStudentDao languageTjjlStudentDao;

	@PostConstruct
	public void setBaseDao() {
		super.setBaseDao(languageTjjlStudentDao);
	}
}