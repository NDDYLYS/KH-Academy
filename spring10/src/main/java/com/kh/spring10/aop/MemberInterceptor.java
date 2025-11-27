package com.kh.spring10.aop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.HandlerInterceptor;

import com.kh.spring10.error.UnauthorizationException;
import com.kh.spring10.service.TokenService;
import com.kh.spring10.vo.TokenVO;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

// 회원만 통과시키난 인터셉터
@Service
public class MemberInterceptor implements HandlerInterceptor {
	@Autowired
	private TokenService tokenService;
	
	@Override
	public boolean preHandle(HttpServletRequest request, // 요청 정보가 담긴 객체, 사용자 정보
			HttpServletResponse response, // 응답 정보가 담긴 객체, 사용자에게 나갈 정보
			Object handler)
			throws Exception {
		
		if (request.getMethod().equalsIgnoreCase("options"))
			return true;
		
		// authorization 검사
		try {
			String authorization = request.getHeader("Authorization");
			if (authorization== null)
				throw new UnauthorizationException("비회원이다.");
			
			TokenVO tokenVO = tokenService.parse(authorization);
			request.setAttribute("tokenVO", tokenVO);
			System.out.println("로그인 상태이다.");
			return true;
		}
		catch(Exception e) {
			System.out.println("로그인 상태가 아니다.");
			e.printStackTrace();
			response.sendError(401);
			return false;
		}
	}
}