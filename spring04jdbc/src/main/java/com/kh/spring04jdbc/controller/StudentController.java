package com.kh.spring04jdbc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.kh.spring04jdbc.dao.StudentDao;
import com.kh.spring04jdbc.dto.StudentDto;

@RestController
@RequestMapping("/student")
public class StudentController 
{
	@Autowired
	private StudentDao studentDao;
	
	@RequestMapping("/home")
	public String home() 
	{
		return "학생 페이지 완료";
	}

	@RequestMapping("/insert")
	public String insert(@ModelAttribute StudentDto studentDto) 
	{
		studentDao.insert(studentDto);
		return "학생 등록 완료";
	}
}
