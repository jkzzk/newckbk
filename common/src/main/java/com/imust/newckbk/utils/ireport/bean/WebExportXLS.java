package com.imust.newckbk.utils.ireport.bean;

import java.util.Collection;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.jasperreports.engine.JRAbstractExporter;
import net.sf.jasperreports.engine.export.JRXlsExporter;

public class WebExportXLS extends AbstractWebExportBean {
    private JRXlsExporter jrXlsExporter;

    public WebExportXLS(String jasperPath, Map<String, Object> parameters, Collection<?> fields, String outNamePrefix,
                        HttpServletRequest request, HttpServletResponse response, ClientOpenMode clientOpenMode) {
        super(jasperPath, parameters, fields, outNamePrefix, "xls", request, response, clientOpenMode);
        jrXlsExporter = new JRXlsExporter();
    }

    @Override
    public JRAbstractExporter getExporter() {
        return jrXlsExporter;
    }

    @Override
    public String getOutContentType() {
        return "application/vnd.ms-excel";
    }
}



