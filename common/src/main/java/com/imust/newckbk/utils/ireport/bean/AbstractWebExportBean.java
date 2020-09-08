package com.imust.newckbk.utils.ireport.bean;

import java.io.*;

import java.net.URLEncoder;

import java.util.Collection;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.jasperreports.engine.JRAbstractExporter;

/**
 * ireport ����web�ļ����࣬����web�����඼������
 * @author jkzzk
 * @since 2019/07/03
 */
public abstract class AbstractWebExportBean implements WebExportBean {
    private String              jasperPath;
    private Map<String, Object> parameters;
    private Collection<?>       fields;
    private String              outNamePrefix;
    private String              outNameSuffix;
    private HttpServletRequest  request;
    private HttpServletResponse response;
    private ClientOpenMode      clientOpenMode;

    public AbstractWebExportBean() {}

    public AbstractWebExportBean(String jasperPath, Map<String, Object> parameters, Collection<?> fields,
                                 String outNamePrefix, String outNameSuffix, HttpServletRequest request,
                                 HttpServletResponse response, ClientOpenMode clientOpenMode) {
        this.jasperPath     = jasperPath;
        this.parameters     = parameters;
        this.fields         = fields;
        this.outNamePrefix  = outNamePrefix;
        this.outNameSuffix  = outNameSuffix;
        this.request        = request;
        this.response       = response;
        this.clientOpenMode = clientOpenMode;
    }

    @Override
    public ClientOpenMode getClientOpenMode() {
        return clientOpenMode;
    }

    public void setClientOpenMode(ClientOpenMode clientOpenMode) {
        this.clientOpenMode = clientOpenMode;
    }

    @Override
    public abstract JRAbstractExporter getExporter();

    @Override
    public Collection<?> getFields() {
        return fields;
    }

    public void setFields(Collection<?> fields) {
        this.fields = fields;
    }

    @Override
    public InputStream getInputStream() {
        InputStream resourceAsStream = request.getSession().getServletContext().getResourceAsStream(jasperPath);

        if (resourceAsStream == null) {
            throw new NullPointerException("δ�ҵ��ļ�: "
                                           + request.getSession().getServletContext().getRealPath(jasperPath));
        }

        return resourceAsStream;
    }

    public String getJasperPath() {
        return jasperPath;
    }

    public void setJasperPath(String jasperPath) {
        this.jasperPath = jasperPath;
    }

    @Override
    public String getOutContentDisposition() {
        ClientOpenMode outProcess = getClientOpenMode();

        if (outProcess == null) {
            throw new RuntimeException("The ClientOpenMode must be non-null");
        }

        try {
            return outProcess.getValue() + ";filename=" + URLEncoder.encode(getOutputName(), "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();

            throw new RuntimeException(e);
        }
    }

    @Override
    public abstract String getOutContentType();

    public void setOutNamePrefix(String outNamePrefix) {
        this.outNamePrefix = outNamePrefix;
    }

    public void setOutNameSuffix(String outNameSuffix) {
        this.outNameSuffix = outNameSuffix;
    }

    @Override
    public String getOutputName() {
        return outNamePrefix + "." + outNameSuffix;
    }

    @Override
    public OutputStream getOutputStream() {
        try {
            response.setContentType(getOutContentType());
            response.setHeader("Content-Disposition", getOutContentDisposition());

            return response.getOutputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public Map<String, Object> getParameters() {
        return parameters;
    }

    public void setParameters(Map<String, Object> parameters) {
        this.parameters = parameters;
    }

    @Override
    public HttpServletRequest getRequest() {
        return request;
    }

    public void setRequest(HttpServletRequest request) {
        this.request = request;
    }

    @Override
    public HttpServletResponse getResponse() {
        return response;
    }

    public void setResponse(HttpServletResponse response) {
        this.response = response;
    }
}



