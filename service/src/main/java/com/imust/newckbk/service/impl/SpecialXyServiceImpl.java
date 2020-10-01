package com.imust.newckbk.service.impl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.imust.newckbk.base.PageEntity;
import com.imust.newckbk.common.RespData;
import com.imust.newckbk.domain.SpecialXy;

import com.imust.newckbk.domain.XsType;
import com.imust.newckbk.utils.SnowRakeIdGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imust.newckbk.dao.SpecialXyDao;
import com.imust.newckbk.service.SpecialXyService;
import com.imust.newckbk.base.AbstractService;
import javax.annotation.PostConstruct;
import java.util.Map;


/**
* @date 2020-09-30
* @author jkzzk
* 
*/
@Service("specialXyService")
public class SpecialXyServiceImpl extends AbstractService<SpecialXy, String> implements SpecialXyService {

	@Autowired
	private SpecialXyDao specialXyDao;

	@Autowired
	private SnowRakeIdGenerator snowRakeIdGenerator;

	@PostConstruct
	public void setBaseDao() {
		super.setBaseDao(specialXyDao);
	}

	@Override
	public PageInfo<SpecialXy> query(PageEntity<Map> mapPageEntity) {
		try {
			PageHelper.startPage(mapPageEntity.getPageNumber(),mapPageEntity.getPageSize());

			return new PageInfo<>(specialXyDao.getExtByPage(mapPageEntity.getData()));
		}catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public RespData saveSpecialXy(SpecialXy specialXy) {
		try {

			specialXy.setId(String.valueOf(snowRakeIdGenerator.nextId()));

			return RespData.successMsg("保存成功",specialXyDao.insert(specialXy));

		}catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public RespData deleteSpecialXy(String ids) {
		try {

			return RespData.successMsg("删除成功",specialXyDao.deleteByIds(ids));

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
}