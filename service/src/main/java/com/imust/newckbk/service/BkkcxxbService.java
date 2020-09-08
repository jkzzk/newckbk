package com.imust.newckbk.service;

import com.github.pagehelper.PageInfo;
import com.imust.newckbk.base.PageEntity;
import com.imust.newckbk.common.RespData;
import com.imust.newckbk.domain.Bkkcxxb;
import com.imust.newckbk.base.BaseService;
import com.imust.newckbk.domain.ext.BkkcxxbExt;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;


/**
* @date 2020-07-17
* @author jkzzk
* 
*/
public interface BkkcxxbService extends BaseService<Bkkcxxb, String>{

    /**
     * 补考课程列表分页查询
     *
     * @param mapPageEntity
     * @return
     */
    PageInfo<BkkcxxbExt> query(PageEntity<Map> mapPageEntity);

    /**
     * 保存补考课程
     *
     * @param bkkcxxb
     * @return
     */
    RespData saveBkkcxxb(Bkkcxxb bkkcxxb);

    /**
     * 更新补考课程
     *
     * @param bkkcxxb
     * @return
     */
    RespData editBkkcxxb(Bkkcxxb bkkcxxb);

    /**
     * 批量删除补考课程
     *
     * @param ids
     * @return
     */
    RespData deleteBkkcxxb(String[] ids);

    /**
     * 导入补考课程
     *
     * @param file
     * @return
     */
    RespData importBkkcxxb(MultipartFile file);
}