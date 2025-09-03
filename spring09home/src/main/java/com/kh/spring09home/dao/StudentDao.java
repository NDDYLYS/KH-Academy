package com.kh.spring09home.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.kh.spring09home.dto.MemberDto;
import com.kh.spring09home.dto.StudentDto;
import com.kh.spring09home.mapper.StudentMapper;
import com.kh.spring09home.vo.PageVO;

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
	
	public int count(PageVO pageVO) 
	{
		if(pageVO.isList()) 
		{
			String sql ="select count(*) from student";
			return jdbcTemplate.queryForObject(sql, int.class);
		}
		else 
		{
			String sql ="select count(*) from student "
					+ "where instr(#1, ?) > 0";
			sql = sql.replace("#1", pageVO.getColumn());
			Object[] params = {pageVO.getKeyword()};
			return jdbcTemplate.queryForObject(sql, int.class, params);
		}
	}

	public List<StudentDto> selectListWithPaging(PageVO pageVO) 
	{
		if(pageVO.isList()) 
		{//목록이라면
			String sql = "select * from ("
					+ "select rownum rn, TMP.* from ("
						+ "select * from student "
						+ "order by student_no asc"
					+ ")TMP"
				+ ") where rn between ? and ?";
			Object[] params = {
					pageVO.getBegin(), pageVO.getEnd()
			};//동적할당
			return jdbcTemplate.query(sql, studentMapper, params);
		}
		else 
		{//검색이라면
			String sql = "select * from ("
								+ "select rownum rn, TMP.* from ("
									+ "select * from student "
									+ "where instr(#1, ?) > 0 "
									+ "order by #1 asc, student_no asc"
								+ ")TMP"
							+ ") where rn between ? and ?";
			sql = sql.replace("#1", pageVO.getColumn());
			Object[] params = {
					pageVO.getKeyword(), pageVO.getBegin(), pageVO.getEnd()
			};//동적할당
			return jdbcTemplate.query(sql, studentMapper, params);
		}
	}
}