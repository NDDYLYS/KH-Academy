package jdbc.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import jdbc.dto.StudentDto;


public class StudentMapper implements RowMapper<StudentDto>
{

	@Override
	public StudentDto mapRow(ResultSet rs, int idx) throws SQLException 
	{
		StudentDto studentDto = new StudentDto();
		studentDto.setStudentNo(rs.getInt("student_no"));
		studentDto.setStudentName(rs.getString("student_name"));
		studentDto.setStudentKor(rs.getInt("student_kor"));
		studentDto.setStudentEng(rs.getInt("student_eng"));
		studentDto.setStudentMat(rs.getInt("student_mat"));
		studentDto.setStudentReg(rs.getTimestamp("student_reg"));
	
		// TODO Auto-generated method stub
		return studentDto;
	}
}