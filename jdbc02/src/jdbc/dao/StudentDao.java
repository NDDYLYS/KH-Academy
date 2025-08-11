package jdbc.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import jdbc.dto.StudentDto;
import jdbc.insert.JDBCHelper;
import jdbc.mapper.StudentMapper;

public class StudentDao 
{
	
	public void insert(StudentDto studentDto) 
	{
		JdbcTemplate jdbcTemplate = JDBCHelper.getJdbcTemplate();
		//OracleConnector connector = new OracleConnector();
		String sql = "insert into student (student_no, student_name, "
				+ "student_kor, student_eng, student_mat, student_reg) "
				+ "values (student_seq.nextval, ?, ?, ?, ?, systimestamp)";
		Object[] params = {studentDto.getStudentName(), 
				studentDto.getStudentKor(), 
				studentDto.getStudentEng(), 
				studentDto.getStudentMat()};		
		//connector.RunSQL(sql, params);
		jdbcTemplate.update(sql, params);
	}
	
	public boolean update(StudentDto studentDto) 
	{
		JdbcTemplate jdbcTemplate = JDBCHelper.getJdbcTemplate();
    	String sql = "update student set student_name=?, student_kor=?, student_eng=?, student_mat=? where student_no=?";
    	Object[] params = {studentDto.getStudentName(), studentDto.getStudentKor(), 
    			studentDto.getStudentEng(), studentDto.getStudentMat(), 
    			studentDto.getStudentNo()};
    	int result = jdbcTemplate.update(sql, params);
    	return 0 < result;
	} 
	
	public boolean delete(int studentNo) 
	{
		JdbcTemplate jdbcTemplate = JDBCHelper.getJdbcTemplate();
    	String sql = "delete student where student_no=?";
    	Object[] params = {studentNo};
    	int result = jdbcTemplate.update(sql, params);
    	return 0 < result;
	}
	
	public List<StudentDto> selectList()
	{
		JdbcTemplate jdbcTemplate = JDBCHelper.getJdbcTemplate();
    	String sql = "select * from student order by student_no asc";
    	StudentMapper studentMapper = new StudentMapper();
    	return jdbcTemplate.query(sql, studentMapper);
	}
	
	public StudentDto selectSolo(String studentName)
	{
		JdbcTemplate jdbcTemplate = JDBCHelper.getJdbcTemplate();
    	String sql = "select * from student where student_name = ?";
    	Object[] params = {studentName};
    	StudentMapper studentMapper = new StudentMapper();
    	return jdbcTemplate.query(sql, params, studentMapper).getFirst();
	}
}