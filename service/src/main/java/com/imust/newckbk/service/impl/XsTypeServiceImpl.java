package com.imust.newckbk.service.impl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.imust.newckbk.base.PageEntity;
import com.imust.newckbk.common.RespData;
import com.imust.newckbk.domain.XsType;

import com.imust.newckbk.domain.ext.BktjjlExt;
import com.imust.newckbk.utils.SnowRakeIdGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imust.newckbk.dao.XsTypeDao;
import com.imust.newckbk.service.XsTypeService;
import com.imust.newckbk.base.AbstractService;
import javax.annotation.PostConstruct;
import java.util.Map;


/**
* @date 2020-09-30
* @author jkzzk
* 
*/
@Service("xsTypeService")
public class XsTypeServiceImpl extends AbstractService<XsType, String> implements XsTypeService {

	@Autowired
	private XsTypeDao xsTypeDao;

	@Autowired
	private SnowRakeIdGenerator snowRakeIdGenerator;

	@PostConstruct
	public void setBaseDao() {
		super.setBaseDao(xsTypeDao);
	}

    @Override
    public PageInfo<XsType> query(PageEntity<Map> mapPageEntity) {
		try {
			PageHelper.startPage(mapPageEntity.getPageNumber(),mapPageEntity.getPageSize());

			return new PageInfo<>(xsTypeDao.getExtByPage(mapPageEntity.getData()));
		}catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
    }

	@Override
	public RespData saveXsType(XsType xsType) {
		try {

			xsType.setId(String.valueOf(snowRakeIdGenerator.nextId()));

			return RespData.successMsg("保存成功",xsTypeDao.insert(xsType));

		}catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public RespData deleteXsType(String ids) {
		try {

			return RespData.successMsg("删除成功",xsTypeDao.deleteByIds(ids));

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
}