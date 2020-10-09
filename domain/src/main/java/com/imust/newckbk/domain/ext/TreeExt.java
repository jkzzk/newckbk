package com.imust.newckbk.domain.ext;

import java.util.List;
import java.util.Objects;

/**
 * @author jkzzk
 * @description
 * @data 2020/10/6
 */
public class TreeExt {

    private String id;

    private String text;

    private String Level;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getLevel() {
        return Level;
    }

    public void setLevel(String level) {
        Level = level;
    }
}
