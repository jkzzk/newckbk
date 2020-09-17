package com.imust.newckbk.service.impl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.imust.newckbk.base.PageEntity;
import com.imust.newckbk.common.RespData;
import com.imust.newckbk.dao.*;
import com.imust.newckbk.domain.Cet4Tjjl;
import com.imust.newckbk.domain.LanguageExam;

import com.imust.newckbk.domain.ext.CET4TJExt;
import com.imust.newckbk.domain.ext.LanguageExamExt;
import com.imust.newckbk.utils.SnowRakeIdGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imust.newckbk.service.LanguageExamService;
import com.imust.newckbk.base.AbstractService;
import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


/**
* @date 2020-09-10
* @author jkzzk
* 
*/
@Service("languageExamService")
public class LanguageExamServiceImpl extends AbstractService<LanguageExam, String> implements LanguageExamService {

	@Autowired
	private LanguageExamDao languageExamDao;
	@Autowired
	private Cet4TjjlDao cet4TjjlDao;
	@Autowired
	private Cet4TytjjlDao cet4TytjjlDao;
	@Autowired
	private Cet4FirstTermDao cet4FirstTermDao;
	@Autowired
	private Cet4SecondTermDao cet4SecondTermDao;

	@Autowired
	private SnowRakeIdGenerator snowRakeIdGenerator;

	@PostConstruct
	public void setBaseDao() {
		super.setBaseDao(languageExamDao);
	}

    @Override
    public PageInfo<LanguageExamExt> query(PageEntity<Map> mapPageEntity) {
		try {
			PageHelper.startPage(mapPageEntity.getPageNumber(),mapPageEntity.getPageSize());

			return new PageInfo<>(languageExamDao.getExtByPage(mapPageEntity.getData()));
		}catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
    }

	@Override
	public RespData saveLanguageExam(LanguageExam languageExam) {
		try {
			languageExam.setId(String.valueOf(snowRakeIdGenerator.nextId()));
			return RespData.successMsg("保存成功",languageExamDao.insert(languageExam));
		}catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public RespData editLanguageExam(LanguageExam languageExam) {
		try {
			return RespData.successMsg("修改成功",languageExamDao.updateById(languageExam));
		}catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public RespData deleteLanguageExam(String[] ids) {
		try {
			return RespData.successMsg("删除成功",languageExamDao.deleteByIdArr(ids));
		}catch (Exception e) {
			e.getMessage();
			throw e;
		}
	}

    @Override
    public List<LanguageExam> getAllByTerm(String zxjxjhh) {
		try {

			return languageExamDao.getAllByTerm(zxjxjhh);

		}catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
    }

	@Override
	public RespData generateCET4() {

		CET4TJExt currentAllCET4TJ = this.getCurrentAllCET4TJ();

		if(currentAllCET4TJ == null) {
			return RespData.errorMsg("条件出错！");
		}

		List<LanguageExam> languageExamsForFirstGrade = new ArrayList<>();
		if(currentAllCET4TJ.getFirstIn().equals("1")) {
			// 生成大一的英语四级数据
			languageExamsForFirstGrade = languageExamDao.generateCET4ForFirstGrade(currentAllCET4TJ);
		}

		// 生成专科的英语四级数据
		List<LanguageExam> languageExamsForJunior = languageExamDao.generateCET4ForJunior(currentAllCET4TJ);

		// 生成其他年级的英语四级数据
		List<LanguageExam> languageExamsForOther = languageExamDao.generateCET4ForOther(currentAllCET4TJ);

		languageExamsForFirstGrade.addAll(languageExamsForJunior);
		languageExamsForFirstGrade.addAll(languageExamsForOther);

		languageExamsForFirstGrade.forEach(item -> {
			item.setId(String.valueOf(snowRakeIdGenerator.nextId()));
		});

		if(!languageExamsForFirstGrade.isEmpty()) {
			languageExamDao.insertBatch(languageExamsForFirstGrade);
		}

		return RespData.successMsg("英语四级名单生成成功！");
	}

	@Override
	public RespData generateCET6() {

		CET4TJExt currentAllCET4TJ = this.getCurrentAllCET4TJ();

		if(currentAllCET4TJ == null) {
			return RespData.errorMsg("条件出错！");
		}

		List<LanguageExam> languageExamsCET6 = languageExamDao.generateCET6ForAll(currentAllCET4TJ);

		languageExamsCET6.forEach(item -> {
			item.setId(String.valueOf(snowRakeIdGenerator.nextId()));
		});

		if(!languageExamsCET6.isEmpty()) {
			languageExamDao.insertBatch(languageExamsCET6);
		}

		return RespData.successMsg("英语六级名单生成成功！");
	}

	@Override
	public RespData generateCRT4() {

		CET4TJExt currentAllCET4TJ = this.getCurrentAllCET4TJ();

		if(currentAllCET4TJ == null) {
			return RespData.errorMsg("条件出错！");
		}

		List<LanguageExam> languageExamsCRT4 = languageExamDao.generateCRT4ForAll(currentAllCET4TJ);

		languageExamsCRT4.forEach(item -> {
			item.setId(String.valueOf(snowRakeIdGenerator.nextId()));
		});

		if(!languageExamsCRT4.isEmpty()) {
			languageExamDao.insertBatch(languageExamsCRT4);
		}

		return RespData.successMsg("俄语四级名单生成成功！");
	}

	@Override
	public RespData generateCRT6() {

		CET4TJExt currentAllCET4TJ = this.getCurrentAllCET4TJ();

		if(currentAllCET4TJ == null) {
			return RespData.errorMsg("条件出错！");
		}

		List<LanguageExam> languageExamsCRT6 = languageExamDao.generateCRT6ForAll(currentAllCET4TJ);

		languageExamsCRT6.forEach(item -> {
			item.setId(String.valueOf(snowRakeIdGenerator.nextId()));
		});

		if(!languageExamsCRT6.isEmpty()) {
			languageExamDao.insertBatch(languageExamsCRT6);
		}

		return RespData.successMsg("俄语六级名单生成成功！");
	}

	@Override
	public RespData generateCJT4() {

		CET4TJExt currentAllCET4TJ = this.getCurrentAllCET4TJ();

		if(currentAllCET4TJ == null) {
			return RespData.errorMsg("条件出错！");
		}

		List<LanguageExam> languageExamsCJT4 = languageExamDao.generateCJT4ForAll(currentAllCET4TJ);

		languageExamsCJT4.forEach(item -> {
			item.setId(String.valueOf(snowRakeIdGenerator.nextId()));
		});

		if(!languageExamsCJT4.isEmpty()) {
			languageExamDao.insertBatch(languageExamsCJT4);
		}

		return RespData.successMsg("日语四级名单生成成功！");
	}

	@Override
	public RespData generateCJT6() {

		CET4TJExt currentAllCET4TJ = this.getCurrentAllCET4TJ();

		if(currentAllCET4TJ == null) {
			return RespData.errorMsg("条件出错！");
		}

		List<LanguageExam> languageExamsCJT6 = languageExamDao.generateCJT6ForAll(currentAllCET4TJ);

		languageExamsCJT6.forEach(item -> {
			item.setId(String.valueOf(snowRakeIdGenerator.nextId()));
		});

		if(!languageExamsCJT6.isEmpty()) {
			languageExamDao.insertBatch(languageExamsCJT6);
		}

		return RespData.successMsg("日语六级名单生成成功！");
	}

    @Override
    public RespData clearMaupData() {
		try {

			languageExamDao.deleteAll();

			return RespData.successMsg("清除成功！",1);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
    }

    private CET4TJExt getCurrentAllCET4TJ() {
		List<Cet4Tjjl> cet4Tjjls = cet4TjjlDao.getByStatus("1");

		CET4TJExt cet4TJExt = null;
		if(cet4Tjjls != null && !cet4Tjjls.isEmpty()) {
			cet4TJExt = new CET4TJExt(cet4Tjjls.get(0));
			cet4TJExt.setCet4Tytjjl(cet4TytjjlDao.getById(cet4TJExt.getTyId()));
			if(cet4TJExt.getFirstTermId() != null && !cet4TJExt.getFirstTermId().equals("")) {
				cet4TJExt.setCet4FirstTerm(cet4FirstTermDao.getById(cet4TJExt.getFirstTermId()));
			}
			if(cet4TJExt.getSecondTermId() != null && !cet4TJExt.getSecondTermId().equals("")) {
				cet4TJExt.setCet4SecondTerm(cet4SecondTermDao.getById(cet4TJExt.getSecondTermId()));
			}
		}

		return cet4TJExt;
	}
}