package com.imust.newckbk.service.impl;

import com.imust.newckbk.common.RespData;
import com.imust.newckbk.dao.LanguageTjjlDao;
import com.imust.newckbk.dao.LanguageTjjlSpecialDao;
import com.imust.newckbk.dao.LanguageTjjlStudentDao;
import com.imust.newckbk.domain.ext.LanguageTjExt;
import com.imust.newckbk.service.LanguageTjService;
import com.imust.newckbk.utils.SnowRakeIdGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LanguageTjServiceImpl implements LanguageTjService {

    @Autowired
    private LanguageTjjlDao languageTjjlDao;
    @Autowired
    private LanguageTjjlSpecialDao languageTjjlSpecialDao;
    @Autowired
    private LanguageTjjlStudentDao languageTjjlStudentDao;

    @Autowired
    private SnowRakeIdGenerator snowRakeIdGenerator;


    @Override
    public RespData save(LanguageTjExt languageTjExt) {
        try {

            String specialId = String.valueOf(snowRakeIdGenerator.nextId());
            String studentId = String.valueOf(snowRakeIdGenerator.nextId());
            languageTjExt.getLanguageTjjlSpecial().setId(specialId);
            languageTjExt.getLanguageTjjlStudent().setId(studentId);
            languageTjExt.getLanguageTjjl().setId(String.valueOf(snowRakeIdGenerator.nextId()));
            languageTjExt.getLanguageTjjl().setSpecialId(specialId);
            languageTjExt.getLanguageTjjl().setStudentId(studentId);

            languageTjjlDao.insert(languageTjExt.getLanguageTjjl());
            languageTjjlSpecialDao.insert(languageTjExt.getLanguageTjjlSpecial());
            languageTjjlStudentDao.insert(languageTjExt.getLanguageTjjlStudent());

            return RespData.successMsg("保存成功","success");

        }catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }
}
