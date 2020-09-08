package com.imust.newckbk.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import com.imust.newckbk.base.AbstractService;
import com.imust.newckbk.base.PageEntity;
import com.imust.newckbk.dao.SysAuthorDao;
import com.imust.newckbk.dao.SysRoleDao;
import com.imust.newckbk.domain.SysAuthor;
import com.imust.newckbk.domain.SysRole;
import com.imust.newckbk.eunm.ResType;
import com.imust.newckbk.service.SysRoleService;
import com.imust.newckbk.utils.StringUtil;

/**
 * @date 2017-08-19
 * @author jkzzk
 *
 */
@Service("sysRoleService")
public class SysRoleServiceImpl extends AbstractService<SysRole, String> implements SysRoleService {
    @Autowired
    private SysRoleDao   sysRoleDao;
    @Autowired
    private SysAuthorDao sysAuthorDao;

    @Override
    public int deleteByMap(Map<String, Object> params) {
        params.put("roleIds", params.get("ids"));
        sysAuthorDao.deleteByMap(params);

        return super.deleteByMap(params);
    }

    @Override
    public SysRole insert(SysRole record) {
        record.setCreateTime(new Date());
        record.setDeleted((byte) 0);

        try {
            record = super.insert(record);
            saveAuthor(record);
        } catch (Exception e) {
            e.printStackTrace();

            return null;
        }

        return record;
    }

    @Override
    public PageInfo<SysRole> query(PageEntity<Map> params) {
        PageHelper.startPage(params.getPageNumber(), params.getPageSize());

        return new PageInfo<SysRole>(sysRoleDao.getByMapPage(params.getData()));
    }

    private int saveAuthor(SysRole role) {
        int count = 0;

        if (StringUtil.isNotEmpty(role.getMenuIds())) {
            SysAuthor author = new SysAuthor();

            author.setRoleId(role.getId());

            String[] menuIds = role.getMenuIds().split(",");

            for (String id : menuIds) {
                author.setResId(Integer.parseInt(id));
                author.setResType(ResType.RES_TYPE_MENU.getCode().byteValue());
                sysAuthorDao.insert(author);
                count++;
            }
        }

        if (StringUtil.isNotEmpty(role.getBtnIds())) {
            String[]  btnIds = role.getBtnIds().split(",");
            SysAuthor author = new SysAuthor();

            author.setRoleId(role.getId());

            for (String btn : btnIds) {
                author.setResId(Integer.parseInt(btn));
                author.setResType(ResType.RES_TYPE_BTN.getCode().byteValue());
                sysAuthorDao.insert(author);
                count++;
            }
        }

        return count;
    }

    @Transactional
    @Override
    public int updateById(SysRole record) {
        record.setUpdateTime(new Date());

        try {
            if ((record != null) && (record.getId() != null) && (!record.getId().equals(""))) {
                Map<String, Object> params = new HashMap<String, Object>();

                params.put("roleId", record.getId());
                sysAuthorDao.deleteByMap(params);
            }

            super.updateById(record);

            return saveAuthor(record);
        } catch (Exception e) {
            e.printStackTrace();

            return 0;
        }
    }

    @PostConstruct
    public void setBaseDao() {
        super.setBaseDao(sysRoleDao);
    }
}


