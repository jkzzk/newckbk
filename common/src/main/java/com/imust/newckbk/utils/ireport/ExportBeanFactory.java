package com.imust.newckbk.utils.ireport;

import java.util.Collection;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.imust.newckbk.utils.ireport.bean.*;
import com.imust.newckbk.utils.ireport.bean.*;
import com.imust.newckbk.utils.ireport.bean.*;

/**
 * ireport �����ļ�bean������
 * @author jkzzk
 * @since 2019/07/03
 */
public class ExportBeanFactory {

    /**
     * ��ȡWeb��������PDF���ļ���������˽���pdf��ʽ���أ�
     * @param jasperPath jasperģ���ļ����·��
     * @param fields ģ����fields��������
     * @param outName ������ļ���
     * @return WebExportPDF
     */
    public static WebExportPDF getWebAttachmentExportPDF(String jasperPath, Collection<?> fields, String outName) {
        return getWebAttachmentExportPDF(jasperPath, null, fields, outName);
    }

    /**
     * ��ȡWeb��������PDF���ļ���������˽���pdf��ʽ���أ�
     * @param jasperPath jasperģ���ļ����·��
     * @param parameters ģ����parameters��������
     * @param outName ����������ļ���
     * @return WebExportPDF
     */
    public static WebExportPDF getWebAttachmentExportPDF(String jasperPath, Map<String, Object> parameters,
                                                         String outName) {
        return getWebAttachmentExportPDF(jasperPath, parameters, null, outName);
    }

    /**
     * ��ȡWeb��������PDF���ļ���������˽���pdf��ʽ���أ��÷���ֱ�ӻ�ȡ��ǰ�����������Ӧ����
     * @param jasperPath jasperģ���ļ����·��
     * @param parameters ģ����parameters��������
     * @param fields ģ����fields��������
     * @param outName ����������ļ���
     * @return WebExportPDF
     */
    public static WebExportPDF getWebAttachmentExportPDF(String jasperPath, Map<String, Object> parameters,
                                                         Collection<?> fields, String outName) {
        ServletRequestAttributes requestAttributes =
            (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();

        return getWebAttachmentExportPDF(jasperPath,
                                         parameters,
                                         fields,
                                         outName,
                                         requestAttributes.getRequest(),
                                         requestAttributes.getResponse());
    }

    /**
     * ��ȡWeb��������PDF���ļ���������˽���pdf��ʽ���أ�
     * @param jasperPath jasperģ���ļ����·��
     * @param parameters ģ����parameters��������
     * @param fields ģ����fields��������
     * @param outName ����������ļ���
     * @param request �������
     * @param response ��Ӧ����
     * @return WebExportPDF
     */
    public static WebExportPDF getWebAttachmentExportPDF(String jasperPath, Map<String, Object> parameters,
                                                         Collection<?> fields, String outName,
                                                         HttpServletRequest request, HttpServletResponse response) {
        return getWebExportPDF(jasperPath,
                               parameters,
                               fields,
                               outName,
                               WebExportBean.ClientOpenMode.attachment,
                               request,
                               response);
    }

    /**
     * ��ȡWeb��������RTF���ļ���������˽���rtf��ʽ���أ�
     * @param jasperPath jasperģ���ļ����·��
     * @param fields ģ����fields��������
     * @param outName ������ļ���
     * @return WebExportRTF
     */
    public static WebExportRTF getWebAttachmentExportRTF(String jasperPath, Collection<?> fields, String outName) {
        return getWebAttachmentExportRTF(jasperPath, null, fields, outName);
    }

    /**
     * ��ȡWeb��������RTF���ļ���������˽���rtf��ʽ���أ�
     * @param jasperPath jasperģ���ļ����·��
     * @param parameters ģ����parameters��������
     * @param outName ����������ļ���
     * @return WebExportPDF
     */
    public static WebExportRTF getWebAttachmentExportRTF(String jasperPath, Map<String, Object> parameters,
                                                         String outName) {
        return getWebAttachmentExportRTF(jasperPath, parameters, null, outName);
    }

    /**
     * ��ȡWeb��������PDF���ļ���������˽���rtf��ʽ���أ��÷���ֱ�ӻ�ȡ��ǰ�����������Ӧ����
     * @param jasperPath jasperģ���ļ����·��
     * @param parameters ģ����parameters��������
     * @param fields ģ����fields��������
     * @param outName ����������ļ���
     * @return WebExportPDF
     */
    public static WebExportRTF getWebAttachmentExportRTF(String jasperPath, Map<String, Object> parameters,
                                                         Collection<?> fields, String outName) {
        ServletRequestAttributes requestAttributes =
            (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();

        return getWebAttachmentExportRTF(jasperPath,
                                         parameters,
                                         fields,
                                         outName,
                                         requestAttributes.getRequest(),
                                         requestAttributes.getResponse());
    }

    /**
     * ��ȡWeb��������PDF���ļ���������˽���rtf��ʽ���أ�
     * @param jasperPath jasperģ���ļ����·��
     * @param parameters ģ����parameters��������
     * @param fields ģ����fields��������
     * @param outName ����������ļ���
     * @param request �������
     * @param response ��Ӧ����
     * @return WebExportPDF
     */
    public static WebExportRTF getWebAttachmentExportRTF(String jasperPath, Map<String, Object> parameters,
                                                         Collection<?> fields, String outName,
                                                         HttpServletRequest request, HttpServletResponse response) {
        WebExportRTF rtf = new WebExportRTF(jasperPath,
                                            parameters,
                                            fields,
                                            outName,
                                            request,
                                            response,
                                            WebExportBean.ClientOpenMode.attachment);

        return rtf;
    }

    /**
     * ��ȡWeb��������xls���ļ���������˽���xls��ʽ���أ�
     * @param jasperPath jasperģ���ļ����·��
     * @param fields ģ����fields��������
     * @param outName ����������ļ���
     * @return WebExportXLS
     */
    public static WebExportXLS getWebAttachmentExportXLS(String jasperPath, Collection<?> fields, String outName) {
        return getWebAttachmentExportXLS(jasperPath, null, fields, outName);
    }

    /**
     * ��ȡWeb��������xls���ļ���������˽���xls��ʽ���أ�
     * @param jasperPath jasperģ���ļ����·��
     * @param parameters ģ����parameters��������
     * @param outName ����������ļ���
     * @return WebExportXLS
     */
    public static WebExportXLS getWebAttachmentExportXLS(String jasperPath, Map<String, Object> parameters,
                                                         String outName) {
        return getWebAttachmentExportXLS(jasperPath, parameters, null, outName);
    }

    /**
     * ��ȡWeb��������xls���ļ���������˽���xls��ʽ���أ��÷���ֱ�ӻ�ȡ��ǰ�����������Ӧ����
     * @param jasperPath jasperģ���ļ����·��
     * @param parameters ģ����parameters��������
     * @param fields ģ����fields��������
     * @param outName ����������ļ���
     * @return WebExportXLS
     */
    public static WebExportXLS getWebAttachmentExportXLS(String jasperPath, Map<String, Object> parameters,
                                                         Collection<?> fields, String outName) {
        ServletRequestAttributes requestAttributes =
            (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();

        return getWebAttachmentExportXLS(jasperPath,
                                         parameters,
                                         fields,
                                         outName,
                                         requestAttributes.getRequest(),
                                         requestAttributes.getResponse());
    }

    /**
     * ��ȡWeb��������xls���ļ���������˽���xls��ʽ���أ�
     * @param jasperPath jasperģ���ļ����·��
     * @param parameters ģ����parameters��������
     * @param fields ģ����fields��������
     * @param outName ����������ļ���
     * @param request �������
     * @param response ��Ӧ����
     * @return WebExportXLS
     */
    public static WebExportXLS getWebAttachmentExportXLS(String jasperPath, Map<String, Object> parameters,
                                                         Collection<?> fields, String outName,
                                                         HttpServletRequest request, HttpServletResponse response) {
        return new WebExportXLS(jasperPath,
                                parameters,
                                fields,
                                outName,
                                request,
                                response,
                                WebExportBean.ClientOpenMode.attachment);
    }

    private static WebExportPDF getWebExportPDF(String jasperPath, Map<String, Object> parameters,
                                                Collection<?> fields, String outName,
                                                WebExportBean.ClientOpenMode clientOpenMode,
                                                HttpServletRequest request, HttpServletResponse response) {
        WebExportPDF pdf = new WebExportPDF(jasperPath, parameters, fields, outName, request, response);

        pdf.setClientOpenMode(clientOpenMode);

        return pdf;
    }

    /**
     * ��ȡWeb��������html���ļ���������˽���html��ʽֱ��Ԥ����
     * @param jasperPath jasperģ���ļ����·��
     * @param fields ģ����fields��������
     * @param outName ������ļ���
     * @return WebExportHTML
     */
    public static WebExportHTML getWebInlineExportHTML(String jasperPath, Collection<?> fields, String outName) {
        return getWebInlineExportHTML(jasperPath, null, fields, outName);
    }

    /**
     * ��ȡWeb��������html���ļ���������˽���html��ʽֱ��Ԥ����
     * @param jasperPath jasperģ���ļ����·��
     * @param parameters ģ����parameters��������
     * @param outName ������ļ���
     * @return WebExportHTML
     */
    public static WebExportHTML getWebInlineExportHTML(String jasperPath, Map<String, Object> parameters,
                                                       String outName) {
        return getWebInlineExportHTML(jasperPath, parameters, null, outName);
    }

    /**
     * ��ȡWeb��������html���ļ���������˽���html��ʽֱ��Ԥ�����÷���ֱ�ӻ�ȡ��ǰ�����������Ӧ����
     * @param jasperPath jasperģ���ļ����·��
     * @param parameters ģ����parameters��������
     * @param fields ģ����fields��������
     * @param outName ������ļ���
     * @return WebExportHTML
     */
    public static WebExportHTML getWebInlineExportHTML(String jasperPath, Map<String, Object> parameters,
                                                       Collection<?> fields, String outName) {
        ServletRequestAttributes requestAttributes =
            (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();

        return getWebInlineExportHTML(jasperPath,
                                      parameters,
                                      fields,
                                      outName,
                                      requestAttributes.getRequest(),
                                      requestAttributes.getResponse());
    }

    /**
     * ��ȡWeb��������html���ļ���������˽���html��ʽֱ��Ԥ����
     * @param jasperPath jasperģ���ļ����·��
     * @param parameters ģ����parameters��������
     * @param fields ģ����fields��������
     * @param outName ������ļ���
     * @param request �������
     * @param response ��Ӧ����
     * @return WebExportHTML
     */
    public static WebExportHTML getWebInlineExportHTML(String jasperPath, Map<String, Object> parameters,
                                                       Collection<?> fields, String outName,
                                                       HttpServletRequest request, HttpServletResponse response) {
        WebExportHTML html = new WebExportHTML(jasperPath,
                                               parameters,
                                               fields,
                                               outName,
                                               request,
                                               response,
                                               WebExportBean.ClientOpenMode.inline);

        return html;
    }

    /**
     * ע�⣺�÷�ʽֻ������һҳ���ݣ�������Ԥ����ҳ��Ʊ��Ϣ�ȣ���ҳ��ʹ������bean
     * ��ȡWeb��������png���ļ���������˽���png��ʽֱ��Ԥ����
     * @param jasperPath jasperģ���ļ����·��
     * @param parameters ģ����parameters��������
     * @param outName ������ļ���
     * @return WebExportHTML
     */
    public static WebExportIMG getWebInlineExportIMG(String jasperPath, Map<String, Object> parameters,
                                                     String outName) {
        ServletRequestAttributes requestAttributes =
            (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();

        return getWebInlineExportIMG(jasperPath,
                                     parameters,
                                     outName,
                                     requestAttributes.getRequest(),
                                     requestAttributes.getResponse());
    }

    /**
     * ע�⣺�÷�ʽֻ������һҳ���ݣ�������Ԥ����ҳ��Ʊ��Ϣ�ȣ���ҳ��ʹ������bean
     * @param jasperPath jasperģ���ļ����·��
     * @param parameters ģ����parameters��������
     * @param fields ģ����fields��������
     * @param outName ������ļ���
     * @param request �������
     * @param response ��Ӧ����
     * @return WebExportIMG
     */
    public static WebExportIMG getWebInlineExportIMG(String jasperPath, Map<String, Object> parameters, String outName,
                                                     HttpServletRequest request, HttpServletResponse response) {
        return new WebExportIMG(jasperPath,
                                parameters,
                                null,
                                outName,
                                request,
                                response,
                                WebExportBean.ClientOpenMode.inline);
    }

    /**
     * ��ȡWeb��������PDF���ļ���������˽���pdf��ʽֱ��Ԥ����
     * @param jasperPath jasperģ���ļ����·��
     * @param fields ģ����fields��������
     * @param outName ������ļ���
     * @return WebExportPDF
     */
    public static WebExportPDF getWebInlineExportPDF(String jasperPath, Collection<?> fields, String outName) {
        return getWebInlineExportPDF(jasperPath, null, fields, outName);
    }

    /**
     * ��ȡWeb��������PDF���ļ���������˽���pdf��ʽֱ��Ԥ����
     * @param jasperPath jasperģ���ļ����·��
     * @param parameters ģ����parameters��������
     * @param outName ������ļ���
     * @return WebExportPDF
     */
    public static WebExportPDF getWebInlineExportPDF(String jasperPath, Map<String, Object> parameters,
                                                     String outName) {
        return getWebInlineExportPDF(jasperPath, parameters, null, outName);
    }

    /**
     * ��ȡWeb��������PDF���ļ���������˽���pdf��ʽֱ��Ԥ�����÷���ֱ�ӻ�ȡ��ǰ�����������Ӧ����
     * @param jasperPath jasperģ���ļ����·��
     * @param parameters ģ����parameters��������
     * @param fields ģ����fields��������
     * @param outName ������ļ���
     * @return WebExportPDF
     */
    public static WebExportPDF getWebInlineExportPDF(String jasperPath, Map<String, Object> parameters,
                                                     Collection<?> fields, String outName) {
        ServletRequestAttributes requestAttributes =
            (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();

        return getWebInlineExportPDF(jasperPath,
                                     parameters,
                                     fields,
                                     outName,
                                     requestAttributes.getRequest(),
                                     requestAttributes.getResponse());
    }

    /**
     * ��ȡWeb��������PDF���ļ���������˽���pdf��ʽֱ��Ԥ����
     * @param jasperPath jasperģ���ļ����·��
     * @param parameters ģ����parameters��������
     * @param fields ģ����fields��������
     * @param outName ������ļ���
     * @param request �������
     * @param response ��Ӧ����
     * @return WebExportPDF
     */
    public static WebExportPDF getWebInlineExportPDF(String jasperPath, Map<String, Object> parameters,
                                                     Collection<?> fields, String outName, HttpServletRequest request,
                                                     HttpServletResponse response) {
        return getWebExportPDF(jasperPath,
                               parameters,
                               fields,
                               outName,
                               WebExportBean.ClientOpenMode.inline,
                               request,
                               response);
    }
}



