package com.imust.newckbk.utils.ireport.bean;

import java.util.Collection;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.jasperreports.engine.JRAbstractExporter;
import net.sf.jasperreports.engine.export.JRRtfExporter;

public class WebExportRTF extends AbstractWebExportBean {
    private JRRtfExporter jrRtfExporter;

    public WebExportRTF(String jasperPath, Map<String, Object> parameters, Collection<?> fields, String outNamePrefix,
                        HttpServletRequest request, HttpServletResponse response, ClientOpenMode clientOpenMode) {
        super(jasperPath, parameters, fields, outNamePrefix, "rtf", request, response, clientOpenMode);
        jrRtfExporter = new JRRtfExporter();
    }

    @Override
    public JRAbstractExporter getExporter() {
        return jrRtfExporter;
    }

    @Override
    public String getOutContentType() {
        return "application/msword";
    }
}



