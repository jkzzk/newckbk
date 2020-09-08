package com.imust.newckbk.service.impl;
import com.imust.newckbk.common.RespData;
import com.imust.newckbk.domain.CodeZxjxjhxnxqxx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imust.newckbk.dao.CodeZxjxjhxnxqxxDao;
import com.imust.newckbk.service.CodeZxjxjhxnxqxxService;
import com.imust.newckbk.base.AbstractService;
import javax.annotation.PostConstruct;


/**
* @date 2020-03-07
* @author jkzzk
* 
*/
@Service("codeZxjxjhxnxqxxService")
public class CodeZxjxjhxnxqxxServiceImpl extends AbstractService<CodeZxjxjhxnxqxx, String> implements CodeZxjxjhxnxqxxService {

	@Autowired
	private CodeZxjxjhxnxqxxDao codeZxjxjhxnxqxxDao;

	@PostConstruct
	public void setBaseDao() {
		super.setBaseDao(codeZxjxjhxnxqxxDao);
	}

	@Override
	public RespData getAllTerm() {
		try {
			return RespData.successMsg("操作成功",codeZxjxjhxnxqxxDao.getAll());
		}catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
}