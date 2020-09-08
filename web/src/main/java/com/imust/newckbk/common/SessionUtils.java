package com.imust.newckbk.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.imust.newckbk.domain.SysUser;

/**
 * @author: jkzzk
 */
public class SessionUtils {
    public static final String SESSION_USER = "SESSION_USER";
    public static final String SESSION_UNIT = "SESSION_UNIT";
    public static final int    SESSION_TIME = 60 * 30;    // (??)

    // ?????????
    public static final String IMG_CODE = "IMG_CODE";

    // ?????????Ч??     ??λ????
    public static final int IMG_VALIDATECODE_INDATE = 600;

    /**
     * ???Session?
     * @param request
     * @param key
     */
    public static void removeAttr(HttpServletRequest request, String key) {
        request.getSession(true).removeAttribute(key);
    }

    /**
     * ??session???????????
     * @param request
     * @return SysUser
     */
    public static void removeUser(HttpServletRequest request) {
        removeAttr(request, SESSION_USER);
    }

    // ?????????
    public static SysUser getCurrentSysUser(HttpServletRequest request) {
        HttpSession session    = request.getSession();
        SysUser     sysAdminVo = (SysUser) session.getAttribute(SESSION_USER);

        if (sysAdminVo != null) {
            return sysAdminVo;
        } else {
            return null;
        }
    }

    // ???session
    public static final HttpSession getSession() {
        HttpServletRequest request =
            ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        HttpSession session = request.getSession();

        return session;
    }

    /**
     * ????session????Ч???
     */
    public static void setSessionValueAndTime(HttpServletRequest request, String key, String value, int time) {
        request.getSession(true).setAttribute(key, value);

        if (time > 0) {
            request.getSession(true).setMaxInactiveInterval(time);
        }
    }

    /**
     * ?????????? ??session
     * @param request
     * @param user
     */
    public static void setUser(HttpServletRequest request, SysUser user) {
        request.getSession(true).setAttribute(SESSION_USER, user);
        request.getSession(true).setMaxInactiveInterval(SESSION_TIME);
    }
}



