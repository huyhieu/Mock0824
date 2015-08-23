package com.viettel.validation.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class SubdomainHandlerInterceptor extends HandlerInterceptorAdapter {

	 @Override
	    public boolean preHandle(HttpServletRequest request,
	            HttpServletResponse response, Object handler) throws Exception {

	        System.out.println(request.getServletPath());
	        return super.preHandle(request, response, handler);
	    }
}