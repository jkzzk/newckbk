package com.imust.newckbk.realm;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.imust.newckbk.common.Contants;
import com.imust.newckbk.common.RespData;
import com.imust.newckbk.common.RetCode;
import com.imust.newckbk.domain.XsXjxxbViewKw;
import com.imust.newckbk.service.XsXjxxbViewKwService;
import com.imust.newckbk.utils.StringUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

import org.springframework.beans.factory.annotation.Autowired;

import com.imust.newckbk.common.SessionUtils;
import com.imust.newckbk.domain.SysBtn;
import com.imust.newckbk.domain.SysMenu;
import com.imust.newckbk.domain.SysUser;
import com.imust.newckbk.service.SysMenuService;
import com.imust.newckbk.service.SysUserService;
import com.imust.newckbk.utils.Base64;
import com.imust.newckbk.utils.MD5;

/**
 * Created by jkzzk
 * @author jkzzk
 */
public class UserRealm extends AuthorizingRealm {
    @Autowired
    private SysUserService sysUserService;
    @Autowired
    private SysMenuService sysMenuService;
    @Autowired
    private XsXjxxbViewKwService xsXjxxbViewKwService;

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {

        String username = token.getPrincipal().toString();

        Map<String, Object> params = new HashMap<String, Object>();

        params.put("loginName", username);

        SysUser user = sysUserService.getOneByMap(params);

        XsXjxxbViewKw xsXjxxbViewKw = xsXjxxbViewKwService.getById(username);

        if (user == null) {
            if(xsXjxxbViewKw == null || xsXjxxbViewKw.getXh() == "") {
                throw new UnknownAccountException("没有该用户");
            }
            user = new SysUser();
            user.setLoginName(xsXjxxbViewKw.getXh());
            user.setRealName(xsXjxxbViewKw.getXm());
            String pc_password = xsXjxxbViewKw.getSfzh().substring(xsXjxxbViewKw.getSfzh().length() - 6);
            String password   = MD5.encode(pc_password);
            String saltSource = Base64.encode((username + password).getBytes()).replace("\n", "");
            user.setSalt(saltSource);
            user.setPassword(StringUtil.saltCode(saltSource, password));
            user.setRoleIds("2");
        }


        Session session = null;

        ByteSource credentialsSalt = new Md5Hash(user.getSalt());

        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(username,
                                                                     user.getPassword(),
                                                                     credentialsSalt,
                                                                     getName());

        session = (session != null) ? session : SecurityUtils.getSubject().getSession();

        session.setAttribute(SessionUtils.SESSION_USER, user);

        return info;
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principal) {
        SimpleAuthorizationInfo info     = new SimpleAuthorizationInfo();
        String username = principal.getPrimaryPrincipal().toString();
        Map<String, Object>     params   = new HashMap<String, Object>();

        params.put("loginName", username);

        SysUser user    = sysUserService.getOneByMap(params);
        String  roleIds = user.getRoleIds();

        params.put("roleIds", roleIds);

        List<SysMenu> menus = sysMenuService.getMenu(params);

        for (SysMenu menu : menus) {
            if ((menu.getBtns() != null) && (menu.getBtns().size() > 0)) {
                for (SysBtn btn : menu.getBtns()) {
                    info.addRole(btn.getBtnCode().split("-")[0]);
                    info.addStringPermission(btn.getBtnCode());
                }
            }
        }

        return info;
    }

    public static void main(String[] args) {
        String saltSource = Base64.encode(("kfs" + MD5.encode("123456")).getBytes()).replace("\n", "");

        System.out.println(saltSource);

        String hashAlgorithmName = "MD5";
        String credentials       = MD5.encode("123456");

        System.out.println(credentials);

        Object salt = new Md5Hash(saltSource);

        System.out.println(salt);

        int hashIterations = 1;
        Object result = new SimpleHash(hashAlgorithmName, credentials, salt, hashIterations);

        System.out.println(result);
    }

    /**
     * init-method
     */
    public void setCredentialMatcher() {
        HashedCredentialsMatcher credentialsMatcher = new HashedCredentialsMatcher();

        credentialsMatcher.setHashAlgorithmName("MD5");
        credentialsMatcher.setHashIterations(1);
        setCredentialsMatcher(credentialsMatcher);
    }

    @Override
    public String getName() {
        return "userRealm";
    }
}
