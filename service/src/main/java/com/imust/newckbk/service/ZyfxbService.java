package com.imust.newckbk.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.imust.newckbk.base.PageEntity;
import com.imust.newckbk.common.RespData;
import com.imust.newckbk.domain.SysUser;
import com.imust.newckbk.domain.Zyfxb;
import com.imust.newckbk.base.BaseService;
import com.imust.newckbk.domain.Zyfxxxb;
import com.imust.newckbk.domain.Zyxxb;
import com.imust.newckbk.domain.ext.MakeupExt;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;


/**
* @date 2020-08-23
* @author jkzzk
* 
*/
public interface ZyfxbService extends BaseService<Zyfxb, String>{

    /**
     * 查询辅修报名是否开启
     *
     * @return
     */
    boolean ifOpen();

    /**
     * 查询是否在辅修报名范围内
     *
     * @param currentSysUser
     * @return
     */
    boolean ifInScope(SysUser currentSysUser);

    /**
     * 学生查询报名数据
     *
     * @param currentSysUser
     * @return
     */
    List<Zyfxb> query(SysUser currentSysUser);

    /**
     * 分页查询辅修列表
     *
     * @param mapPageEntity
     * @return
     */
    PageInfo<Zyfxb> queryList(PageEntity<Map> mapPageEntity);

    /**
     * 保存当前
     *
     * @param zyfxb
     * @return
     */
    RespData save(Zyfxb zyfxb);

    /**
     * 批量删除
     *
     * @param ids
     * @return
     */
    RespData deleteMakeUp(String[] ids);

    /**
     * 导出辅修报名数据
     *
     * @param response
     */
    void export(HttpServletResponse response);

    /**
     * 学生辅修报名信息
     *
     * @param loginName
     * @return
     */
    Zyfxb getByXh(String loginName);

    /**
     * 修改学生辅修报名信息
     *
     * @param zyfxb
     * @return
     */
    RespData updateByXh(Zyfxb zyfxb);

    /**
     * 但因辅修申请表
     *
     * @param xh
     */
    void printApplyTable(String xh);
}