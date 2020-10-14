package com.imust.newckbk.service;

import com.github.pagehelper.PageInfo;
import com.imust.newckbk.base.PageEntity;
import com.imust.newckbk.common.RespData;
import com.imust.newckbk.domain.CetStuscore;
import com.imust.newckbk.base.BaseService;
import com.imust.newckbk.domain.Zyxxb;
import com.imust.newckbk.domain.ext.CetStuscoreExt;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;


/**
* @date 2020-09-09
* @author jkzzk
* 
*/
public interface CetStuscoreService extends BaseService<CetStuscore, String>{

    /**
     * 分页查询
     *
     * @param mapPageEntity
     * @return
     */
    PageInfo<CetStuscoreExt> query(PageEntity<Map> mapPageEntity);

    /**
     * 导入历史成绩
     *
     * @param file
     * @return
     */
    RespData importCetStuscore(MultipartFile file);
}