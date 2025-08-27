package com.kh.spring09home.aop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.HandlerInterceptor;

import com.kh.spring09home.dao.MemberDao;
import com.kh.spring09home.dto.MemberDto;
import com.kh.spring09home.error.NeedPermissionException;
import com.kh.spring09home.error.TargetNotfoundException;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Service
public class PreventAdminInterceptor implements HandlerInterceptor
{
	@Autowired
	private MemberDao memberDao;
	
// 관리자 페이지에서 상세, 수정, 삭제할 떄 관리자는 차단하는 인터셉터
	@Override
	public boolean preHandle(HttpServletRequest request, // 요청 정보가 담긴 객체, 사용자 정보
			HttpServletResponse response, // 응답 정보가 담긴 객체, 사용자에게 나갈 정보
			Object handler)
			throws Exception 
	{
		String memberId = request.getParameter("memberId");
		if (memberId == null)
			throw new NeedPermissionException("허용되지 않은 접근");
		MemberDto memberDto = memberDao.selectOne(memberId);
		if (memberDto == null)
			throw new TargetNotfoundException("존재하지 않는 회원");
		
		boolean isAdmin = memberDto.getMemberLevel().equals("관리자");
		if (isAdmin)
			throw new NeedPermissionException("관리자에 대한 접근은 금지");
		
		return true;
	}
}
