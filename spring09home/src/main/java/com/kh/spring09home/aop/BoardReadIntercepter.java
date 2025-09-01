package com.kh.spring09home.aop;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.HandlerInterceptor;

import com.kh.spring09home.dao.BoardDao;
import com.kh.spring09home.dto.BoardDto;
import com.kh.spring09home.error.TargetNotfoundException;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Service
public class BoardReadIntercepter implements HandlerInterceptor
{
	@Autowired
	private BoardDao boardDao;
	
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response,
			Object handler)
			throws Exception {
		
		HttpSession session = request.getSession();
		String loginId = (String) session.getAttribute("loginId");
		int boardNo = Integer.parseInt(request.getParameter("boardNo"));
		
		BoardDto boardDto = boardDao.selectOne(boardNo);
		if (boardDto == null)
				throw new TargetNotfoundException("존재하지 않는 게시글");
		if (loginId != null && boardDto.getBoardWriter() != null) 
		{
			if (loginId.equals(boardDto.getBoardWriter())) 
			{
				return true; // 내 글일 때는 그냥 통과
			}
		}
		
		String loginLevel = (String)session.getAttribute("loginLevel");
		if (loginLevel != null && loginLevel.equals("관리자")) 
		{
			return true; // 관리자는 조회수가 오르지 않는다
		}
		
		Set<Integer> history = (Set<Integer>)session.getAttribute("history");
		if (history == null)
			history = new HashSet<>();
		if (history.contains(boardNo))
			return true;
		else
			history.add(boardNo);
		session.setAttribute("history", history);
		
		boardDao.read(boardDto.getBoardNo());
		return true;		
	}
}