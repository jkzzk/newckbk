package com.imust.newckbk.controller;

import com.imust.newckbk.common.RespData;
import com.imust.newckbk.common.SessionUtils;
import com.imust.newckbk.domain.SysMenu;
import com.imust.newckbk.domain.SysRole;
import com.imust.newckbk.domain.SysUser;
import com.imust.newckbk.service.SysMenuService;
import com.imust.newckbk.service.SysRoleService;
import com.imust.newckbk.utils.MD5;
import com.imust.newckbk.utils.StringUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping("/mobile")
public class MobileLoginController {

    @Autowired
    private SysRoleService sysRoleService;
    @Autowired
    private SysMenuService sysMenuService;

    @RequestMapping(value = "/")
    public String login() {
        return "mobile/login";
    }

    @RequestMapping(value = "/login")
    @ResponseBody
    public RespData login(String username, String password, HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token   = new UsernamePasswordToken(username, MD5.encode(password));

        try {

            if(username.equals("admin")) {
                return RespData.errorMsg("手机端只允许学生登录");
            }
            subject.login(token);

            return RespData.successMsg("登录成功");
        } catch (UnknownAccountException ex) {
            return RespData.errorMsg("没有该用户");
        } catch (IncorrectCredentialsException ex) {
            return RespData.errorMsg("密码或用户名不对");
        } catch (AuthenticationException ae) {
            ae.printStackTrace();
            return RespData.errorMsg("身份验证失败");
        }
    }

    @RequestMapping(value = "index")
    public String index(Model model) {
        SysUser user = (SysUser) SecurityUtils.getSubject().getSession().getAttribute(SessionUtils.SESSION_USER);
        model.addAttribute("user", user);
        return "/mobile/index";
    }

    @RequestMapping("/reswitch")
    public String reswitch() {
        return "/mobile/reswitch";
    }

}
