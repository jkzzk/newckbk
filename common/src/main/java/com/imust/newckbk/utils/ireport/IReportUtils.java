package com.imust.newckbk.utils.ireport;

import java.awt.*;
import java.awt.image.BufferedImage;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;

import com.imust.newckbk.utils.ireport.bean.WebExportBean;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import org.apache.commons.collections.CollectionUtils;

import com.imust.newckbk.utils.ireport.bean.ExportBean;

import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRGraphics2DExporter;
import net.sf.jasperreports.engine.export.JRGraphics2DExporterParameter;
import net.sf.jasperreports.engine.util.JRLoader;
import org.apache.commons.io.IOUtils;

/**
 * ireport������
 * @author jkzzk
 * @since 2019/07/02
 */
public class IReportUtils {

    /**
     * 依据导出类解析导出
     *
     * @param exportBean
     */
    public static void export(ExportBean exportBean) {
        Map<String, Object> parameters   = exportBean.getParameters();
        Collection<?>       fields       = exportBean.getFields();
        JRAbstractExporter  exporter     = exportBean.getExporter();
        InputStream         inputStream  = exportBean.getInputStream();
        OutputStream        outputStream = exportBean.getOutputStream();

        // �ж�ȡ������Դ
        JRDataSource jRDataSource;

        if (CollectionUtils.isNotEmpty(fields)) {
            jRDataSource = new JRBeanCollectionDataSource(fields);
        } else {
            jRDataSource = new JREmptyDataSource();
        }

        try {

            // ����������ģ��
            JasperReport jasperReport = (JasperReport) JRLoader.loadObject(inputStream);
            JasperPrint  jasperPrint  = JasperFillManager.fillReport(jasperReport, parameters, jRDataSource);

            // ���
            exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);

            if (!(exporter instanceof JRGraphics2DExporter)) {
                exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, outputStream);
                exporter.exportReport();
            } else {
                BufferedImage bufferedImage = new BufferedImage(jasperPrint.getPageWidth() * 4,
                                                                jasperPrint.getPageHeight() * 4,
                                                                BufferedImage.TYPE_INT_RGB);

                // ȡgraphics
                Graphics2D graphics = bufferedImage.createGraphics();

                // ������Ӧ������Ϣ
                exporter.setParameter(JRGraphics2DExporterParameter.GRAPHICS_2D, graphics);
                exporter.setParameter(JRGraphics2DExporterParameter.ZOOM_RATIO, 4f);
                exporter.exportReport();
                ImageIO.write(bufferedImage, "png", outputStream);
                graphics.dispose();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (inputStream != null) {
                    inputStream.close();
                }

                if (outputStream != null) {
                    outputStream.close();
                }
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
        }
    }

    /**
     * 依据导出类解析导出
     *
     * @param exportBean
     */
    public static void export(ExportBean... exportBean) {

        JasperReport jasperReport = null;
        JasperPrint jasperPrint = null;
        JRAbstractExporter exporter = exportBean[0].getExporter();
        OutputStream outputStream = exportBean[0].getOutputStream();
        try {
            for (ExportBean bean : exportBean) {

                Map<String, Object> parameters = bean.getParameters();
                Collection<?> fields = bean.getFields();
                InputStream inputStream = bean.getInputStream();


                // 判断取得数据源
                JRDataSource jRDataSource;
                if (CollectionUtils.isNotEmpty(fields)) {
                    jRDataSource = new JRBeanCollectionDataSource(fields);
                } else {
                    jRDataSource = new JREmptyDataSource();
                }
                // 填充参数解析模板
                JasperReport _jasperReport = (JasperReport) JRLoader.loadObject(inputStream);
                JasperPrint _jasperPrint = JasperFillManager.fillReport(_jasperReport, parameters, jRDataSource);

                if (jasperReport == null) {
                    jasperReport = _jasperReport;
                }
                if (jasperPrint == null) {
                    jasperPrint = _jasperPrint;
                }else {
                    List<JRPrintPage> pages = _jasperPrint.getPages();
                    for (JRPrintPage page : pages) {
                        jasperPrint.addPage(page);
                    }
                }
                IOUtils.closeQuietly(inputStream);
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }


        try {
            // 输出
            exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
            if (!(exporter instanceof JRGraphics2DExporter)) {
                exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, outputStream);
                exporter.exportReport();
            } else {
                BufferedImage bufferedImage = new BufferedImage(jasperPrint.getPageWidth() * 4, jasperPrint.getPageHeight() * 4, BufferedImage.TYPE_INT_RGB);
                //取graphics
                Graphics2D graphics = bufferedImage.createGraphics();
                //设置相应参数信息
                exporter.setParameter(JRGraphics2DExporterParameter.GRAPHICS_2D, graphics);
                exporter.setParameter(JRGraphics2DExporterParameter.ZOOM_RATIO, 4f);
                exporter.exportReport();
                ImageIO.write(bufferedImage, "png", outputStream);
                graphics.dispose();
            }
        } catch (JRException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * 依据导出类解析导出
     *
     * @param exportBeans
     */
    public static void export(List<WebExportBean> exportBeans, HttpServletResponse response) {

        try {

            List<JasperPrint> jasperPrints = new ArrayList<JasperPrint>();

            for (ExportBean exportBean : exportBeans) {

                Map<String, Object> parameters = exportBean.getParameters();
                Collection<?> fields = exportBean.getFields();
                InputStream inputStream = exportBean.getInputStream();


                // 判断取得数据源
                JRDataSource jRDataSource;
                if (CollectionUtils.isNotEmpty(fields)) {
                    jRDataSource = new JRBeanCollectionDataSource(fields);
                } else {
                    jRDataSource = new JREmptyDataSource();
                }
                // 填充参数解析模板
                JasperReport _jasperReport = (JasperReport) JRLoader.loadObject(inputStream);
                JasperPrint _jasperPrint = JasperFillManager.fillReport(_jasperReport, parameters, jRDataSource);

                jasperPrints.add(_jasperPrint);

                IOUtils.closeQuietly(inputStream);
            }

            JRPdfExporter exporter = new JRPdfExporter();
            exporter.setParameter(JRExporterParameter.JASPER_PRINT_LIST, jasperPrints);
            exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, response.getOutputStream());
            exporter.exportReport();

        }catch (Exception e) {
            e.printStackTrace();
        }

    }
}



