package com.kh.spring09home.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kh.spring09home.dao.BoardLikeDao;
import com.kh.spring09home.vo.BoardLikeVO;

import jakarta.servlet.http.HttpSession;

@CrossOrigin
@RestController
@RequestMapping("/rest/board")
public class BoardRestController 
{
	@Autowired
	private BoardLikeDao boardLikeDao;
	
	@GetMapping("/check")
	public BoardLikeVO check(HttpSession session, @RequestParam int boardNo) 
	{
		String loginId = (String)session.getAttribute("loginId");
		boolean result = boardLikeDao.check(loginId, boardNo);		
		int count = boardLikeDao.countByBoardNo(boardNo);
		
		BoardLikeVO boardLikeVO = new BoardLikeVO();
		boardLikeVO.setLike(result);
		boardLikeVO.setCount(count);
		return boardLikeVO;
	}
	
	@GetMapping("/action")
	public BoardLikeVO action(HttpSession session, @RequestParam int boardNo) 
	{
		String loginId = (String)session.getAttribute("loginId");
		
		BoardLikeVO boardLikeVO = new BoardLikeVO();
		if(boardLikeDao.check(loginId, boardNo)) {//좋아요를 누른 이력이 있으면
			boardLikeDao.delete(loginId, boardNo);
			boardLikeVO.setLike(false);
		}
		else {//좋아요를 누른 이력이 없으면
			boardLikeDao.insert(loginId, boardNo);
			boardLikeVO.setLike(true);
		}
		int count = boardLikeDao.countByBoardNo(boardNo);
		boardLikeVO.setCount(count);
		return boardLikeVO;
	}
}