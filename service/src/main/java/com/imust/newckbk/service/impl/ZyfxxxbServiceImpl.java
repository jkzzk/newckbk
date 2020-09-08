package com.imust.newckbk.service.impl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.imust.newckbk.base.PageEntity;
import com.imust.newckbk.common.RespData;
import com.imust.newckbk.domain.Bkkcxxb;
import com.imust.newckbk.domain.Zyfxxxb;

import com.imust.newckbk.domain.Zyxxb;
import com.imust.newckbk.domain.excel.BkkcxxbExcel;
import com.imust.newckbk.domain.excel.ZyfxxxbExcel;
import com.imust.newckbk.utils.SnowRakeIdGenerator;
import com.imust.newckbk.utils.easypoi.ExcelUtiles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imust.newckbk.dao.ZyfxxxbDao;
import com.imust.newckbk.service.ZyfxxxbService;
import com.imust.newckbk.base.AbstractService;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Map;


/**
* @date 2020-08-23
* @author jkzzk
* 
*/
@Service("zyfxxxbService")
public class ZyfxxxbServiceImpl extends AbstractService<Zyfxxxb, String> implements ZyfxxxbService {

	@Autowired
	private ZyfxxxbDao zyfxxxbDao;

	@Autowired
	private SnowRakeIdGenerator snowRakeIdGenerator;

	@PostConstruct
	public void setBaseDao() {
		super.setBaseDao(zyfxxxbDao);
	}


	@Override
	public PageInfo<Zyfxxxb> query(PageEntity<Map> mapPageEntity) {
		try {
			PageHelper.startPage(mapPageEntity.getPageNumber(),mapPageEntity.getPageSize());
			return new PageInfo<>(zyfxxxbDao.getByExtPage(mapPageEntity.getData()));
		}catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public RespData saveZyxxb(Zyfxxxb zyfxxxb) {
		try {
			zyfxxxb.setId(String.valueOf(snowRakeIdGenerator.nextId()));

			return RespData.successMsg("保存成功",zyfxxxbDao.insert(zyfxxxb));
		}catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public RespData delZyxxb(List<String> asList) {
		try {
			return RespData.successMsg("删除成功",zyfxxxbDao.deleteByArr(asList));
		}catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public RespData importBkkcxxb(MultipartFile file) {
		try {
			List<ZyfxxxbExcel> zyfxxxbExcels = ExcelUtiles.importExcel(file, 2, 1, ZyfxxxbExcel.class);

			for (ZyfxxxbExcel zyfxxxbExcel : zyfxxxbExcels) {
				Zyfxxxb zyfxxxb = new Zyfxxxb(zyfxxxbExcel);
				zyfxxxb.setId(String.valueOf(snowRakeIdGenerator.nextId()));
				zyfxxxbDao.insert(zyfxxxb);
			}

			return RespData.successMsg("导入成功");
		}catch (Exception e) {
			e.getMessage();
			throw e;
		}
	}
}