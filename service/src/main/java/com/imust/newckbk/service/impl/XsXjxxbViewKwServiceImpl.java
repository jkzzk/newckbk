package com.imust.newckbk.service.impl;

import javax.annotation.PostConstruct;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.imust.newckbk.base.PageEntity;
import com.imust.newckbk.common.RespData;
import com.imust.newckbk.domain.SysUser;
import com.imust.newckbk.domain.report.XszzyxxReportExt;
import com.imust.newckbk.utils.ireport.ExportBeanFactory;
import com.imust.newckbk.utils.ireport.IReportUtils;
import com.imust.newckbk.utils.ireport.bean.WebExportPDF;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imust.newckbk.base.AbstractService;
import com.imust.newckbk.dao.XsXjxxbViewKwDao;
import com.imust.newckbk.domain.XsXjxxbViewKw;
import com.imust.newckbk.service.XsXjxxbViewKwService;

import java.util.Map;

/**
 * @date 2019-09-02
 * @author jkzzk
 *
 */
@Service("xsXjxxbViewKwService")
public class XsXjxxbViewKwServiceImpl extends AbstractService<XsXjxxbViewKw, String> implements XsXjxxbViewKwService {
    @Autowired
    private XsXjxxbViewKwDao xsXjxxbViewKwDao;

    @PostConstruct
    public void setBaseDao() {
        super.setBaseDao(xsXjxxbViewKwDao);
    }

    @Override
    public PageInfo<XsXjxxbViewKw> query(PageEntity<Map> pageParams) {
        try{
            PageHelper.startPage(pageParams.getPageNumber(),pageParams.getPageSize());

            return new PageInfo<XsXjxxbViewKw>(xsXjxxbViewKwDao.getByMapPage(pageParams.getData()));
        }catch (Exception e) {
            throw e;
        }
    }

    @Override
    public RespData login(String xh, String password) {
        try{
            XsXjxxbViewKw xsXjxxbViewKw = xsXjxxbViewKwDao.getById(xh);
            if(xsXjxxbViewKw == null || xsXjxxbViewKw.getXh() == "") {
                return RespData.errorMsg("没有该用户");
            }
            String sfzh = xsXjxxbViewKw.getSfzh();
            int length = sfzh.length();
            if(!sfzh.substring(length-6,length).equals(password)) {
                return RespData.errorMsg("密码或用户名不对");
            }

            SysUser sysUser = new SysUser();
            sysUser.setLoginName(xsXjxxbViewKw.getXh());
            sysUser.setRealName(xsXjxxbViewKw.getXm());
            sysUser.setRoleIds("2");
            sysUser.setPassword(password);

            return RespData.successMsg("登录成功",sysUser);

        }catch (Exception e) {
            throw e;
        }
    }
}



