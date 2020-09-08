package com.imust.newckbk.service.impl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.imust.newckbk.base.PageEntity;
import com.imust.newckbk.common.RespData;
import com.imust.newckbk.domain.Fxtjb;

import com.imust.newckbk.domain.ext.FxtjbExt;
import com.imust.newckbk.utils.SnowRakeIdGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imust.newckbk.dao.FxtjbDao;
import com.imust.newckbk.service.FxtjbService;
import com.imust.newckbk.base.AbstractService;
import javax.annotation.PostConstruct;
import java.util.Date;
import java.util.Map;


/**
* @date 2020-08-23
* @author jkzzk
* 
*/
@Service("fxtjbService")
public class FxtjbServiceImpl extends AbstractService<Fxtjb, String> implements FxtjbService {

	@Autowired
	private FxtjbDao fxtjbDao;

	@Autowired
	private SnowRakeIdGenerator snowRakeIdGenerator;

	@PostConstruct
	public void setBaseDao() {
		super.setBaseDao(fxtjbDao);
	}

    @Override
    public PageInfo<FxtjbExt> query(PageEntity<Map> mapPageEntity) {
		try {
			PageHelper.startPage(mapPageEntity.getPageNumber(),mapPageEntity.getPageSize());

			return new PageInfo<>(fxtjbDao.getExtByPage(mapPageEntity.getData()));
		}catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
    }

	@Override
	public RespData saveFxtjb(Fxtjb fxtjb) {
		try {

			// 废弃操作
			fxtjbDao.abandonOld();

			fxtjb.setId(String.valueOf(snowRakeIdGenerator.nextId()));

			return RespData.successMsg("保存成功",fxtjbDao.insert(fxtjb));
		}catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public RespData clearFxtjb() {
		try {
			return RespData.successMsg("清除成功！",fxtjbDao.clearFxtjb());
		}catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
}