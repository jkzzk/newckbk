package com.imust.newckbk.eunm;

public enum CommonSeparator {
    SEPARATOR_COMMA(1, ",");

    private Integer code;
    private String  name;

    private CommonSeparator(Integer code, String name) {
        this.code = code;
        this.name = name;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public static String getName(int code) {
        for (CommonSeparator r : CommonSeparator.values()) {
            if (r.getCode() == code) {
                return r.getName();
            }
        }

        return null;
    }

    public void setName(String name) {
        this.name = name;
    }
}



