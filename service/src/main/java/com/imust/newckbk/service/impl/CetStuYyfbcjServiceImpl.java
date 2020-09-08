package com.imust.newckbk.service.impl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.imust.newckbk.base.PageEntity;
import com.imust.newckbk.domain.CetStuYyfbcj;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imust.newckbk.dao.CetStuYyfbcjDao;
import com.imust.newckbk.service.CetStuYyfbcjService;
import com.imust.newckbk.base.AbstractService;
import javax.annotation.PostConstruct;
import java.util.Map;


/**
* @date 2020-07-05
* @author jkzzk
* 
*/
@Service("cetStuYyfbcjService")
public class CetStuYyfbcjServiceImpl extends AbstractService<CetStuYyfbcj, String> implements CetStuYyfbcjService {

	@Autowired
	private CetStuYyfbcjDao cetStuYyfbcjDao;

	@PostConstruct
	public void setBaseDao() {
		super.setBaseDao(cetStuYyfbcjDao);
	}

    @Override
    public PageInfo<CetStuYyfbcj> query(PageEntity<Map> mapPageEntity) {
        try {
			PageHelper.startPage(mapPageEntity.getPageNumber(),mapPageEntity.getPageSize());

			return new PageInfo<>(cetStuYyfbcjDao.getExtByPage(mapPageEntity.getData()));
		}catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
    }
}