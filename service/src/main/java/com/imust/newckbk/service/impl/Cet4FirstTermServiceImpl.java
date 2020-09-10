package com.imust.newckbk.service.impl;
import com.imust.newckbk.domain.Cet4FirstTerm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imust.newckbk.dao.Cet4FirstTermDao;
import com.imust.newckbk.service.Cet4FirstTermService;
import com.imust.newckbk.base.AbstractService;
import javax.annotation.PostConstruct;


/**
* @date 2020-09-09
* @author jkzzk
* 
*/
@Service("cet4FirstTermService")
public class Cet4FirstTermServiceImpl extends AbstractService<Cet4FirstTerm, String> implements Cet4FirstTermService {

	@Autowired
	private Cet4FirstTermDao cet4FirstTermDao;

	@PostConstruct
	public void setBaseDao() {
		super.setBaseDao(cet4FirstTermDao);
	}
}