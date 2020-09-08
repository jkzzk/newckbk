package com.imust.newckbk.controller;

import java.io.IOException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.imust.newckbk.service.XsXjxxbViewKwService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.imust.newckbk.common.RespData;
import com.imust.newckbk.common.RetCode;
import com.imust.newckbk.common.SessionUtils;
import com.imust.newckbk.domain.SysMenu;
import com.imust.newckbk.domain.SysRole;
import com.imust.newckbk.domain.SysUser;
import com.imust.newckbk.service.SysMenuService;
import com.imust.newckbk.service.SysRoleService;
import com.imust.newckbk.utils.MD5;
import com.imust.newckbk.utils.StringUtil;
import com.imust.newckbk.utils.ValidateCodeUtil;

/**
 * Created by jkzzk on 2017/8/18.
 */
@Controller
public class LoginController {
    @Autowired
    private SysRoleService sysRoleService;
    @Autowired
    private SysMenuService sysMenuService;
    @Autowired
    private XsXjxxbViewKwService xsXjxxbViewKwService;

    /**
     * 首页
     */
    @RequestMapping(value = "index")
    public String index(Model model) {
        SysUser user = (SysUser) SecurityUtils.getSubject().getSession().getAttribute(SessionUtils.SESSION_USER);
        Map<String, Object> params = new HashMap<String, Object>();

        params.put("roleIds", user.getRoleIds());

        List<SysRole> roles   = sysRoleService.getByMap(params);
        String roleIds = "";

        for (SysRole role : roles) {
            roleIds += role.getId() + ",";
        }

        List<SysMenu> menus = null;

        if (StringUtil.isNotEmpty(roleIds)) {
            params.clear();
            params.put("roleIds", roleIds.substring(0, roleIds.length() - 1));
            menus = sysMenuService.getMenu(params);
        }

        model.addAttribute("menus", menus);
        model.addAttribute("user", user);

        return "index";
    }

    @RequestMapping(value = "/")
    public String login() {
        return "login";
    }

    /**
     * 登录
     */
    @RequestMapping(value = "login")
    @ResponseBody
    public RespData login(String username, String password, String code, HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        //验证码
        /*
         * String sessionCode = (String) SessionUtils.getSession().getAttribute(SessionUtils.IMG_CODE);
         * if (!code.equalsIgnoreCase(sessionCode)) {
         *   return RespData.errorMsg(RetCode.ACTIVE_EXCEPTION.getCode(), "????????");
         * }
         */
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token   = new UsernamePasswordToken(username, MD5.encode(password));

        try {

            subject.login(token);

            return RespData.successMsg("登录成功");
        } catch (UnknownAccountException ex) {
            return RespData.successMsg("没有该用户");
        } catch (IncorrectCredentialsException ex) {
            return RespData.errorMsg("密码或用户名不对");
        } catch (AuthenticationException ae) {
            ae.printStackTrace();
            return RespData.errorMsg("身份验证失败");
        }
    }

    /**
     * 登出
     */
    @RequestMapping(value = "logout")
    public String logout() {
        Subject subject = SecurityUtils.getSubject();

        if (subject != null) {
            subject.logout();
        }

        return "login";
    }

    /**
     * 验证码
     */
/*    @RequestMapping(value = "/validateCode")
    public String validateCode(HttpServletResponse response) {

        response.setContentType("image/jpeg");

        response.setHeader("Pragma", "no-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);

        ValidateCodeUtil code = new ValidateCodeUtil(120, 40, 0, 0);

        SessionUtils.getSession().setAttribute(SessionUtils.IMG_CODE, code.getCode());

        try {
            code.write(response.getOutputStream());
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }*/
}
