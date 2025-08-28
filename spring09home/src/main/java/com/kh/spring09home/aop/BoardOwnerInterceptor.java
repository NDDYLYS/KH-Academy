package com.kh.spring09home.aop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.HandlerInterceptor;

import com.kh.spring09home.dao.BoardDao;
import com.kh.spring09home.dto.BoardDto;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Service
public class BoardOwnerInterceptor implements HandlerInterceptor
{
	@Autowired
	private BoardDao boardDao;
	
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response,
			Object handler)
			throws Exception {
		
		boolean isAdmin = request.getSession().getAttribute("loginLevel").equals("관리자");
		if (isAdmin)
			return true;
		 String boardNoT = request.getParameter("boardNo");
		 long boardNo = Long.parseLong(boardNoT);
		 BoardDto boardDto = boardDao.selectOne(boardNo);
		 String loginId = (String)request.getSession().getAttribute("loginId");
		 
		 return boardDto.getBoardWriter().equals(loginId);		
	}
}