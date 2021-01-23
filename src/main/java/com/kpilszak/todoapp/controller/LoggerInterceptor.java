package com.kpilszak.todoapp.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
class LoggerInterceptor implements HandlerInterceptor {
	public static final Logger logger = LoggerFactory.getLogger(LoggerInterceptor.class);
	
	@Override
	public boolean preHandle(
			final HttpServletRequest request, final HttpServletResponse response, final Object handler
	) throws Exception {
		logger.info("[preHandle]" + request.getMethod() + " " + request.getRequestURI());
		return true;
	}
}
