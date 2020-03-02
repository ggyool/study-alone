package org.ggyool.guestbook.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LogInterceptor extends HandlerInterceptorAdapter{
	
	// Controller 메소드가 실행되기 전에 실행
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		//System.out.println(handler.toString() +" 을 호출했습니다.");
		return true;
	}
	
	// Controller 메소드가 실행 된 후 실행
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		//System.out.println(handler.toString() +" 가 종료되었습니다.");
		//System.out.println(modelAndView.getViewName() + "을 view로 사용합니다.");
	}
	
}
