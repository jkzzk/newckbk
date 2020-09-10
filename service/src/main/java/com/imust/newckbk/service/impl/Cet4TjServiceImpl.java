package com.imust.newckbk.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.imust.newckbk.base.PageEntity;
import com.imust.newckbk.common.RespData;
import com.imust.newckbk.dao.Cet4FirstTermDao;
import com.imust.newckbk.dao.Cet4SecondTermDao;
import com.imust.newckbk.dao.Cet4TjjlDao;
import com.imust.newckbk.dao.Cet4TytjjlDao;
import com.imust.newckbk.domain.*;
import com.imust.newckbk.domain.ext.CET4TJExt;
import com.imust.newckbk.service.Cet4TjService;
import com.imust.newckbk.utils.SnowRakeIdGenerator;
import org.codehaus.groovy.syntax.CSTNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("/cet4tjservice")
public class Cet4TjServiceImpl implements Cet4TjService {

    @Autowired
    private Cet4TjjlDao cet4TjjlDao;
    @Autowired
    private Cet4TytjjlDao cet4TytjjlDao;
    @Autowired
    private Cet4FirstTermDao cet4FirstTermDao;
    @Autowired
    private Cet4SecondTermDao cet4SecondTermDao;

    @Autowired
    SnowRakeIdGenerator snowRakeIdGenerator;

    /**
     * 分页查询
     *
     * @param mapPageEntity
     * @return
     */
    @Override
    public PageInfo<CET4TJExt> query(PageEntity<Map> mapPageEntity) {
        try {
            PageHelper.startPage(mapPageEntity.getPageNumber(),mapPageEntity.getPageSize());

            return new PageInfo<>(cet4TjjlDao.getExtByPage(mapPageEntity.getData()));
        }catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    /**
     * 获取当前四级条件信息
     *
     * @param id
     * @return
     */
    @Override
    public CET4TJExt getCurrentSet(String id) {
        try {
            CET4TJExt cet4TJExt = cet4TjjlDao.getExtById(id);

            Cet4Tytjjl cet4Tytjjl = cet4TytjjlDao.getById(cet4TJExt.getTyId());

            Cet4FirstTerm cet4FirstTerm = null;
            if(cet4TJExt.getFirstTermId() != null && !cet4TJExt.getFirstTermId().equals("")) {
                cet4FirstTerm = cet4FirstTermDao.getById(cet4TJExt.getFirstTermId());
            }

            Cet4SecondTerm cet4SecondTerm = null;
            if(cet4TJExt.getSecondTermId() != null && !cet4TJExt.getSecondTermId().equals("")) {
                cet4SecondTerm = cet4SecondTermDao.getById(cet4TJExt.getSecondTermId());
            }

            cet4TJExt.setCet4Tytjjl(cet4Tytjjl);
            cet4TJExt.setCet4FirstTerm(cet4FirstTerm);
            cet4TJExt.setCet4SecondTerm(cet4SecondTerm);

            return cet4TJExt;
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public RespData saveCet4TJExt(CET4TJExt cet4TJExt) {
        try {
            cet4TjjlDao.updateByStatus(0);


            Cet4Tytjjl cet4Tytjjl = cet4TJExt.getCet4Tytjjl();
            String cet4TytjjlId = String.valueOf(snowRakeIdGenerator.nextId());
            cet4Tytjjl.setId(cet4TytjjlId);
            cet4TytjjlDao.insert(cet4Tytjjl);

            Cet4FirstTerm cet4FirstTerm = cet4TJExt.getCet4FirstTerm();
            String cet4FirstTermId = null;
            if(cet4FirstTerm != null) {
                cet4FirstTermId = String.valueOf(snowRakeIdGenerator.nextId());
                cet4FirstTerm.setId(cet4FirstTermId);
                cet4FirstTermDao.insert(cet4FirstTerm);
            }

            Cet4SecondTerm cet4SecondTerm = cet4TJExt.getCet4SecondTerm();
            String cet4SecondTermId = null;
            if(cet4SecondTerm != null) {
                cet4SecondTermId = String.valueOf(snowRakeIdGenerator.nextId());
                cet4SecondTerm.setId(cet4SecondTermId);
                cet4SecondTermDao.insert(cet4SecondTerm);
            }

            cet4TJExt.setId(String.valueOf(snowRakeIdGenerator.nextId()));
            cet4TJExt.setTyId(cet4TytjjlId);
            cet4TJExt.setFirstTermId(cet4FirstTermId);
            cet4TJExt.setSecondTermId(cet4SecondTermId);
            cet4TJExt.setStatus("1");
            cet4TjjlDao.insert(cet4TJExt);

            return RespData.successMsg("保存成功！");
        }catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public RespData clearCet4Tjjl() {
        try {
            List<Cet4Tjjl> cet4Tjjls = cet4TjjlDao.getByStatus("0");

            for (Cet4Tjjl cet4Tjjl : cet4Tjjls) {
                cet4TytjjlDao.deleteById(cet4Tjjl.getTyId());
                if(cet4Tjjl.getFirstTermId() != null) {
                    cet4FirstTermDao.deleteById(cet4Tjjl.getFirstTermId());
                }
                if(cet4Tjjl.getSecondTermId() != null) {
                    cet4SecondTermDao.deleteById(cet4Tjjl.getSecondTermId());
                }
                cet4TjjlDao.deleteById(cet4Tjjl.getId());
            }

            return RespData.successMsg("清除成功！");
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }
}
