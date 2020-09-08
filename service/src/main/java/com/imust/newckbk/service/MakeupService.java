package com.imust.newckbk.service;

import com.github.pagehelper.PageInfo;
import com.imust.newckbk.base.PageEntity;
import com.imust.newckbk.common.RespData;
import com.imust.newckbk.domain.Bkkcxxb;
import com.imust.newckbk.domain.Makeup;
import com.imust.newckbk.domain.SysUser;
import com.imust.newckbk.domain.ext.BkkcxxbExt;
import com.imust.newckbk.domain.ext.MakeupExt;
import com.imust.newckbk.domain.ext.RwLlrwAllViewKwExt;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

public interface MakeupService {

    /**
     * 查询学生补考课程
     * @param currentSysUser
     * @return
     */
    List<MakeupExt> query(SysUser currentSysUser);

    /**
     * 是否开了补考
     * @return
     */
    boolean ifOpen();

    /**
     * 是否在补考学生范围内
     * @param currentSysUser
     * @return
     */
    boolean ifInScope(SysUser currentSysUser);


    /**
     * 保存补考信息
     * @param makeup
     * @return
     */
    RespData save(Makeup makeup);

    /**
     * 补考报名
     *
     * @param ids
     * @return
     */
    RespData enter(String[] ids);

    /**
     * 取消补考报名
     *
     * @param ids
     * @return
     */
    RespData outer(String[] ids);

    /**
     * 后台分页查询
     *
     * @param mapPageEntity
     * @return
     */
    PageInfo<MakeupExt> queryList(PageEntity<Map> mapPageEntity);

    /**
     * 批量删除
     *
     * @param ids
     * @return
     */
    RespData deleteMakeUp(String[] ids);

    /**
     * 批量导出
     *
     * @param response
     * @return
     */
    void export(HttpServletResponse response);

    /**
     * 打印准考证
     *
     * @param xh
     */
    void printEnterCard(String xh,HttpServletResponse response);

    /**
     * 缴费
     *
     * @param ids
     * @return
     */
    RespData inpay(String[] ids);

    /**
     * 取消缴费
     *
     * @param ids
     * @return
     */
    RespData outpay(String[] ids);

    /**
     * 获取其他课程
     *
     * @param xh
     * @return
     */
    List<BkkcxxbExt> getExtraCourse(String xh);
}
