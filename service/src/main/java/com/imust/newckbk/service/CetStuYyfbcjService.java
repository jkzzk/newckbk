package com.imust.newckbk.service;

import com.github.pagehelper.PageInfo;
import com.imust.newckbk.base.PageEntity;
import com.imust.newckbk.common.RespData;
import com.imust.newckbk.domain.CetStuYyfbcj;
import com.imust.newckbk.base.BaseService;
import com.imust.newckbk.domain.ext.BktjjlExt;
import com.imust.newckbk.domain.ext.CetStuYyfbcjExt;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;


/**
* @date 2020-07-05
* @author jkzzk
* 
*/
public interface CetStuYyfbcjService extends BaseService<CetStuYyfbcj, String>{

    /**
     * 分页查询
     *
     * @param mapPageEntity
     * @return
     */
    PageInfo<CetStuYyfbcjExt> query(PageEntity<Map> mapPageEntity);

    /**
     * 保存分班成绩
     *
     * @param cetStuYyfbcj
     * @return
     */
    RespData saveCetStuYyfbcj(CetStuYyfbcj cetStuYyfbcj);

    /**
     * 批量删除
     *
     * @param ids
     * @return
     */
    RespData delCetStuYyfbcj(List<String> ids);

    /**
     * 导入分班成绩
     *
     * @param file
     * @return
     */
    RespData importCetStuYyfbcj(MultipartFile file);
}