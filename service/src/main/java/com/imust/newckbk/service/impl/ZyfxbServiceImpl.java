package com.imust.newckbk.service.impl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.imust.newckbk.base.PageEntity;
import com.imust.newckbk.common.RespData;
import com.imust.newckbk.dao.*;
import com.imust.newckbk.domain.*;

import com.imust.newckbk.domain.excel.ZyfxbExcel;
import com.imust.newckbk.domain.ext.FxtjbExt;
import com.imust.newckbk.domain.report.XszzyxxReportExt;
import com.imust.newckbk.domain.report.ZyfxbReportExt;
import com.imust.newckbk.utils.easypoi.ExcelUtiles;
import com.imust.newckbk.utils.ireport.ExportBeanFactory;
import com.imust.newckbk.utils.ireport.IReportUtils;
import com.imust.newckbk.utils.ireport.bean.WebExportPDF;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imust.newckbk.service.ZyfxbService;
import com.imust.newckbk.base.AbstractService;
import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;


/**
* @date 2020-08-23
* @author jkzzk
* 
*/
@Service("zyfxbService")
public class ZyfxbServiceImpl extends AbstractService<Zyfxb, String> implements ZyfxbService {

	@Autowired
	private ZyfxbDao zyfxbDao;
	@Autowired
	private JwkzxxjlDao jwkzxxjlDao;
	@Autowired
	private XsXjxxbViewKwDao xsXjxxbViewKwDao;
	@Autowired
	private FxtjbDao fxtjbDao;
	@Autowired
	private ZyfxxxbDao zyfxxxbDao;

	@PostConstruct
	public void setBaseDao() {
		super.setBaseDao(zyfxbDao);
	}

    @Override
    public boolean ifOpen() {
		Jwkzxxjl currentSet = jwkzxxjlDao.getCurrentSet();
		if(currentSet.getFxkg() == 0) {
			return false;
		}else {
			return true;
		}
    }

	@Override
	public boolean ifInScope(SysUser currentSysUser) {
		try {
			XsXjxxbViewKw xsXjxxbViewKw = xsXjxxbViewKwDao.getById(currentSysUser.getLoginName());
			FxtjbExt currentSet = fxtjbDao.getEffectiveSet();

			if(xsXjxxbViewKw.getSfyxj().equals("否")) {
				return false;
			}

			if(currentSet.getGrade() != null && currentSet.getGrade().indexOf(xsXjxxbViewKw.getDqnj()) == -1) {
				return false;
			}

			return true;
		}catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public List<Zyfxb> query(SysUser currentSysUser) {
		try {
			return zyfxbDao.getByXh(currentSysUser.getLoginName());
		}catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public PageInfo<Zyfxb> queryList(PageEntity<Map> mapPageEntity) {
		try {

			PageHelper.startPage(mapPageEntity.getPageNumber(),mapPageEntity.getPageSize());

			return new PageInfo<>(zyfxbDao.getExtByPage(mapPageEntity.getData()));

		}catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public RespData save(Zyfxb zyfxb) {
		try {
			XsXjxxbViewKw xsXjxxbViewKw = xsXjxxbViewKwDao.getById(zyfxb.getXh());
			if(xsXjxxbViewKw == null || xsXjxxbViewKw.getXh().equals("")) {
				return RespData.errorMsg("未找到该学生！");
			}
			zyfxb.setXm(xsXjxxbViewKw.getXm());
			zyfxb.setXsm(xsXjxxbViewKw.getXsm());
			zyfxb.setZym(xsXjxxbViewKw.getZym());
			zyfxb.setBjh(xsXjxxbViewKw.getBjh());

			Zyfxxxb zyfxxxb = zyfxxxbDao.getById(zyfxb.getZyfxxxbId());
			zyfxb.setNfxxsm(zyfxxxb.getXsm());
			zyfxb.setNfxzym(zyfxxxb.getZym());

			FxtjbExt effectiveSet = fxtjbDao.getEffectiveSet();
			zyfxb.setZxjxjhh(effectiveSet.getZxjxjhh());

			return RespData.successMsg("保存成功！",zyfxbDao.insert(zyfxb));
		}catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public RespData deleteMakeUp(String[] ids) {
		try {
			return RespData.successMsg("删除成功",zyfxbDao.deleteByIdArr(ids));
		}catch (Exception e) {
			e.getMessage();
			throw e;
		}
	}

	@Override
	public void export(HttpServletResponse response) {
		try {
			FxtjbExt currentSet = fxtjbDao.getEffectiveSet();
			// 查询导出数据
			List<ZyfxbExcel> makeUPExcels = zyfxbDao.getMakeupExcle(currentSet.getZxjxjhh());
			// 导出
			ExcelUtiles.exportExcel(makeUPExcels,"学生辅修报名信息","sheet1", ZyfxbExcel.class,"学生辅修报名信息.xls",response);
		}catch (Exception e) {
			e.getMessage();
			throw e;
		}
	}

	@Override
	public Zyfxb getByXh(String loginName) {
		try {
			List<Zyfxb> zyfxbList = zyfxbDao.getByXh(loginName);
			if(zyfxbList.isEmpty()) {
				return new Zyfxb();
			}else {
				return zyfxbList.get(0);
			}
		}catch (Exception e) {
			e.getMessage();
			throw e;
		}
	}

	@Override
	public RespData updateByXh(Zyfxb zyfxb) {
		try {
			return RespData.successMsg("修改成功！",zyfxbDao.updateById(zyfxb));
		}catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

    @Override
    public void printApplyTable(String xh) {
        try {
			FxtjbExt currentSet = fxtjbDao.getEffectiveSet();

//			String termInfo = this.getPrintTermInfo(currentSet.getZxjxjhh());

			ZyfxbReportExt zyfxbReportExt = zyfxbDao.getReportByXh(xh);
			Map zyfxbPar = BeanUtils.describe(zyfxbReportExt);
			WebExportPDF webExportCoverPDF = ExportBeanFactory.getWebInlineExportPDF("ireport-tmp/fxapply.jasper", zyfxbPar, "学生辅修申请");
			IReportUtils.export(webExportCoverPDF);

		}catch (Exception e) {
        	e.printStackTrace();
		}
    }
}