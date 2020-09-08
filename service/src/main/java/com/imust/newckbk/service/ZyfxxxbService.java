package com.imust.newckbk.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.imust.newckbk.base.PageEntity;
import com.imust.newckbk.common.RespData;
import com.imust.newckbk.domain.Zyfxxxb;
import com.imust.newckbk.base.BaseService;
import com.imust.newckbk.domain.Zyxxb;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;


/**
* @date 2020-08-23
* @author jkzzk
* 
*/
public interface ZyfxxxbService extends BaseService<Zyfxxxb, String>{

    /**
     * 分页查询辅修专业
     *
     * @param mapPageEntity
     * @return
     */
    PageInfo<Zyfxxxb> query(PageEntity<Map> mapPageEntity);

    /**
     * 保存辅修专业信息
     *
     * @param zyfxxxb
     * @return
     */
    RespData saveZyxxb(Zyfxxxb zyfxxxb);

    /**
     * 批量删除辅修专业信息
     *
     * @param asList
     * @return
     */
    RespData delZyxxb(List<String> asList);

    /**
     * 导入辅修专业信息
     *
     * @param file
     * @return
     */
    RespData importBkkcxxb(MultipartFile file);
}