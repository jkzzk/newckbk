package com.imust.newckbk.common;

public enum RetCode {

    NOT_LOGIN_EXCEPTION(-1, "未登录"),
    ACTIVE_EXCEPTION(0, "系统异常"),
    ACTIVE_SUCCESS(1, "操作成功"),
    ACTIVE_FAILURE(2, "操作失败"),
    ERROR_PARAMS_NOT_NULL(3, "参数不能为空"),
    REQUEST_SUCCESS(200,"请求成功"),
    ERROR_PARAMS(400, "参数不完整"),
    ERROR_DUPLICATE(401, "重复操作"),
    ERROR_AUTH(402, "无权限"),
    ERROR_PARAMS_DECRYPT(402, "参数解密失败"),
    ERROR_WRONG(403, "用户无法使用此系统"),
    ERROR_RESOURCES(404, "请求资源不存在"),
    ERROR_PARAMS_FORMAT(500, "参数格式错误");

    private Integer code;
    private String  msg;

    private RetCode(int code, String msg) {
        this.code = code;
        this.msg  = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}



