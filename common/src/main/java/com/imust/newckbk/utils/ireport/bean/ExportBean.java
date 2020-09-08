package com.imust.newckbk.utils.ireport.bean;

import java.io.InputStream;
import java.io.OutputStream;

import java.util.Collection;
import java.util.Map;

import net.sf.jasperreports.engine.JRAbstractExporter;

/**
 * ireport �����ඥ�����
 * @author jkzzk
 * @since 2019/07/03
 */
public interface ExportBean {
    JRAbstractExporter getExporter();

    Collection<?> getFields();

    InputStream getInputStream();

    OutputStream getOutputStream();

    Map<String, Object> getParameters();
}



