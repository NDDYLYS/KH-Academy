package com.kh.spring08.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.spring08.dao.StudentDao;
import com.kh.spring08.dto.StudentDto;

@Controller
@RequestMapping("/student")
public class StudentController 
{
	@Autowired
	private StudentDao studentDao;
	
	@RequestMapping("/add1")
	public String add1() 
	{
		return "/WEB-INF/views/student/add1.jsp";
	}
	
	@RequestMapping("/add2")
	public String add2(@ModelAttribute StudentDto studentDto) 
	{
		studentDao.insert(studentDto);
		//return "/WEB-INF/views/pokemon/add2.jsp";
		return "redirect:add3";
	}
	
	@RequestMapping("/add3")
	public String add3() 
	{
		return "/WEB-INF/views/student/add3.jsp";
	}
}
