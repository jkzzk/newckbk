package com.imust.newckbk.service.impl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.imust.newckbk.base.PageEntity;
import com.imust.newckbk.common.RespData;
import com.imust.newckbk.domain.CetStuYyfbcj;
import com.imust.newckbk.domain.CetStuscore;

import com.imust.newckbk.domain.Zyxxb;
import com.imust.newckbk.domain.excel.CetStuYyfbcjExcel;
import com.imust.newckbk.domain.ext.CetStuscoreExt;
import com.imust.newckbk.utils.easypoi.ExcelUtiles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imust.newckbk.dao.CetStuscoreDao;
import com.imust.newckbk.service.CetStuscoreService;
import com.imust.newckbk.base.AbstractService;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Map;


/**
* @date 2020-09-09
* @author jkzzk
* 
*/
@Service("cetStuscoreService")
public class CetStuscoreServiceImpl extends AbstractService<CetStuscore, String> implements CetStuscoreService {

	@Autowired
	private CetStuscoreDao cetStuscoreDao;

	@PostConstruct
	public void setBaseDao() {
		super.setBaseDao(cetStuscoreDao);
	}

    @Override
    public PageInfo<CetStuscoreExt> query(PageEntity<Map> mapPageEntity) {
		try {
			PageHelper.startPage(mapPageEntity.getPageNumber(),mapPageEntity.getPageSize());
			return new PageInfo<>(cetStuscoreDao.getByExtPage(mapPageEntity.getData()));
		}catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
    }

    @Override
    public RespData importCetStuscore(MultipartFile file) {
		try {

			List<CetStuscore> cetStuscoreExcels = ExcelUtiles.importExcel(file, 2, 1, CetStuscore.class);

			for (CetStuscore cetStuscore : cetStuscoreExcels) {
				cetStuscoreDao.insert(cetStuscore);
			}

			return RespData.successMsg("导入成功");
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
    }
}