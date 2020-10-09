package com.imust.newckbk.service.impl;

import com.imust.newckbk.domain.ext.LangStisticExt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imust.newckbk.dao.LangStisticExtDao;
import com.imust.newckbk.service.LangStisticExtService;
import com.imust.newckbk.base.AbstractService;
import javax.annotation.PostConstruct;


/**
* @date 2020-10-08
* @author jkzzk
* 
*/
@Service("langStisticExtService")
public class LangStisticExtServiceImpl extends AbstractService<LangStisticExt, String> implements LangStisticExtService {

	@Autowired
	private LangStisticExtDao langStisticExtDao;

	@PostConstruct
	public void setBaseDao() {
		super.setBaseDao(langStisticExtDao);
	}
}