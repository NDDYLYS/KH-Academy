package com.kh.spring09home.aop;

import org.springframework.stereotype.Service;
import org.springframework.web.servlet.HandlerInterceptor;

import com.kh.spring09home.error.UnauthorizationException;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Service
public class MemberLoginInterceptor implements HandlerInterceptor
{
	@Override
	public boolean preHandle(HttpServletRequest request, // 요청 정보가 담긴 객체, 사용자 정보
			HttpServletResponse response, // 응답 정보가 담긴 객체, 사용자에게 나갈 정보
			Object handler)
			throws Exception {

		// 사용자의 정보를 조회하고 싶을 때는 Request 서용
		// 사용자의 결과화면을 제어하고 싶을 떄는 Response 사용
		HttpSession session = request.getSession();
		String loginId = (String)session.getAttribute("loginId");
		// 세션에 loginId가 존재한다면
		boolean isMember = loginId != null;
		
		System.out.println("멤버 로그인 인터셉터 실행");
		if (isMember) // 회원이면
		{
			return true;			
		}
		else 
		{
			// 차단하기 전에 사용자에게 보여줄 내용을 설정하도록 구현
			//response.sendRedirect("/member/login");
			//response.sendError(401);
			throw new UnauthorizationException("로그인이 필요합니다.");
		}		
	}
}
