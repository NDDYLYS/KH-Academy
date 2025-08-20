package com.kh.spring09home.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.spring09home.dao.BookDao;
import com.kh.spring09home.dto.BookDto;

@Controller
@RequestMapping("/book") //
public class BookController 
{
	@Autowired
	private BookDao bookDao;
	
	@RequestMapping("/add1")
	public String add1() 
	{
		return "/WEB-INF/views/book/add1.jsp";
	}
	
	@RequestMapping("/add2")
	public String add2(@ModelAttribute BookDto bookDto) 
	{
		bookDao.insert(bookDto);
		//return "/WEB-INF/views/pokemon/add2.jsp";
		return "redirect:add3";
	}
	
	@RequestMapping("/add3")
	public String add3() 
	{
		return "/WEB-INF/views/book/add3.jsp";
	}
}