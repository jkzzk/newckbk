package com.imust.newckbk.common;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class UploadFileConfig {
    public static String imgPath = null;

    public String getImgPath() {
        return imgPath;
    }

    @Value("${img.url}")
    public void setImgPath(String imgPath1) {
        if (imgPath == null) {
            imgPath = imgPath1;
        }
    }
}



