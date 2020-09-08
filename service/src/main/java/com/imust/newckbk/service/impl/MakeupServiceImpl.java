package com.imust.newckbk.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.imust.newckbk.base.AbstractService;
import com.imust.newckbk.base.PageEntity;
import com.imust.newckbk.common.RespData;
import com.imust.newckbk.dao.*;
import com.imust.newckbk.domain.*;
import com.imust.newckbk.domain.excel.MakeUPExcel;
import com.imust.newckbk.domain.ext.BkkcxxbExt;
import com.imust.newckbk.domain.ext.BktjjlExt;
import com.imust.newckbk.domain.ext.MakeupExt;
import com.imust.newckbk.domain.ext.RwLlrwAllViewKwExt;
import com.imust.newckbk.domain.report.MakeUpReportExt;
import com.imust.newckbk.domain.report.MakeUpReportList;
import com.imust.newckbk.service.MakeupService;
import com.imust.newckbk.service.XsXpbViewService;
import com.imust.newckbk.utils.SnowRakeIdGenerator;
import com.imust.newckbk.utils.easypoi.ExcelUtiles;
import com.imust.newckbk.utils.ireport.ExportBeanFactory;
import com.imust.newckbk.utils.ireport.IReportUtils;
import com.imust.newckbk.utils.ireport.bean.WebExportBean;
import com.imust.newckbk.utils.ireport.bean.WebExportPDF;
import org.apache.commons.beanutils.BeanUtils;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.*;

@Service("makeUpService")
public class MakeupServiceImpl extends AbstractService<Makeup, String> implements MakeupService {

    @Autowired
    private MakeupDao makeupDao;
    @Autowired
    private JwkzxxjlDao jwkzxxjlDao;
    @Autowired
    private BktjjlDao bktjjlDao;
    @Autowired
    private XsXjxxbViewKwDao xsXjxxbViewKwDao;
    @Autowired
    private XsUnfinishedDao xsUnfinishedDao;
    @Autowired
    private XsXpbViewService xsXpbViewService;

    @Autowired
    private SnowRakeIdGenerator snowRakeIdGenerator;

    @PostConstruct
    public void setBaseDao() {
        super.setBaseDao(makeupDao);
    }

    @Override
    public List<MakeupExt> query(SysUser currentSysUser) {
        try {
            BktjjlExt effectiveSet = bktjjlDao.getEffectiveSet();
            // 查询已插入列表
            List<MakeupExt> makeupExts = makeupDao.getByExt(currentSysUser.getLoginName(), effectiveSet.getSxqzxjxjhh());
            // 查询所有需要插入的列表
            List<Makeup> makeupCourse = makeupDao.getMakeupCourse(currentSysUser.getLoginName(), effectiveSet.getSxqzxjxjhh(), effectiveSet.getBkfs());

            // 如果已插入列表为空，说明该学生未报过名，直接插入
            if(makeupExts == null || makeupExts.isEmpty()) {

                for (Makeup makeup : makeupCourse) {
                    makeup.setId(String.valueOf(snowRakeIdGenerator.nextId()));
                    makeupDao.insert(makeup);
                }

                makeupExts = makeupDao.getByExt(currentSysUser.getLoginName(), effectiveSet.getSxqzxjxjhh());
            }else if(makeupExts.size() != makeupCourse.size()) {
                // 如果已插入列表与全部列表长度不一致，说明新增了课程或减少了课程
                Iterator<Makeup> iterator = makeupCourse.iterator();
                while(iterator.hasNext()) {
                    Makeup makeup = iterator.next();
                    for (MakeupExt makeupExt : makeupExts) {
                        if(makeupExt.getKch().equals(makeup.getKch()) || makeupExt.getKcm().equals(makeup.getKcm())) {
                            iterator.remove();
                            break;
                        }
                    }
                }

                for (Makeup makeup : makeupCourse) {
                    makeup.setId(String.valueOf(snowRakeIdGenerator.nextId()));
                    makeupDao.insert(makeup);
                }

                makeupExts = makeupDao.getByExt(currentSysUser.getLoginName(), effectiveSet.getSxqzxjxjhh());
            }else {
                makeupExts = makeupDao.getByExt(currentSysUser.getLoginName(), effectiveSet.getSxqzxjxjhh());
            }

            return this.removeDuplicate(makeupExts);
        }catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    private List<MakeupExt> removeDuplicate(List<MakeupExt> makeupExts) {
        // 课程号去重复
        Map<String,MakeupExt> makeupExtMap_kch = new HashMap<>();
        for (MakeupExt makeupExt : makeupExts) {
            makeupExtMap_kch.put(makeupExt.getKch(),makeupExt);
        }
        List<MakeupExt> makeupExtList_kch = new ArrayList<>(makeupExtMap_kch.values());

        // 课程名去重复
        Map<String,MakeupExt> makeupExtMap_kcm = new HashMap<>();
        for (MakeupExt makeupExtListKch : makeupExtList_kch) {
            makeupExtMap_kcm.put(makeupExtListKch.getKcm(),makeupExtListKch);
        }
        List<MakeupExt> makeupExtList_kcm = new ArrayList<>(makeupExtMap_kcm.values());

        return makeupExtList_kcm;
    }

    @Override
    public boolean ifOpen() {
        try {
            Jwkzxxjl currentSet = jwkzxxjlDao.getCurrentSet();
            if(currentSet.getBkkg() == 0) {
                return false;
            }else {
                return true;
            }
        }catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public boolean ifInScope(SysUser currentSysUser) {
        try {
            XsXjxxbViewKw xsXjxxbViewKw = xsXjxxbViewKwDao.getById(currentSysUser.getLoginName());
            BktjjlExt currentSet = bktjjlDao.getEffectiveSet();

            if(currentSet.getBkdx().equals("1") && xsXjxxbViewKw.getSfyxj().equals("否")) {
                return false;
            }

            if(currentSet.getBkdx().equals("2")) {
                String unfinishedXh = xsUnfinishedDao.getByXh(currentSysUser.getLoginName());
                if(unfinishedXh == null || unfinishedXh.equals(""))
                    return false;
                else
                    return true;
            }

            if(currentSet.getZxnj() != null && currentSet.getZxnj().indexOf(xsXjxxbViewKw.getDqnj()) == -1) {
                return false;
            }

            return true;
        }catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public RespData save(Makeup makeup) {
        try {
            makeup.setId(String.valueOf(snowRakeIdGenerator.nextId()));
            return RespData.successMsg("保存成功",makeupDao.insert(makeup));
        }catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public RespData enter(String[] ids) {
        try {
            return RespData.successMsg("报名成功！",makeupDao.updateMakeUPByIdArr(ids,(byte) 1));
        }catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public RespData outer(String[] ids) {
        try {
            return RespData.successMsg("已取消报名！",makeupDao.updateMakeUPByIdArr(ids,(byte) 0));
        }catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public PageInfo<MakeupExt> queryList(PageEntity<Map> mapPageEntity) {
        try {
            PageHelper.startPage(mapPageEntity.getPageNumber(),mapPageEntity.getPageSize());

            return new PageInfo<>(makeupDao.getExtByPage(mapPageEntity.getData()));
        }catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public RespData deleteMakeUp(String[] ids) {
        try {
            return RespData.successMsg("删除成功",makeupDao.deleteByIdArr(ids));
        }catch (Exception e) {
            e.getMessage();
            throw e;
        }
    }

    @Override
    public void export(HttpServletResponse response) {
        try {
            BktjjlExt effectiveSet = bktjjlDao.getEffectiveSet();
            // 查询导出数据
            List<MakeUPExcel> makeUPExcels = makeupDao.getMakeupExcle(effectiveSet.getSxqzxjxjhh());
            // 导出
            ExcelUtiles.exportExcel(makeUPExcels,"学生补考报名信息","sheet1", MakeUPExcel.class,"学生补考报名信息.xls",response);
        }catch (Exception e) {
            e.getMessage();
            throw e;
        }
    }

    @Override
    public void printEnterCard(String xh,HttpServletResponse response) {
        try {
            BktjjlExt effectiveSet = bktjjlDao.getEffectiveSet();
            XsXjxxbViewKw xsXjxxbViewKw = xsXjxxbViewKwDao.getById(xh);
            XsXpbView xsXpbView = xsXpbViewService.getById(xh);
            List<MakeUpReportList> makeUpReportLists = makeupDao.getMakeupReportList(xh);
            List<MakeUpReportList> makeupReportSaveList = makeupDao.getMakeupReportSaveList(xh);

            MakeUpReportExt makeUpReportExt = new MakeUpReportExt(xsXjxxbViewKw,effectiveSet.getZxjxjhm());
            Map<String,Object> makeUpReportExtPar = BeanUtils.describe(makeUpReportExt);
            InputStream photo = new ByteArrayInputStream(xsXpbView == null ? new byte[0] : xsXpbView.getZp());
            InputStream photoSave = new ByteArrayInputStream(xsXpbView == null ? new byte[0] : xsXpbView.getZp());
            makeUpReportExtPar.put("photo",photo);
            makeUpReportExtPar.put("photoSave",photoSave);
            photo.close();
            photoSave.close();
            List<WebExportBean> webExportPDFS = new ArrayList<>();
            WebExportPDF webExportCardPDF = ExportBeanFactory.getWebInlineExportPDF("ireport-tmp/makeupCard.jasper", makeUpReportExtPar, makeUpReportLists,"准考证");
            webExportPDFS.add(webExportCardPDF);
            WebExportPDF webExportCardSavePDF = ExportBeanFactory.getWebInlineExportPDF("ireport-tmp/makeupCardSave.jasper", makeUpReportExtPar, makeupReportSaveList,"准考证存根");
            webExportPDFS.add(webExportCardSavePDF);
            IReportUtils.export(webExportPDFS,response);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public RespData inpay(String[] ids) {
        try {
            return RespData.successMsg("缴费成功！",makeupDao.updatePayByIdArr(ids,(byte) 1));
        }catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public RespData outpay(String[] ids) {
        try {
            return RespData.successMsg("已取消缴费！",makeupDao.updatePayByIdArr(ids,(byte) 0));
        }catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public List<BkkcxxbExt> getExtraCourse(String xh) {
        try {
            XsXjxxbViewKw student = xsXjxxbViewKwDao.getById(xh);
            // 生效条件
            BktjjlExt effectiveSet = bktjjlDao.getEffectiveSet();
            // 未插入补考数据库的表
            List<MakeupExt> makeupNoInsertData = makeupDao.getNoInsertData(xh,effectiveSet.getBkfs());

            for (MakeupExt makeupNoInsertDatum : makeupNoInsertData) {
                Makeup makeup = new Makeup();
                makeup.setId(String.valueOf(snowRakeIdGenerator.nextId()));
                makeup.setXh(xh);
                makeup.setXm(student.getXm());
                makeup.setKch(makeupNoInsertDatum.getKch());
                makeup.setKcm(makeupNoInsertDatum.getKcm());
                makeup.setXf(makeupNoInsertDatum.getXf());
                makeup.setMaxScore(makeupNoInsertDatum.getMaxScore());
                makeup.setIfMakeUp((byte) 0);
                makeup.setIfPay((byte) 0);
                makeup.setJxjhh(effectiveSet.getSxqzxjxjhh());

                makeupDao.insert(makeup);
            }

            // 所有课程
            List<BkkcxxbExt> extraCourse = makeupDao.getExtraCourse(xh);

            return extraCourse;
        }catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }
}
