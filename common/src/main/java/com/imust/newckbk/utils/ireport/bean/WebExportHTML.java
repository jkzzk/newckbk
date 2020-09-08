package com.imust.newckbk.utils.ireport.bean;

import java.util.Collection;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.jasperreports.engine.JRAbstractExporter;
import net.sf.jasperreports.engine.export.HtmlExporter;

public class WebExportHTML extends AbstractWebExportBean {
    private HtmlExporter jrHtmlExporter;

    public WebExportHTML(String jasperPath, Map<String, Object> parameters, Collection<?> fields, String outNamePrefix,
                         HttpServletRequest request, HttpServletResponse response, ClientOpenMode clientOpenMode) {
        super(jasperPath, parameters, fields, outNamePrefix, "html", request, response, clientOpenMode);
        jrHtmlExporter = new HtmlExporter();
    }

    @Override
    public JRAbstractExporter getExporter() {
        return jrHtmlExporter;
    }

    @Override
    public String getOutContentType() {
        return "text/html";
    }
}



