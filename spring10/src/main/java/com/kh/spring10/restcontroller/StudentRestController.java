package com.kh.spring10.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kh.spring10.dao.StudentDao;
import com.kh.spring10.dto.StudentDto;

@CrossOrigin // CORS 해제
@RestController
@RequestMapping("/student")
public class StudentRestController 
{
	@Autowired
	private StudentDao studentDao;
	
	// 앞으로의 주소 생성 방식 -> 자원기반(Resource Oriented Architecture)
	// 포켓몬은 /pokemon으로 처리
	// 방식이 다르면 같은 주소도 여러 개 사용 가능
	// 사용 가능 방식 : get, post, put, patch, delete
	// CRUD와 전송 방식을 매칭시킨다
	// post -> create(등록)
	// get -> read(데이터 변조가 없음)
	// put/patch -> update(전체 변경/일부 변경)
	// delete -> delete
	
	// /pokemon/ [post]
	
	@PostMapping("/")
	public void insert(@RequestBody StudentDto studentDto) 
	{
		int studentNo = studentDao.sequence();
		studentDto.setStudentNo(studentNo);
		studentDao.insert(studentDto);
	}
	
	@GetMapping("/")
	public List<StudentDto> list()
	{
		List<StudentDto> list = studentDao.selectList();
		return list;
	}
}