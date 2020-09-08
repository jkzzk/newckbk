package com.imust.newckbk.service.impl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.imust.newckbk.base.PageEntity;
import com.imust.newckbk.domain.Jwkzxxjl;

import com.imust.newckbk.domain.SysUser;
import com.imust.newckbk.domain.ext.JwkzxxjlExt;
import com.imust.newckbk.utils.SnowRakeIdGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imust.newckbk.dao.JwkzxxjlDao;
import com.imust.newckbk.service.JwkzxxjlService;
import com.imust.newckbk.base.AbstractService;
import javax.annotation.PostConstruct;
import java.util.Date;
import java.util.Map;


/**
* @date 2020-02-29
* @author jkzzk
* 
*/
@Service("jwkzxxjlService")
public class JwkzxxjlServiceImpl extends AbstractService<Jwkzxxjl, String> implements JwkzxxjlService {

	@Autowired
	private SnowRakeIdGenerator snowRakeIdGenerator;

	@Autowired
	private JwkzxxjlDao jwkzxxjlDao;

	@PostConstruct
	public void setBaseDao() {
		super.setBaseDao(jwkzxxjlDao);
	}

	@Override
	public PageInfo<JwkzxxjlExt> query(PageEntity<Map> pageParams) {
		try {
			PageHelper.startPage(pageParams.getPageNumber(),pageParams.getPageSize());

			return new PageInfo<JwkzxxjlExt>(jwkzxxjlDao.getExtByMapPage(pageParams.getData()));
		}catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public Jwkzxxjl getCurrentSet() {
		try {
			return jwkzxxjlDao.getCurrentSet();
		}catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

    @Override
    public int setCurrentSet(Jwkzxxjl jwkzxxjl, SysUser currentSysUser) {
		try {
			//将状态为1（代表当前）的记录更新为0
			jwkzxxjlDao.setCurrentSet(0);
			//将当前设置插入表中
			jwkzxxjl.setId(String.valueOf(snowRakeIdGenerator.nextId()));
			jwkzxxjl.setStatus((byte) 1);
			jwkzxxjl.setCreateTime(new Date());
			jwkzxxjl.setCreateBy(currentSysUser.getId());
			return jwkzxxjlDao.insert(jwkzxxjl);
		}catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
    }

    @Override
    public int clearRecord() {
		try {
			return jwkzxxjlDao.clearRecord();
		}catch (Exception e) {
			e.getMessage();
			throw e;
		}
    }
}