package com.imust.newckbk.service.impl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.imust.newckbk.base.PageEntity;
import com.imust.newckbk.common.RespData;
import com.imust.newckbk.dao.ZzytjjlDao;
import com.imust.newckbk.domain.Xszzyxxb;

import com.imust.newckbk.domain.Zzytjjl;
import com.imust.newckbk.domain.ext.XszzyxxbExt;
import com.imust.newckbk.domain.report.XszzyxxReportExt;
import com.imust.newckbk.service.ZzytjjlService;
import com.imust.newckbk.utils.SnowRakeIdGenerator;
import com.imust.newckbk.utils.ireport.ExportBeanFactory;
import com.imust.newckbk.utils.ireport.IReportUtils;
import com.imust.newckbk.utils.ireport.bean.WebExportPDF;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imust.newckbk.dao.XszzyxxbDao;
import com.imust.newckbk.service.XszzyxxbService;
import com.imust.newckbk.base.AbstractService;
import javax.annotation.PostConstruct;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;


/**
* @date 2020-05-13
* @author jkzzk
* 
*/
@Service("xszzyxxbService")
public class XszzyxxbServiceImpl extends AbstractService<Xszzyxxb, String> implements XszzyxxbService {

	@Autowired
	private XszzyxxbDao xszzyxxbDao;
	@Autowired
	private ZzytjjlDao zzytjjlDao;
	@Autowired
	private SnowRakeIdGenerator snowRakeIdGenerator;

	@PostConstruct
	public void setBaseDao() {
		super.setBaseDao(xszzyxxbDao);
	}

	@Override
	public PageInfo<XszzyxxbExt> query(PageEntity<Map> mapPageEntity) {
		try {
			PageHelper.startPage(mapPageEntity.getPageNumber(),mapPageEntity.getPageSize());

			return new PageInfo<>(xszzyxxbDao.getExtByPage(mapPageEntity.getData()));
		}catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public RespData saveXszzyxxb(Xszzyxxb xszzyxxb) {
		try {
			xszzyxxb.setId(String.valueOf(snowRakeIdGenerator.nextId()));
			return RespData.successMsg("保存成功",xszzyxxbDao.insert(xszzyxxb));
		}catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public RespData delXszzyxxb(List<String> ids) {
		try {
			return RespData.successMsg("删除成功",xszzyxxbDao.deleteByArr(ids));
		}catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public XszzyxxbExt getXszzyxxbById(String id) {
		try {
			return xszzyxxbDao.getExtById(id);
		}catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public XszzyxxbExt getXszzyxxbByXh(String loginName) {
		try {
			return xszzyxxbDao.getExtByXh(loginName);
		}catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public void printApplyTable(String xh) throws Exception {
		try {

			Zzytjjl currentSet = zzytjjlDao.getCurrentSet();

			String termInfo = this.getPrintTermInfo(currentSet.getZxjxjhh());

			XszzyxxReportExt xszzyxxReportExt = xszzyxxbDao.getByXh(xh);
			xszzyxxReportExt.setTerm(termInfo);
			Map xszzyxxReportExtPar = BeanUtils.describe(xszzyxxReportExt);
			WebExportPDF webExportCoverPDF = ExportBeanFactory.getWebInlineExportPDF("ireport-tmp/xszzyapply.jasper", xszzyxxReportExtPar, "学生转专业申请");
			IReportUtils.export(webExportCoverPDF);

		}catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public List<Xszzyxxb> getExtByEnity(Xszzyxxb xszzyxxb) {
		try {
			return xszzyxxbDao.getByEntity(xszzyxxb);
		}catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	private String getPrintTermInfo(String zxjxjhh) {
		String[] termInfoArr = zxjxjhh.split("-");
		String termInfo = "";
		termInfo += termInfoArr[0];
		termInfo += "/";
		termInfo += termInfoArr[1];
		termInfo += "第";
		if(termInfoArr[2].equals("1")) {
			termInfo += "一学期学生转专业申请表";
		}
		if(termInfoArr[2].equals("2")) {
			termInfo += "二学期学生转专业申请表";
		}

		return termInfo;
	}
}