package com.imust.newckbk.service;

import com.imust.newckbk.common.RespData;
import com.imust.newckbk.domain.ext.LanguageTjExt;

public interface LanguageTjService {

    /**
     * 保存语种考试条件
     *
     * @param languageTjExt
     * @return
     */
    RespData save(LanguageTjExt languageTjExt);
}
