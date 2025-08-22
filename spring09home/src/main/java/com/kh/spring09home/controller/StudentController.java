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

import com.kh.spring09home.dao.StudentDao;
import com.kh.spring09home.dto.StudentDto;
import com.kh.spring09home.error.TargetNotfoundException;

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
			List<StudentDto> studentList = studentDao.selectList(column, keyword);
			model.addAttribute("studentList", studentList);			
		}
		else 
		{
			List<StudentDto> studentList = studentDao.selectList();
			model.addAttribute("studentList", studentList);
		}
		return "/WEB-INF/views/student/list.jsp";
	}
	
	@RequestMapping("/detail")
	public String detail(Model model,
						@RequestParam int studentNo) 
	{
		StudentDto studentDto = studentDao.selectOne(studentNo);
		model.addAttribute("studentDto", studentDto);
		
		return "/WEB-INF/views/student/detail.jsp";
	}
	
	@GetMapping("/edit")
	public String edit(Model model,
			@RequestParam int studentNo)
	{
		StudentDto studentDto = studentDao.selectOne(studentNo);
		if (studentDto == null) 
		{
			//return "redirect:list"; // 에러페이지매핑
			//throw new RuntimeException("존재하지 않는 포켓몬 번호");
			throw new TargetNotfoundException("존재하지 않는 학생 번호");
		}
		
		model.addAttribute("studentDto", studentDto);
		return "/WEB-INF/views/student/edit.jsp";
	}
	
	@PostMapping("/edit")
	public String edit(@ModelAttribute StudentDto studentDto) 
	{
		studentDao.update(studentDto);
		return "redirect:detail?studentNo=" + studentDto.getStudentNo();
	}
	
	@RequestMapping("/remove")
	public String remove(@RequestParam int studentNo)
	{
		StudentDto studentDto = studentDao.selectOne(studentNo);
		if (studentDto == null) 
		{
			throw new TargetNotfoundException("존재하지 않는 학생 번호");
		}
		
		studentDao.delete(studentNo);
		return "redirect:list";
	}
}
