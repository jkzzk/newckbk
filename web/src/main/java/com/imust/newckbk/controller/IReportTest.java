package com.imust.newckbk.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.hssf.util.HSSFColor;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.imust.newckbk.utils.ireport.ExportBeanFactory;
import com.imust.newckbk.utils.ireport.IReportUtils;
import com.imust.newckbk.utils.ireport.bean.*;

@Controller
public class IReportTest {
    @RequestMapping("/testWebAttachmentExportPDF")
    public void testWebAttachmentExportPDF() {
        Map<String, Object> objectObjectHashMap = new HashMap<>();

        objectObjectHashMap.put("tradingDayOfStr", "2018-01-01");
        objectObjectHashMap.put("depositAccountName", "ʯ����xxx");

        WebExportPDF webExportPDF = ExportBeanFactory.getWebAttachmentExportPDF("ireport-tmp/report-test.jasper",
                                                                                objectObjectHashMap,
                                                                                "��������pdf");

        IReportUtils.export(webExportPDF);
    }

    @RequestMapping("/testWebAttachmentExportRTF")
    public void testWebAttachmentExportRTF() {
        Map<String, Object> objectObjectHashMap = new HashMap<>();

        objectObjectHashMap.put("tradingDayOfStr", "2018-01-01");
        objectObjectHashMap.put("depositAccountName", "ʯ����xxx");

        WebExportRTF webExportRTF = ExportBeanFactory.getWebAttachmentExportRTF("ireport-tmp/report-test.jasper",
                                                                                objectObjectHashMap,
                                                                                "��������rtf");

        IReportUtils.export(webExportRTF);
    }

    @RequestMapping("/testWebAttachmentExportXLS")
    public void testWebAttachmentExportXLS() {
        Map<String, Object> objectObjectHashMap = new HashMap<>();

        objectObjectHashMap.put("tradingDayOfStr", "2018-01-01");
        objectObjectHashMap.put("depositAccountName", "ʯ����xxx");

        WebExportXLS webExportHTML = ExportBeanFactory.getWebAttachmentExportXLS("ireport-tmp/report-test.jasper",
                                                                                 objectObjectHashMap,
                                                                                 "��������xls");

        System.out.println(HSSFColor.class.getProtectionDomain().getCodeSource().getLocation());
        IReportUtils.export(webExportHTML);
    }

    @RequestMapping("/testWebInlineExportHTML")
    public void testWebInlineExportHTML() {
        Map<String, Object> objectObjectHashMap = new HashMap<>();

        objectObjectHashMap.put("tradingDayOfStr", "2018-01-01");
        objectObjectHashMap.put("depositAccountName", "ʯ����xxx");

        ArrayList<Map> maps = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            HashMap<String, Object> it = new HashMap<>();

            it.put("devName", "��˾" + i);
            it.put("projName", "��Ŀ" + i);
            it.put("projName", "��Ŀ" + i);
            it.put("creditAmount", "" + i);
            it.put("debitAmount", "" + i);
            it.put("tradingDayOfStr", "2018-01-" + i);
            it.put("billingTimeOfStr", "2018-01-" + i);
            maps.add(it);
        }

        WebExportHTML webExportHTML = ExportBeanFactory.getWebInlineExportHTML("ireport-tmp/report-test.jasper",
                                                                               objectObjectHashMap,
                                                                               maps,
                                                                               "����Ԥ��html");

        IReportUtils.export(webExportHTML);
    }

    @RequestMapping("/testWebInlineExportIMG")
    public void testWebInlineExportIMG() {
        Map<String, Object> objectObjectHashMap = new HashMap<>();

        objectObjectHashMap.put("tradingDayOfStr", "2018-01-01");
        objectObjectHashMap.put("depositAccountName", "ʯ����xxx");

        WebExportIMG webExportIMG = ExportBeanFactory.getWebInlineExportIMG("ireport-tmp/report-test.jasper",
                                                                            objectObjectHashMap,
                                                                            "����Ԥ��png");

        IReportUtils.export(webExportIMG);
    }

    @RequestMapping("/testWebInlineExportPDF")
    public void testWebInlineExportPDF() {
        Map<String, Object> objectObjectHashMap = new HashMap<>();

        objectObjectHashMap.put("tradingDayOfStr", "2018-01-01");
        objectObjectHashMap.put("depositAccountName", "ʯ����xxx");

        ArrayList<Map> maps = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            HashMap<String, Object> it = new HashMap<>();

            it.put("devName", "��˾" + i);
            it.put("projName", "��Ŀ" + i);
            it.put("projName", "��Ŀ" + i);
            it.put("creditAmount", "" + i);
            it.put("debitAmount", "" + i);
            it.put("tradingDayOfStr", "2018-01-" + i);
            it.put("billingTimeOfStr", "2018-01-" + i);
            maps.add(it);
        }

        WebExportPDF webExportPDF = ExportBeanFactory.getWebInlineExportPDF("ireport-tmp/report-test.jasper",
                                                                            objectObjectHashMap,
                                                                            maps,
                                                                            "����Ԥ��pdf");

        IReportUtils.export(webExportPDF);
    }
}



