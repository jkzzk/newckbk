package com.imust.newckbk.domain;

public class XsType {
    private String id;

    private String typeName;

    private String typeId;

    private String typeAttr;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName == null ? null : typeName.trim();
    }

    public String getTypeId() {
        return typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId == null ? null : typeId.trim();
    }

    public String getTypeAttr() {
        return typeAttr;
    }

    public void setTypeAttr(String typeAttr) {
        this.typeAttr = typeAttr;
    }
}