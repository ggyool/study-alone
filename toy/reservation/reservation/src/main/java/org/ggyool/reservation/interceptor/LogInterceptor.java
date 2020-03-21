package org.ggyool.reservation.interceptor;



import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LogInterceptor extends HandlerInterceptorAdapter{

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {	
		String clientIP = request.getRemoteAddr();
		StringBuffer URL = request.getRequestURL();
		Date currentTime = new Date();		
		logger.info("currentTime : {}", currentTime.toString());
		logger.info("clientIP : {}", clientIP);
		logger.info("URL : {}", URL);
		logger.info("-------------------------------------------------------------------------------------");
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
	}
	
}
