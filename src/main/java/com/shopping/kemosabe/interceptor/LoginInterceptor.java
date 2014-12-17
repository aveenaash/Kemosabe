package com.shopping.kemosabe.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.shopping.kemosabe.domain.UserRegistration;

@Component
@SessionAttributes ({"isLoggedIn", "loggedUser"})
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
		
		String adminSitesSignature[] = {"kemosabe/user/"};
		boolean URIFound = false;
		for (String a : adminSitesSignature){
			if (request.getRequestURI().contains(a)){
				URIFound = true;
				break;
			}
		}
		
		if (URIFound){
			//System.out.println(((ModelMap) modelAndView.getModel()).get("loggedUser") == null);
			if (((ModelMap) modelAndView.getModel()).get("loggedUser") == null) {
				UserRegistration user = new UserRegistration();
				modelAndView.addObject("user", user);
				modelAndView.setViewName("redirect:/login");
			}
		}
		return;
	}
}