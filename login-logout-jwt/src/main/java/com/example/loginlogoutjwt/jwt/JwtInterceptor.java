package com.example.loginlogoutjwt.jwt;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
@Component
public class JwtInterceptor extends HandlerInterceptorAdapter{
	
	
	@Autowired
	private JwtUtils jwtutil;
@Override
public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
		throws Exception {
//	System.out.println("URL "+request.getRequestURI());
	
	
	String auth=request.getHeader("authorization");
	if( !(request.getRequestURI().contains("login") || request.getRequestURI().contains("signup"))) {
		jwtutil.verify(auth);
	}
	//System.out.println("AUTH "+auth);
	
	//System.out.println("----PRE HANDLE----");
	return super.preHandle(request, response, handler);
}
}
