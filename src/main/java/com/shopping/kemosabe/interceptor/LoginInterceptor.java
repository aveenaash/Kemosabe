package com.shopping.kemosabe.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.shopping.kemosabe.domain.UserRegistration;

@Component
public class LoginInterceptor extends HandlerInterceptorAdapter {
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		System.out.println("GreetingInterceptor: REQUEST Intercepted for URI: "
				+ request.getRequestURI());
		
		return true;
	}
	
	public void postHandle(
			HttpServletRequest request, HttpServletResponse response, 
			Object handler, ModelAndView modelAndView){
		if (request.getRequestURI().contains("kemosabe/user/home")){
			System.out.println("reached Here");
			System.out.println(request.getParameter("isLoggedIn") == null);
			if (request.getParameter("isLoggedIn") != null) {
				if (((String)request.getParameter("isLoggedIn")).equalsIgnoreCase("true")){
					return;
				}
			} 
			UserRegistration user = new UserRegistration();
			modelAndView.addObject("user", user);
			modelAndView.setViewName("redirect:/login");
		}
	}
}