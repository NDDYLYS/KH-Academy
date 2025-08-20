package com.kh.spring09home.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.spring09home.dao.BookDao;
import com.kh.spring09home.dto.BookDto;

@Controller
@RequestMapping("/book") //
public class BookController 
{
	@Autowired
	private BookDao bookDao;
	
	@GetMapping("/save")
	public String save() 
	{
		return "/WEB-INF/views/book/save.jsp";
	}
	
	@PostMapping("/save")
	public String save(@ModelAttribute BookDto bookDto) 
	{
		bookDao.insert(bookDto);
		//return "/WEB-INF/views/pokemon/add2.jsp";
		return "redirect:saveFinish";
	}
	
	@RequestMapping("/saveFinish")
	public String saveFinish() 
	{
		return "/WEB-INF/views/book/saveFinish.jsp";
	}
}