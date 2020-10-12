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
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
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

			List<String> gardeList = this.getGradeArr(languageInfoExt.getFirstGrade());

			// 分年级筛选，本科类型与特殊学院置于sql语句中

			// 大一年级
			if("1".equals(languageInfoExt.getIsFirstGrade())) {

			}

			// 大二年级
			if("1".equals(languageInfoExt.getIsSecondGrade())) {

			}

			// 大三年级
			if("1".equals(languageInfoExt.getIsThirdGrade())) {

			}

			// 大四年级
			if("1".equals(languageInfoExt.getIsFoGrade())) {

			}


			return RespData.successMsg("英语四级名单生成成功！");
		}else {

			return RespData.errorMsg("条件中没有设置CET4考试！");
		}
	}

	private List<String> getGradeArr(String firstGrade) {

		List<String> gradeList = new ArrayList<>();

		if(firstGrade != null && !firstGrade.equals("")) {
			int first = Integer.parseInt(firstGrade);
			for(int i = first; i > first-5; i--) {
				gradeList.add(String.valueOf(i));
			}
		}

		return gradeList;
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

			List<StatisticReport> schoolBaseNumber = null;
			if(langStisticExt.getGrade() != null && !langStisticExt.getGrade().equals("")) {
				String[] gradeArr = langStisticExt.getGrade().split(",");
				String newGradeStr = "";
				for (String grade : gradeArr) {
					newGradeStr += grade + "级" + ",";
				}
				langStisticExt.setGrade(newGradeStr.substring(0,newGradeStr.length()-1));
			}
			schoolBaseNumber = cetStuscoreDao.statisticBaseNumberRegister(langStisticExt);

			List<StatisticReport> baseNumber = null;
			if(langStisticExt.getGrade() != null && !langStisticExt.getGrade().equals("")) {
				String[] gradeArr = langStisticExt.getGrade().split(",");
				String newGradeStr = "";
				for (String grade : gradeArr) {
					newGradeStr += grade.substring(0,2) + ",";
				}
				langStisticExt.setGrade(newGradeStr.substring(0,newGradeStr.length()-1));
			}
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
				for (StatisticReport statisticReportAvg : avgScore) {
					if(statisticReportAvg.getAcademy().equals(statisticReportMax.getAcademy()) && statisticReportAvg.getMajor().equals(statisticReportMax.getMajor())
					&& statisticReportAvg.getGrade().equals(statisticReportMax.getGrade()) && statisticReportAvg.getClasses().equals(statisticReportMax.getClasses())) {
						statisticReportMax.setAvgScore(statisticReportAvg.getAvgScore());
					}
				}
				for (StatisticReport statisticReportPass : passNumber) {
					if(statisticReportPass.getAcademy().equals(statisticReportMax.getAcademy()) && statisticReportPass.getMajor().equals(statisticReportMax.getMajor())
							&& statisticReportPass.getGrade().equals(statisticReportMax.getGrade()) && statisticReportPass.getClasses().equals(statisticReportMax.getClasses())) {
						statisticReportMax.setPassNumber(statisticReportPass.getPassNumber());
					}
				}
				for (StatisticReport statisticReportMissing : missingNumber) {
					if(statisticReportMissing.getAcademy().equals(statisticReportMax.getAcademy()) && statisticReportMissing.getMajor().equals(statisticReportMax.getMajor())
							&& statisticReportMissing.getGrade().equals(statisticReportMax.getGrade()) && statisticReportMissing.getClasses().equals(statisticReportMax.getClasses())) {
						statisticReportMax.setMissingNumber(statisticReportMissing.getMissingNumber());
					}
				}
				for (StatisticReport statisticReportBase: baseNumber) {
					if(statisticReportBase.getAcademy().equals(statisticReportMax.getAcademy()) && statisticReportBase.getMajor().equals(statisticReportMax.getMajor())
							&& statisticReportBase.getGrade().equals(statisticReportMax.getGrade()) && statisticReportBase.getClasses().equals(statisticReportMax.getClasses())) {
						statisticReportMax.setBaseNumber(statisticReportBase.getBaseNumber());
					}
				}
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
				statisticReport.setMissingRate(new BigDecimal(statisticReport.getMissingNumber().doubleValue()/statisticReport.getBaseNumber().doubleValue()).setScale(4,BigDecimal.ROUND_HALF_UP).multiply(new BigDecimal(100)));
				statisticReport.setPassRate(new BigDecimal(statisticReport.getPassNumber().doubleValue()/statisticReport.getBaseNumber().doubleValue()).setScale(4,BigDecimal.ROUND_HALF_UP).multiply(new BigDecimal(100)));
				if(langStisticExt.getDataSource().equals("1")) {
					statisticReport.setSchoolPassRate(new BigDecimal(statisticReport.getPassNumber().doubleValue()/statisticReport.getSchoolNumber().doubleValue()).setScale(4,BigDecimal.ROUND_HALF_UP).multiply(new BigDecimal(100)));
				}
			}

			statisticReportDao.deleteAll();
			for (StatisticReport statisticReport : maxScore) {
				statisticReportDao.insert(statisticReport);
			}

			return RespData.successMsg("统计成功！",1);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

    @Override
    public void exportStatistic(HttpServletResponse response) {
        try {

			// 查询统计好的数据
			List<StatisticReportExcel> statisticReportExcels = statisticReportDao.getAll();

			List<LangStisticExt> langStisticExts = langStisticExtDao.getOne();

			// 分组合计
			statisticReportExcels = this.getSumList(statisticReportExcels);

			LangStisticExt langStisticExt = null;
			if(langStisticExts != null && langStisticExts.size() >= 0) {
				langStisticExt = langStisticExts.get(0);
			}

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

    // 分组合计并插入
	private List<StatisticReportExcel> getSumList(List<StatisticReportExcel> statisticReportExcels) {

		// 按语种类别合计
		List<StatisticReportExcel> statisticReportExcelsByLangType = statisticReportDao.sumByLangType();
		for (StatisticReportExcel statisticReportExcel : statisticReportExcelsByLangType) {
			BigDecimal missingRate = new BigDecimal(statisticReportExcel.getMissingNumber()).divide(new BigDecimal(statisticReportExcel.getBaseNumber()),2,BigDecimal.ROUND_UP);
			statisticReportExcel.setMissingRate(missingRate.toString());
			BigDecimal schoolPassRate = new BigDecimal(statisticReportExcel.getPassNumber()).divide(new BigDecimal(statisticReportExcel.getSchoolNumber()),2, BigDecimal.ROUND_UP);
			statisticReportExcel.setSchoolPassRate(schoolPassRate.toString());
			BigDecimal passRate = new BigDecimal(statisticReportExcel.getPassNumber()).divide(new BigDecimal(statisticReportExcel.getBaseNumber()),2, BigDecimal.ROUND_UP);
			statisticReportExcel.setPassRate(passRate.toString());
		}
		// 按学院合计
		List<StatisticReportExcel> statisticReportExcelsByAcademy = statisticReportDao.sumByAcademy();
		for (StatisticReportExcel statisticReportExcel : statisticReportExcelsByAcademy) {
			BigDecimal missingRate = new BigDecimal(statisticReportExcel.getMissingNumber()).divide(new BigDecimal(statisticReportExcel.getBaseNumber()),2,BigDecimal.ROUND_UP);
			statisticReportExcel.setMissingRate(missingRate.toString());
			BigDecimal schoolPassRate = new BigDecimal(statisticReportExcel.getPassNumber()).divide(new BigDecimal(statisticReportExcel.getSchoolNumber()),2, BigDecimal.ROUND_UP);
			statisticReportExcel.setSchoolPassRate(schoolPassRate.toString());
			BigDecimal passRate = new BigDecimal(statisticReportExcel.getPassNumber()).divide(new BigDecimal(statisticReportExcel.getBaseNumber()),2, BigDecimal.ROUND_UP);
			statisticReportExcel.setPassRate(passRate.toString());
		}
		// 按专业合计
		List<StatisticReportExcel> statisticReportExcelsByMajor = statisticReportDao.sumByMajor();
		for (StatisticReportExcel statisticReportExcel : statisticReportExcelsByMajor) {
			BigDecimal missingRate = new BigDecimal(statisticReportExcel.getMissingNumber()).divide(new BigDecimal(statisticReportExcel.getBaseNumber()),2,BigDecimal.ROUND_UP);
			statisticReportExcel.setMissingRate(missingRate.toString());
			BigDecimal schoolPassRate = new BigDecimal(statisticReportExcel.getPassNumber()).divide(new BigDecimal(statisticReportExcel.getSchoolNumber()),2, BigDecimal.ROUND_UP);
			statisticReportExcel.setSchoolPassRate(schoolPassRate.toString());
			BigDecimal passRate = new BigDecimal(statisticReportExcel.getPassNumber()).divide(new BigDecimal(statisticReportExcel.getBaseNumber()),2, BigDecimal.ROUND_UP);
			statisticReportExcel.setPassRate(passRate.toString());
		}
		// 按年级合计
		List<StatisticReportExcel> statisticReportExcelsByGrade = statisticReportDao.sumByGrade();
		for (StatisticReportExcel statisticReportExcel : statisticReportExcelsByGrade) {
			BigDecimal missingRate = new BigDecimal(statisticReportExcel.getMissingNumber()).divide(new BigDecimal(statisticReportExcel.getBaseNumber()),2,BigDecimal.ROUND_UP);
			statisticReportExcel.setMissingRate(missingRate.toString());
			BigDecimal schoolPassRate = new BigDecimal(statisticReportExcel.getPassNumber()).divide(new BigDecimal(statisticReportExcel.getSchoolNumber()),2, BigDecimal.ROUND_UP);
			statisticReportExcel.setSchoolPassRate(schoolPassRate.toString());
			BigDecimal passRate = new BigDecimal(statisticReportExcel.getPassNumber()).divide(new BigDecimal(statisticReportExcel.getBaseNumber()),2, BigDecimal.ROUND_UP);
			statisticReportExcel.setPassRate(passRate.toString());
		}

		StatisticStruct statisticStruct = new StatisticStruct(statisticReportExcels,statisticReportExcelsByLangType,statisticReportExcelsByAcademy,statisticReportExcelsByMajor,statisticReportExcelsByGrade);

		List<StatisticReportExcel> statisticReportExcelsCalc = statisticStruct.getStatisticStruct().insertCalcStatisticStruct().getCalcStatisticStruct().getStatisticReportExcelsCalc();

		return statisticReportExcelsCalc;
	}

	private Workbook getExcelWorkBook(List<StatisticReportExcel> statisticReportExcels, LangStisticExt langStisticExt) {
		Workbook workbook = new SXSSFWorkbook();

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

		for (int i = 0; i < statisticReportExcels.size(); i++) {
			Row row = statisticSheet.createRow(i);
			for (int j = 0; j < column; j++) {
				Cell cell = row.createCell(j);
				if(0 == j) {
					cell.setCellValue(statisticReportExcels.get(i).getLangType());
				}
				if(1 == j) {
					cell.setCellValue(statisticReportExcels.get(i).getAcademy());
				}
				if(2 == j) {
					cell.setCellValue(statisticReportExcels.get(i).getMajor());
				}
				if(3 == j) {
					cell.setCellValue(statisticReportExcels.get(i).getGrade());
				}
				if(4 == j) {
					cell.setCellValue(statisticReportExcels.get(i).getClasses());
				}
				if(5 == j) {
					if(column == 15 || column == 14) {
						cell.setCellValue(statisticReportExcels.get(i).getSchoolNumber());
					}else {
						cell.setCellValue(statisticReportExcels.get(i).getBaseNumber());
					}
				}
				if(6 == j) {
					if(column == 15 || column == 14) {
						cell.setCellValue(statisticReportExcels.get(i).getBaseNumber());
					}else {
						cell.setCellValue(statisticReportExcels.get(i).getActualNumber());
					}
				}
				if(7 == j) {
					if(column == 15 || column == 14) {
						cell.setCellValue(statisticReportExcels.get(i).getActualNumber());
					}else {
						cell.setCellValue(statisticReportExcels.get(i).getMissingNumber());
					}
				}
				if(8 == j) {
					if(column == 15 || column == 14) {
						cell.setCellValue(statisticReportExcels.get(i).getMissingNumber());
					}else {
						cell.setCellValue(statisticReportExcels.get(i).getMissingRate()+"%");
					}
				}
				if(9 == j) {
					if(column == 15 || column == 14) {
						cell.setCellValue(statisticReportExcels.get(i).getMissingRate()+"%");
					}else {
						cell.setCellValue(statisticReportExcels.get(i).getPassNumber());
					}
				}
				if(10 == j) {
					if(column == 15 || column == 14) {
						cell.setCellValue(statisticReportExcels.get(i).getPassNumber());
					}else {
						if(column == 13) {
							cell.setCellValue(statisticReportExcels.get(i).getPassRate() + "%");
						}else {
							cell.setCellValue(statisticReportExcels.get(i).getAvgScore());
						}
					}
				}
				if(11 == j) {
					if(column == 15 || column == 14) {
						cell.setCellValue(statisticReportExcels.get(i).getSchoolPassRate() + "%");
					}else {
						if(column == 13) {
							cell.setCellValue(statisticReportExcels.get(i).getAvgScore());
						}else {
							cell.setCellValue(statisticReportExcels.get(i).getMaxScore());
						}
					}
				}
				if(12 == j) {
					if(column == 15) {
						cell.setCellValue(statisticReportExcels.get(i).getPassRate() + "%");
					}else {
						if(column == 13) {
							cell.setCellValue(statisticReportExcels.get(i).getMaxScore());
						}else {
							cell.setCellValue(statisticReportExcels.get(i).getAvgScore());
						}
					}
				}
				if(13 == j) {
					if(column == 15) {
						cell.setCellValue(statisticReportExcels.get(i).getAvgScore());
					}else if(column == 14) {
						cell.setCellValue(statisticReportExcels.get(i).getMaxScore());
					}
				}
				if(14 == j) {
					if(column == 15) {
						cell.setCellValue(statisticReportExcels.get(i).getMaxScore());
					}
				}
			}
		}

		return workbook;
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