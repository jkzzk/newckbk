package com.imust.newckbk.service.impl;
import com.imust.newckbk.domain.excel.StatisticReport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imust.newckbk.dao.StatisticReportDao;
import com.imust.newckbk.service.StatisticReportService;
import com.imust.newckbk.base.AbstractService;
import javax.annotation.PostConstruct;


/**
* @date 2020-10-08
* @author jkzzk
* 
*/
@Service("statisticReportService")
public class StatisticReportServiceImpl extends AbstractService<StatisticReport, String> implements StatisticReportService {

	@Autowired
	private StatisticReportDao statisticReportDao;

	@PostConstruct
	public void setBaseDao() {
		super.setBaseDao(statisticReportDao);
	}
}