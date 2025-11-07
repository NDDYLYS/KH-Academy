package com.kh.spring09home.aop;

import org.springframework.stereotype.Service;
import org.springframework.web.servlet.HandlerInterceptor;

import com.kh.spring09home.error.NeedPermissionException;
import com.kh.spring09home.error.UnauthorizationException;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Service
public class AdvencedMemberInterceptor implements HandlerInterceptor
{
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response,
			Object handler)
			throws Exception {

		HttpSession session = request.getSession();
		String loginLevel = (String)session.getAttribute("loginLevel");
		
		if (loginLevel.equals("일반회원"))
			throw new NeedPermissionException("권한이 부족합니다.");
		return true;		
	}
}
