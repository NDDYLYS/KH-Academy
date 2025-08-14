package com.kh.spring04jdbc.dao;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.kh.spring04jdbc.dto.PokemonDto;
import com.kh.spring04jdbc.dto.StudentDto;
import com.kh.spring04jdbc.mapper.StudentMapper;

@Repository
public class StudentDao 
{
	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private StudentMapper studentMapper;

	public void insert(StudentDto studentDto) 
	{
		String sql = "insert into student (student_no, student_name, "
				+ "student_kor, student_eng, student_mat, student_reg) "
				+ "values (student_seq.nextval, ?, ?, ?, ?, systimestamp)";
		Object[] params = {studentDto.getStudentName(), 
				studentDto.getStudentKor(), 
				studentDto.getStudentEng(), 
				studentDto.getStudentMat()};
		jdbcTemplate.update(sql, params);
	}
	
	public boolean update(StudentDto studentDto) 
	{
		String sql = "update student set student_name=?,"
				+ " student_kor=?, student_eng=?, student_mat=? "
				+ "where student_no=?";
    	Object[] params = {studentDto.getStudentName(), studentDto.getStudentKor(), 
    			studentDto.getStudentEng(), studentDto.getStudentMat(), 
    			studentDto.getStudentNo()};
    	int result = jdbcTemplate.update(sql, params);
    	return 0 < result;
	} 
	
	public boolean delete(int studentNo) 
	{
		String sql = "delete student where student_no=?";
    	Object[] params = {studentNo};
    	int result = jdbcTemplate.update(sql, params);
    	return 0 < result;
	}
	
	public List<StudentDto> selectList(String column, String keyword)
	{
		String sql = "select * from student where instr("+column+", ?) > 0 "
				+ "order by "+column+" asc, student_no asc";
		Object[] params = {keyword};
		return jdbcTemplate.query(sql, studentMapper, params);
	}
	
	public List<StudentDto> selectList()
	{
		String sql = "select * from student order by student_no asc";
    	return jdbcTemplate.query(sql, studentMapper);
	}
	
	public StudentDto selectOne(int studentNo)
	{		
		String sql = "select * from student where student_no = ?";
		Object[] params = {studentNo};
		List<StudentDto> list = jdbcTemplate.query(sql, studentMapper, params);
		return list.isEmpty()? null : list.get(0);
	}
}