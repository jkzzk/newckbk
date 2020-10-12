package com.imust.newckbk.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;

import com.imust.newckbk.common.Contants;
import com.imust.newckbk.common.DefaultPage;
import com.imust.newckbk.common.RespData;
import com.imust.newckbk.common.SessionUtils;
import com.imust.newckbk.domain.SysRole;
import com.imust.newckbk.domain.SysUser;
import com.imust.newckbk.service.SysRoleService;
import com.imust.newckbk.service.SysUserService;

/**
 * 用户
 */
@Controller
@RequestMapping("/user")
public class SysUserController {
    private static final Logger log = LoggerFactory.getLogger("controller");
    @Autowired
    private SysUserService      sysUserService;
    @Autowired
    private SysRoleService      sysRoleService;

    /**
     * 修改失败
     * @param newpassword
     * @return
     */
    @RequestMapping("changepwd")
    public @ResponseBody
    RespData changePwd(HttpServletRequest request, String newpassword) {
        SysUser user = SessionUtils.getCurrentSysUser(request);

        try {
            user.setPassword(newpassword);

            if (sysUserService.changePwd(user)) {
                return RespData.successMsg("修改成功");
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.error("系统异常" + e);

            return RespData.errorMsg("修改失败");
        }

        return RespData.errorMsg("系统异常");
    }

    /**
     * ɾ���û�
     * @param params
     * @return
     */
    @RequestMapping("del")
    public @ResponseBody
    RespData del(@RequestParam Map params) {
        log.info("ɾ���û� params=��" + params + "��");

        try {
            if (sysUserService.deleteByMap(params) > 0) {
                return RespData.successMsg("��ɾ����");
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.error("ϵͳ�쳣��" + e);

            return RespData.errorMsg("ϵͳ�쳣��");
        }

        return RespData.errorMsg("ɾ��ʧ��!");
    }

    /**
     * ����û�
     * @param user
     * @return
     */
    @RequestMapping("edit")
    public String edit(SysUser user, Model m) {
        List<SysRole> roles = null;

        if ((user.getId() != null) && (!user.getId().equals(""))) {
            user = sysUserService.getById(user.getId());
        }

        roles = sysRoleService.getAll();
        m.addAttribute("user", user);
        m.addAttribute("roles", roles);

        return "user/edit";
    }

    /**
     * �û��б�
     * @param params
     * @param m
     * @return
     */
    @RequestMapping("list")
    public String list(@RequestParam Map params, Model m) {
        log.info("��ȡ�û��б� params = ��" + params + "��");

        PageInfo<SysUser> page = sysUserService.query(DefaultPage.setDefaultPage(params));

        m.addAttribute("page", page);
        m.addAttribute("params", params);

        return "user/list";
    }

    /**
     * �����û�
     * @param user
     * @param request
     * @return
     */
    @RequestMapping("save")
    public @ResponseBody
    RespData save(SysUser user, HttpServletRequest request) {
        log.info("�����û�");

        SysUser sess = SessionUtils.getCurrentSysUser(request);
        int     flag = 0;

        try {
            if ((user.getId() != null) && (!user.getId().equals(""))) {
                user.setUpdateBy(sess.getId());
                flag = sysUserService.updateById(user);
            } else {
                user.setCreateBy(sess.getId());
                sysUserService.insert(user);
            }

            if ((flag > 0) || ((user.getId() != null) && (!user.getId().equals("")))) {
                String msg = (flag > 0)
                             ? "�����ɹ���"
                             : "�����ɹ�����ʼ����Ϊ��" + Contants.INIT_PASSWORD;

                return RespData.successMsg(msg);
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.error("ϵͳ�쳣��" + e);

            return RespData.errorMsg("ϵͳ�쳣��");
        }

        return RespData.errorMsg("����ʧ�ܣ�");
    }

    /**
     * Description:�޸�����ҳ��<br>
     * url: /<br>
     * create by: dong gui peng<br>
     * date: 2019/7/3 0003 18:31 <br>
     * @param: JSON:{}<br>
     * @return: java.lang.String<br>
     */
    @RequestMapping("tochange")
    public String toChange(String id, Model m) {
        SysUser user = sysUserService.getById(id);

        m.addAttribute("user", user);

        return "user/change-pwd";
    }

    /**
     * У���û����Ƿ����
     * @param params
     * @return
     */
    @RequestMapping("exist")
    public @ResponseBody
    RespData isExist(@RequestParam Map params) {
        List<SysUser> users = sysUserService.getByMap(params);

        if ((users != null) && (users.size() > 0)) {
            return RespData.errorMsg("���û��Ѵ���!");
        }

        return RespData.successMsg("");
    }
}



