package com.imust.newckbk.service.impl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.imust.newckbk.base.PageEntity;
import com.imust.newckbk.common.RespData;
import com.imust.newckbk.dao.*;
import com.imust.newckbk.domain.Cet4Tjjl;
import com.imust.newckbk.domain.LanguageExam;

import com.imust.newckbk.domain.excel.LanTypeCalc;
import com.imust.newckbk.domain.excel.StatisticReport;
import com.imust.newckbk.domain.excel.StatisticReportExcel;
import com.imust.newckbk.domain.excel.StatisticStruct;
import com.imust.newckbk.domain.ext.*;
import com.imust.newckbk.exception.CustomException;
import com.imust.newckbk.utils.SnowRakeIdGenerator;
import com.imust.newckbk.utils.easypoi.ExcelUtiles;
import org.apache.ibatis.annotations.Lang;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imust.newckbk.service.LanguageExamService;
import com.imust.newckbk.base.AbstractService;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletResponse;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;


/**
* @date 2020-09-10
* @author jkzzk
* 
*/
@Service("languageExamService")
public class LanguageExamServiceImpl extends AbstractService<LanguageExam, String> implements LanguageExamService {

	Logger logger = LoggerFactory.getLogger(LanguageExamServiceImpl.class);

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
	private LanguageTjjlDao languageTjjlDao;
	@Autowired
	private CetStuscoreDao cetStuscoreDao;
	@Autowired
	private XsXjxxbViewKwDao xsXjxxbViewKwDao;
	@Autowired
	private StatisticReportDao statisticReportDao;
	@Autowired
	private LangStisticExtDao langStisticExtDao;

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

		LanguageInfoExt languageInfoExt = languageTjjlDao.getAllTj();

		boolean cet4 = languageInfoExt.getCet4().equals("1");
		if(cet4) {

			this.getGradeArr(languageInfoExt);

			// 分年级筛选，本科类型与特殊学院置于sql语句中
			List<LanguageExam> languageExams = new ArrayList<>();

			// 大一年级本科
			if("1".equals(languageInfoExt.getIsFirstGrade())) {
				List<LanguageExam> firstCollagelanguageExams = languageExamDao.generateCET4CollageForFirstGrade(languageInfoExt);
				languageExams.addAll(firstCollagelanguageExams);
			}

			// 大二年级本科
			if("1".equals(languageInfoExt.getIsSecondGrade())) {
				List<LanguageExam> secondCollagelanguageExams = languageExamDao.generateCET4CollageForSecondGrade(languageInfoExt);
				languageExams.addAll(secondCollagelanguageExams);
			}

			// 大三年级本科
			if("1".equals(languageInfoExt.getIsThirdGrade())) {
				List<LanguageExam> thirdCollagelanguageExams = languageExamDao.generateCET4CollageForThirdGrade(languageInfoExt);
				languageExams.addAll(thirdCollagelanguageExams);
			}

			// 大四年级本科
			if("1".equals(languageInfoExt.getIsFoGrade())) {
				List<LanguageExam> foCollagelanguageExams = languageExamDao.generateCET4CollageForFoGrade(languageInfoExt);
				languageExams.addAll(foCollagelanguageExams);
			}

			// 大五年级本科
			if("1".equals(languageInfoExt.getIsFifthGrade())) {
				List<LanguageExam> fifCollagelanguageExams = languageExamDao.generateCET4CollageForFifGrade(languageInfoExt);
				languageExams.addAll(fifCollagelanguageExams);
			}

			// 专一年级
			if("1".equals(languageInfoExt.getIsJuniorFirstGrade())) {
				List<LanguageExam> firstJuniorlanguageExams = languageExamDao.generateCET4JuniorForFirstGrade(languageInfoExt);
				languageExams.addAll(firstJuniorlanguageExams);
			}

			// 专二年级
			if("1".equals(languageInfoExt.getIsJuniorSecondGrade())) {
				List<LanguageExam> secondJuniorlanguageExams = languageExamDao.generateCET4JuniorForSecondGrade(languageInfoExt);
				languageExams.addAll(secondJuniorlanguageExams);
			}

			// 专三年级
			if("1".equals(languageInfoExt.getIsJuniorThirdGrade())) {
				List<LanguageExam> thirdJuniorlanguageExams = languageExamDao.generateCET4JuniorForThirdGrade(languageInfoExt);
				languageExams.addAll(thirdJuniorlanguageExams);
			}

			languageExams.forEach(item -> {
				item.setId(String.valueOf(snowRakeIdGenerator.nextId()));
			});

			for (LanguageExam languageExam : languageExams) {
				languageExamDao.insert(languageExam);
			}

			return RespData.successMsg("英语四级名单生成成功！");
		}else {

			return RespData.errorMsg("条件中没有设置CET4考试！");
		}
	}

	/**
	 * 根据大一年级获取在校所有年级
	 *
	 * @param languageInfoExt
	 */
	private void getGradeArr(LanguageInfoExt languageInfoExt) {

		List<String> gradeList = new ArrayList<>();

		if(languageInfoExt.getFirstGrade() != null && !languageInfoExt.getFirstGrade().equals("")) {
			int first = Integer.parseInt(languageInfoExt.getFirstGrade());
			for(int i = first; i > first-5; i--) {
				gradeList.add(String.valueOf(i));
			}

			for(int i = 0; i < gradeList.size(); i++) {
				if(i == 1) {
					languageInfoExt.setSecondGrade(gradeList.get(i));
				}
				if(i == 2) {
					languageInfoExt.setThirdGrade(gradeList.get(i));
				}
				if(i == 3) {
					languageInfoExt.setFoGrade(gradeList.get(i));
				}
				if(i == 4) {
					languageInfoExt.setFifGrade(gradeList.get(i));
				}
			}
		}
	}

	@Override
	public RespData generateCET6() {

		LanguageInfoExt languageInfoExt = languageTjjlDao.getAllTj();

		if(languageInfoExt == null) {
			return RespData.errorMsg("条件出错！");
		}

		boolean cet6 = languageInfoExt.getCet6().equals("1");

		if(cet6) {

			List<LanguageExam> languageExamsCET6 = languageExamDao.generateCET6ForAll(languageInfoExt);

			languageExamsCET6.forEach(item -> {
				item.setId(String.valueOf(snowRakeIdGenerator.nextId()));
			});

			if(!languageExamsCET6.isEmpty()) {
				for (LanguageExam languageExam : languageExamsCET6) {
					languageExamDao.insert(languageExam);
				}
			}

			return RespData.successMsg("英语六级名单生成成功！");
		}else {
			return RespData.errorMsg("条件中没有设置CET6考试！");
		}
	}

	@Override
	public RespData generateCRT4() {

		LanguageInfoExt languageInfoExt = languageTjjlDao.getAllTj();

		if(languageInfoExt == null) {
			return RespData.errorMsg("条件出错！");
		}

		boolean crt4 = languageInfoExt.getCrt4().equals("1");

		if(crt4) {

			List<LanguageExam> languageExamsCRT4 = languageExamDao.generateCRT4ForAll(languageInfoExt);

			languageExamsCRT4.forEach(item -> {
				item.setId(String.valueOf(snowRakeIdGenerator.nextId()));
			});

			if(!languageExamsCRT4.isEmpty()) {
				for (LanguageExam languageExam : languageExamsCRT4) {
					languageExamDao.insert(languageExam);
				}
			}

			return RespData.successMsg("俄语四级名单生成成功！");
		}else {
			return RespData.errorMsg("条件中没有设置CRT4考试！");
		}
	}

	@Override
	public RespData generateCRT6() {

		LanguageInfoExt languageInfoExt = languageTjjlDao.getAllTj();

		if(languageInfoExt == null) {
			return RespData.errorMsg("条件出错！");
		}

		boolean crt6 = languageInfoExt.getCrt6().equals("1");

		if(crt6) {

			List<LanguageExam> languageExamsCRT6 = languageExamDao.generateCRT6ForAll(languageInfoExt);

			languageExamsCRT6.forEach(item -> {
				item.setId(String.valueOf(snowRakeIdGenerator.nextId()));
			});

			if(!languageExamsCRT6.isEmpty()) {
				for (LanguageExam languageExam : languageExamsCRT6) {
					languageExamDao.insert(languageExam);
				}
			}

			return RespData.successMsg("俄语六级名单生成成功！");
		}else {
			return RespData.errorMsg("条件中没有设置CRT6考试！");
		}
	}

	@Override
	public RespData generateCJT4() {

		LanguageInfoExt languageInfoExt = languageTjjlDao.getAllTj();

		if(languageInfoExt == null) {
			return RespData.errorMsg("条件出错！");
		}

		boolean cjt4 = languageInfoExt.getCjt4().equals("1");

		if(cjt4) {

			List<LanguageExam> languageExamsCJT4 = languageExamDao.generateCJT4ForAll(languageInfoExt);

			languageExamsCJT4.forEach(item -> {
				item.setId(String.valueOf(snowRakeIdGenerator.nextId()));
			});

			if(!languageExamsCJT4.isEmpty()) {
				for (LanguageExam languageExam : languageExamsCJT4) {
					languageExamDao.insert(languageExam);
				}
			}

			return RespData.successMsg("日语四级名单生成成功！");
		}else {
			return RespData.errorMsg("条件中没有设置CJT4考试！");
		}
	}

	@Override
	public RespData generateCJT6() {

		LanguageInfoExt languageInfoExt = languageTjjlDao.getAllTj();

		if(languageInfoExt == null) {
			return RespData.errorMsg("条件出错！");
		}

		boolean crt6 = languageInfoExt.getCrt6().equals("1");

		if(crt6) {

			List<LanguageExam> languageExamsCJT6 = languageExamDao.generateCJT6ForAll(languageInfoExt);

			languageExamsCJT6.forEach(item -> {
				item.setId(String.valueOf(snowRakeIdGenerator.nextId()));
			});

			if(!languageExamsCJT6.isEmpty()) {
				for (LanguageExam languageExam : languageExamsCJT6) {
					languageExamDao.insert(languageExam);
				}
			}

			return RespData.successMsg("日语六级名单生成成功！");
		}else {
			return RespData.errorMsg("条件中没有设置CJT6考试！");
		}
	}

	@Override
	public RespData generateCGT4() {

		LanguageInfoExt languageInfoExt = languageTjjlDao.getAllTj();

		if(languageInfoExt == null) {
			return RespData.errorMsg("条件出错！");
		}

		boolean cgt4 = languageInfoExt.getCgt4().equals("1");

		if(cgt4) {

			List<LanguageExam> languageExamsCGT4 = languageExamDao.generateCGT4ForAll(languageInfoExt);

			languageExamsCGT4.forEach(item -> {
				item.setId(String.valueOf(snowRakeIdGenerator.nextId()));
			});

			if(!languageExamsCGT4.isEmpty()) {
				for (LanguageExam languageExam : languageExamsCGT4) {
					languageExamDao.insert(languageExam);
				}
			}

			return RespData.successMsg("德语四级名单生成成功！");
		}else {
			return RespData.errorMsg("条件中没有设置CGT4考试！");
		}
	}

	@Override
	public RespData generateCGT6() {

		LanguageInfoExt languageInfoExt = languageTjjlDao.getAllTj();

		if(languageInfoExt == null) {
			return RespData.errorMsg("条件出错！");
		}

		boolean cgt6 = languageInfoExt.getCgt6().equals("1");

		if(cgt6) {

			List<LanguageExam> languageExamsCGT6 = languageExamDao.generateCGT6ForAll(languageInfoExt);

			languageExamsCGT6.forEach(item -> {
				item.setId(String.valueOf(snowRakeIdGenerator.nextId()));
			});

			if(!languageExamsCGT6.isEmpty()) {
				for (LanguageExam languageExam : languageExamsCGT6) {
					languageExamDao.insert(languageExam);
				}
			}

			return RespData.successMsg("日语六级名单生成成功！");
		}else {
			return RespData.errorMsg("条件中没有设置CGT6考试！");
		}
	}

	@Override
	public RespData generatePoretcoB() {

		LanguageInfoExt languageInfoExt = languageTjjlDao.getAllTj();

		if(languageInfoExt == null) {
			return RespData.errorMsg("条件出错！");
		}

		boolean poretcoB = languageInfoExt.getPretcoB().equals("1");

		if(poretcoB) {

			List<LanguageExam> languageExamsPoretcoB = languageExamDao.generatePoretcoBForAll(languageInfoExt);

			languageExamsPoretcoB.forEach(item -> {
				item.setId(String.valueOf(snowRakeIdGenerator.nextId()));
			});

			if(!languageExamsPoretcoB.isEmpty()) {
				for (LanguageExam languageExam : languageExamsPoretcoB) {
					languageExamDao.insert(languageExam);
				}
			}

			return RespData.successMsg("英语三级名单生成成功！");
		}else {
			return RespData.errorMsg("条件中没有设置PORECT-B考试！");
		}
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

    @Override
    public RespData getAllExamDate() {
		try {

			return RespData.successMsg("查询成功",cetStuscoreDao.getAllExamDate());

		}catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	/**
	 *  获取在校年级
	 *
	 * @return
	 */
    public RespData getGradeInSchool() {
		try {

			int year = LocalDate.now().getYear();
			int month = LocalDate.now().getMonth().getValue();
			List<TreeExt> grades = new ArrayList<>();
			int index = 0;
			if(month > 9) {
				index = year;
			}else {
				index = year-1;
			}

			for (int i = index; i > index-5; i--) {
				TreeExt treeExt = new TreeExt();
				treeExt.setId(String.valueOf(snowRakeIdGenerator.nextId()));
				treeExt.setText(String.valueOf(i));
				treeExt.setLevel("0");
				grades.add(treeExt);
			}

			return RespData.successMsg("查询成功",grades);

		}catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public RespData getAcademy(QueryTreeExt queryTreeExt) {
		try {
			List<String> academys = xsXjxxbViewKwDao.getAcademy(queryTreeExt.getGrade() + "级");
			List<TreeExt> treeExts = new ArrayList<>();

			for (String academy : academys) {
				TreeExt treeExt = new TreeExt();
				treeExt.setId(String.valueOf(snowRakeIdGenerator.nextId()));
				treeExt.setText(academy);
				treeExt.setLevel("1");
				treeExts.add(treeExt);
			}

			return RespData.successMsg("",treeExts);
		}catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public RespData getMajor(QueryTreeExt queryTreeExt) {
		try {
			List<String> academys = xsXjxxbViewKwDao.getMajor(queryTreeExt.getGrade() + "级",queryTreeExt.getAcademy());
			List<TreeExt> treeExts = new ArrayList<>();

			for (String academy : academys) {
				TreeExt treeExt = new TreeExt();
				treeExt.setId(String.valueOf(snowRakeIdGenerator.nextId()));
				treeExt.setText(academy);
				treeExt.setLevel("2");
				treeExts.add(treeExt);
			}

			return RespData.successMsg("",treeExts);
		}catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public RespData getClasses(QueryTreeExt queryTreeExt) {
		try {
			List<String> academys = xsXjxxbViewKwDao.getClasses(queryTreeExt.getGrade() + "级",queryTreeExt.getAcademy(),queryTreeExt.getMajor());
			List<TreeExt> treeExts = new ArrayList<>();

			for (String academy : academys) {
				TreeExt treeExt = new TreeExt();
				treeExt.setId(String.valueOf(snowRakeIdGenerator.nextId()));
				treeExt.setText(academy);
				treeExt.setLevel("3");
				treeExts.add(treeExt);
			}

			return RespData.successMsg("",treeExts);
		}catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

    @Override
    public RespData statisticReport(LangStisticExt langStisticExt) {
		try {

			// 删除旧数据
			langStisticExtDao.deleteAll();
			// 插入新数据
			langStisticExtDao.insert(langStisticExt);

			if(!langStisticExt.cleanUpStatisticType()) {
				return RespData.errorMsg("统计类别为空");
			}

			List<StatisticReport> schoolBaseNumber = null;
			if(langStisticExt.getGrade() != null && !langStisticExt.getGrade().equals("")) {
				String[] gradeArr = langStisticExt.getGrade().split(",");
				String newGradeStr = "";
				for (String grade : gradeArr) {
					String tmpGrade = grade.substring(0, grade.length() - 1) + "级\'";
					newGradeStr += tmpGrade + ",";
				}
				langStisticExt.setGrade(newGradeStr.substring(0,newGradeStr.length()-1));
			}
			schoolBaseNumber = cetStuscoreDao.statisticBaseNumberRegister(langStisticExt);

			List<StatisticReport> baseNumber = null;
			/*if(langStisticExt.getGrade() != null && !langStisticExt.getGrade().equals("")) {
				String[] gradeArr = langStisticExt.getGrade().split(",");
				String newGradeStr = "";
				for (String grade : gradeArr) {
					newGradeStr += grade.substring(1,2) + ",";
				}
				langStisticExt.setGrade(newGradeStr.substring(0,newGradeStr.length()-1));
			}*/
			baseNumber = cetStuscoreDao.statisticBaseNumberEnter(langStisticExt);

			List<StatisticReport> missingNumber = null;
			missingNumber = cetStuscoreDao.statisticMissingNumber(langStisticExt);

			List<StatisticReport> passNumber = null;
			passNumber = cetStuscoreDao.statisticPassNumber(langStisticExt);

			List<StatisticReport> avgScore = null;
			avgScore = cetStuscoreDao.statisticAvgScore(langStisticExt);

			List<StatisticReport> maxScore = null;
			maxScore = cetStuscoreDao.statisticMaxScore(langStisticExt);

			for (StatisticReport statisticReportMax : maxScore) {
				logger.debug("平均分");
				for (StatisticReport statisticReportAvg : avgScore) {
					if(statisticReportAvg.getAcademy().equals(statisticReportMax.getAcademy()) && statisticReportAvg.getMajor().equals(statisticReportMax.getMajor())
					&& statisticReportAvg.getGrade().equals(statisticReportMax.getGrade()) && statisticReportAvg.getClasses().equals(statisticReportMax.getClasses())) {
						statisticReportMax.setAvgScore(statisticReportAvg.getAvgScore());
					}
				}
				logger.debug("通过人数");
				for (StatisticReport statisticReportPass : passNumber) {
					if(statisticReportPass.getAcademy().equals(statisticReportMax.getAcademy()) && statisticReportPass.getMajor().equals(statisticReportMax.getMajor())
							&& statisticReportPass.getGrade().equals(statisticReportMax.getGrade()) && statisticReportPass.getClasses().equals(statisticReportMax.getClasses())) {
						statisticReportMax.setPassNumber(statisticReportPass.getPassNumber());
					}
				}
				logger.debug("缺考人数");
				for (StatisticReport statisticReportMissing : missingNumber) {
					if(statisticReportMissing.getAcademy().equals(statisticReportMax.getAcademy()) && statisticReportMissing.getMajor().equals(statisticReportMax.getMajor())
							&& statisticReportMissing.getGrade().equals(statisticReportMax.getGrade()) && statisticReportMissing.getClasses().equals(statisticReportMax.getClasses())) {
						statisticReportMax.setMissingNumber(statisticReportMissing.getMissingNumber());
					}
				}
				logger.debug("报考人数");
				for (StatisticReport statisticReportBase: baseNumber) {
					if(statisticReportBase.getAcademy().equals(statisticReportMax.getAcademy()) && statisticReportBase.getMajor().equals(statisticReportMax.getMajor())
							&& statisticReportBase.getGrade().equals(statisticReportMax.getGrade()) && statisticReportBase.getClasses().equals(statisticReportMax.getClasses())) {
						statisticReportMax.setBaseNumber(statisticReportBase.getBaseNumber());
					}
				}
				logger.debug("学籍");
				if(null != schoolBaseNumber) {
					for (StatisticReport statisticReportSchool: schoolBaseNumber) {
						if(statisticReportSchool.getClasses().equals(statisticReportMax.getClasses())) {
							statisticReportMax.setSchoolNumber(statisticReportSchool.getSchoolNumber());
						}
					}
				}
			}

			for (StatisticReport statisticReport : maxScore) {
				statisticReport.setActualNumber(statisticReport.getBaseNumber()-statisticReport.getMissingNumber());
				if(!statisticReport.getBaseNumber().equals(0)) {
					logger.debug(statisticReport.getBaseNumber().toString());
					statisticReport.setMissingRate(new BigDecimal(statisticReport.getMissingNumber().doubleValue() / statisticReport.getBaseNumber().doubleValue()).setScale(4, BigDecimal.ROUND_HALF_UP).multiply(new BigDecimal(100)));
					statisticReport.setPassRate(new BigDecimal(statisticReport.getPassNumber().doubleValue()/statisticReport.getBaseNumber().doubleValue()).setScale(4,BigDecimal.ROUND_HALF_UP).multiply(new BigDecimal(100)));
				}else {
					statisticReport.setMissingRate(new BigDecimal(0));
					statisticReport.setPassRate(new BigDecimal(0));
				}
				if(!statisticReport.getSchoolNumber().equals(0)) {
					logger.debug(statisticReport.getSchoolNumber().toString());
					statisticReport.setSchoolPassRate(new BigDecimal(statisticReport.getPassNumber().doubleValue()/statisticReport.getSchoolNumber().doubleValue()).setScale(4,BigDecimal.ROUND_HALF_UP).multiply(new BigDecimal(100)));
				}else {
					statisticReport.setSchoolPassRate(new BigDecimal(0));
				}
			}

			statisticReportDao.deleteAll();
			for (StatisticReport statisticReport : maxScore) {
				statisticReportDao.insert(statisticReport);
			}

			return RespData.successMsg("统计成功！",1);
		} catch (Exception e) {
			e.printStackTrace();
			logger.debug("系统错误：" + e.toString());
			throw e;
		}
	}

    @Override
    public void exportStatistic(HttpServletResponse response) {
        try {

			// 查询统计好的数据
			List<StatisticReportExcel> statisticReportExcels = statisticReportDao.getAll();

			List<LangStisticExt> langStisticExts = langStisticExtDao.getOne();

			LangStisticExt langStisticExt = null;
			if(langStisticExts != null && langStisticExts.size() >= 0) {
				langStisticExt = langStisticExts.get(0);
				langStisticExt.cleanUpStatisticType();
			}

			// 分组合计
			statisticReportExcels = this.getSumList(statisticReportExcels,langStisticExt);

			Workbook workbook = this.getExcelWorkBook(statisticReportExcels,langStisticExt);

			if(workbook == null) {
				throw new CustomException("创建workbook失败!");
			}

			ExcelUtiles.baseExportExcel("语种考试统计报表.xlsx",response,workbook);
		}catch (Exception e) {
        	e.printStackTrace();
        	throw e;
		}
    }

	@Override
	public List<LanguageExam> getAllByType(String exportType) {
    	return languageExamDao.getAllByType(exportType);
	}

    // 分组合计并插入
	private List<StatisticReportExcel> getSumList(List<StatisticReportExcel> statisticReportExcels, LangStisticExt langStisticExt) {

		// 按语种类别合计
		List<StatisticReportExcel> statisticReportExcelsByLangType = new ArrayList<>();
		if(langStisticExt.getHasAcademy()) {
			statisticReportExcelsByLangType = statisticReportDao.sumByLangType();
			for (StatisticReportExcel statisticReportExcel : statisticReportExcelsByLangType) {
				BigDecimal missingRate = new BigDecimal(statisticReportExcel.getMissingNumber()).divide(new BigDecimal(statisticReportExcel.getBaseNumber()), 4, BigDecimal.ROUND_UP).multiply(new BigDecimal(100)).setScale(2,BigDecimal.ROUND_UP);
				statisticReportExcel.setMissingRate(missingRate.toString());
				if (statisticReportExcel.getSchoolNumber().equals("0")) {
					statisticReportExcel.setSchoolNumber(statisticReportExcel.getBaseNumber());
				}
				BigDecimal schoolPassRate = new BigDecimal(statisticReportExcel.getPassNumber()).divide(new BigDecimal(statisticReportExcel.getSchoolNumber()), 4, BigDecimal.ROUND_UP).multiply(new BigDecimal(100)).setScale(2,BigDecimal.ROUND_UP);
				statisticReportExcel.setSchoolPassRate(schoolPassRate.toString());
				BigDecimal passRate = new BigDecimal(statisticReportExcel.getPassNumber()).divide(new BigDecimal(statisticReportExcel.getBaseNumber()), 4, BigDecimal.ROUND_UP).multiply(new BigDecimal(100)).setScale(2,BigDecimal.ROUND_UP);
				statisticReportExcel.setPassRate(passRate.toString());
			}
		}
		// 按学院合计
		List<StatisticReportExcel> statisticReportExcelsByAcademy = new ArrayList<>();
		if(langStisticExt.getHasMajor()) {
			statisticReportExcelsByAcademy = statisticReportDao.sumByAcademy();
			for (StatisticReportExcel statisticReportExcel : statisticReportExcelsByAcademy) {
				BigDecimal missingRate = new BigDecimal(statisticReportExcel.getMissingNumber()).divide(new BigDecimal(statisticReportExcel.getBaseNumber()),4,BigDecimal.ROUND_UP).multiply(new BigDecimal(100)).setScale(2,BigDecimal.ROUND_UP);
				statisticReportExcel.setMissingRate(missingRate.toString());
				if(statisticReportExcel.getSchoolNumber().equals("0")) {
					statisticReportExcel.setSchoolNumber(statisticReportExcel.getBaseNumber());
				}
				BigDecimal schoolPassRate = new BigDecimal(statisticReportExcel.getPassNumber()).divide(new BigDecimal(statisticReportExcel.getSchoolNumber()),4, BigDecimal.ROUND_UP).multiply(new BigDecimal(100)).setScale(2,BigDecimal.ROUND_UP);
				statisticReportExcel.setSchoolPassRate(schoolPassRate.toString());
				BigDecimal passRate = new BigDecimal(statisticReportExcel.getPassNumber()).divide(new BigDecimal(statisticReportExcel.getBaseNumber()),4, BigDecimal.ROUND_UP).multiply(new BigDecimal(100)).setScale(2,BigDecimal.ROUND_UP);
				statisticReportExcel.setPassRate(passRate.toString());
			}
		}

		// 按专业合计
		List<StatisticReportExcel> statisticReportExcelsByMajor = new ArrayList<>();
		if(langStisticExt.getHasGrade()) {
			statisticReportExcelsByMajor = statisticReportDao.sumByMajor();
			for (StatisticReportExcel statisticReportExcel : statisticReportExcelsByMajor) {
				BigDecimal missingRate = new BigDecimal(statisticReportExcel.getMissingNumber()).divide(new BigDecimal(statisticReportExcel.getBaseNumber()), 4, BigDecimal.ROUND_UP).multiply(new BigDecimal(100)).setScale(2,BigDecimal.ROUND_UP);
				statisticReportExcel.setMissingRate(missingRate.toString());
				if (statisticReportExcel.getSchoolNumber().equals("0")) {
					statisticReportExcel.setSchoolNumber(statisticReportExcel.getBaseNumber());
				}
				BigDecimal schoolPassRate = new BigDecimal(statisticReportExcel.getPassNumber()).divide(new BigDecimal(statisticReportExcel.getSchoolNumber()), 4, BigDecimal.ROUND_UP).multiply(new BigDecimal(100)).setScale(2,BigDecimal.ROUND_UP);
				statisticReportExcel.setSchoolPassRate(schoolPassRate.toString());
				BigDecimal passRate = new BigDecimal(statisticReportExcel.getPassNumber()).divide(new BigDecimal(statisticReportExcel.getBaseNumber()), 4, BigDecimal.ROUND_UP).multiply(new BigDecimal(100)).setScale(2,BigDecimal.ROUND_UP);
				statisticReportExcel.setPassRate(passRate.toString());
			}
		}
		// 按年级合计
		List<StatisticReportExcel> statisticReportExcelsByGrade = new ArrayList<>();
		if(langStisticExt.getHasClasses()) {
			statisticReportExcelsByGrade = statisticReportDao.sumByGrade();
			for (StatisticReportExcel statisticReportExcel : statisticReportExcelsByGrade) {
				BigDecimal missingRate = new BigDecimal(statisticReportExcel.getMissingNumber()).divide(new BigDecimal(statisticReportExcel.getBaseNumber()),4,BigDecimal.ROUND_UP).multiply(new BigDecimal(100)).setScale(2,BigDecimal.ROUND_UP);
				statisticReportExcel.setMissingRate(missingRate.toString());
				if(statisticReportExcel.getSchoolNumber().equals("0")) {
					statisticReportExcel.setSchoolNumber(statisticReportExcel.getBaseNumber());
				}
				BigDecimal schoolPassRate = new BigDecimal(statisticReportExcel.getPassNumber()).divide(new BigDecimal(statisticReportExcel.getSchoolNumber()),4, BigDecimal.ROUND_UP).multiply(new BigDecimal(100)).setScale(2,BigDecimal.ROUND_UP);
				statisticReportExcel.setSchoolPassRate(schoolPassRate.toString());
				BigDecimal passRate = new BigDecimal(statisticReportExcel.getPassNumber()).divide(new BigDecimal(statisticReportExcel.getBaseNumber()),4, BigDecimal.ROUND_UP).multiply(new BigDecimal(100)).setScale(2,BigDecimal.ROUND_UP);
				statisticReportExcel.setPassRate(passRate.toString());
			}
		}

		StatisticStruct statisticStruct = new StatisticStruct(statisticReportExcels,statisticReportExcelsByLangType,statisticReportExcelsByAcademy,statisticReportExcelsByMajor,statisticReportExcelsByGrade);

		List<StatisticReportExcel> statisticReportExcelsCalc = statisticStruct.getStatisticStruct().insertCalcStatisticStruct().getCalcStatisticStruct().getStatisticReportExcelsCalc();

		return statisticReportExcelsCalc;
	}

	private Workbook getExcelWorkBook(List<StatisticReportExcel> statisticReportExcels, LangStisticExt langStisticExt) {
		Workbook workbook = new SXSSFWorkbook();

		CellStyle cellStyleValue = workbook.createCellStyle();
		cellStyleValue.setBorderBottom(BorderStyle.THIN); //下边框
		cellStyleValue.setBorderLeft(BorderStyle.THIN);//左边框
		cellStyleValue.setBorderTop(BorderStyle.THIN);//上边框
		cellStyleValue.setBorderRight(BorderStyle.THIN);//右边框
		cellStyleValue.setAlignment(HorizontalAlignment.CENTER); // 居中
		cellStyleValue.setVerticalAlignment(VerticalAlignment.CENTER); // 居中

		CellStyle cellStyleTitle = workbook.createCellStyle();
		cellStyleTitle.setBorderBottom(BorderStyle.THIN); //下边框
		cellStyleTitle.setBorderLeft(BorderStyle.THIN);//左边框
		cellStyleTitle.setBorderTop(BorderStyle.THIN);//上边框
		cellStyleTitle.setBorderRight(BorderStyle.THIN);//右边框
		cellStyleTitle.setAlignment(HorizontalAlignment.CENTER); // 居中
		Font font = workbook.createFont();
		font.setBold(true);
		cellStyleTitle.setFont(font);

		CellStyle cellStyleCalc = workbook.createCellStyle();
		cellStyleTitle.setBorderBottom(BorderStyle.THIN); //下边框
		cellStyleTitle.setBorderLeft(BorderStyle.THIN);//左边框
		cellStyleTitle.setBorderTop(BorderStyle.THIN);//上边框
		cellStyleTitle.setBorderRight(BorderStyle.THIN);//右边框
		cellStyleTitle.setAlignment(HorizontalAlignment.CENTER); // 居中
		Font font_color = workbook.createFont();
		font_color.setBold(true);
		font_color.setColor(Font.COLOR_RED);
		cellStyleTitle.setFont(font);

		if(langStisticExt == null) {
			return null;
		}

		Sheet statisticSheet = workbook.createSheet("报表");

		int column = 0;
		if(langStisticExt.getDataSource().equals("1,2")) {
			column = 15;
		}else if(langStisticExt.getDataSource().equals("1")) {
			column = 14;
		}else if(langStisticExt.getDataSource().equals("2")) {
			column = 13;
		}

		// 设置列宽
		for (int i = 0; i < column; i++) {
			statisticSheet.setColumnWidth(i, 6000);
		}

		// 设置标题
		this.setTitle(column,statisticSheet,cellStyleTitle);

		// 填写数据并统计合并列位置
		Map<Integer,Integer> region = new TreeMap<>();
		Iterator<StatisticReportExcel> iterator = statisticReportExcels.iterator();
		int i = 0;
		while (iterator.hasNext()) {
			StatisticReportExcel next = iterator.next();
			if(next == null) {
				continue;
			}
			i++;
			Row row = statisticSheet.createRow(i);
			row.setHeightInPoints(20);
			for (int j = 0; j < column; j++) {
				Cell cell = row.createCell(j);
				cell.setCellStyle(cellStyleValue);
				if(0 == j) {
					cell.setCellValue(next.getLangType());
				}
				if(1 == j) {
					String academy = next.getAcademy();
					cell.setCellValue(academy);
					if(academy != null && !academy.equals("") && next.getAcademy().equals("合计")) {
						region.put(i,1);
					}
				}
				if(2 == j) {
					String major = next.getMajor();
					cell.setCellValue(major);
					if(major != null && !major.equals("") && next.getMajor().equals("合计")) {
						region.put(i,2);
					}
				}
				if(3 == j) {
					String grade = next.getGrade();
					cell.setCellValue(grade);
					if(grade != null && !grade.equals("") && next.getGrade().equals("合计")) {
						region.put(i,3);
					}
				}
				if(4 == j) {
					cell.setCellValue(next.getClasses());
				}
				if(5 == j) {
					if(column == 15 || column == 14) {
						cell.setCellValue(next.getSchoolNumber());
					}else {
						cell.setCellValue(next.getBaseNumber());
					}
				}
				if(6 == j) {
					if(column == 15 || column == 14) {
						cell.setCellValue(next.getBaseNumber());
					}else {
						cell.setCellValue(next.getActualNumber());
					}
				}
				if(7 == j) {
					if(column == 15 || column == 14) {
						cell.setCellValue(next.getActualNumber());
					}else {
						cell.setCellValue(next.getMissingNumber());
					}
				}
				if(8 == j) {
					if(column == 15 || column == 14) {
						cell.setCellValue(next.getMissingNumber());
					}else {
						cell.setCellValue(next.getMissingRate()+"%");
					}
				}
				if(9 == j) {
					if(column == 15 || column == 14) {
						cell.setCellValue(next.getMissingRate()+"%");
					}else {
						cell.setCellValue(next.getPassNumber());
					}
				}
				if(10 == j) {
					if(column == 15 || column == 14) {
						cell.setCellValue(next.getPassNumber());
					}else {
						if(column == 13) {
							cell.setCellValue(next.getPassRate() + "%");
						}else {
							cell.setCellValue(next.getAvgScore());
						}
					}
				}
				if(11 == j) {
					if(column == 15 || column == 14) {
						cell.setCellValue(next.getSchoolPassRate() + "%");
					}else {
						if(column == 13) {
							cell.setCellValue(next.getAvgScore());
						}else {
							cell.setCellValue(next.getMaxScore());
						}
					}
				}
				if(12 == j) {
					if(column == 15) {
						cell.setCellValue(next.getPassRate() + "%");
					}else {
						if(column == 13) {
							cell.setCellValue(next.getMaxScore());
						}else {
							cell.setCellValue(next.getAvgScore());
						}
					}
				}
				if(13 == j) {
					if(column == 15) {
						cell.setCellValue(next.getAvgScore());
					}else if(column == 14) {
						cell.setCellValue(next.getMaxScore());
					}
				}
				if(14 == j) {
					if(column == 15) {
						cell.setCellValue(next.getMaxScore());
					}
				}
			}
		}

		// 合并列
		for (Integer row : region.keySet()) {
			Integer col = region.get(row);
			if(1 == col) {
				CellRangeAddress regionMerge = new CellRangeAddress(row,row,col,col+3);
				statisticSheet.addMergedRegion(regionMerge);
			}else if(2 == col) {
				CellRangeAddress regionMerge = new CellRangeAddress(row,row,col,col+2);
				statisticSheet.addMergedRegion(regionMerge);
			}else if(3 == col) {
				CellRangeAddress regionMerge = new CellRangeAddress(row,row,col,col+1);
				statisticSheet.addMergedRegion(regionMerge);
			}
		}

		//合并行

		//删除列

		return workbook;
	}

	/**
	 * 设置表头
	 *
	 * @param column
	 * @param statisticSheet
	 * @param cellStyleTitle
	 */
	private void setTitle(int column, Sheet statisticSheet, CellStyle cellStyleTitle) {
		// 设置表头
		Row titleRow = statisticSheet.createRow(0);
		titleRow.setHeightInPoints(30);
		for (int i = 0; i < column; i++) {
			titleRow.createCell(i);
		}
		titleRow.getCell(0).setCellValue("语种类别");
		titleRow.getCell(0).setCellStyle(cellStyleTitle);
		titleRow.getCell(1).setCellValue("学院");
		titleRow.getCell(1).setCellStyle(cellStyleTitle);
		titleRow.getCell(2).setCellValue("专业");
		titleRow.getCell(2).setCellStyle(cellStyleTitle);
		titleRow.getCell(3).setCellValue("年级");
		titleRow.getCell(3).setCellStyle(cellStyleTitle);
		titleRow.getCell(4).setCellValue("班级");
		titleRow.getCell(4).setCellStyle(cellStyleTitle);
		if(column == 15 || column == 14) {
			titleRow.getCell(5).setCellValue("学籍人数");
			titleRow.getCell(5).setCellStyle(cellStyleTitle);
		}else if(column == 13) {
			titleRow.getCell(5).setCellValue("报考人数");
			titleRow.getCell(5).setCellStyle(cellStyleTitle);
		}
		if(column == 15 || column == 14) {
			titleRow.getCell(6).setCellValue("报考人数");
			titleRow.getCell(6).setCellStyle(cellStyleTitle);
		}else if(column == 13) {
			titleRow.getCell(6).setCellValue("实考人数");
			titleRow.getCell(6).setCellStyle(cellStyleTitle);
		}
		if(column == 15 || column == 14) {
			titleRow.getCell(7).setCellValue("实考人数");
			titleRow.getCell(7).setCellStyle(cellStyleTitle);
		}else if(column == 13) {
			titleRow.getCell(7).setCellValue("缺考人数");
			titleRow.getCell(7).setCellStyle(cellStyleTitle);
		}
		if(column == 15 || column == 14) {
			titleRow.getCell(8).setCellValue("缺考人数");
			titleRow.getCell(8).setCellStyle(cellStyleTitle);
		}else if(column == 13) {
			titleRow.getCell(8).setCellValue("缺考率");
			titleRow.getCell(8).setCellStyle(cellStyleTitle);
		}
		if(column == 15 || column == 14) {
			titleRow.getCell(9).setCellValue("缺考率");
			titleRow.getCell(9).setCellStyle(cellStyleTitle);
		}else if(column == 13) {
			titleRow.getCell(9).setCellValue("通过人数");
			titleRow.getCell(9).setCellStyle(cellStyleTitle);
		}
		if(column == 15 || column == 14) {
			titleRow.getCell(10).setCellValue("通过人数");
			titleRow.getCell(10).setCellStyle(cellStyleTitle);
		}else if(column == 13) {
			titleRow.getCell(10).setCellValue("通过率(报考)");
			titleRow.getCell(10).setCellStyle(cellStyleTitle);
		}
		if(column == 15 || column == 14) {
			titleRow.getCell(11).setCellValue("通过率(学籍)");
			titleRow.getCell(11).setCellStyle(cellStyleTitle);
		}else if(column == 13) {
			titleRow.getCell(11).setCellValue("平均分数");
			titleRow.getCell(11).setCellStyle(cellStyleTitle);
		}
		if(column == 15) {
			titleRow.getCell(12).setCellValue("通过率(报考)");
			titleRow.getCell(12).setCellStyle(cellStyleTitle);
		}else if(column == 14) {
			titleRow.getCell(12).setCellValue("平均分数");
			titleRow.getCell(12).setCellStyle(cellStyleTitle);
		}else if(column == 13) {
			titleRow.getCell(12).setCellValue("最高分数");
			titleRow.getCell(12).setCellStyle(cellStyleTitle);
		}
		if(column == 15) {
			titleRow.getCell(13).setCellValue("平均分数");
			titleRow.getCell(13).setCellStyle(cellStyleTitle);
		}else if(column == 14) {
			titleRow.getCell(13).setCellValue("最高分数");
			titleRow.getCell(13).setCellStyle(cellStyleTitle);
		}
		if(column == 15) {
			titleRow.getCell(14).setCellValue("最高分数");
			titleRow.getCell(14).setCellStyle(cellStyleTitle);
		}
	}

	/**
	 * 删除列，把每一个行的属于删除列的单元格，删除，在把后面的单元格依次向前移动
	 *
	 * @param sheet
	 * @param removeColumnNum
	 * @param removeColumnTotal
	 */
	public static void removeColumn(Sheet sheet, int removeColumnNum, int removeColumnTotal){

		if(sheet == null){
			return;
		}
		for (Iterator<Row> rowIterator = sheet.rowIterator(); rowIterator.hasNext();) {
			Row row = rowIterator.next();
			Cell cell = row.getCell(removeColumnNum);
			if(cell == null){
				continue;
			}
			row.removeCell(cell);

			for(int n = removeColumnNum; n < (removeColumnTotal + removeColumnNum); n++){
				row.shiftCellsLeft(n,n+1,1);
			}
		}
	}
}