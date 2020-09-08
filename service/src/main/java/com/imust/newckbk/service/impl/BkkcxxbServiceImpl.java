package com.imust.newckbk.service.impl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.imust.newckbk.base.PageEntity;
import com.imust.newckbk.common.RespData;
import com.imust.newckbk.domain.Bkkcxxb;

import com.imust.newckbk.domain.excel.BkkcxxbExcel;
import com.imust.newckbk.domain.ext.BkkcxxbExt;
import com.imust.newckbk.utils.SnowRakeIdGenerator;
import com.imust.newckbk.utils.easypoi.ExcelUtiles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imust.newckbk.dao.BkkcxxbDao;
import com.imust.newckbk.service.BkkcxxbService;
import com.imust.newckbk.base.AbstractService;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Map;


/**
* @date 2020-07-17
* @author jkzzk
* 
*/
@Service("bkkcxxbService")
public class BkkcxxbServiceImpl extends AbstractService<Bkkcxxb, String> implements BkkcxxbService {

	@Autowired
	private BkkcxxbDao bkkcxxbDao;

	@Autowired
	private SnowRakeIdGenerator snowRakeIdGenerator;

	@PostConstruct
	public void setBaseDao() {
		super.setBaseDao(bkkcxxbDao);
	}

    @Override
    public PageInfo<BkkcxxbExt> query(PageEntity<Map> mapPageEntity) {
		try {
			PageHelper.startPage(mapPageEntity.getPageNumber(),mapPageEntity.getPageSize());

			return new PageInfo<>(bkkcxxbDao.getExtByPage(mapPageEntity.getData()));
		}catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
    }

	@Override
	public RespData saveBkkcxxb(Bkkcxxb bkkcxxb) {
		try {
			bkkcxxb.setId(String.valueOf(snowRakeIdGenerator.nextId()));
			return RespData.successMsg("保存成功",bkkcxxbDao.insert(bkkcxxb));
		}catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public RespData editBkkcxxb(Bkkcxxb bkkcxxb) {
		try {
			return RespData.successMsg("保存成功",bkkcxxbDao.updateById(bkkcxxb));
		}catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public RespData deleteBkkcxxb(String[] ids) {
		try {
			return RespData.successMsg("删除成功",bkkcxxbDao.deleteByIdArr(ids));
		}catch (Exception e) {
			e.getMessage();
			throw e;
		}
	}

	@Override
	public RespData importBkkcxxb(MultipartFile file) {
		try {
			List<BkkcxxbExcel> bkkcxxbs = ExcelUtiles.importExcel(file, 2, 1, BkkcxxbExcel.class);

			for (BkkcxxbExcel bkkcxxbExcel : bkkcxxbs) {
				Bkkcxxb bkkcxxb = new Bkkcxxb(bkkcxxbExcel);
				bkkcxxb.setId(String.valueOf(snowRakeIdGenerator.nextId()));
				bkkcxxbDao.insert(bkkcxxb);
			}

			return RespData.successMsg("导入成功");
		}catch (Exception e) {
			e.getMessage();
			throw e;
		}
	}
}