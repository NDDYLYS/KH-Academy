package jdbc.dao;

import org.springframework.jdbc.core.JdbcTemplate;

import jdbc.dto.StudentDto;
import jdbc.insert.JDBCHelper;
import jdbc.util.OracleConnector;

public class StudentDao 
{
	
	public void insert(StudentDto studentDto) 
	{
		//JdbcTemplate jdbcTemplate = JDBCHelper.getJdbcTemplate();
		OracleConnector connector = new OracleConnector();
		String sql = "insert into student (student_no, student_name, "
				+ "student_kor, student_eng, student_mat, student_reg) "
				+ "values (student_seq.nextval, ?, ?, ?, ?, systimestamp)";
		Object[] params = {studentDto.getStudentName(), 
				studentDto.getStudentKor(), 
				studentDto.getStudentEng(), 
				studentDto.getStudentMat()};		
		connector.RunSQL(sql, params);
		//jdbcTemplate.update(sql, params);
	}
	
}