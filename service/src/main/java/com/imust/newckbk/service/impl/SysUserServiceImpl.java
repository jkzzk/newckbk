package com.imust.newckbk.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import com.imust.newckbk.base.AbstractService;
import com.imust.newckbk.base.PageEntity;
import com.imust.newckbk.common.Contants;
import com.imust.newckbk.dao.SysUserDao;
import com.imust.newckbk.domain.SysUser;
import com.imust.newckbk.service.SysUserService;
import com.imust.newckbk.utils.Base64;
import com.imust.newckbk.utils.MD5;
import com.imust.newckbk.utils.SnowRakeIdGenerator;
import com.imust.newckbk.utils.StringUtil;

/**
 * @date 2017-08-19
 * @author jkzzk
 *
 */
@Service("sysUserService")
public class SysUserServiceImpl extends AbstractService<SysUser, String> implements SysUserService {
    @Autowired
    private SysUserDao          sysUserDao;
    @Autowired
    private SnowRakeIdGenerator snowRakeIdGenerator;

    public boolean changePwd(SysUser user) {
        String              password   = MD5.encode(user.getPassword());
        String              saltSource = Base64.encode((user.getLoginName() + password).getBytes()).replace("\n", "");
        Map<String, Object> params     = new HashMap<String, Object>();

        params.put("id", user.getId());
        params.put("password", StringUtil.saltCode(saltSource, password));
        params.put("salt", saltSource);

        int result = sysUserDao.updateByMap(params);

        return (result > 0)
               ? true
               : false;
    }

    public static void main(String[] args) {

        String  password   = MD5.encode("123456");
        String  saltSource = Base64.encode(("adminjwk" + password).getBytes()).replace("\n", "");
        System.out.println(saltSource);
        System.out.println(StringUtil.saltCode(saltSource, password));
    }

    @Override
    public SysUser insert(SysUser record) {
        String password   = MD5.encode(Contants.INIT_PASSWORD);
        String saltSource = Base64.encode((record.getLoginName() + password).getBytes()).replace("\n", "");

        record.setPassword(StringUtil.saltCode(saltSource, password));
        record.setCreateTime(new Date());
        record.setDeleted((byte) 0);
        record.setSalt(saltSource);

        return super.insert(record);
    }

    @Override
    public PageInfo<SysUser> query(PageEntity<Map> params) {
        PageHelper.startPage(params.getPageNumber(), params.getPageSize());

        return new PageInfo<>(sysUserDao.getByMapPage(params.getData()));
    }

    @Override
    public int updateById(SysUser record) {
        record.setUpdateTime(new Date());

        return super.updateById(record);
    }

    @PostConstruct
    public void setBaseDao() {
        super.setBaseDao(sysUserDao);
    }
}



