package com.imust.newckbk.interceptor;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.imust.newckbk.common.SessionUtils;
import com.imust.newckbk.domain.SysUser;

/**
 * Created by jkzzk
 */
public class LoginInterceptor implements HandlerInterceptor {
    private List<String> uncheckUrls;

    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {}

    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           ModelAndView modelAndView)
            throws Exception {}

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        Session session = SecurityUtils.getSubject().getSession();
        SysUser user    = (SysUser) session.getAttribute(SessionUtils.SESSION_USER);

        if ((null != user)
                || uncheckUrls.contains(request.getServletPath())
                || "/login".equals(request.getServletPath()) ) {
            return true;
        }

        if(request.getServletPath().startsWith("/mobile") && (null == user)) {
            response.sendRedirect(request.getContextPath() + "/mobile/");

            return false;
        }

        if (("/".equals(request.getServletPath())) || ("/logout".equals(request.getServletPath())) || (null == user)) {
            response.sendRedirect(request.getContextPath() + "/");

            return false;
        }

        return false;
    }

    public List<String> getUncheckUrls() {
        return uncheckUrls;
    }

    public void setUncheckUrls(List<String> uncheckUrls) {
        this.uncheckUrls = uncheckUrls;
    }
}
