package com.imust.newckbk.service.impl;
import com.imust.newckbk.common.RespData;
import com.imust.newckbk.domain.CodeNjb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imust.newckbk.dao.CodeNjbDao;
import com.imust.newckbk.service.CodeNjbService;
import com.imust.newckbk.base.AbstractService;
import javax.annotation.PostConstruct;


/**
* @date 2020-03-07
* @author jkzzk
* 
*/
@Service("codeNjbService")
public class CodeNjbServiceImpl extends AbstractService<CodeNjb, String> implements CodeNjbService {

	@Autowired
	private CodeNjbDao codeNjbDao;

	@PostConstruct
	public void setBaseDao() {
		super.setBaseDao(codeNjbDao);
	}

	@Override
	public RespData getAllGrade() {
		try {
			return RespData.successMsg("操作成功",codeNjbDao.getAll());
		}catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
}