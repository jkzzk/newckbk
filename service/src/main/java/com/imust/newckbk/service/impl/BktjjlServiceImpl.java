package com.imust.newckbk.service.impl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.imust.newckbk.base.PageEntity;
import com.imust.newckbk.common.RespData;
import com.imust.newckbk.domain.Bktjjl;

import com.imust.newckbk.domain.SysUser;
import com.imust.newckbk.domain.ext.BktjjlExt;
import com.imust.newckbk.utils.SnowRakeIdGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imust.newckbk.dao.BktjjlDao;
import com.imust.newckbk.service.BktjjlService;
import com.imust.newckbk.base.AbstractService;
import javax.annotation.PostConstruct;
import java.util.Date;
import java.util.Map;


/**
* @date 2020-03-07
* @author jkzzk
* 
*/
@Service("bktjjlService")
public class BktjjlServiceImpl extends AbstractService<Bktjjl, String> implements BktjjlService {

	@Autowired
	private BktjjlDao bktjjlDao;

	@Autowired
	private SnowRakeIdGenerator snowRakeIdGenerator;

	@PostConstruct
	public void setBaseDao() {
		super.setBaseDao(bktjjlDao);
	}

    @Override
    public PageInfo<BktjjlExt> query(PageEntity<Map> pageParams) {
       	try {
			PageHelper.startPage(pageParams.getPageNumber(),pageParams.getPageSize());

			return new PageInfo<>(bktjjlDao.getExtByPage(pageParams.getData()));
		}catch (Exception e) {
       		e.printStackTrace();
       		throw e;
		}
    }

	@Override
	public BktjjlExt getCurrentSet(String id) {
		try {

			return bktjjlDao.getCurrentSet(id);

		}catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public RespData saveBktjjl(Bktjjl bktjjl, SysUser currentSysUser) {
		try {

			// 废弃操作
			bktjjlDao.abandonOld();

			bktjjl.setId(String.valueOf(snowRakeIdGenerator.nextId()));
			bktjjl.setCreateBy(currentSysUser.getId());
			bktjjl.setCreateTime(new Date());

			return RespData.successMsg("保存成功",bktjjlDao.insert(bktjjl));
		}catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public RespData clearBktjjl() {
		try {
			return RespData.successMsg("清除成功",bktjjlDao.clearBktjjl());
		}catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
}