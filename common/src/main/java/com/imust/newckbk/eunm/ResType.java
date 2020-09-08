package com.imust.newckbk.eunm;

public enum ResType {
    RES_TYPE_MENU(1, "�˵�"), RES_TYPE_BTN(2, "��ť");

    private Integer code;
    private String  name;

    private ResType(Integer code, String name) {
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
        for (ResType r : ResType.values()) {
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



