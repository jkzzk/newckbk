package com.imust.newckbk.utils.ireport.bean;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * ireport web���������
 * @author jkzzk
 * @since 2019/07/03
 */
public interface WebExportBean extends ExportBean {
    public static enum ClientOpenMode {
        inline {

            // ҳ������
            @Override
            public String getValue() {
                return "inline";
            }
        },
        attachment {

            // ��������
            @Override
            public String getValue() {
                return "attachment";
            }
        };

        public abstract String getValue();
    }

    ClientOpenMode getClientOpenMode();

    String getOutContentDisposition();

    String getOutContentType();

    String getOutputName();

    HttpServletRequest getRequest();

    HttpServletResponse getResponse();
}



