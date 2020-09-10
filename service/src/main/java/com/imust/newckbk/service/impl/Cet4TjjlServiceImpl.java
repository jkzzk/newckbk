package com.imust.newckbk.service.impl;
import com.imust.newckbk.domain.Cet4Tjjl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imust.newckbk.dao.Cet4TjjlDao;
import com.imust.newckbk.service.Cet4TjjlService;
import com.imust.newckbk.base.AbstractService;
import javax.annotation.PostConstruct;
import java.util.List;


/**
* @date 2020-09-09
* @author jkzzk
* 
*/
@Service("cet4TjjlService")
public class Cet4TjjlServiceImpl extends AbstractService<Cet4Tjjl, String> implements Cet4TjjlService {

	@Autowired
	private Cet4TjjlDao cet4TjjlDao;

	@PostConstruct
	public void setBaseDao() {
		super.setBaseDao(cet4TjjlDao);
	}

    @Override
    public Cet4Tjjl getCurrentSet() {
		List<Cet4Tjjl> cet4Tjjls = cet4TjjlDao.getByStatus("1");

		return cet4Tjjls.isEmpty() ? null : cet4Tjjls.get(0);
	}
}