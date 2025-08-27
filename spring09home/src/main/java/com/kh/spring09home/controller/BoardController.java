package com.kh.spring09home.controller;

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
import com.kh.spring09home.dto.BookDto;

@Controller
@RequestMapping("/board")
public class BoardController 
{
	@Autowired
	private BoardDao boardDao;
	
	@RequestMapping("/list")
	public String list(Model model, 
			@RequestParam(required = false) String column, 
			@RequestParam(required = false) String keyword) 
	{
		boolean isSearch = column != null && keyword != null;
		model.addAttribute("isSearch", isSearch);
		model.addAttribute("column", column);
		model.addAttribute("keyword", keyword);
		
		if (isSearch) 
		{
			List<BoardDto> boardList = boardDao.selectList(column, keyword);
			model.addAttribute("boardList", boardList);			
		}
		else 
		{
			List<BoardDto> boardList = boardDao.selectList();
			model.addAttribute("boardList", boardList);
		}
		return "/WEB-INF/views/board/list.jsp";
	}
	
	@GetMapping("/add")
	public String add() 
	{
		return "/WEB-INF/views/board/add.jsp";
	}
	
	@PostMapping("/add")
	public String add(@ModelAttribute BoardDto boardDto) 
	{
		boardDao.add(boardDto);
		return "redirect:/board/list";
	}
}
