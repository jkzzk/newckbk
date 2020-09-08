package com.imust.newckbk.common;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;

import com.imust.newckbk.common.RespData;

//ȫ���쳣������
public class CustomExceptionResolver implements HandlerExceptionResolver {

    // ϵͳ�׳����쳣
    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
                                         Exception ex) {
        String ajax = request.getHeader("X-Requested-With");

        if (StringUtils.isNotEmpty(ajax)) {
            try {
                response.setContentType("text/json;charset=utf-8");
                response.getWriter().write(JSON.toJSONString(RespData.errorMsg(-99, ex.getMessage())));
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {

            // handler���Ǵ�����������Ҫִ�е�Handler����(ֻ��method)
            // �������쳣���͡�
            // ������Ϣ
            String       message      = ex.getMessage();
            ModelAndView modelAndView = new ModelAndView();

            // ��������Ϣ����ҳ��
            modelAndView.addObject("message", message);

            // ָ�򵽴������
            modelAndView.setViewName("error");

            return modelAndView;
        }

        return null;
    }
}



