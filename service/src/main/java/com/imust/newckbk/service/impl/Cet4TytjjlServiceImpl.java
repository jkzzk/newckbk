package com.imust.newckbk.service.impl;
import com.imust.newckbk.domain.Cet4Tytjjl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imust.newckbk.dao.Cet4TytjjlDao;
import com.imust.newckbk.service.Cet4TytjjlService;
import com.imust.newckbk.base.AbstractService;
import javax.annotation.PostConstruct;


/**
* @date 2020-09-09
* @author jkzzk
* 
*/
@Service("cet4TytjjlService")
public class Cet4TytjjlServiceImpl extends AbstractService<Cet4Tytjjl, String> implements Cet4TytjjlService {

	@Autowired
	private Cet4TytjjlDao cet4TytjjlDao;

	@PostConstruct
	public void setBaseDao() {
		super.setBaseDao(cet4TytjjlDao);
	}
}