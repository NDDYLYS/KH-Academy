package com.kh.spring10.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.spring10.dto.StudentDto;

@Repository
public class StudentDao 
{
	@Autowired
	private SqlSession sqlSession;
	
	
	public int sequence() 
	{
		return sqlSession.selectOne("student.sequence");
	}
	
	public void insert(StudentDto studentDto) 
	{
		sqlSession.insert("student.insert", studentDto);
	}
}