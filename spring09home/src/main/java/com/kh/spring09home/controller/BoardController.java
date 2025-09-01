package com.kh.spring09home.controller;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kh.spring09home.dao.BoardDao;
import com.kh.spring09home.dto.BoardDto;
import com.kh.spring09home.error.TargetNotfoundException;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/board")
public class BoardController {
	@Autowired
	private BoardDao boardDao;

	@RequestMapping("/list")
	public String list(Model model, 
			@RequestParam(required = false) String column,
			@RequestParam(required = false) String keyword) {
		boolean isSearch = column != null && keyword != null;
		model.addAttribute("isSearch", isSearch);
		model.addAttribute("column", column);
		model.addAttribute("keyword", keyword);

		List<BoardDto> boardList = null;
		if (isSearch) 
		{
			boardList = boardDao.selectList(column, keyword);
		} 
		else 
		{
			boardList = boardDao.selectList();
		}
		
		//int boardCount = boardList.size();
		//model.addAttribute("boardCount", boardCount);
		model.addAttribute("boardList", boardList);
		return "/WEB-INF/views/board/list.jsp";
	}

	@GetMapping("/insert")
	public String insert() {
		return "/WEB-INF/views/board/insert.jsp";
	}

	@PostMapping("/insert")
	public String insert(HttpSession session,
			@ModelAttribute BoardDto boardDto) {
		String loginId = (String)session.getAttribute("loginId");
		boardDto.setBoardWriter(loginId);
		int boardNo = boardDao.insertSequence();
		boardDto.setBoardNo(boardNo);
		boardDao.insert(boardDto);
		return "redirect:/board/detail?boardNo=" + boardNo;
	}

	@RequestMapping("/detail")
	public String detail(HttpSession session,
			Model model, 
			@RequestParam int boardNo) {
		BoardDto boardDto = boardDao.selectOne(boardNo);
		if (boardDto == null) 
			throw new TargetNotfoundException("존재하지 않는 게시글 번호");
		String loginId = (String)session.getAttribute("loginId");
		if (loginId == null)
			throw new TargetNotfoundException("존재하지 않는 회원입니다");
		
		model.addAttribute("boardDto", boardDto);

		return "/WEB-INF/views/board/detail.jsp";
	}
	
//	@RequestMapping("/like")
//	public String like(Model model,
//			@RequestParam long boardNo) {
//		BoardDto boardDto = boardDao.selectOne(boardNo);
//		if (boardDto == null) 
//			throw new TargetNotfoundException("존재하지 않는 게시글 번호");
//		model.addAttribute("boardDto", boardDto);
//		boardDao.like(boardNo);
//		return "/WEB-INF/views/board/detail.jsp";
//	}
	
	@GetMapping("/update")
	public String update(Model model,
			@RequestParam int boardNo)
	{
		BoardDto boardDto = boardDao.selectOne(boardNo);
		if (boardDto == null) 
			throw new TargetNotfoundException("존재하지 않는 게시글 번호");
		model.addAttribute("boardDto", boardDto);
		return "/WEB-INF/views/board/update.jsp";
	}
	
	@PostMapping("/update")
	public String update(@ModelAttribute BoardDto boardDto) 
	{
		boardDao.update(boardDto);
		return "redirect:detail?boardNo=" + boardDto.getBoardNo();
	}
	
	@RequestMapping("/delete")
	public String delete(@RequestParam int boardNo)
	{
		BoardDto boardDto = boardDao.selectOne(boardNo);
		if (boardDto == null) 
			throw new TargetNotfoundException("존재하지 않는 게시글 번호");		
		boardDao.delete(boardNo);
		return "redirect:list";
	}
}
