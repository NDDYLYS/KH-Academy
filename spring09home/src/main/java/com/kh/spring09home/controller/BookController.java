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

import com.kh.spring09home.dao.BookDao;
import com.kh.spring09home.dto.BookDto;

@Controller
@RequestMapping("/book") //
public class BookController 
{
	@Autowired
	private BookDao bookDao;
	
	// (+추가) 이 콘트롤러로 들어오는 empty string은 null이다
//	@InitBinder
//	public void InitBinder(WebDataBinder binder) 
//	{
//		binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
//	}
	
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
			List<BookDto> bookList = bookDao.selectList(column, keyword);
			model.addAttribute("bookList", bookList);			
		}
		else 
		{
			List<BookDto> bookList = bookDao.selectList();
			model.addAttribute("bookList", bookList);
		}
		return "/WEB-INF/views/book/list.jsp";
	}
}