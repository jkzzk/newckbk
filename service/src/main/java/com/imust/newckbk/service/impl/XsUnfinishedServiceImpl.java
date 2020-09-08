package com.imust.newckbk.service.impl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.imust.newckbk.base.PageEntity;
import com.imust.newckbk.common.RespData;
import com.imust.newckbk.domain.XsUnfinished;

import com.imust.newckbk.domain.ext.XsUnfinishedExt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imust.newckbk.dao.XsUnfinishedDao;
import com.imust.newckbk.service.XsUnfinishedService;
import com.imust.newckbk.base.AbstractService;
import javax.annotation.PostConstruct;
import java.math.BigDecimal;
import java.util.Map;


/**
* @date 2020-05-05
* @author jkzzk
* 
*/
@Service("xsUnfinishedService")
public class XsUnfinishedServiceImpl extends AbstractService<XsUnfinished, String> implements XsUnfinishedService {

	@Autowired
	private XsUnfinishedDao xsUnfinishedDao;

	@PostConstruct
	public void setBaseDao() {
		super.setBaseDao(xsUnfinishedDao);
	}

	@Override
	public PageInfo<XsUnfinishedExt> query(PageEntity<Map> mapPageEntity) {
		try {

			PageHelper.startPage(mapPageEntity.getPageNumber(),mapPageEntity.getPageSize());

			return new PageInfo<>(xsUnfinishedDao.getExtByPage(mapPageEntity.getData()));

		}catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public RespData saveXsUnfinished(XsUnfinished xsUnfinished) {
		try {
			xsUnfinished.setXslbdm(new BigDecimal(2));
			return RespData.successMsg("保存成功",xsUnfinishedDao.insert(xsUnfinished));
		}catch (Exception e) {
			e.printStackTrace();
			throw e;
		}

	}

	@Override
	public RespData clearXsUnfinished(String ids) {
		try {
			String[] xhs = ids.split(",");

			for (String xh : xhs) {
				xsUnfinishedDao.deleteById(xh);
			}

			return RespData.successMsg("删除成功");
		}catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
}