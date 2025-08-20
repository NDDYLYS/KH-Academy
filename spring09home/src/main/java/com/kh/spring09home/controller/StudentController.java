package com.kh.spring09home.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.spring09home.dao.StudentDao;
import com.kh.spring09home.dto.PokemonDto;
import com.kh.spring09home.dto.StudentDto;

@Controller
@RequestMapping("/student")
public class StudentController 
{
	@Autowired
	private StudentDao studentDao;
	
	@GetMapping("/add")
	public String add() 
	{
		return "/WEB-INF/views/student/add.jsp";
	}
	
	@PostMapping("/add")
	public String add(@ModelAttribute StudentDto studentDto) 
	{
		studentDao.insert(studentDto);
		//return "/WEB-INF/views/pokemon/add2.jsp";
		return "redirect:addFinish";
	}
	
	@RequestMapping("/addFinish")
	public String addFinish() 
	{
		return "/WEB-INF/views/student/addFinish.jsp";
	}
	
	// 목록 페이지 매핑
	@RequestMapping("/list")
	public String list(Model model) 
	{
		List<StudentDto> studentList = studentDao.selectList();
		model.addAttribute("studentList", studentList);
		return "/WEB-INF/views/student/list.jsp";
	}
}
