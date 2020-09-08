
/*
* Created on 2015-09-14 16:21:00
*
 */
package com.imust.newckbk.common;

/**
 * ����ǰ�˵����ݸ�ʽ
 * @author jkzzk
 */
public class RespData implements java.io.Serializable {
    private static final long serialVersionUID = 1L;
    private Integer           code;
    private String            msg;
    private Object            data;

    public static RespData errorMsg(String msg) {
        RespData rsp = new RespData();

        rsp.setCode(RetCode.ACTIVE_FAILURE.getCode());
        rsp.setMsg(msg);

        return rsp;
    }

    public static RespData errorMsg(Integer code, String msg) {
        RespData rsp = new RespData();

        rsp.setCode(code);
        rsp.setMsg(msg);

        return rsp;
    }

    public static RespData successMsg(String msg) {
        RespData rsp = new RespData();

        rsp.setCode(RetCode.ACTIVE_SUCCESS.getCode());
        rsp.setMsg(msg);

        return rsp;
    }

    public static RespData successMsg(String msg, Object data) {
        RespData rsp = new RespData();

        rsp.setCode(RetCode.ACTIVE_SUCCESS.getCode());
        rsp.setMsg(msg);
        rsp.setData(data);

        return rsp;
    }

    public static RespData successMsg(Integer code, String msg, Object data) {
        RespData rsp = new RespData();

        rsp.setCode(code);
        rsp.setMsg(msg);
        rsp.setData(data);

        return rsp;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}



