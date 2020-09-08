package com.imust.newckbk.utils.ireport.bean;

import java.util.Collection;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.jasperreports.engine.JRAbstractExporter;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.export.JRGraphics2DExporter;

public class WebExportIMG extends AbstractWebExportBean {
    private JRGraphics2DExporter jrGraphics2DExporter;

    public WebExportIMG(String jasperPath, Map<String, Object> parameters, Collection<?> fields, String outNamePrefix,
                        HttpServletRequest request, HttpServletResponse response, ClientOpenMode clientOpenMode) {
        super(jasperPath, parameters, fields, outNamePrefix, "png", request, response, clientOpenMode);

        try {
            jrGraphics2DExporter = new JRGraphics2DExporter();
        } catch (JRException e) {
            e.printStackTrace();

            throw new RuntimeException(e);
        }
    }

    @Override
    public JRAbstractExporter getExporter() {
        return jrGraphics2DExporter;
    }

    @Override
    public String getOutContentType() {
        return "image/png";
    }
}



