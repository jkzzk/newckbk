package com.imust.newckbk.service.impl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.imust.newckbk.base.PageEntity;
import com.imust.newckbk.common.RespData;
import com.imust.newckbk.domain.Zyxxb;

import com.imust.newckbk.utils.SnowRakeIdGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imust.newckbk.dao.ZyxxbDao;
import com.imust.newckbk.service.ZyxxbService;
import com.imust.newckbk.base.AbstractService;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Map;


/**
* @date 2020-05-12
* @author jkzzk
* 
*/
@Service("zyxxbService")
public class ZyxxbServiceImpl extends AbstractService<Zyxxb, String> implements ZyxxbService {

	@Autowired
	private ZyxxbDao zyxxbDao;
	@Autowired
	private SnowRakeIdGenerator snowRakeIdGenerator;

	@PostConstruct
	public void setBaseDao() {
		super.setBaseDao(zyxxbDao);
	}

    @Override
    public PageInfo<Zyxxb> query(PageEntity<Map> mapPageEntity) {
    	try {
			PageHelper.startPage(mapPageEntity.getPageNumber(),mapPageEntity.getPageSize());
			return new PageInfo<>(zyxxbDao.getByExtPage(mapPageEntity.getData()));
		}catch (Exception e) {
    		e.printStackTrace();
    		throw e;
		}
	}

	@Override
	public RespData saveZyxxb(Zyxxb zyxxb) {
		try {
			zyxxb.setId(String.valueOf(snowRakeIdGenerator.nextId()));
			return RespData.successMsg("保存成功",zyxxbDao.insert(zyxxb));
		}catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public RespData delZyxxb(List<String> ids) {
		try {
			return RespData.successMsg("删除成功",zyxxbDao.deleteByArr(ids));
		}catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

    @Override
    public List<String> getAllXsm(Map<String, Object> params) {
		try {
			return zyxxbDao.getAllXsm(params);
		}catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
    }

	@Override
	public List<String> getAllZym(Map<String, Object> params) {
		try {
			return zyxxbDao.getAllZym(params);
		}catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
}