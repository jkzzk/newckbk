package com.imust.newckbk.service.impl;
import com.imust.newckbk.domain.Cet4SecondTerm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imust.newckbk.dao.Cet4SecondTermDao;
import com.imust.newckbk.service.Cet4SecondTermService;
import com.imust.newckbk.base.AbstractService;
import javax.annotation.PostConstruct;


/**
* @date 2020-09-09
* @author jkzzk
* 
*/
@Service("cet4SecondTermService")
public class Cet4SecondTermServiceImpl extends AbstractService<Cet4SecondTerm, String> implements Cet4SecondTermService {

	@Autowired
	private Cet4SecondTermDao cet4SecondTermDao;

	@PostConstruct
	public void setBaseDao() {
		super.setBaseDao(cet4SecondTermDao);
	}
}