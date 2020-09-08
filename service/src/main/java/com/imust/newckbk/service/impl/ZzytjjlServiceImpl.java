package com.imust.newckbk.service.impl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.imust.newckbk.base.PageEntity;
import com.imust.newckbk.common.RespData;
import com.imust.newckbk.domain.SysUser;
import com.imust.newckbk.domain.Zzytjjl;

import com.imust.newckbk.domain.ext.ZzytjjlExt;
import com.imust.newckbk.utils.SnowRakeIdGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imust.newckbk.dao.ZzytjjlDao;
import com.imust.newckbk.service.ZzytjjlService;
import com.imust.newckbk.base.AbstractService;
import javax.annotation.PostConstruct;
import java.math.BigDecimal;
import java.util.Map;


/**
* @date 2020-05-13
* @author jkzzk
* 
*/
@Service("zzytjjlService")
public class ZzytjjlServiceImpl extends AbstractService<Zzytjjl, String> implements ZzytjjlService {

	@Autowired
	private ZzytjjlDao zzytjjlDao;
	@Autowired
	private SnowRakeIdGenerator snowRakeIdGenerator;

	@PostConstruct
	public void setBaseDao() {
		super.setBaseDao(zzytjjlDao);
	}

	@Override
	public PageInfo<ZzytjjlExt> query(PageEntity<Map> mapPageEntity) {
		try {
			PageHelper.startPage(mapPageEntity.getPageNumber(),mapPageEntity.getPageSize());

			return new PageInfo<>(zzytjjlDao.getExtByPage(mapPageEntity.getData()));
		}catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public RespData saveZzytjjl(Zzytjjl zzytjjl, SysUser currentSysUser) {
		try {
			zzytjjlDao.invalidAll();

			zzytjjl.setId(String.valueOf(snowRakeIdGenerator.nextId()));
			zzytjjl.setStatus(new BigDecimal(1));

			return RespData.successMsg("保存成功",zzytjjlDao.insert(zzytjjl));
		}catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public RespData clearZzytjjl() {
		try {
			return RespData.successMsg("清除成功",zzytjjlDao.clearInvalid());
		}catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

    @Override
    public Zzytjjl getCurrentSet() {
		try {
			return zzytjjlDao.getCurrentSet();
		}catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
    }
}