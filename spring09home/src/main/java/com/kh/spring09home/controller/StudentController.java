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
import com.kh.spring09home.vo.PageVO;

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
	
	@RequestMapping("/list")
	public String list(Model model, @ModelAttribute(value = "pageVO") PageVO pageVO) 
	{
		model.addAttribute("studentList", studentDao.selectListWithPaging(pageVO));
		pageVO.setDataCount(studentDao.count(pageVO));
		model.addAttribute("pageVO", pageVO); // @ModelAttribute에 value 설정시 생략 가능
		
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
			throw new TargetNotfoundException("존재하지 않는 학생 번호");

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
			throw new TargetNotfoundException("존재하지 않는 학생 번호");
		
		studentDao.delete(studentNo);
		return "redirect:list";
	}
}
