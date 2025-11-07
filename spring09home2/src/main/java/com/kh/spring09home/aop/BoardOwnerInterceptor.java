package com.kh.spring09home.aop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.HandlerInterceptor;

import com.kh.spring09home.dao.BoardDao;
import com.kh.spring09home.dto.BoardDto;
import com.kh.spring09home.error.NeedPermissionException;
import com.kh.spring09home.error.TargetNotfoundException;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

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
		
		HttpSession session = request.getSession();
		String loginId = (String)session.getAttribute("loginId");
		String loginLevel = (String)session.getAttribute("loginLevel");
		
		String uri = request.getRequestURI();
		if (loginLevel.equals("관리자") && uri.equals("/board/delete"))
			return true;
		 String boardNoT = request.getParameter("boardNo");
		 int boardNo = Integer.parseInt(boardNoT);
		 BoardDto boardDto = boardDao.selectOne(boardNo);
		 if (boardDto == null)
			 throw new TargetNotfoundException("존재하지 않는 게시글");
		 if (loginId.equals(boardDto.getBoardWriter()) == false)
			 throw new NeedPermissionException("본인의 글만 수정과 삭제가 가능합니다");
		 return true;		
	}
}