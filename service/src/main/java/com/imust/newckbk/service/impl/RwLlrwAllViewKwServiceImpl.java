package com.imust.newckbk.service.impl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.imust.newckbk.base.PageEntity;
import com.imust.newckbk.common.RespData;
import com.imust.newckbk.dao.CxkcxxbDao;
import com.imust.newckbk.domain.Cxkcxxb;
import com.imust.newckbk.domain.RwLlrwAllViewKw;

import com.imust.newckbk.domain.ext.RwLlrwAllViewKwExt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imust.newckbk.dao.RwLlrwAllViewKwDao;
import com.imust.newckbk.service.RwLlrwAllViewKwService;
import com.imust.newckbk.base.AbstractService;
import javax.annotation.PostConstruct;
import java.util.Map;


/**
* @date 2020-05-04
* @author jkzzk
* 
*/
@Service("rwLlrwAllViewKwService")
public class RwLlrwAllViewKwServiceImpl extends AbstractService<RwLlrwAllViewKw, String> implements RwLlrwAllViewKwService {

	@Autowired
	private RwLlrwAllViewKwDao rwLlrwAllViewKwDao;
	@Autowired
	private CxkcxxbDao cxkcxxbDao;

	@PostConstruct
	public void setBaseDao() {
		super.setBaseDao(rwLlrwAllViewKwDao);
	}

    @Override
    public PageInfo<RwLlrwAllViewKwExt> query(PageEntity<Map> mapPageEntity) {
		try {
			PageHelper.startPage(mapPageEntity.getPageNumber(),mapPageEntity.getPageSize());

			return new PageInfo<>(rwLlrwAllViewKwDao.getExtByPage(mapPageEntity.getData()));
		}catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
    }

	@Override
	public RespData setRetake(RwLlrwAllViewKwExt rwLlrwAllViewKwExt) {
		try {
			String[] kchs = rwLlrwAllViewKwExt.getKchs().split(",");
			for (String kch : kchs) {
				Cxkcxxb cxkcxxb = new Cxkcxxb();
				cxkcxxb.setKch(kch);
				cxkcxxbDao.insert(cxkcxxb);
			}

			return RespData.successMsg("操作成功");
		}catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public RespData reSetRetake(RwLlrwAllViewKwExt rwLlrwAllViewKwExt) {
		try {
			String[] kchs = rwLlrwAllViewKwExt.getKchs().split(",");
			for (String kch : kchs) {
				cxkcxxbDao.deleteById(kch);
			}
			return RespData.successMsg("操作成功");
		}catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
}