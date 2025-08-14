package com.kh.spring04jdbc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kh.spring04jdbc.dao.StudentDao;
import com.kh.spring04jdbc.dto.PokemonDto;
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

	@RequestMapping("/add")
	public String add(@ModelAttribute StudentDto studentDto) 
	{
		studentDao.insert(studentDto);
		return "학생 등록 완료";
	}
	
	@RequestMapping("/edit")
	public String edit(@ModelAttribute StudentDto studentDto) 
	{
		boolean success = studentDao.update(studentDto);
		if (success)
			return "학생 수정 완료";
		else
			return "학생 수정 실패";
	}
	
	@RequestMapping("/remove")
	public String remove(@RequestParam int studentNo) 
	{
		boolean success = studentDao.delete(studentNo);
		if (success)
			return "학생 삭제 완료";
		else
			return "학생 삭제 실패";
	}
	
	@RequestMapping("/select")
	public String select() 
	{
		List<StudentDto> list = studentDao.selectList();
		String total = "";
		for(StudentDto element : list) 
		{
			total += element;
			total += "\\n";
		}
		return total;
	}
	
	
	// http://localhost:8080/student/list?column=student_name&keyword=이가이
	@RequestMapping("/list")
	public String list(@RequestParam(required = false, defaultValue = "") String column, 
			@RequestParam(required = false, defaultValue = "") String keyword) 
	{
		List<StudentDto> list = null;
		if (column.equals("") || keyword.equals(""))
			list = studentDao.selectList();
		else
			list = studentDao.selectList(column, keyword);
		
		StringBuffer buffer = new StringBuffer();		
		buffer.append("학생 수 : " + list.size() + "<br>");
		for(StudentDto solo : list)
		{
			buffer.append(solo);
			buffer.append("<br>");			
		}
		
		return buffer.toString();
	}
	
	@RequestMapping("/detail")
	public String detail(@RequestParam int studentNo) 
	{
		StudentDto studentDto = studentDao.selectOne(studentNo);
		if (studentDto == null)
			return "존재하지 않는 학생입니다.";
			
		StringBuffer buffer = new StringBuffer();
	
		buffer.append("학생 : " + studentDto.getStudentName() + "<br>");
		buffer.append(studentDto);
		buffer.append("<br>");
		
		return buffer.toString();
	}
}
