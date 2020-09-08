package com.imust.newckbk.utils.ireport.bean;

import java.util.Collection;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.jasperreports.engine.export.JRPdfExporter;

public class WebExportPDF extends AbstractWebExportBean {
    private JRPdfExporter jrPdfExporter;

    public WebExportPDF(String jasperPath, Map<String, Object> parameters, Collection<?> fields, String outNamePrefix,
                        HttpServletRequest request, HttpServletResponse response) {
        setJasperPath(jasperPath);
        setParameters(parameters);
        setFields(fields);
        setOutNamePrefix(outNamePrefix);
        setRequest(request);
        setResponse(response);
        setOutNameSuffix("pdf");
        jrPdfExporter = new JRPdfExporter();
    }

    @Override
    public JRPdfExporter getExporter() {
        return jrPdfExporter;
    }

    @Override
    public String getOutContentType() {
        return "application/pdf";
    }
}



