package com.imust.newckbk.service.impl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.imust.newckbk.base.PageEntity;
import com.imust.newckbk.common.RespData;
import com.imust.newckbk.domain.CetStuYyfbcj;

import com.imust.newckbk.domain.excel.CetStuYyfbcjExcel;
import com.imust.newckbk.domain.ext.CetStuYyfbcjExt;
import com.imust.newckbk.utils.SnowRakeIdGenerator;
import com.imust.newckbk.utils.easypoi.ExcelUtiles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imust.newckbk.dao.CetStuYyfbcjDao;
import com.imust.newckbk.service.CetStuYyfbcjService;
import com.imust.newckbk.base.AbstractService;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Map;


/**
* @date 2020-07-05
* @author jkzzk
* 
*/
@Service("cetStuYyfbcjService")
public class CetStuYyfbcjServiceImpl extends AbstractService<CetStuYyfbcj, String> implements CetStuYyfbcjService {

	@Autowired
	private CetStuYyfbcjDao cetStuYyfbcjDao;

	@Autowired
	private SnowRakeIdGenerator snowRakeIdGenerator;

	@PostConstruct
	public void setBaseDao() {
		super.setBaseDao(cetStuYyfbcjDao);
	}

    @Override
    public PageInfo<CetStuYyfbcjExt> query(PageEntity<Map> mapPageEntity) {
        try {
			PageHelper.startPage(mapPageEntity.getPageNumber(),mapPageEntity.getPageSize());

			return new PageInfo<>(cetStuYyfbcjDao.getExtByPage(mapPageEntity.getData()));
		}catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
    }

	@Override
	public RespData saveCetStuYyfbcj(CetStuYyfbcj cetStuYyfbcj) {
		try {

			cetStuYyfbcj.setId(String.valueOf(snowRakeIdGenerator.nextId()));


			return RespData.successMsg("保存成功", cetStuYyfbcjDao.insert(cetStuYyfbcj));

		}catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public RespData delCetStuYyfbcj(List<String> ids) {
		try {

			return RespData.successMsg("删除成功",cetStuYyfbcjDao.deleteByArr(ids));

		}catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public RespData importCetStuYyfbcj(MultipartFile file) {
		try {

			List<CetStuYyfbcjExcel> cetStuYyfbcjExcels = ExcelUtiles.importExcel(file, 2, 1, CetStuYyfbcjExcel.class);

			for (CetStuYyfbcjExcel cetStuYyfbcjExcel : cetStuYyfbcjExcels) {
				CetStuYyfbcj cetStuYyfbcj = new CetStuYyfbcj(cetStuYyfbcjExcel);
				cetStuYyfbcj.setId(String.valueOf(snowRakeIdGenerator.nextId()));
				cetStuYyfbcjDao.insert(cetStuYyfbcj);
			}

			return RespData.successMsg("导入成功");
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
}